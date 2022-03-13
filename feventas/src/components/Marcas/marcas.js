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



function Marcas(props){

    const { setUsername, username, tipoUsuario, setTipoUsuario }=useContext(LoginContext);
    const [msg, setMsg]=useState('');
    const[error, setError]=useState(false);
        
    const usuarioRef = useRef(null);
    const contRef = useRef(null);

    const history = useHistory();

       const handleLogin=()=>{
                

               
                /*console.log(username);
                console.log(tipoUsuario);*/
                console.log("Hola");

        }


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
                              }} inputRef={usuarioRef}/>
                        </Grid>
                        
                    </Grid>
                    <Grid container direction={"column"} spacing={8}>
                        <Grid item id={error ? "error": "noerror"}>
                            <Alert severity="error">Error</Alert>
                        </Grid>
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={handleLogin}>Registrar Marca</Button>
                        </Grid>
                    </Grid>
            </div>
        );

}

export default Marcas;