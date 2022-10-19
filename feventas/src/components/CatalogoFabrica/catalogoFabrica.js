import './catalogoFabrica.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Grid from '@mui/material/Grid';
import Card from '@material-ui/core/Card';
import { withRouter } from "react-router";
import { Button, TextField } from '@material-ui/core';
import axios from 'axios';
import Comprar from '../comprar/comprar';
import Table from '@material-ui/core/Table';
import {  withStyles } from '@material-ui/core/styles';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import Paper from "@material-ui/core/Paper";
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import ComprarFabrica from './comprarFabrica'
import Icon from '@mui/material/Icon';
import NuevoCatalogo from '../NuevoCatalogo/nuevoCatalogo';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import SearchIcon from '@material-ui/icons/Search';

const StyledTableCell = withStyles({
    root: {
      color: "#ffffff"
    }
  })(TableCell);

  const StyledTable = withStyles({
    root: {
      /*width: "95%",*/
      overflow: 'scroll',
      color: "#ffffff"
    }
  })(Table);

class CatalogoFabrica extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            id: this.props.match.params.id,
            marca: "",
            ip: "",
            tipo_disp: '3',
            total: 0,
            inventario: '',
            televisor:'',
            imgs: [{imagen: ''}],
            inventario: [{}],
            marcas:  [{}]
        }
    } 
   
    buscar=()=>{
        const url= 'http://'+process.env.REACT_APP_IP+':8080/CatalogoFabrica'
            
        axios.get(url, {params: {nIP: this.state.marca.ip, nPort: "4000"}}).then(response => response.data)
          .then((data) => {
                this.setState({inventario: data});
                console.log(data);
            }
        
          );
        console.log(this.state.marca);
    }

    

    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

            const url= 'http://'+process.env.REACT_APP_IP+':8080/Marca/ObtenerTodos'

            axios.get(url).then(response => response.data)
              .then((data) => {
                this.setState({marcas: data});
                
                console.log(data);
              });

           
    }
    
    render(){
        return(
            <div className='page'>
                <div className="searchbar">
                    <h1>Escoger Fábrica</h1>
                        <FormControl className="outlined-short">
                            <InputLabel>Fábrica</InputLabel>
                            <Select label="Orden de precio" displayEmpty onChange={e=>this.setState({marca: e.target.value})}  value={this.state.marca}>
                            {this.state.marcas.map((m) => (
                                <MenuItem value={m}>{m.id_marca+" - "+m.nombre}</MenuItem>))  }
                            </Select>
                        </FormControl>
                        <Button onClick={this.buscar}><SearchIcon/></Button>
                    </div>
                <Card className="detalle">
                <h3>Catálogo Fábrica</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Categoría</StyledTableCell>
                                        <StyledTableCell align="right">Marca</StyledTableCell>
                                        <StyledTableCell align="right">Existencias</StyledTableCell>
                                        <StyledTableCell align="right">Precio Lista</StyledTableCell>
                                        <StyledTableCell align="right">Color</StyledTableCell>
                                        <StyledTableCell align="right">Descripcion</StyledTableCell>
                                        <StyledTableCell align="right">Modelo</StyledTableCell>
                                        <StyledTableCell align="right">Meses Garantía</StyledTableCell>
                                        <StyledTableCell align="center">Extras</StyledTableCell>
                                        <StyledTableCell align="right">Comprar</StyledTableCell>
                                        <StyledTableCell align="right">Añadir a Catálogo</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.inventario.map((inv) => (
                                        <TableRow key={inv._id}> 
                                            <TableCell align="right">{inv.categoria}</TableCell>
                                            <TableCell align="right">{inv.marca}</TableCell>
                                            <TableCell align="right">{inv.existencia}</TableCell>
                                            <TableCell align="right">{inv.precio}</TableCell>
                                            <TableCell align="right">{inv.color}</TableCell>
                                            <TableCell align="right">{inv.descripcion}</TableCell>
                                            <TableCell align="right">{inv.modelo}</TableCell>
                                            <TableCell align="right">{inv.diasEnvio}</TableCell>
                                            {inv.categoria=="Televisor"?
                                                <TableCell align="right">{<ul><li>{"Entradas HDMI: "+inv.hdmi}</li> 
                                                                                    <li>{"Bits de profundidad: "+inv.bits}</li>
                                                                                    <li>{"Pulgadas Pantalla: "+inv.pulgadas}</li>
                                                                                    <li>{"Resolución: "+inv.resolucion}</li></ul>}</TableCell>
                                            :inv.categoria=="Videojuego"?
                                            <TableCell align="right">{<ul><li>{"Jugadores: "+inv.maximoJugadores}</li> 
                                                                                    <li>{"Gráficos: "+inv.graficos}</li>
                                                                                    <li>{"Consola: "+inv.consola}</li></ul>}</TableCell>
                                            :inv.categoria=="Smartwatch"?
                                            <TableCell align="right">{<ul><li>{"Memoria: "+inv.memoria}</li> 
                                                                                    <li>{"Pulgadas pantalla: "+inv.pulgadasReloj}</li>
                                                                                    <li>{"MB de Ram: "+inv.ram}</li>
                                                                                    <li>{"Sistema Operativo: "+inv.sistemaOperativo}</li></ul>}</TableCell>

                                            :<TableCell></TableCell>}
                                            <StyledTableCell align="right">{<ComprarFabrica id={inv._id} ip={this.state.marca.ip}/>}</StyledTableCell>
                                            {inv.categoria=="Televisor"?
                                             <StyledTableCell align="right">{<NuevoCatalogo comp={false} titulo={"Añadir"} edit={true}
                                                    color={inv.color}
                                                    descripcion={inv.descripcion}
                                                    garantia={inv.garantia}
                                                    precio={inv.precio}
                                                    modelo={inv.modelo}
                                                    marca={this.state.marca.id_marca}
                                                    categoria={1}

                                                    res={inv.resolucion}
                                                    bits={inv.bits}
                                                    pulgadas={inv.pulgadas}
                                                    hdmi={inv.hdmi}

                                                    idFab={inv._id}
                                            
                                            />}</StyledTableCell>
                                            :inv.categoria=="Videojuego"?
                                            <StyledTableCell align="right">{<NuevoCatalogo comp={false} titulo={"Añadir"} edit={true}
                                                    color={inv.color}
                                                    descripcion={inv.descripcion}
                                                    garantia={inv.garantia}
                                                    precio={inv.precio}
                                                    modelo={inv.modelo}
                                                    marca={this.state.marca.id_marca}
                                                    categoria={2}


                                                    max_jug={inv.maximoJugadores}
                                                    graficos={inv.graficos}
                                                    consola={inv.consola}

                                                    idFab={inv._id}
                                            
                                            />}</StyledTableCell>
                                            :inv.categoria=="Smartwatch"?
                                            <StyledTableCell align="right">{ <NuevoCatalogo comp={false} titulo={"Añadir"} edit={true}
                                                    color={inv.color}
                                                    descripcion={inv.descripcion}
                                                    garantia={inv.garantia}
                                                    precio={inv.precio}
                                                    modelo={inv.modelo}
                                                    marca={this.state.marca.id_marca}
                                                    categoria={3}

                                                    so={inv.sistemaOperativo}
                                                    ram={inv.ram}
                                                    memoria={inv.memoria}
                                                    pulgadas={inv.pulgadasReloj}

                                                    idFab={inv._id}
                                                    
                                            />}</StyledTableCell>
                                            :<StyledTableCell align="right">{<NuevoCatalogo comp={false} titulo={"Añadir"} edit={true}
                                                    color={inv.color}
                                                    descripcion={inv.descripcion}
                                                    garantia={inv.garantia}
                                                    precio={inv.precio}
                                                    modelo={inv.modelo}
                                                    marca={this.state.marca.id_marca}
                                                    categoria={0}

                                                    idFab={inv._id}
                                            
                                            />}</StyledTableCell>}
                                        </TableRow>
                                    ))}
                                    </TableBody>
                                </StyledTable>
                </Card>
            </div>
        );
    }
}

export default CatalogoFabrica;

