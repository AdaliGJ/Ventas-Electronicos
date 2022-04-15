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
          pass: null,
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
          nit: 0
          
      }
      this.handleOpen=this.handleOpen.bind(this);
      this.cancel=this.cancel.bind(this);
      this.addItem=this.addItem.bind(this);
      this.generarFactura=this.generarFactura.bind(this);
  }
  
  handleOpen=(e)=>{
       this.setState({open: !this.state.open})  
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