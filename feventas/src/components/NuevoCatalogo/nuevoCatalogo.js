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

          color:this.props.edit? this.props.color:"",
          descripcion:this.props.edit? this.props.descripcion:"",
          garantia: this.props.edit? this.props.garantia:0,
          precio:this.props.edit? this.props.precio:'',
          modelo: this.props.edit? this.props.modelo: "",
          marca: this.props.edit? this.props.marca:0,
          categoria: this.props.edit? this.props.categoria:0,
          marcas: [{id: 1, nombre: "Samsung"}, {id: 2, nombre: "Amazon"}],
          tipo_productos: [],

          imgs: '',
          archivos: '',

         
          res: this.props.res? this.props.res:'',
          bits: this.props.bits? this.props.bits:0,
          pulgadas: this.props.pulgadas? this.props.pulgadas:0,
          hdmi: this.props.hdmi? this.props.hdmi:0,

          max_jug:  this.props.max_jug? this.props.max_jug:0,
          graficos:  this.props.graficos? this.props.graficos:'',
          consola:  this.props.consola? this.props.consola:'',

          so:  this.props.so? this.props.so:'',
          ram: this.props.ram? this.props.ram:0,
          memoria:  this.props.memoria? this.props.memoria:0,

          img1: '',
          img2: '',
          img3: ''
          
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
    const url = 'http://'+process.env.REACT_APP_IP+':8080/Procedimiento/Insertar';

        
        let formData = new FormData();
        formData.append('nCategoriaDispositivo', this.state.categoria);
        formData.append('nMarca', this.state.marca);
        formData.append('nExistencias', 0);
        formData.append('nPrecioLista', this.state.precio);
        formData.append('nColor', this.state.color);
        formData.append('nDescripcion', this.state.descripcion);
        formData.append('nModelo', this.state.modelo);
        formData.append('nMesesGarantia', this.state.garantia);
        

        formData.append('nResolucion', this.state.res);
        formData.append('nBitsProfundidad', this.state.bits);
        formData.append('nPulgadasPantalla', this.state.pulgadas);
        formData.append('nEntradasHDMI', this.state.hdmi);
        
        formData.append('nSistemaOperativo', this.state.so);
        formData.append('nRamMB', this.state.ram);
        formData.append('nMemoriaGB', this.state.memoria);

        formData.append('nMaxJugadores', this.state.max_jug);
        formData.append('nGraficos', this.state.graficos);
        formData.append('nConsola', this.state.consola);

        formData.append('nAccion', "ins");

        formData.append('nImg1', this.state.img1);
        formData.append('nImg2', this.state.img2);
        formData.append('nImg3', this.state.img3);

        


      axios.post(url, formData,  {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }})
        .then((response)=>{
        console.log(response);
        this.setState({open: false});
        })
        .catch((response)=>{
        console.log(response);
        });

        if(this.props.edit){
          const url2 = 'http://'+process.env.REACT_APP_IP+':8080/Procedimiento/Mapeo';

        
          let formData2 = new FormData();
          formData2.append('nId', this.props.idFab);
          formData2.append('nMarca', this.state.marca);
          formData2.append('nCategoria', this.props.categoria);

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

        }

        




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

  const url= 'http://'+process.env.REACT_APP_IP+':8080/Tipo_dispositivo/ObtenerTodos'

  axios.get(url).then(response => response.data)
    .then((data) => {
      this.setState({tipo_productos: data});
      
      console.log(data);
    });

    const url2= 'http://'+process.env.REACT_APP_IP+':8080/Marca/ObtenerTodos'

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
              <TextField className="modalfield-short" label="Costo (Q)" type="text" variant="outlined" onInput={e=>this.setState({precio: e.target.value})}  value={this.state.precio}/> 
            </Grid>
            <Grid item className="text-together">
              <TextField className="modalfield" label="Descripción"  type="text" multiline rows={4} variant="outlined" onInput={e=>this.setState({descripcion: e.target.value})}  value={this.state.descripcion}/> 
            </Grid>
            <Grid item className="text-together">
                <TextField className="modalfield" label="Link Imagen 1"  type="text" variant="outlined" onInput={e=>this.setState({img1: e.target.value})}  value={this.state.img1}/> 
            </Grid>
            <Grid item className="text-together">
                <TextField className="modalfield" label="Link Imagen 2"  type="text" variant="outlined" onInput={e=>this.setState({img2: e.target.value})}  value={this.state.img2}/> 
            </Grid>
            <Grid item className="text-together">
                <TextField className="modalfield" label="Link Imagen 3"  type="text" variant="outlined" onInput={e=>this.setState({img3: e.target.value})}  value={this.state.img3}/> 
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