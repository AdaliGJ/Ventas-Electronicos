import React, {useRef, useContext, useState} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import { Link, useHistory} from "react-router-dom";
import Alert from '@material-ui/lab/Alert';
import './login.css'
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



function Login(props){

    const[error, setError]=useState(false);
    const { setUsername, username, tipoUsuario, setTipoUsuario }=useContext(LoginContext);
        
    const usuarioRef = useRef(null);
    const contRef = useRef(null);

    const history = useHistory();

       const handleLogin=()=>{
                
        const url = 'http://localhost:8080/Usuarios/Login';
        const url2 = 'http://localhost:8080/Usuarios/Obtener';
               
        axios.get(url, {params: {nIdUsuario: usuarioRef.current.value, nPassword: contRef.current.value}}).then(response => response.data)
        .then((data) => {
          if(data.respuesta=="error"){
            setError(true);
          }else {
            setUsername(usuarioRef.current.value);
            axios.get(url2, {params: {nNit: usuarioRef.current.value}}).then(response => response.data)
            .then((data) => {
              setTipoUsuario(data.tipo_usuario);
            });
          }
          
          console.log(data);
        }) .catch((response)=>{
            console.log(response);
        });
 
              /*console.log(username);
                console.log(tipoUsuario);*/
                console.log("Hola");

        }


        return(
            <div className="page">
                    <h1 id="login_tit">Login</h1>
                    <Grid container direction={"column"} spacing={7}>
                        <Grid item>
                            <TextField className="standard-basic" label="NIT del usuario" placeholder="Usuario" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={usuarioRef} type="number"/>
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

export default Login;