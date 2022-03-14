import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './comprar.css';

import axios from 'axios';

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
          total: props.total,
          producto: props.producto,
          nombre: ''
          
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
  /*const url = 'localhost:8080/Dispositivos_Indiviuales/Insertar';

  let formData = new FormData();
  formData.append('nCategoriaDispositivo', this.state.categoria);
  formData.append('nMarca', this.state.marca);



  axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      this.setState({open: true});
  })
  .catch((response)=>{
    console.log(response);
});*/



    this.handleOpen();
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
    <div >
      <Button onClick={this.handleOpen} id="boton-modal-comprar">Comprar</Button>
      <Modal open={this.state.open} onClose={this.handleOpen} id="comprar-modal">
        <Box className="box">
        <div>
              <h2>Detalle Compra: </h2>
              <p>{"Producto: " + this.props.producto}</p>
              <p>{"Total: "+this.state.total}</p>
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
                <TextField className="outlined-required" label="NIT" type="number"  onInput={e=>this.setState({nit: e.target.value})}  value={this.state.nit}/>
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
              <Button id="comprar" onClick={this.addItem}>Comprar</Button>
              <Button id="cancelar-comprar" onClick={this.cancel}>Cancelar</Button>
            </Grid>
          </Grid>
          }
        </Box>
      </Modal>
    </div>
  );
}
}

export default Comprar;