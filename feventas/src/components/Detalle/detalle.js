import './detalle.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Grid from '@mui/material/Grid';
import ImgCarousel, {SliderData} from './carrusel'
import Card from '@material-ui/core/Card';
import { withRouter } from "react-router";
import { Button, TextField } from '@material-ui/core';


class Detalle extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            id: this.props.match.params.id,
            marca: "marca",
            modelo: "modelo X1",
            tipo_disp: 3,
            dispositivo: "Teléfono",
            color: "rojo",
            precionum: 100,
            precio: "",
            garantia: "1 año",
            res: "2x100",
            bits: 2,
            pantalla: 2,
            hdmi: 1,
            jugadores: 2,
            graficos: "n",
            consola: "Nintendo",
            so: "Android",
            hd: 512,
            ram: 8, 
            existencias: 5,
            total: 0
        }
    } 
   
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario,
            precio: "Q"+this.state.precionum}); 
    }
    
    render(){
        return(
            <div className='page'>
                <h1>{this.state.id+" "+this.state.marca+" "+this.state.modelo}</h1>
                <Card className="detalle">
                <Grid container spacing={4}>
                        <Grid item xs={4}>
                            <ImgCarousel slides={SliderData}/>
                        </Grid>
                        <Grid item xs={4}>
                            <div className='Especificaciones'>
                                <h3>Especificaciones: </h3>
                                <ul>
                                    <li>{"Dispositivo: "+this.state.dispositivo}</li>
                                    <li>{"Marca: "+this.state.marca}</li>
                                    <li>{"Modelo: "+this.state.modelo}</li>
                                    <li>{"Color: "+this.state.color}</li>
                                    <li>{"Precio: "+this.state.precio}</li>
                                    <li>{"Garantía: "+this.state.garantia}</li>
                                </ul>
                                {this.state.tipo_disp==1?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Resolución: "+this.state.res}</li>
                                    <li>{"Bits de Profundidad: "+this.state.bits}</li>
                                    <li>{"Pulgadas: "+this.state.pantalla}</li>
                                    <li>{"Entradas HDMI: "+this.state.hdmi}</li>
                                </ul>
                                    :this.state.tipo_disp==2?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Máximo de Jugadores: "+this.state.jugadores}</li>
                                    <li>{"Gráficos: "+this.state.graficos}</li>
                                    <li>{"Consola: "+this.state.consola}</li>
                                </ul>:
                                    this.state.tipo_disp==3?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Pulgadas: "+this.state.pantalla}</li>
                                    <li>{"Sistema Operativo: "+this.state.so}</li>
                                    <li>{"Disco Duro (GB): "+this.state.hd}</li>
                                    <li>{"RAM (MB): "+this.state.ram}</li>
                                </ul>:
                                    null}
                            </div>
                        </Grid>
                        <Grid item xs={4}>
                            <div className="compra_1">
                                <h3>Cantidad de productos:</h3>
                                <TextField type="number" id="quantity" name="quantity" InputProps={{ inputProps: { min: 1, max: this.state.existencias } }} onChange={e=>this.setState({total: e.target.value})}  value={this.state.total}/>
                                <br/>
                                <h2>{"Total: Q"+this.state.precionum*this.state.total}</h2>
                                <br/>
                                <br/><Button>Comprar</Button>
                            </div>
                        </Grid>
                    </Grid>
                   
                    

                </Card>
            </div>
        );
    }
}

export default Detalle;