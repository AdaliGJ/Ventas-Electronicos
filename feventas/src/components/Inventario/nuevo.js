import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './inventario.css';

import axios from 'axios';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';



class NuevoInventario extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          open: false,
          serie: props.comp? props.serie:"",
          producto: null,
          id: props.comp? props.prod:null,
          usuario: null,
          productos: [{id: 1, nombre: 2}, {id: 2, nombre: 4}]
          
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
      texto: '',
      producto: ''
    });
    this.handleOpen();
  }


addItem = ()=>{
  const url = 'http://localhost:8080/Dispositivos_individuales/Prueba';

  let formData = new FormData();
  formData.append('nId', this.state.id);
  formData.append('nSerie', this.state.serie);
  formData.append('nVendido', 0);
 



  axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      this.setState({open: false,
      serie: ''});
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

  const url= 'http://localhost:8080/Inventario/ObtenerTodos'

  axios.get(url).then(response => response.data)
    .then((data) => {
      this.setState({productos: data});
      
      console.log(data);
    });

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
              <TextField className="modalfield" label="Serie" type="text" variant="outlined" onInput={e=>this.setState({serie: e.target.value})}  value={this.state.serie}/> 
            </Grid>
            <Grid item>
              <FormControl className="modalfield" variant ="outlined">
                    <InputLabel>Producto</InputLabel>
                    <Select label="Producto" displayEmpty onChange={e=>this.setState({id: e.target.value})}>
                    {this.state.productos.map((p) => (
                        <MenuItem value={p.idInventario}>{"ID: "+p.idInventario+" Marca: "+p.marca+" Descripción: "+p.descripcion}</MenuItem>
                    ))}
                    </Select>
                </FormControl>
            </Grid>
            <Grid item>
            {this.props.comp?
              <Button id="actualizarInv" onClick={this.updateItem}>Actualizar</Button> :
              <Button id="agregarInv" onClick={this.addItem}>Agregar</Button>
            }
              <Button id="cancelarInv" onClick={this.props.comp? this.handleOpen: this.cancel }>Cancelar</Button>
            </Grid>
          </Grid>
        </Box>
      </Modal>
    </div>
  );
}
}

export default NuevoInventario;