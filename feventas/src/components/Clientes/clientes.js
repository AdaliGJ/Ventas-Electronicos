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
        }

        this.register=this.register.bind(this);
    }


    register(){
        console.log("Hola");
    }

   


    
    
    componentDidMount(){

   
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
                                <Select label="Tipo de Suscripció" displayEmpty onChange={e=>this.setState({tipo_suscricpion: e.target.value})} value={this.state.tipo_suscricpion} >
                                    <MenuItem  value={1} type="number">Mayorista</MenuItem>
                                    <MenuItem  value={2} type="number">Gran Cliente</MenuItem>
                                </Select>
                            </FormControl> 
                        </Grid>
                    </Grid>
                    </div>
                </CardContent>
                <CardActions className="action">
                    <Grid container direction={"column"} spacing={1}>
                        <Grid item>
                            <Button id="send1" variant="contained" onClick={this.register}>Actualizar los datos</Button>
                        </Grid>
                        <Grid item>
                            <Button  id="send2" variant="contained" onClick={this.register}>laa</Button>
                        </Grid>

                    </Grid>
                </CardActions>
                </Card>
            </div>
        );
    }
}

export default Clientes;