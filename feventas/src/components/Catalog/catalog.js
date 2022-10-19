import './catalog.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Products from './products';


import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';

import NuevoCatalogo from '../NuevoCatalogo/nuevoCatalogo';
import Grid from '@mui/material/Grid';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';


import axios from 'axios';

class Catalog extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            serie: "",
            producto: null,
            id: null,
            usuario: null,
            orden: 1,
            busc: '',
            inventario: []
            
        }

        this.buscar=this.buscar.bind(this);

    }
    
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        /*const url= 'http://'+process.env.REACT_APP_IP+':8080/Inventario/ObtenerTodos'*/

        //const url= 'http://'+process.env.REACT_APP_IP+':8080/VistaImgs/ObtenerTodos'

        const url= 'http://'+process.env.REACT_APP_IP+':8080/VistaCatalogo/ObtenerInventarioAsc'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            
            console.log(data);
            console.log(this.state.inventario);
          });

        const url2 = 'http://'+process.env.REACT_APP_IP+':8080/Inventario/PruebaPost';
      
        axios.post(url2)
        .then((response)=>{
            console.log(response);
        })
        .catch((response)=>{
          console.log(response);
      });
       
        
    }

    buscar=()=>{
        if(this.state.orden==2){
        const url= 'http://'+process.env.REACT_APP_IP+':8080/VistaCatalogo/BuscarMenorMayor'
      
        axios.get(url, {params:{nBusqueda: this.state.busc}}).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            
            console.log(data);
            console.log(this.state.inventario);
          });
        }else{
            const url= 'http://'+process.env.REACT_APP_IP+':8080/VistaCatalogo/BuscarMayorMenor'
          
            axios.get(url, {params:{nBusqueda: this.state.busc}}).then(response => response.data)
              .then((data) => {
                this.setState({inventario: data});
                
                console.log(data);
                console.log(this.state.inventario);
              });
            }
      }
    
    render(){
        return(
            <div>
                <div className="page">
                <h2>Búsqueda de Dispositivos</h2>
                    <div className="searchbar">
                        <FormControl className="outlined-short">
                            <InputLabel>Orden de Precio</InputLabel>
                            <Select label="Orden de precio" displayEmpty onChange={e=>this.setState({orden: e.target.value})}  value={this.state.marca}>
                                <MenuItem value={1}>Mayor a Menor</MenuItem>
                                <MenuItem value={2}>Menor a Mayor</MenuItem>
                            </Select>
                        </FormControl>
                        --
                        <TextField className="outlined-short" label="Dispositivo"  name="dispositivo" onChange={e=>this.setState({busc: e.target.value})}/>
                        <Button onClick={this.buscar}><SearchIcon/></Button>
                    </div>
                    {this.state.tipo_usuario == 1?
                    <NuevoCatalogo comp={false} titulo={"Añadir producto"} edit={false} />:null}
                    <div className="catalog">
                    <Grid container spacing={2}>
                    {this.state.inventario.map((inv) => (
                        <Grid item xs={4}>
                           <Products id={inv.idinventario} precio={inv.preciolista} existencias={inv.existencias} image={inv.imagen} desc={inv.descripcion} modelo={inv.tipodispositivo +" " +inv.nombremarca+" " +inv.modelo} marca={inv.marca}/>
                        </Grid>
                    ))}
                    </Grid>
                    </div>
                    
                </div>
            </div>
        );
    }
}

export default Catalog;