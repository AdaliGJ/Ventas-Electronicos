import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './nuevoCatalogo.css';

import axios from 'axios';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';



class NuevoCatalogo extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          open: false,

          color:"",
          descripcion:"",
          garantia: null,
          precio:"",
          modelo: "",
          marca:null,
          categoria: null,
          marcas: [{id: 1, nombre: "Samsung"}, {id: 2, nombre: "Amazon"}],
          tipo_productos: [],

          imgs: '',
          archivos: null,

         
          res: '',
          bits: '',
          pulgadas:'',
          hdmi: '',

          max_jug: '',
          graficos: '',
          consola: '',

          so: '',
          ram:'',
          memoria: ''
          
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

  handleChange = e => {
    if(e.target.files[0]){
        this.setState({imgs:  this.state.imgs==''? e.target.files[0].name : this.state.imgs + ', '+ e.target.files[0].name,
        archivos: e.target.files});
        console.log(this.state.imgs);
    }else{
        this.setState({imgs: ''});
    }
  }


addItem = ()=>{
   /* var submitItem = this.props.submit;
    submitItem(this.state.serie);*/
    const url = 'localhost:8080/Inventario/Insertar';

        let formData = new FormData();
        formData.append('nCategoriaDispositivo', this.state.categoria);
        formData.append('nMarca', this.state.marca);
        formData.append('nExistencias', 0);
        formData.append('nPrecioLista', this.state.precio);
        formData.append('nColor', this.state.color);
        formData.append('nDescripcion', this.state.descripcion);
        formData.append('nModelo', this.state.modelo);
        formData.append('nMesesGarantia', this.state.garantia);

        const inv ={
          nCategoriaDispositivo: this.state.categoria,
          nMarca: this.state.marca,
          nExistencias: 0,
          nPrecioLista: this.state.precio,
          nColor: this.state.color,
          Descripcion: this.state.descripcion,
          nModelo: this.state.modelo,
          nMesesGarantia: this.state.garantia
        }

        axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
        .then((response)=>{
            console.log(response);
            this.setState({open: true});
        })
        .catch((response)=>{
          console.log(response);
      });

   

        




    this.handleOpen();

    console.log(this.state.precio);
 }

updateItem = ()=> {
    /*var actItem = this.props.update;
    actItem(this.state.serie);*/
    this.handleOpen();
}

 componentDidMount(){
  const context = this.context;
  this.setState({usuario: context.username,
    tipo_usuario: context.tipoUsuario});

  const url= 'http://localhost:8080/Tipo_dispositivo/ObtenerTodos'

  axios.get(url).then(response => response.data)
    .then((data) => {
      this.setState({tipo_productos: data});
      
      console.log(data);
    });

    const url2= 'http://localhost:8080/Marca/ObtenerTodos'

    axios.get(url2).then(response => response.data)
      .then((data) => {
        this.setState({marcas: data});
        
        console.log(data);
      });

 }

  render(){
    
  return (
    <div id={this.state.usuario==1? "sicat": "nocat"}>
      <Button onClick={this.handleOpen} id="boton-modal-cat">{this.props.titulo}</Button>
      <Modal open={this.state.open} onClose={this.handleOpen} id="modal-flow">
        <Box className="box">
          <h2>Ingresar los Datos del Dispositivo</h2>
          <Grid container direction={"column"} spacing={2}>
            <Grid item>
              <FormControl className="modalfield" variant ="outlined">
                    <InputLabel>Tipo Dispositivo</InputLabel>
                    <Select label="Tipo Dispositivo" displayEmpty onChange={e=>this.setState({categoria: e.target.value})}  value={this.state.categoria}>
                    {this.state.tipo_productos.map((p) => (
                        <MenuItem value={p.id_tipo_dispositivo}>{p.nombre}</MenuItem>
                    ))}
                    </Select>
                </FormControl>
            </Grid>
            <Grid item>
              <FormControl className="modalfield" variant ="outlined">
                    <InputLabel>Marca</InputLabel>
                    <Select label="Marca" displayEmpty onChange={e=>this.setState({marca: e.target.value})}  value={this.state.marca}>
                    {this.state.marcas.map((m) => (
                        <MenuItem value={m.id_marca}>{m.nombre}</MenuItem>
                    ))}
                    </Select>
                </FormControl>
            </Grid>
            <Grid item className="text-together">
              <TextField className="modalfield-short" label="Modelo"  type="text" variant="outlined" onInput={e=>this.setState({modelo: e.target.value})}  value={this.state.modelo}/> 
              <hr/>
              <TextField className="modalfield-short" label="Color" type="text" variant="outlined" onInput={e=>this.setState({color: e.target.value})}  value={this.state.color}/> 
            </Grid>
            <Grid item className="text-together">
              <TextField className="modalfield-short" label="Meses de Garantía"  type="number" variant="outlined" onInput={e=>this.setState({garantia: e.target.value})}  value={this.state.garantia}/> 
              <hr/>
              <TextField className="modalfield-short" label="Costo (Q)" type="number" variant="outlined" onInput={e=>this.setState({precio: e.target.value})}  value={this.state.precio}/> 
            </Grid>
            <Grid item className="text-together">
              <TextField className="modalfield" label="Descripción"  type="text" multiline rows={4} variant="outlined" onInput={e=>this.setState({descripcion: e.target.value})}  value={this.state.descripcion}/> 
            </Grid>
            <Grid item>
              <TextField type="file" name="img-file" id="img-file" inputProps={{ accept: '.jpg, .png, .jpeg' }} onChange={this.handleChange}/>  
                <label htmlFor="img-file"> 
                  <Button id="send-prod-img" variant="contained" component="span">Subir Imagen del producto</Button>
                  <p>{this.state.imgs !=null? this.state.imgs : "Ninguna Imagen Seleccionada"}</p>
                </label> 
            </Grid>
            {this.state.categoria==1? <Grid container direction={"column"} spacing={2}>
              <Grid item className="text-together">
                <TextField className="modalfield-short" label="Resolución"  type="text" variant="outlined" onInput={e=>this.setState({res: e.target.value})}  value={this.state.res}/> 
                <hr/>
                <TextField className="modalfield-short" label="Bits de Profundidad" type="number" variant="outlined" onInput={e=>this.setState({bits: e.target.value})}  value={this.state.bits}/> 
              </Grid>
              <Grid item className="text-together">
                <TextField className="modalfield-short" label="Pantalla (pulgadas)"  type="number" variant="outlined" onInput={e=>this.setState({pulgadas: e.target.value})}  value={this.state.pulgadas}/> 
                <hr/>
                <TextField className="modalfield-short" label="Entradas HDMI" type="number" variant="outlined" onInput={e=>this.setState({hdmi: e.target.value})}  value={this.state.hdmi}/> 
              </Grid>
            </Grid>
            :this.state.categoria==2?<Grid container direction={"column"} spacing={2}>
            <Grid item className="text-together">
              <TextField className="modalfield-short" label="Máximo de Jugadores"  type="number" variant="outlined" onInput={e=>this.setState({max_jug: e.target.value})}  value={this.state.max_jug}/> 
              <hr/>
              <TextField className="modalfield-short" label="Gráficos" type="text" variant="outlined" onInput={e=>this.setState({graficos: e.target.value})}  value={this.state.graficos}/> 
            </Grid>
            <Grid item className="text-together">
              <TextField className="modalfield" label="Consola"  type="text" variant="outlined" onInput={e=>this.setState({consola: e.target.value})}  value={this.state.consola}/> 
            </Grid>
          </Grid>

            :this.state.categoria==3?<Grid container direction={"column"} spacing={2}>
              <Grid item className="text-together">
                <TextField className="modalfield-short" label="Sistema Operativo"  type="text" variant="outlined" onInput={e=>this.setState({so: e.target.value})}  value={this.state.so}/> 
                <hr/>
                <TextField className="modalfield-short" label="RAM (MB)" type="number" variant="outlined" onInput={e=>this.setState({ram: e.target.value})}  value={this.state.ram}/> 
              </Grid>
              <Grid item className="text-together">
                <TextField className="modalfield-short" label="Pantalla (pulgadas)"  type="number" variant="outlined" onInput={e=>this.setState({pulgadas: e.target.value})}  value={this.state.pulgadas}/> 
                <hr/>
                <TextField className="modalfield-short" label="Memoria (GB)" type="number" variant="outlined" onInput={e=>this.setState({memoria: e.target.value})}  value={this.state.memoria}/> 
              </Grid>
            </Grid>:null
              
            }

            <Grid item>
            {this.props.comp?
              <Button id="actualizarCat" onClick={this.updateItem}>Actualizar</Button> :
              <Button id="agregarCat" onClick={this.addItem}>Agregar</Button>
            }
              <Button id="cancelarCat" onClick={this.props.comp? this.handleOpen: this.cancel }>Cancelar</Button>
            </Grid>
          </Grid>
        </Box>
      </Modal>
    </div>
  );
}
}

export default NuevoCatalogo;