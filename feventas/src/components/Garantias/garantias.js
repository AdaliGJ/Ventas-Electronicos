import React, {useRef} from 'react';
import './garantias.css'
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





class Garantias extends React.Component{

  static contextType = LoginContext;
    
    
  constructor(props){
      super(props);
      this.state={
         ip: '',
         serie: '',
         marcas: [],
         marca: ''
      }

    }

    componentDidMount(){
      const context = this.context;
      this.setState({usuario: context.username,
        tipo_usuario: context.tipoUsuario});
    
      const url= 'http://localhost:8080/Marca/ObtenerTodos'
    
      axios.get(url).then(response => response.data)
        .then((data) => {
          this.setState({marcas: data});
          
          console.log(data);
        });
    
     }

  register=()=>{

    const url = 'http://localhost:8080/ValidarGarantia';

    let formData = new FormData();
    formData.append('nSerie', this.state.serie);
    formData.append('nIP', this.state.marca.ip);

    axios.get(url, {params: {nSerie: this.state.serie, nIP:this.state.marca.ip }}).then(response => response.data)
    .then((data) => {
      this.setState({ip: '', marca: ''});
      
      console.log(data);
    });


    console.log("Hola");
}

      render(){
        return(
            <div className="page">
                    <h1 id="login_tit">Validación de Garantía</h1>
                    <Grid container direction={"column"} spacing={5}>
                        <Grid item>
                            <TextField type="text" onChange={e=>this.setState({serie: e.target.value})} className="standard-basic" label="Serie" placeholder="Serie del Dispositivo" />
                        </Grid>
                        <Grid item>
                            <FormControl className="standard-basic"  >
                                <InputLabel InputLabelProps={{shrink: true }}>Marca del Dispositivo</InputLabel>
                                <Select label="Marca del Dispositivo" displayEmpty onChange={e=>this.setState({marca: e.target.value})} value={this.state.marca} >
                                {this.state.marcas.map((m) => (
                                    <MenuItem value={m} key={m.id_marca}>{m.nombre}</MenuItem>
                                ))}
                                </Select>
                            </FormControl> 
                        </Grid>
                    </Grid>
                    <Grid container direction={"column"} spacing={8}>
                        
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={this.register}>ValidarGarantia</Button>
                        </Grid>
                    </Grid>
            </div>
        );
    }
}

export default Garantias;