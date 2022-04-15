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

const StyledTableCell = withStyles({
    root: {
      color: "#ffffff"
    }
  })(TableCell);

  const StyledTable = withStyles({
    root: {
      /*width: "95%",*/
      overflow: 'scroll'
    }
  })(Table);

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
            imgs: [{imagen: ''}],
            inventario: [{}]
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
                <Card className="detalle">
                <h3>Catálogo Fábrica</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">ID</StyledTableCell>
                                        <StyledTableCell align="right">Categoría</StyledTableCell>
                                        <StyledTableCell align="right">Marca</StyledTableCell>
                                        <StyledTableCell align="right">Existencias</StyledTableCell>
                                        <StyledTableCell align="right">Precio Lista</StyledTableCell>
                                        <StyledTableCell align="right">Color</StyledTableCell>
                                        <StyledTableCell align="right">Descripcion</StyledTableCell>
                                        <StyledTableCell align="right">Modelo</StyledTableCell>
                                        <StyledTableCell align="right">Meses Garantía</StyledTableCell>
                                        <StyledTableCell align="right">Extras</StyledTableCell>
                                        <StyledTableCell align="right">Comprar</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.inventario.map((inv) => (
                                        <TableRow>
                                            <TableCell align="right" component="th" scope="row">
                                            </TableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
                                            <StyledTableCell align="right"></StyledTableCell>
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