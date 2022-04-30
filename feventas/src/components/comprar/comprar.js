import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import Alert from '@material-ui/lab/Alert';
import SearchIcon from '@material-ui/icons/Search';
import './comprar.css';

import axios from 'axios';

import jsPDF from 'jspdf';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';



class Comprar extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          open: false,
          sus: null,
          producto: props.producto,
          nombre: 'N/A',
          cliente: 0,
          registrado: false,
          persona: {nit:'CF',nombre: 'N/A'},
          today: new Date(),
          tipo_cliente: 0,
          total: this.props.total,
          credito: '0',
          cat: this.props.tipo,
          nit: 0,
          cantidad: this.props.cantidad,
          existencias: this.props.existencias,
          pedido: false,

          cl: '',
          pass: '',
          ip: '',
          port:'',

          serie: [],

          error: false,
          succ: false,

          clienteFab: '',

          inv: [],
          idFab: '',

          idVentas:0,

          no: false
          
      }
      this.handleOpen=this.handleOpen.bind(this);
      this.cancel=this.cancel.bind(this);
      this.addItem=this.addItem.bind(this);
      this.generarFactura=this.generarFactura.bind(this);
  }
  
  handleOpen=(e)=>{
       this.setState({open: !this.state.open});
       this.setState({cantidad:this.props.cantidad-this.props.existencias});  
  }

  autenticar=(e)=>{
    const context = this.context;
    const url2 = 'http://localhost:8080/AutCliente';
    //const url2 = 'http://localhost:8080/Usuarios/Obtener';

     
     let formData = new FormData();
     formData.append('nCliente', this.state.cl);
     formData.append('nPassword', this.state.pass);
     formData.append('nIP', this.state.ip);
     formData.append('nPort', this.state.port);
            
     axios.post(url2, formData,  {
         headers: {
             'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
         }})
         .then((response)=>{
             console.log(response);
             if(response.data._id=="error"){
                 this.setState({error: true});
             }else{
                 context.setCliente(response.data._id);
                 context.setIp(this.state.ip);
                 context.setPuerto(this.state.port);
                 this.setState({succ: true});

                 const url= 'http://localhost:8080/CatalogoFabrica'
            
                 axios.get(url, {params: {nIP: this.state.ip, nPort: this.state.port}}).then(response => response.data)
                   .then((data) => {
                         this.setState({inv: data});
                         console.log(data);
                     }
                 
                   );

             }    
         })
         .catch((response)=>{
             console.log(response);
             this.setState({error: true});;
             context.setCliente(null);
             context.setIp(null);
             context.setPuerto(null);
         });
  }

  cancel=()=>{
    this.setState({
      texto: '',
      producto: ''
    });
    this.handleOpen();
  }

  change=()=>{

    const url= 'http://localhost:8080/Clientes/Obtener'
    const url2= 'http://localhost:8080/Fichas_clientes/Obtener'
    const url3= 'http://localhost:8080/Tipo_clientes/Obtener'
    

    axios.get(url, {params: {nNit: this.state.nit}}).then(response => response.data)
    .then((data) => {
      this.setState({cliente: data});
        axios.get(url2, {params: {nNit: this.state.nit}}).then(response => response.data)
          .then((data) => {
            this.setState({nombre: data.nombre});
          });
          axios.get(url3, {params: {nIdTipoCliente: data.tipo_cliente}}).then(response => response.data)
          .then((data) => {
            this.setState({tipo_cliente: data.descuento,
            total: this.props.total-this.props.total*data.descuento*0.01});
            console.log(data);
          });

        console.log(data.existencias);
      
    });
  }


addItem = ()=>{
  const url= 'http://localhost:8080/Ventas/Orden'

  console.log(this.state.today.getDate()+'-'+this.state.today.getMonth()+'-'+this.state.today.getFullYear());
  console.log(this.props.total-this.props.total*this.state.tipo_cliente*0.01.toString());
  console.log(this.props.tipo)

    let formData = new FormData();
    formData.append("nCredito", this.state.credito);
    formData.append("nFecha", this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());
    formData.append("nCategoria", this.props.tipo);
    formData.append("nCliente", this.state.nit);
    formData.append("nPrecio", this.props.total-this.props.total*this.state.tipo_cliente*0.01);
    formData.append('nFactura', this.state.nit+this.state.today.getDay().toString()+this.state.today.getTime().toString());

    axios.post(url, formData,  {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }})
    .then((response)=>{
        console.log(response);
        this.setState({registrado:true});
    })
    .catch((response)=>{
        console.log(response);
        
    });

    /*const url2= 'http://localhost:8080/Ventas/Orden3'
    const url3= 'http://localhost:8080/Dispositivos_individuales/ObtenerSeries'

    axios.get(url3, {params: {nId: this.props.tipo}}).then(response => response.data)
        .then((data) => {
          this.setState({serie: data});
          let formData2 = new FormData();
          formData2.append("nSeries", data);
          formData2.append("nCredito", this.state.credito);
          formData2.append("nFecha", this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());
          formData2.append("nPrecioVenta", this.props.total/this.props.cantidad);
          formData2.append("nCantidad", this.props.cantidad);

          axios.post(url2, formData2,  {
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
              }})
          .then((response)=>{
              console.log(response);
              
          })
          .catch((response)=>{
              console.log(response);
              
          });


        });*/

   /*Cambiar*/
   const url2= 'http://localhost:8080/Ventas/Orden2'
   const url3= 'http://localhost:8080/Dispositivos_individuales/ObtenerSerie'
   const url4= 'http://localhost:8080/Reporteria'
   var contador = 0;
    for(var i = 0; i<this.props.cantidad;i++){
      if(this.props.existencias>=i && this.state.no){
        formData.delete('nSuma');
        formData.append('nSuma', i+1);
        formData.delete('nOff');
        formData.append('nOff', i);

        
        axios.get(url3, {params: {nId: this.props.tipo}}).then(response => response.data)
        .then((data) => {
          this.setState({serie: data});
          let formData2 = new FormData();
          formData2.append("nSerie", data);
          formData2.append("nPrecioVenta", this.props.total/this.props.cantidad);
          formData.append('nIP', this.state.ip);
          formData.append('nPort', "4000");
 

          axios.post(url4, formData2,  {
              headers: {
                  'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
              }})
          .then((response)=>{
              console.log(response);
              
          })
          .catch((response)=>{
              console.log(response);
              
          });


        });
       

        axios.post(url2, formData,  {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }})
        .then((response)=>{
            console.log(response);
           
        })
        .catch((response)=>{
            console.log(response);
            
        });
      }
      //this.setState({cantidad:this.state.cantidad-1});
      contador=contador +1;
    }

    this.setState({cantidad:this.state.cantidad-contador});
    console.log(this.props.cantidad);
    console.log(this.props.existencias);

    if(this.state.cantidad>0 && this.state.no){
      const url5 = 'http://localhost:8080/WebServicePost';

      let formData5 = new FormData();
      formData5.append('nIdPedidoVentas', this.state.idVentas + 1);
      formData5.append('nCliente', this.state.clienteFab);
      formData5.append('nIdInventario', this.state.idFab);
      formData5.append('nCantidad', this.state.cantidad);
      formData5.append('nIdInventarioVentas', this.props.tipo);
      formData.append('nIP', this.state.ip);
      formData.append('nPort', "4000");
     
    
    
    
      axios.post(url5, formData5, {headers: {"Content-Type": "application/json"}})
      .then((response)=>{
          console.log(response);
          
      })
      .catch((response)=>{
        console.log(response);
      });
    
      const url6 = 'http://localhost:8080/Pedidos/Insertar';
      let formData6 = new FormData();
      formData6.append('nidpedido', this.state.idVentas + 1);
      formData6.append('nfecha', this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());
      formData6.append('nidInventario', this.props.tipo);
      formData6.append('ncantidad', this.state.cantidad);
      formData6.append('nestado', 'registrado');
      formData6.append('nfechaEntrega', '');
    
      axios.post(url6, formData6, {headers: {"Content-Type": "application/json"}})
      .then((response)=>{
          console.log(response);
      })
      .catch((response)=>{
        console.log(response);
      });

    }


    this.generarFactura();
    this.handleOpen();

    

    
 }

generarFactura = ()=> {


      const doc = new jsPDF();

      doc.setFontSize(12);
      doc.text(20, 60, 'NIT: '+ this.state.nit);
      doc.text(20, 70, 'Nombre: '+ this.state.nombre);
      doc.text(20, 80, 'Serie: '+ this.state.nit+this.state.today.getDay()+this.state.today.getTime());
      doc.text(115, 50,'Total: Q'+ this.state.total);

    
      doc.save('factura.pdf');

  
}


generarFactura2 = ()=> {

 

      const doc = new jsPDF();

      doc.setFontSize(12);
      doc.text(20, 60, 'NIT: '+ this.state.nit);
      doc.text(20, 70, 'Nombre: '+ this.state.nombre);
      doc.text(20, 80, 'Serie: '+ this.state.nit+this.state.today.getDay()+this.state.today.getTime());
      doc.text(115, 50,'Total: Q'+ this.state.total);

    
      doc.save('factura.pdf');
          
     
       
    this.handleOpen();
}

 componentDidMount(){
  const context = this.context;
  this.setState({usuario: context.username,
    tipo_usuario: context.tipoUsuario,
  total: this.props.total});

  
console.log(this.props.total);

  const url= 'http://localhost:8080/Inventario/ObtenerTodos'

  axios.get(url).then(response => response.data)
    .then((data) => {
      this.setState({productos: data});
      
      console.log(data);
      console.log(this.props.existencias);

    });


    console.log(this.state.cantidad);
    console.log(this.state.existencias);

    const url4= 'http://localhost:8080/Pedidos/ObtenerId'
          
            axios.get(url4).then(response => response.data)
              .then((data) => {
                this.setState({idVentas: data});
                
                console.log(data);
              }).catch((response)=>{
                this.setState({idVentas: 0});
            });

    this.setState({cantidad:this.props.cantidad-this.props.existencias});


    const url5= 'http://localhost:8080/Procedimiento/GetIP'

    axios.get(url5, {params: {nId: this.props.id2}}).then(response => response.data)
    .then((data) => {
        if(data=="no"){
          this.setState({no: false})
        }else{
          this.setState({ip: data})
          this.setState({no: true})
        }
        
        //console.log(data);
  });

 }

  render(){
    
  return (
    <div >
      <Button onClick={this.handleOpen} id="boton-modal-comprar">Comprar</Button>
      <Modal open={this.state.open} onClose={this.handleOpen} id="comprar-modal">
        <Box className="box">
        <div>
              <h2>Detalle Compra: </h2>
              <p>{"Producto: " + this.props.producto}</p>
              <p>{"Precio: Q"+this.props.total}</p>
          </div>
          <Grid container direction={"column"} spacing={2}>
            <h2>Ingrese sus datos</h2>
            <Grid item>
              <div className="searchbar">
                        <TextField className="outlined-required" label="NIT" type="number"  onInput={e=>this.setState({nit: e.target.value})}  value={this.state.nit}/>
                        <Button onClick={this.change}><SearchIcon/></Button>
                    </div>
                
            </Grid>
            <Grid item> 
                <TextField className="outlined-required" label="Cliente" type="text"  onInput={e=>this.setState({nombre: e.target.value})}  value={this.state.nombre}/>
            </Grid>
            <Grid item> 
                <TextField className="outlined-required" label="Usuario en Fábrica" type="text"  onInput={e=>this.setState({clienteFab: e.target.value})}  value={this.state.clienteFab}/>
            </Grid>
            {this.state.tipo_cliente == 15?
            <Grid item> 
               <FormControl className="outlined-required">
                    <InputLabel>¿Comprar al Crédito?</InputLabel>
                    <Select label="ID Inventario" displayEmpty onChange={e=>this.setState({credito: e.target.value})}  value={this.state.credito}>
                        <MenuItem value={'0'}>No</MenuItem>
                        <MenuItem value={'1'}>Sí</MenuItem>
                    </Select>
                </FormControl> </Grid>:null}
                <h3>¿Faltan existencias? <a className='aclic' /*onClick={e=>this.setState({pedido: !this.state.pedido})}*/>Encárguelas a Fábrica</a></h3>
                {this.state.pedido == true?
                <div>
                  <h3>Autenticarse</h3>
                <Grid item> 
                  <TextField className="outlined-required" label="Cliente" type="text"  onInput={e=>this.setState({cl: e.target.value})}  value={this.state.cl}/>
                  <TextField className="outlined-required" label="Contraseña" type="password"  onInput={e=>this.setState({pass: e.target.value})}  value={this.state.pass}/>
                </Grid>
                <Grid item> 
                  <TextField className="outlined-required" label="Dirección IP" type="text"  onInput={e=>this.setState({ip: e.target.value})}  value={this.state.ip}/>
                  <TextField className="outlined-required" label="Puerto" type="text"  onInput={e=>this.setState({port: e.target.value})}  value={this.state.port}/>
                </Grid>
                <Grid item>
                  <Button id="autenticar" onClick={this.autenticar}>Autenticarse</Button>
                </Grid></div>:null}
                {this.state.succ == true?
                 <Grid item>
                <FormControl className="outlined-required" variant ="outlined">
                    <InputLabel>Producto</InputLabel>
                    <Select label="Producto" displayEmpty onChange={e=>this.setState({idFab: e.target.value})}>
                    {this.state.inv.map((p) => (
                        <MenuItem value={p._id}>{"ID: "+p._id+" Marca: "+p.marca+" Descripción: "+p.descripcion}</MenuItem>
                    ))}
                    </Select>
                </FormControl></Grid>
                :null}
             <Grid item>
              <Button id="comprar" onClick={this.addItem}>Comprar</Button>
              <Button id="cancelar-comprar" onClick={this.cancel}>Cancelar</Button>
            </Grid>
            <div>
              <h3>{"Precio Final: "+ (this.props.total-this.props.total*this.state.tipo_cliente*0.01)}</h3>
          </div>
          </Grid>
           <Alert severity="success" id={this.state.registrado? "sidoc": "nodoc"}>Compra realizada exitosamente. <a onClick={this.generarFactura2}>Generar Factura</a></Alert>
        </Box>
      </Modal>
    </div>
  );
}
}

export default Comprar;