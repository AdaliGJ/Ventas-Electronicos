import './catalog.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Products from './products';


import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';

import NuevoCatalogo from '../NuevoCatalogo/nuevoCatalogo';
import Grid from '@mui/material/Grid';

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
            inventario: []
            
        }
    }
    
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        /*const url= 'http://localhost:8080/Inventario/ObtenerTodos'*/

        const url= 'http://localhost:8080/VistaImgs/ObtenerTodos'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            
            console.log(data);
            console.log(this.state.inventario);
          });

        const url2 = 'http://localhost:8080/Inventario/PruebaPost';
      
        axios.post(url2)
        .then((response)=>{
            console.log(response);
        })
        .catch((response)=>{
          console.log(response);
      });
       
        
    }
    
    render(){
        return(
            <div>
                <div className="page">
                <h2>Búsqueda de Dispositivos</h2>
                    <div className="searchbar">
                        <TextField className="outlined-required" label="Dispositivo"  name="dispositivo"/>
                        <Button><SearchIcon/></Button>
                    </div>
                    <NuevoCatalogo comp={false} titulo={"Añadir producto"}/>
                    <div className="catalog">
                    <Grid container spacing={2}>
                    {this.state.inventario.map((inv) => (
                        <Grid item xs={4}>
                           <Products id={inv.idinventario}  image={inv.imagen} desc={inv.descripcion} modelo={inv.modelo} marca={inv.marca}/>
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