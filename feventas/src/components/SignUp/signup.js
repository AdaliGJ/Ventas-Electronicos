import React, {useRef} from 'react';
import './signup.css'
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockIcon from '@material-ui/icons/Lock';
import Button from '@material-ui/core/Button';
import axios from 'axios'







function SignUp(props){

  const user_type = useRef(null);
  const contRef = useRef(null);
  const nombre = useRef(null);


  const register=()=>{

    const url = 'http://localhost:8080/Usuarios/Insertar';

    let formData = new FormData();
    formData.append('nTipoUsuario', user_type);
    formData.append('nPassword', contRef);
    formData.append('nNombre', nombre);

    

    axios.post(url, {params: {'nTipoUsuario': user_type, 'nPassword': contRef, 'nNombre': nombre}})
    .then((response)=>{
        console.log(response);
        this.setState({open: true});
    })
    .catch((response)=>{
        console.log(response);
    });


    console.log("Hola");
}


        return(
            <div className="page">
                    <h1 id="login_tit">Registro</h1>
                    <Grid container direction={"column"} spacing={7}>
                        <Grid item>
                            <TextField onChange={e=>this.setState({nombre: e.target.value})} className="standard-basic" label="Nombre de usuario" placeholder="Usuario" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={nombre}/>
                        </Grid>
                        <Grid item>
                            <TextField onChange={e=>this.setState({password: e.target.value})} className="standard-basic" label="Contraseña" type="password"  InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <LockIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={contRef}/>
                        </Grid>
                        <Grid item>
                            <TextField onChange={e=>this.setState({user_type: e.target.value})} className="standard-basic" label="Tipo de usuario" type="Apellido"  InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <LockIcon />
                                  </InputAdornment>
                                ),
                              }} inputRef={contRef}/>
                        </Grid>
                    </Grid>
                    <Grid container direction={"column"} spacing={8}>
                        
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={this.register}>Registrar</Button>
                        </Grid>
                    </Grid>
            </div>
        );

}

export default SignUp;