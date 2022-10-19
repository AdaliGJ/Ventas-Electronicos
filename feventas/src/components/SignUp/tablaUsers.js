import './signup.css';
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



class UsersTable extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            id: null,
            nombre: '',
            usuarios: [],
            tipo: null
        }

        this.aproveData=this.aproveData.bind(this);
        this.deleteData=this.deleteData.bind(this);
    }



    aproveData=(d1, d2)=>{
        const url= 'http://'+process.env.REACT_APP_IP+':8080/Procedimiento/CambioPermisos'

        

        let formData = new FormData();
        console.log(d1);

        formData.append('nId', d2);
        formData.append('nAccion', d1);


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
        const url= 'http://'+process.env.REACT_APP_IP+':8080/Usuarios/ObtenerTodos'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({usuarios: data});
            
            console.log(data);
          });
    }

    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        const url= 'http://'+process.env.REACT_APP_IP+':8080/Usuarios/ObtenerTodos'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({usuarios: data});
            
            console.log(data);
          });
      
       }
    
    render(){
        return(
            <div>
                <div className="page">
                            <Paper className="container">
                            <h2>Usuarios</h2>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Nit</StyledTableCell>
                                        <StyledTableCell align="right">Tipo Usuario</StyledTableCell>
                                        <StyledTableCell align="right">Nombre</StyledTableCell>
                                        <StyledTableCell align="right">Cambiar Permisos</StyledTableCell>
                                        <StyledTableCell align="right">Eliminar</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.usuarios.map((m) => (
                                        <TableRow key={m.idUsuario}>
                                            <TableCell align="right" component="th" scope="row">
                                                {m.idUsuario}
                                            </TableCell>
                                        <TableCell align="right">{m.tipo_usuario}</TableCell>
                                        <TableCell align="right">{m.nombre}</TableCell>
                                        <TableCell align="right"><button onClick={()=>this.aproveData(1, m.idUsuario)}><CheckCircle/></button></TableCell>
                                        <TableCell align="right"><button onClick={()=>this.aproveData(2, m.idUsuario)}><DeleteForever/></button></TableCell>
                                        
                                        </TableRow>
                                    ))}
                                    </TableBody>
                                </StyledTable>
                            </Paper>
                    
                </div>
            </div>
        );
    }
}

export default UsersTable;