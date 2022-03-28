import React, {useRef, useContext, useState} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import { Link, useHistory} from "react-router-dom";
import Alert from '@material-ui/lab/Alert';
import './marcas.css'
import Card from '@material-ui/core/Card';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockIcon from '@material-ui/icons/Lock';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import axios from 'axios';


class Marcas extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            marca: ''
        }
    } 

    
    

    handleLogin=()=>{
                
        const url = 'http://localhost:8080/Marca/Insertar';

        let formData = new FormData();
        formData.append('nNombre', this.state.marca);
               
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
    

        }

        render(){
        return(
            <div className="page">
                    <h1 id="login_tit">Registro Marcas</h1>
                    <Grid container direction={"column"} spacing={7}>
                        <Grid item>
                            <TextField className="standard-basic" label="Marca" placeholder="Marca" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} onChange={e=>this.setState({marca: e.target.value})} value={this.state.marca} />
                        </Grid>
                        
                    </Grid>
                    <Grid container direction={"column"} spacing={8}>
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={this.handleLogin}>Registrar Marca</Button>
                        </Grid>
                    </Grid>
            </div>
        );
    }
}

export default Marcas;