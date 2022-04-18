import './pedidos.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Table from '@material-ui/core/Table';
import {  withStyles } from '@material-ui/core/styles';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import Paper from "@material-ui/core/Paper";
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import {CheckCircle, DeleteForever} from '@material-ui/icons/';
import {Edit} from '@material-ui/icons/';
import axios from 'axios';
import EstadoPedido from './estadoPedido';

import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';

import Grid from '@mui/material/Grid';



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



class Pedidos extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            serie: "",
            producto: null,
            id: null,
            usuario: null,
            inventario: [{serie: 1, producto: 2}, {serie: 2, producto: 4}],
            inventario2: [{serie: 1, producto: 2}, {serie: 2, producto: 4}]
            
        }

        this.aproveData=this.aproveData.bind(this);
        this.deleteData=this.deleteData.bind(this);
    }


    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

        const url= 'http://localhost:8080/Pedidos/ObtenerRegistrados'
      
        axios.get(url, {params: {nEstado: 'entregado'}}).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            
            console.log(data);
          });

          axios.get(url, {params: {nEstado: 'registrado'}}).then(response => response.data)
          .then((data) => {
            this.setState({inventario2: data});
            
            console.log(data);
          });
        
    }

    aproveData=(datos)=>{
       /* const url = 'http://localhost/scripts/solicitudes.php';

        let formData = new FormData();
        console.log(datos);

        formData.append('dpi', datos.dpi_empleado);


        axios.post(url, formData)
        .then((response) => {
            console.log(response);
            this.getData();
        })
        .catch( (response) =>{
            console.log(response);
        });*/
    }

    deleteData=(datos)=>{
       /* const url = 'http://localhost/scripts/eliminar_solicitudes.php';

        let formData = new FormData();
        console.log(datos);

        formData.append('dpi', datos.dpi_empleado);


        axios.post(url, formData)
        .then((response) => {
            console.log(response);
            this.getData();
        })
        .catch( (response) =>{
            console.log(response);
        });*/
    }

    

     /*componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        /*const url= 'http://localhost:8080/Dispositivos_individuales/ObtenerTodos'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            
            console.log(data);
          });
      
       }*/
    
    render(){
        return(
            <div>
                <div className="page">
                <h2>Pedidos</h2>
                    <Grid container spacing={1}>
                        <Grid item xs={6}>
                            <Paper className="container">
                                <h3>Pedidos Creados</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    {this.state.tipo_usuario == 1?
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Pedido</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Cantidad</StyledTableCell>
                                        <StyledTableCell align="right">Cancelar</StyledTableCell>
                                    </TableRow>:
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Pedido</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Cantidad</StyledTableCell>
                                    </TableRow>}
                                    </TableHead>
                                    {this.state.tipo_usuario == 1?
                                    <TableBody>
                                    {this.state.inventario2.map((inv) => (
                                        <TableRow key={inv.idpedido}>
                                            <TableCell align="right" component="th" scope="row">
                                                {inv.idpedido}
                                            </TableCell>
                                        <TableCell align="right">{inv.idInventario}</TableCell>
                                        <TableCell align="right">{inv.cantidad}</TableCell>
                                        <TableCell align="right"><EstadoPedido titulo={<DeleteForever/>} id={inv.idpedido} estado={'cancelado'}/></TableCell>
                                        </TableRow>
                                    ))}
                                    </TableBody>:
                                     <TableBody>
                                     {this.state.inventario2.map((inv) => (
                                         <TableRow key={inv.idpedido}>
                                             <TableCell align="right" component="th" scope="row">
                                                {inv.idpedido}
                                             </TableCell>
                                             <TableCell align="right">{inv.idInventario}</TableCell>
                                        <TableCell align="right">{inv.cantidad}</TableCell>
                                         </TableRow>
                                     ))}
                                     </TableBody>}
                                </StyledTable>
                            </Paper>
                        </Grid>
                        <Grid item xs={6}>
                            <Paper className="container">
                                <h3>Pedidos Recibidos</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    {this.state.tipo_usuario == 1?
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Pedido</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Cantidad</StyledTableCell>
                                        <StyledTableCell align="right">Confirmar Recibido</StyledTableCell>
                                    </TableRow>:
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Pedido</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Cantidad</StyledTableCell>
                                    </TableRow>}
                                    </TableHead>
                                    {this.state.tipo_usuario == 1?
                                    <TableBody>
                                    {this.state.inventario.map((inv) => (
                                        <TableRow key={inv.idpedido}>
                                            <TableCell align="right" component="th" scope="row">
                                                {inv.idpedido}
                                            </TableCell>
                                        <TableCell align="right">{inv.idInventario}</TableCell>
                                        <TableCell align="right">{inv.cantidad}</TableCell>
                                        <TableCell align="right"><EstadoPedido titulo={<CheckCircle/>} id={inv.idpedido} estado={'recibido'}/></TableCell>
                                        </TableRow>
                                    ))}
                                    </TableBody>:
                                     <TableBody>
                                     {this.state.inventario.map((inv) => (
                                         <TableRow key={inv.idpedido}>
                                         <TableCell align="right" component="th" scope="row">
                                             {inv.idpedido}
                                         </TableCell>
                                         <TableCell align="right">{inv.idInventario}</TableCell>
                                         <TableCell align="right">{inv.cantidad}</TableCell>
                                         </TableRow>
                                     ))}
                                     </TableBody>}
                                </StyledTable>
                            </Paper>
                        </Grid>
                    </Grid>
                    
                </div>
            </div>
        );
    }
}

export default Pedidos;