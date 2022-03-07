import './inventario.css';
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

import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';

import Grid from '@mui/material/Grid';
import NuevoInventario from './nuevo';



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



class Inventario extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            serie: "",
            producto: null,
            id: null,
            usuario: null,
            inventario: [{serie: 1, producto: "Harold"}, {serie: 2, producto: "Jaime"}]
            
        }

        this.aproveData=this.aproveData.bind(this);
        this.deleteData=this.deleteData.bind(this);
    }


    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});
        
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
    
    render(){
        return(
            <div>
                <div className="page">
                <h2>Inventario</h2>
                    <NuevoInventario titulo="Añadir Producto"/>
                    <Grid container spacing={1}>
                        <Grid item xs={6}>
                            <Paper className="container">
                                <h3>Pedidos recibidos</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Serie</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Dar de Alta</StyledTableCell>
                                        <StyledTableCell align="right">Rechazar</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.inventario.map((inv) => (
                                        <TableRow key={inv.serie}>
                                            <TableCell align="right" component="th" scope="row">
                                                {inv.serie}
                                            </TableCell>
                                        <TableCell align="right">{inv.producto}</TableCell>
                                        <TableCell align="right"><Button id="aprobar" onClick={()=>this.aproveData(inv)}><CheckCircle/></Button></TableCell>
                                        <TableCell align="right"><Button id="rechazar" onClick={()=>this.deleteData(inv)}><DeleteForever/></Button></TableCell>
                                        </TableRow>
                                    ))}
                                    </TableBody>
                                </StyledTable>
                            </Paper>
                        </Grid>
                        <Grid item xs={6}>
                            <Paper className="container">
                                <h3>Inventario Actual</h3>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Serie</StyledTableCell>
                                        <StyledTableCell align="right">Producto</StyledTableCell>
                                        <StyledTableCell align="right">Editar</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.inventario.map((inv) => (
                                        <TableRow key={inv.serie}>
                                            <TableCell align="right" component="th" scope="row">
                                                {inv.serie}
                                            </TableCell>
                                        <TableCell align="right">{inv.producto}</TableCell>
                                        <TableCell align="right"><NuevoInventario titulo={<Edit/>} comp={true}/></TableCell>
                                        </TableRow>
                                    ))}
                                    </TableBody>
                                </StyledTable>
                            </Paper>
                        </Grid>
                    </Grid>
                    
                </div>
            </div>
        );
    }
}

export default Inventario;