import React, {useRef, useContext, useState} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import { Link, useHistory} from "react-router-dom";
import Alert from '@material-ui/lab/Alert';
import './fabricaLog.css'
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockIcon from '@material-ui/icons/Lock';

import Button from '@material-ui/core/Button';
import axios from 'axios';



function FabricaLog(props){

    const[error, setError]=useState(false);
    const { setUsername, username, tipoUsuario, setTipoUsuario }=useContext(LoginContext);
        
    const usuarioRef = useRef('');
    const contRef = useRef('');

    const history = useHistory();

       const handleLogin=()=>{
                
        const url = 'http://localhost:8080/AutCliente';
       //const url2 = 'http://localhost:8080/Usuarios/Obtener';

        
        let formData = new FormData();
        formData.append('nCliente', usuarioRef.current.value);
        formData.append('nPassword', contRef.current.value);
        formData.append('nIP', "1");
        formData.append('nPort', "22");
               
        axios.post(url, formData,  {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }})
            .then((response)=>{
                console.log(response);
                if(response._id=="error"){
                    setError(true);
                }else{
                    history.push("/caralogo-fabrica");
                }    
            })
            .catch((response)=>{
                console.log(response);
                setError(true);
            });

            history.push("/catalogo-fabrica");

        }
 



        return(
            <div className="page">
                    <h1 id="login_tit">Autenticarse</h1>
                    <Grid container direction={"column"} spacing={7}>
                        <Grid item>
                            <TextField className="standard-basic" label="Correo" placeholder="Correo" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={usuarioRef} type="text"/>
                        </Grid>
                        <Grid item>
                            <TextField className="standard-basic" label="Contraseña" type="password"  InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <LockIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={contRef}/>
                        </Grid>
                    </Grid>
                    <Grid container direction={"column"} spacing={0}>
                        <Grid item id={error ? "error": "noerror"}>
                            <Alert className="alerta "severity="error">Error: usuario o contraseña incorrectos</Alert>
                        </Grid>
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={handleLogin}>Inicar Sesión</Button>
                        </Grid>
                    </Grid>
            </div>
        );

}

export default FabricaLog;