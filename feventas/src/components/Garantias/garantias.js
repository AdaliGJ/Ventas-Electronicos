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
         marca: '',

         today: new Date(),

         idPV: '',
         idIV: '',
         cl: '',
         idInv: '',
         cantidad: '',
         fechaEntrega: '',
         port:'4000',
         pedir: false,
         vencida: false,
         idVentas: ''
  
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


        const url2= 'http://localhost:8080/Pedidos/ObtenerId'
   
          
        axios.get(url2).then(response => response.data)
          .then((data) => {
            this.setState({idVentas: data});
            
            console.log(data);
          }).catch((response)=>{
            this.setState({idVentas: 0});
        });
    
     }

  pedir=()=> {  
    const url = 'http://localhost:8080/PedidoGarantia';

    let formData = new FormData();
    formData.append('nIdPedidoVentas', this.state.idVentas +1);
    formData.append('nIdInventarioVentas', this.state.idIV);
    formData.append('nCliente', this.state.cl);
    formData.append('nIdInventario', this.state.idInv);
    formData.append('nCantidad', this.state.cantidad);
    formData.append('nIP', this.state.marca.ip);
    formData.append('nPort', '4000');

    axios.post(url, formData, {headers: {"Content-Type": "application/json"}})
      .then((response)=>{
          console.log(response);
      })
      .catch((response)=>{
        console.log(response);
      });

      const url6 = 'http://localhost:8080/Pedidos/Insertar';
      let formData6 = new FormData();
      formData6.append('nidpedido', this.state.idVentas + 1);
      formData6.append('nfecha', this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());
      formData6.append('nidInventario', this.state.idIV);
      formData6.append('ncantidad', '1');
      formData6.append('nestado', 'registrado');
      formData6.append('nfechaEntrega', '');
    
      axios.post(url6, formData6, {headers: {"Content-Type": "application/json"}})
      .then((response)=>{
          console.log(response);
      })
      .catch((response)=>{
        console.log(response);
      });

      const url2 = 'http://localhost:8080/Dispositivos_individuales/Prueba';

      let formData2 = new FormData();
      formData.append('nId', this.state.idIV);
      formData.append('nSerie', this.state.serie);
      formData.append('nVendido', 2);

      axios.post(url2, formData, {headers: {"Content-Type": "application/json"}})
      .then((response)=>{
          console.log(response);
          this.setState({serie: ''});
      })
      .catch((response)=>{
        console.log(response);
    });
 

  }

  register=()=>{

    const url = 'http://localhost:8080/ValidarGarantia';

    let formData = new FormData();
    formData.append('nSerie', this.state.serie);
    formData.append('nIP', this.state.marca.ip);

    axios.get(url, {params: {nSerie: this.state.serie, nIP:this.state.marca.ip }}).then(response => response.data)
    .then((data) => {
      if(data.Garantia == "Devuelto"){
          this.setState({
            idPV: data.Pedido.idPedidoVentas,
            idIV: data.Pedido.idInventarioVentas,
            cl: data.Pedido.cliente,
            idInv: data.Pedido.idInventario,
            cantidad: '1',
            fechaEntrega: data.Pedido.fechaEntrega,
            pedir: true
          })
      }else{
        this.setState({vencida: true})
      }
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
                        {this.state.pedir?
                        <Grid item>
                            <Button id="pedir" variant="contained" onClick={this.pedir}>Pedir Devolución a Fábrica</Button>
                        </Grid>: null}
                        {this.state.vencida?
                        <p>Error la Garantía ya venció</p>: null}
                    </Grid>
            </div>
        );
    }
}

export default Garantias;