import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './catalogoFabrica.css';

import axios from 'axios';


import Icon from '@mui/material/Icon';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';


class ComprarFabrica extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          open: false,
          cantidad: 0,
          idVentas: 0,
          id: props.id,
          usuario: null,
          today: new Date(),
          cliente: '',
          inventario:  [ ],
          producto:''
          
      }
      this.handleOpen=this.handleOpen.bind(this);
      this.cancel=this.cancel.bind(this);
      this.addItem=this.addItem.bind(this);

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
  const url = 'http://localhost:8080/WebServicePost';

  let formData = new FormData();
  formData.append('nIdPedidoVentas', this.state.idVentas + 1);
  formData.append('nCliente', this.state.cliente);
  formData.append('nIdInventario', this.props.id);
  formData.append('nCantidad', this.state.cantidad);
 



  axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      
  })
  .catch((response)=>{
    console.log(response);
  });

  const url2 = 'http://localhost:8080/Pedidos/Insertar';
  let formData2 = new FormData();
  formData2.append('nidpedido', this.state.idVentas + 1);
  formData2.append('nfecha', this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());
  formData2.append('nidInventario', this.state.producto);
  formData2.append('ncantidad', this.state.cantidad);
  formData2.append('nestado', 'registrado');
  formData2.append('nfechaEntrega', '');

  axios.post(url2, formData2, {headers: {"Content-Type": "application/json"}})
  .then((response)=>{
      console.log(response);
      this.setState({open: false});
  })
  .catch((response)=>{
    console.log(response);
  });

 }

 componentDidMount(){
  const context = this.context;
  this.setState({usuario: context.tipoUsuario,
    cliente: context.cliente});

    const url= 'http://localhost:8080/Pedidos/ObtenerId'
          
            axios.get(url).then(response => response.data)
              .then((data) => {
                this.setState({idVentas: data});
                
                console.log(data);
              }).catch((response)=>{
                this.setState({idVentas: 0});
            });

            const url2= 'http://localhost:8080/VistaCatalogo/ObtenerInventarioAsc'
      
            axios.get(url2).then(response => response.data)
              .then((data) => {
                this.setState({inventario: data});
                
                console.log(data);
                console.log(this.state.inventario);
              });

 }

  render(){
    
  return (
    <div >
      <Button onClick={this.handleOpen} id="boton-modal-fabrica">Comprar</Button>
      <Modal open={this.state.open} onClose={this.handleOpen}>
        <Box className="box">
          <h2>Pedido Producto</h2>
          <Grid container direction={"column"} spacing={2}>
            <Grid item>
              <TextField className="modalfield" label="ID Producto" type="text" variant="outlined" onInput={e=>this.setState({id: e.target.value})}  value={this.state.id}/> 
            </Grid>
            <Grid item>
              <FormControl className="modalfield" variant ="outlined">
                    <InputLabel>ID Inventario</InputLabel>
                    <Select label="ID Inventario" displayEmpty onChange={e=>this.setState({producto: e.target.value})}  value={this.state.producto}>
                    {this.state.inventario.map((p) => (
                        <MenuItem value={p.idinventario}>{p.idinventario+"-"+p.tipodispositivo+" "+p.nombremarca+" "+p.modelo+" "+p.color}</MenuItem>
                    ))}
                    </Select>
                </FormControl>
            </Grid>
            <Grid item>
              <TextField className="modalfield" label="Cantidad" type="number" variant="outlined" onInput={e=>this.setState({cantidad: e.target.value})}  value={this.state.cantidad}/> 
            </Grid>
            <Grid item>
              <Button id="agregarPed" onClick={this.addItem}>Agregar</Button>
              <Button id="cancelarPed" onClick={this.cancel }>Cancelar</Button>
            </Grid>
          </Grid>
        </Box>
      </Modal>
    </div>
  );
}
}

export default ComprarFabrica;