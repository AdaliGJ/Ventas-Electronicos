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
          cliente: null,
          registrado: false,
          persona: {nit:'CF',nombre: 'N/A'},
          today: new Date().getDate().toString(),
          tipo_cliente: '',
          total: this.props.total,
          credito: 0
          
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

        console.log(data);
      
    });
  }


addItem = ()=>{
  const url= 'http://localhost:8080/Ventas/Orden'


    let formData = new FormData();
    formData.append("nCredito", this.state.credito);
    formData.append("nFecha", this.state.today);
    formData.append("nCategoria", this.props.tipo);

    axios.post(url, formData,  {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }})
    .then((response)=>{
        console.log(response);
    })
    .catch((response)=>{
        console.log(response);
        
    });

    this.setState({registrado:true});

    

    
 }

generarFactura = ()=> {

  const url= 'http://localhost:8080/Fichas_clientes/Obtener'

  axios.get(url, {params: {nIdCliente: this.state.nit}}).then(response => response.data)
    .then((data) => {
      this.setState({persona: data});

      const doc = new jsPDF();

      doc.setFontSize(12);
      doc.text(20, 60, 'NIT: '+ this.state.persona.nit);
      doc.text(20, 70, 'Nombre: '+ this.state.persona.nombre);
      doc.text(20, 80, 'Serie: '+ this.state.persona.nit+this.state.today.getDay()+this.state.today.getTime());
      doc.text(115, 50,'Total: Q'+ this.state.total);

    
      doc.save('factura.pdf');
          
          console.log(data);
        });
  
    this.handleOpen();
}


generarFactura2 = ()=> {

 

      const doc = new jsPDF();

      doc.setFontSize(12);
      doc.text(20, 60, 'NIT: '+ this.state.persona.nit);
      doc.text(20, 70, 'Nombre: '+ this.state.persona.nombre);
      doc.text(20, 80, 'Serie: '+ this.state.persona.nit+this.state.today.getDay()+this.state.today.getTime());
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
              <p>{"Precio: Q"+this.state.total}</p>
          </div>
          <Grid container direction={"column"} spacing={2}>
            <h2>Ingrese sus datos</h2>
            <Grid item>
              <div className="searchbar">
                        <TextField className="outlined-required" label="ID" type="number"  onInput={e=>this.setState({nit: e.target.value})}  value={this.state.nit}/>
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
              <h3>{"Cliente: "+ this.state.nombre}</h3>
          </div>
          </Grid>
           <Alert severity="success" id={this.state.registrado? "sidoc": "nodoc"}>Compra realizada exitosamente. <a onClick={this.generarFactura}>Generar Factura</a></Alert>
        </Box>
      </Modal>
    </div>
  );
}
}

export default Comprar;