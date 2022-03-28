import React, { Component } from 'react';
import Card from '@material-ui/core/Card';
import TextField from '@material-ui/core/TextField';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import CardActions from '@material-ui/core/CardActions';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import { LoginContext } from '../../context/LoginContext.js';
import './clientes.css';
import axios from 'axios'


class Clientes extends React.Component{
    static contextType = LoginContext;
    
    
    constructor(props){
        super(props);
        this.state={
            nit: null,
            full_name: '',
            email:'',
            telefono: null,
            tipo_suscricpion: null,
            vencimiento: null,
            img: null,
            archivo: '', 
            tipos_clientes: null
        }

        this.register=this.register.bind(this);
    }


    register(){
        const url = 'http://localhost:8080/Clientes/Insertar';

        let formData = new FormData();
        formData.append('nTipoCliente', this.state.tipo_suscricpion);
        formData.append('nNit', this.state.nit);



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

        /*axios.get(url, {params: {nTipoCliente: "1", nContraseña: "2"}}).then(response => response.data)
          .then((data) => {
            console.log(data);
          });


        console.log("Hola");*/
    }

   
    handleChange = e => {
        if(e.target.files[0]){
            this.setState({img:  e.target.files[0].name,
            archivo: e.target.files[0]});
            console.log(this.state.img);
        }else{
            this.setState({img: ''});
        }
      }

    
    
    componentDidMount(){

        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});


        const url = 'http://localhost:8080/Tipo_clientes/ObtenerTodos';

        axios.get(url).then(response => response.data)
        .then((data) => {
          this.setState({tipos_clientes: data});
          
          console.log(data);
        }) .catch((response)=>{
            console.log(response);
        });

    
    }
    
    render(){
        return(
            <div className="data">
                <Card className="data_form" mt={5}>
                <CardContent className="content">
                    <h1>Regístrese como cliente</h1>
                    <div className="register-data">
                    <Grid container direction={"column"} spacing={3}>
                        <Grid item className="text-together">
                            <TextField className="outlined-required" label="NIT" type="number"  onInput={e=>this.setState({nit: e.target.value})}  value={this.state.nit}/>
                            <hr/>
                            <TextField className="outlined-short" label="Nombre Completo" type="text"  onInput={e=>this.setState({full_name: e.target.value})}  value={this.state.full_name}/>
                        </Grid>
                        <Grid item className="text-together">    
                            <TextField className="outlined-required" label="Email" type="text"  onInput={e=>this.setState({email: e.target.value})}  value={this.state.email}/>    
                            <hr/>
                            <TextField className="outlined-required" label="Teléfono" type="number"  onChange={e=>this.setState({telefono: e.target.value})} value={this.state.telefono}/>
                        </Grid>
                        <Grid item className="text-together">
                          <TextField className="outlined-required" label="Fecha de Vencimiento" type="date"  onChange={e=>this.setState({vencimiento: e.target.value})} value={this.state.vencimiento} InputLabelProps={{shrink: true }}/>
                            <hr/>
                            <FormControl className="outlined-required"  >
                                <InputLabel InputLabelProps={{shrink: true }}>Tipo de Suscripción</InputLabel>
                                <Select label="Tipo de Suscripción" displayEmpty onChange={e=>this.setState({tipo_suscricpion: e.target.value})} value={this.state.tipo_suscricpion} >
                                    <MenuItem  value={3} type="number">Mayorista</MenuItem>
                                    <MenuItem  value={2} type="number">Gran Cliente</MenuItem>
                                </Select>
                            </FormControl> 
                        </Grid>
                    </Grid>
                    </div>
                </CardContent>
                <CardActions className="action">
                    <Grid container direction={"column"} spacing={0.1}>
                        <Grid item>
                            <TextField type="file" name="img-file" id="img-file" inputProps={{ accept: '.jpg, .png, .jpeg' }} onChange={this.handleChange}/>  
                                <label htmlFor="img-file"> 
                                    <Button id="send1" variant="contained" component="span">Subir Patente de Comercio</Button>
                                    <p>{this.state.img !=''? this.state.img : "Ninguna Imagen Seleccionada"}</p>
                                </label> 
                        </Grid>
                        <Grid item>
                            <Button  id="send2" variant="contained" onClick={this.register}>Aceptar</Button>
                            
                        </Grid>

                    </Grid>
                </CardActions>
                </Card>
            </div>
        );
    }
}

export default Clientes;