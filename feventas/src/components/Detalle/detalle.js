import './detalle.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Grid from '@mui/material/Grid';
import ImgCarousel, {SliderData} from './carrusel'
import Card from '@material-ui/core/Card';
import { withRouter } from "react-router";
import { Button, TextField } from '@material-ui/core';
import axios from 'axios';
import Comprar from '../comprar/comprar';


class Detalle extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            id: this.props.match.params.id,
            marca: "",
           
            tipo_disp: '3',
           
           /* precionum: 100,
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
            existencias: 5,*/
            total: 0,
            cantidad: 1,
            inventario: '',
            televisor:'',
            imgs: [{imagen: ''}],
            existencias: 0
        }
    } 
   
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario,
            precio: "Q"+this.state.precionum}); 
            console.log(SliderData);

            const url= 'http://'+process.env.REACT_APP_IP+':8080/Inventario/Obtener'
            const url2= 'http://'+process.env.REACT_APP_IP+':8080/Marca/Obtener'
            const url3= 'http://'+process.env.REACT_APP_IP+':8080/Tipo_dispositivo/Obtener'
            const url5= 'http://'+process.env.REACT_APP_IP+':8080/Imagenes_dispositivos/ObtenerA'
            const url6= 'http://'+process.env.REACT_APP_IP+':8080/Dispositivos_individuales/ObtenerCantidad'
      
            axios.get(url, {params: {nId: this.state.id}}).then(response => response.data)
              .then((data) => {
                this.setState({inventario: data});
                console.log(data.existencias);
                //console.log(data.marca);
                axios.get(url6, {params: {nId: this.state.id}}).then((response) => {
                    this.setState({existencias: response.data});
                    console.log(response.data);
                });

                axios.get(url2, {params: {nIdMarca: data.marca}}).then((data2) => {
                    this.setState({marca: data2.data.nombre});
                    //console.log(data2);
                });
                axios.get(url3, {params: {nIdTipoDispositivo: data.categoriaDispositivo}}).then((data3) => {
                    this.setState({tipo_disp: data3.data.nombre});
                    //console.log(data3);
                });
                axios.get(url5, {params: {nIdInventario: this.state.id}}).then((data5) => {
                   
                    this.setState({imgs: data5.data});
                    console.log(data5);
                    console.log(this.state.imgs);
                    
                });
                if(data.categoriaDispositivo==1){
                  const url4='http://'+process.env.REACT_APP_IP+':8080/Televisores/Obtener'
                    axios.get(url4, {params: {nIdInventario: data.idInventario}}).then((data4) => {
                        this.setState({televisor: data4.data});
                        //console.log(data4);
                    });
                }else if(data.categoriaDispositivo==2){
                    const url4='http://'+process.env.REACT_APP_IP+':8080/Videojuegos/Obtener'
                    axios.get(url4, {params: {nIdInventario: data.idInventario}}).then((data4) => {
                        this.setState({televisor: data4.data});
                        //console.log(data4);
                    });
                }else if(data.categoriaDispositivo==3){
                    const url4='http://'+process.env.REACT_APP_IP+':8080/Smartwatch/Obtener'
                    axios.get(url4, {params: {nIdInventario: data.idInventario}}).then((data4) => {
                        this.setState({televisor: data4.data});
                        //console.log(data4);
                    });
                }

              });
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
                                {this.state.inventario.categoriaDispositivo==1?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Resolución: "+this.state.televisor.resolucion}</li>
                                    <li>{"Bits de Profundidad: "+this.state.televisor.bits_profundidad_color}</li>
                                    <li>{"Pulgadas: "+this.state.televisor.pulgadas_pantalla}</li>
                                    <li>{"Entradas HDMI: "+this.state.televisor.entradas_HDMI}</li>
                                </ul>
                                    :this.state.inventario.categoriaDispositivo==2?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Máximo de Jugadores: "+this.state.televisor.max_jugadores}</li>
                                    <li>{"Gráficos: "+this.state.televisor.graficos}</li>
                                    <li>{"Consola: "+this.state.televisor.consola}</li>
                                </ul>:
                                    this.state.inventario.categoriaDispositivo==3?<ul>
                                    <h4>Extras:</h4>
                                    <li>{"Pulgadas: "+this.state.televisor.pulgadas_pantalla}</li>
                                    <li>{"Sistema Operativo: "+this.state.televisor.sistema_operativo}</li>
                                    <li>{"Disco Duro (GB): "+this.state.televisor_memoria_GB}</li>
                                    <li>{"RAM (MB): "+this.state.televisor.ram_MB}</li>
                                </ul>:
                                    null}
                            </div>
                        </Grid>
                        <Grid item xs={4}>
                            <div className="compra_1">
                               
                                <h2>{"Precio: Q"+this.state.inventario.precioLista/**this.state.total*/}</h2>
                                <h4>{"Existencias: "+this.state.existencias/**this.state.total*/}</h4>
                                <TextField className="outlined-required" label="Cantidad" type="number"  onInput={e=>this.setState({cantidad: e.target.value, total: e.target.value*this.state.inventario.precioLista})}  value={this.state.cantidad}/>
                                <br/>
                                <br/><Comprar existencias={this.state.existencias} tipo={this.props.match.params.id} producto={this.state.tipo_disp+" "+this.state.marca+" "+this.state.inventario.modelo} total={this.state.inventario.precioLista*this.state.cantidad} cantidad={this.state.cantidad}/>
                            </div>
                        </Grid>
                    </Grid>
                   
                    

                </Card>
            </div>
        );
    }
}

export default Detalle;