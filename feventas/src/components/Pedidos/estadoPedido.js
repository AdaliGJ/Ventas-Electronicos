import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './pedidos.css';

import axios from 'axios';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';



class EstadoPedido extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          open: false,
          serie: props.comp? props.serie:"",
          producto: null,
          id: props.comp? props.prod:null,
          usuario: null,
          cliente: ''
          
      }
      this.handleOpen=this.handleOpen.bind(this);
      this.cancel=this.cancel.bind(this);
      this.addItem=this.addItem.bind(this);
      this.updateItem=this.updateItem.bind(this);
  }
  
  handleOpen=(e)=>{
       this.setState({open: !this.state.open})  
  }

  cancel=()=>{
    this.setState({
      cliente: ''
    });
    this.handleOpen();
  }


addItem = ()=>{
  const url = 'http://localhost:8080/EstadoPedido';

  let formData = new FormData();
  formData.append('nIdPedido', this.props.id);
  formData.append('nCliente', this.state.cliente);
  formData.append('nEstado', this.props.estado);
  formData.append('nResponsable', this.context.username);
 

  axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      //this.setState({open: false});
  })
  .catch((response)=>{
    console.log(response);
});

const url2 = 'http://localhost:8080/Pedidos/Estado';

  let formData2 = new FormData();
  formData2.append('nId', this.props.id);
  formData2.append('nFecha', '');
  formData2.append('nEstado', this.props.estado);
 

  axios.post(url2, formData2, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      this.setState({open: false});
      window.location.reload();
  })
  .catch((response)=>{
    console.log(response);
});




 }

updateItem = ()=> {
    /*var actItem = this.props.update;
    actItem(this.state.serie);*/
    this.handleOpen();
}

 componentDidMount(){
  const context = this.context;
  this.setState({usuario: context.tipoUsuario});

 }

  render(){
    
  return (
    <div id={this.state.usuario==1? "siinv": "noinv"}>
      <Button onClick={this.handleOpen} id="boton-modal">{this.props.titulo}</Button>
      <Modal open={this.state.open} onClose={this.handleOpen}>
        <Box className="box">
          <h2>Ingresar los datos</h2>
          <Grid container direction={"column"} spacing={2}>
            <Grid item>
              <TextField className="modalfield" label="ID Cliente" type="text" variant="outlined" onInput={e=>this.setState({cliente: e.target.value})}  value={this.state.cliente}/> 
            </Grid>
            
              <Button id="agregarInv" onClick={this.addItem}>Agregar</Button>
          
              <Button id="cancelarInv" onClick={this.props.comp? this.handleOpen: this.cancel }>Cancelar</Button>
            </Grid>
        </Box>
      </Modal>
    </div>
  );
}
}

export default EstadoPedido;