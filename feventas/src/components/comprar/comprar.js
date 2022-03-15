import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import Alert from '@material-ui/lab/Alert';
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
          today: new Date()
          
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


addItem = ()=>{
  const url= 'http://localhost:8080/Clientes/Login'
  const url2= 'http://localhost:8080/Fichas_clientes/Obtener'

  axios.get(url, {params: {nIdCliente: this.state.nit, nPassword: this.state.pass}}).then(response => response.data)
    .then((data) => {
      this.setState({cliente: data});
      if(data.respuesta=="ok"){
        this.setState({registrado: true});
        axios.get(url2, {params: {nIdCliente: this.state.nit}}).then(response => response.data)
          .then((data) => {
            this.setState({nombre: data.nombre});
          });

        console.log(data);
      }else{
        console.log(data);
        this.setState({sus: 2})
      }
    });


    
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
      doc.text(115, 50,'Total: Q'+ this.props.total);

    
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
      doc.text(115, 50,'Total: Q'+ this.props.total);

    
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
          <h4>¿Está suscrito a nuestra página?</h4>
          <FormControl className="modalfield" variant ="outlined">
                    <InputLabel></InputLabel>
                    <Select label="" displayEmpty onChange={e=>this.setState({sus: e.target.value})}  value={this.state.sus}>
                    
                        <MenuItem value={1}>Sí</MenuItem>
                        <MenuItem value={2}>No</MenuItem>
                    
                    </Select>
                </FormControl>
          {this.state.sus==1?  
          <Grid container direction={"column"} spacing={2}>
            <h2>Ingrese sus datos</h2>
            <Grid item>
                <TextField className="outlined-required" label="ID" type="number"  onInput={e=>this.setState({nit: e.target.value})}  value={this.state.nit}/>
            </Grid>
            <Grid item> 
                <TextField className="outlined-required" label="Contraseña" type="password"  onInput={e=>this.setState({pass: e.target.value})}  value={this.state.pass}/>
            </Grid>
             <Grid item>
              <Button id="comprar" onClick={this.addItem}>Comprar</Button>
              <Button id="cancelar-comprar" onClick={this.cancel}>Cancelar</Button>
            </Grid>
            <div>
              <h3>{"Cliente: "+ this.state.nombre}</h3>
          </div>
          </Grid>: <Grid container direction={"column"} spacing={2}>
          <Grid item>
              <Button id="comprar" onClick={this.generarFactura2}>Comprar</Button>
              <Button id="cancelar-comprar" onClick={this.cancel}>Cancelar</Button>
            </Grid>
          </Grid>
          }
           <Alert severity="success" id={this.state.registrado? "sidoc": "nodoc"}>Compra realizada exitosamente. <a onClick={this.generarFactura}>Generar Factura</a></Alert>
        </Box>
      </Modal>
    </div>
  );
}
}

export default Comprar;