import './clientes.css';
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



class ClientsTable extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            id: null,
            nombre: '',
            clientes: [],
            tipo: null,
            today: new Date()
        }

        this.aproveData=this.aproveData.bind(this);
        this.deleteData=this.deleteData.bind(this);
    }



    aproveData=(d1, d2)=>{
        const url= 'http://'+process.env.REACT_APP_IP+':8080/Procedimiento/CambioFecha'

        

        let formData = new FormData();
        console.log(d1);

        formData.append('nId', d2);
        formData.append('nAccion', d1);
        formData.append('nFecha', this.state.today.getDate().toString()+'-'+this.state.today.getMonth().toString()+'-'+this.state.today.getFullYear().toString());


        axios.post(url, formData)
        .then((response) => {
            console.log(response);
            this.getData();
        })
        .catch( (response) =>{
            console.log(response);
        });
    }

    deleteData=(datos)=>{
       /* const url = 'http://'+process.env.REACT_APP_IP+'/scripts/eliminar_solicitudes.php';

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

    getData=()=>{
        const url= 'http://'+process.env.REACT_APP_IP+':8080/VistaInfoCliente/ObtenerTodos'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({clientes: data});
            
            console.log(data);
          });
    }

    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        this.getData();

        this.state.today.setFullYear(this.state.today.getFullYear()+1);
        console.log(this.state.today);
      
       }
    
    render(){
        return(
            <div>
                <div className="page">
                            <Paper className="container">
                            <h2>Clientes</h2>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    {this.state.tipo_usuario==1?
                                    <TableRow className="table-header">
                                        <StyledTableCell align="center">NIT</StyledTableCell>
                                        <StyledTableCell align="center">Tipo Cliente</StyledTableCell>
                                        <StyledTableCell align="center">Nombre</StyledTableCell>
                                        <StyledTableCell align="center">Vencimiento suscripción</StyledTableCell>
                                        <StyledTableCell align="center">Patente</StyledTableCell>
                                         
                                        <StyledTableCell align="right">Renovar Suscripción</StyledTableCell>
                                        <StyledTableCell align="right">Eliminar</StyledTableCell>
                                        
                                    </TableRow>: <TableRow className="table-header">
                                        <StyledTableCell align="center">NIT</StyledTableCell>
                                        <StyledTableCell align="center">Tipo Cliente</StyledTableCell>
                                        <StyledTableCell align="center">Nombre</StyledTableCell>
                                        <StyledTableCell align="center">Vencimiento suscripción</StyledTableCell>
                                        <StyledTableCell align="center">Patente</StyledTableCell>     
                                    </TableRow>}
                                    </TableHead>
                                    {this.state.tipo_usuario==1?
                                    <TableBody>
                                    {this.state.clientes.map((m) => (
                                        <TableRow key={m.nit}>
                                            <TableCell align="center" component="th" scope="row">
                                                {m.nit}
                                            </TableCell>
                                        <TableCell align="center">{m.tipocliente+ " - "+ m.nombretipocliente}</TableCell>
                                        <TableCell align="center">{m.nombrecliente}</TableCell>
                                        <TableCell align="center">{m.vencimiento}</TableCell>
                                        <TableCell align="center"><img className="patente" src={m.patente}></img></TableCell>
                                       
                                        <TableCell align="right"><button onClick={()=>this.aproveData(1, m.nit)}><CheckCircle/></button></TableCell>
                                        <TableCell align="right"><button onClick={()=>this.aproveData(2, m.nit)}><DeleteForever/></button></TableCell>
                                        
                                        </TableRow>
                                    ))}
                                    </TableBody>:<TableBody>
                                    {this.state.clientes.map((m) => (
                                        <TableRow key={m.nit}>
                                            <TableCell align="center" component="th" scope="row">
                                                {m.nit}
                                            </TableCell>
                                        <TableCell align="center">{m.tipocliente+ " - "+ m.nombretipocliente}</TableCell>
                                        <TableCell align="center">{m.nombrecliente}</TableCell>
                                        <TableCell align="center">{m.vencimiento}</TableCell>
                                        <TableCell align="center"><img className="patente" src={m.patente}></img></TableCell>
                                        </TableRow>
                                    ))}
                                    </TableBody>}
                                </StyledTable>
                            </Paper>
                    
                </div>
            </div>
        );
    }
}

export default ClientsTable;