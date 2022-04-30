import './credito.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import Table from '@material-ui/core/Table';
import {  withStyles } from '@material-ui/core/styles';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import Paper from "@material-ui/core/Paper";
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
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



class Credito extends React.Component{
    
    static contextType = LoginContext;
   
    constructor(props){
        super(props);
        this.state={
            id: null,
            nombre: '',
            ventas: []
        }

    }


    insert=()=>{
        const url= 'http://localhost:8080/Email/Insertar';

        axios.post(url).then(response => response.data)
          .then((data) => {
            
            console.log(data);
          });

    }

   
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
            tipo_usuario: context.tipoUsuario});

      
        const url= 'http://localhost:8080/Procedimiento/Credito'
      
        axios.get(url).then(response => response.data)
          .then((data) => {
            this.setState({ventas: data});
            
            console.log(data);
          });
      
       }
    
    render(){
        return(
            <div>
                <div className="page">
                    <Button id='not' onClick={this.insert}>Notificar clientes</Button>
                            <Paper className="container">
                            <h2>Deudas Ventas al Crédito</h2>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">NIT Cliente</StyledTableCell>
                                        <StyledTableCell align="right">Deuda</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.ventas.map((m) => (
                                        <TableRow key={m.ID_CLIENTE}>
                                            <TableCell align="right" component="th" scope="row">
                                                {m.ID_CLIENTE}
                                            </TableCell>
                                        <TableCell align="right">{"Q"+m.DEUDA}</TableCell>
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

export default Credito;