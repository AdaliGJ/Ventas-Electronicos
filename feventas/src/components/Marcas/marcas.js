import React, {useRef, useContext, useState} from 'react';
import {LoginContext} from "../../context/LoginContext.js";
import { Link, useHistory} from "react-router-dom";
import Alert from '@material-ui/lab/Alert';
import './marcas.css'
import Card from '@material-ui/core/Card';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import InputAdornment from '@material-ui/core/InputAdornment';
import LockIcon from '@material-ui/icons/Lock';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import axios from 'axios';
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



class Marcas extends React.Component{
    
    static contextType = LoginContext;

    constructor(props){
        super(props);
        this.state={
            marca: '',
            marcas: [],
            ip: ''
        }
    } 

    
    

    handleLogin=()=>{
                
        const url = 'http://'+process.env.REACT_APP_IP+':8080/Marca/Insertar2';

        let formData = new FormData();
        formData.append('nNombre', this.state.marca);
        formData.append('nIP', this.state.ip);
               
        axios.post(url, formData,  {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }})
            .then((response)=>{
            console.log(response);
            })
            .catch((response)=>{
            console.log(response);
            });

            this.getData();
            this.setState({marca: '',
            ip: ''});

        }

        getData=()=>{
            const url= 'http://'+process.env.REACT_APP_IP+':8080/Marca/ObtenerTodos'
          
            axios.get(url).then(response => response.data)
              .then((data) => {
                this.setState({marcas: data});
                
                console.log(data);
              });
            
    
            }

        componentDidMount(){
            const context = this.context;
            this.setState({usuario: context.username,
                tipo_usuario: context.tipoUsuario});
    
            this.getData();
           
          
           }

        render(){
        return(
            <div className="page">
                       {this.state.tipo_usuario == 1?
                    <div>
                    <h1 id="login_tit">Registro Marcas</h1>
                 
                    <Grid container direction={"column"} spacing={7}>
                        <Grid item>
                            <TextField className="standard-basic" label="Marca" placeholder="Marca" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} onChange={e=>this.setState({marca: e.target.value})} value={this.state.marca} />
                        </Grid>
                        <Grid item>
                            <TextField className="standard-basic" label="Dirección IP" placeholder="IP" InputProps={{
                                startAdornment: (
                                  <InputAdornment position="start">
                                    <AccountCircleIcon />
                                  </InputAdornment>
                                ),
                              }} onChange={e=>this.setState({ip: e.target.value})} value={this.state.ip} />
                        </Grid>
                        
                    </Grid>
                    <Grid container direction={"column"} spacing={8}>
                        <Grid item>
                            <Button id="enviar" variant="contained" onClick={this.handleLogin}>Registrar Marca</Button>
                        </Grid>
                    </Grid></div>:null}
                    <Paper className="container">
                            <h2>Catálogo</h2>
                                <StyledTable className="customized-table">
                                    <TableHead >
                                    <TableRow className="table-header">
                                        <StyledTableCell align="right">Id</StyledTableCell>
                                        <StyledTableCell align="right">Marca</StyledTableCell>
                                        <StyledTableCell align="right">IP</StyledTableCell>
                                    </TableRow>
                                    </TableHead>
                                    <TableBody>
                                    {this.state.marcas.map((m) => (
                                        <TableRow key={m.id_marca}>
                                            <TableCell align="right" component="th" scope="row">
                                                {m.id_marca}
                                            </TableCell>
                                        <TableCell align="right">{m.nombre}</TableCell>
                                        <TableCell align="right">{m.ip}</TableCell>
                                        
                                        </TableRow>
                                    ))}
                                    </TableBody>
                                </StyledTable>
                            </Paper>

            </div>
        );
    }
}

export default Marcas;