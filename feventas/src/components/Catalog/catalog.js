import './catalog.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Products from './products';


import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';


import Grid from '@mui/material/Grid';

class Catalog extends React.Component{
    
    static contextType = LoginContext;
   
    
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});
        
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
                    <div className="catalog">
                    <Grid container spacing={2}>
                        <Grid item xs={4}>
                           <Products id={1}/>
                        </Grid>
                        <Grid item xs={4}>
                            <Products id={4}/>
                        </Grid>
                        <Grid item xs={4}>
                            <Products id={2}/>
                        </Grid>
                    </Grid>
                    </div>
                    
                </div>
            </div>
        );
    }
}

export default Catalog;