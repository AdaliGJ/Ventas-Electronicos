import './catalogoFabrica.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Grid from '@mui/material/Grid';
import Card from '@material-ui/core/Card';
import { withRouter } from "react-router";
import { Button, TextField } from '@material-ui/core';
import axios from 'axios';
import Comprar from '../comprar/comprar';


class CatalogoFabrica extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            id: this.props.match.params.id,
            marca: "",
           
            tipo_disp: '3',
           
            total: 0,

            inventario: '',
            televisor:'',
            imgs: [{imagen: ''}]
        }
    } 
   
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

            const url= 'http://localhost:8080/CatalogoFabrica'
            
            axios.get(url).then(response => response.data)
              .then((data) => {
                    this.setState({inventario: data})
                }
            
              );
    }
    
    render(){
        return(
            <div className='page'>
                <h1>{this.state.tipo_disp+" "+this.state.marca+" "+this.state.inventario.modelo}</h1>
                <Card className="detalle">
                <Grid container spacing={4}>
                        <Grid item xs={4}>
                            {this.state.imgs.map((p) => (
                                <img src={p.imagen} width="50%"/>
                        ))}
                        </Grid>
                        <Grid item xs={4}>
                            <div className='Especificaciones'>
                                <h3>Especificaciones: </h3>
                                <ul>
                                    <li>{"Dispositivo: "+this.state.tipo_disp}</li>
                                    <li>{"Marca: "+this.state.marca}</li>
                                    <li>{"Modelo: "+this.state.inventario.modelo}</li>
                                    <li>{"Color: "+this.state.inventario.color}</li>
                                    <li>{"Precio: Q"+this.state.inventario.precioLista}</li>
                                    <li>{"Garantía: "+this.state.inventario.mesesGarantia+" meses"}</li>
                                </ul>
                            
                            </div>
                        </Grid>
                        <Grid item xs={4}>
                            <div className="compra_1">
                               
                                <h2>{"Total: Q"+this.state.inventario.precioLista/**this.state.total*/}</h2>
                                <br/>
                                <br/><Comprar tipo={this.props.match.params.id} producto={this.state.tipo_disp+" "+this.state.marca+" "+this.state.inventario.modelo} total={this.state.inventario.precioLista}/>
                            </div>
                        </Grid>
                    </Grid>
                   
                    

                </Card>
            </div>
        );
    }
}

export default CatalogoFabrica;