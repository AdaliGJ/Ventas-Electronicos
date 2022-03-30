import React, {useRef} from 'react';
import './signup.css'
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockIcon from '@material-ui/icons/Lock';
import Button from '@material-ui/core/Button';
import axios from 'axios'
import { LoginContext } from '../../context/LoginContext';
import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';







class SignUp extends React.Component{

  static contextType = LoginContext;
    
    
  constructor(props){
      super(props);
      this.state={
         user_type: null,
         password: '',
         nombre: '',
         nit: '',
         usuarios: []
      }

    }

    componentDidMount(){
      const context = this.context;
      this.setState({usuario: context.username,
        tipo_usuario: context.tipoUsuario});
    
      const url= 'http://localhost:8080/Tipo_usuario/ObtenerTodos'
    
      axios.get(url).then(response => response.data)
        .then((data) => {
          this.setState({usuarios: data});
          
          console.log(data);
        });
    
     }

  register=()=>{

    const url = 'http://localhost:8080/Usuarios/Insertar';

    let formData = new FormData();
    formData.append('nNit', this.state.nit);
    formData.append('nTipoUsuario', this.state.user_type);
    formData.append('nPassword', this.state.password);
    formData.append('nNombre', this.state.nombre);

    console.log(this.state.user_type);
    console.log(this.state.password);
    console.log(this.state.nombre);
    console.log(this.state.nit);

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


    console.log("Hola");
}

      render(){
        return(
            <div className="page">
                    <h1 id="login_tit">Registro</h1>
                    <Grid container direction={"column"} spacing={5}>
                        <Grid item>
                            <TextField type="number" onChange={e=>this.setState({nit: e.target.value})} className="standard-basic" label="NIT del Usuario" placeholder="NIT" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} />
                        </Grid>
                        <Grid item>
                            <TextField onChange={e=>this.setState({nombre: e.target.value})} className="standard-basic" label="Nombre de la persona" placeholder="Usuario" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} />
                        </Grid>
                        <Grid item>
                            <TextField onChange={e=>this.setState({password: e.target.value})} className="standard-basic" label="Contraseña" type="password"  InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <LockIcon />
                                  </InputAdornment>
                                ),
                              }} />
                        </Grid>
                        <Grid item>
                            <FormControl className="standard-basic"  >
                                <InputLabel InputLabelProps={{shrink: true }}>Tipo de Usuario</InputLabel>
                                <Select label="Tipo de Usuario" displayEmpty onChange={e=>this.setState({user_type: e.target.value})} value={this.state.user_type} >
                                {this.state.usuarios.map((m) => (
                                    <MenuItem value={m.id_tipo_usuario} key={m.id_tipo_usuario}>{m.nombre}</MenuItem>
                                ))}
                                </Select>
                            </FormControl> 
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
}

export default SignUp;