import React, {Component} from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import  Modal from '@material-ui/core/Modal';
import TextField from '@material-ui/core/TextField';
import { Grid } from '@material-ui/core';
import { LoginContext } from '../../context/LoginContext';
import './nuevoCatalogo.css';

import FormControl from '@material-ui/core/FormControl';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';



class NuevoCatalogo extends React.Component {
  static contextType = LoginContext;
  constructor(props){
      super(props);
      this.state={
          color:"",
          descripcion:"",
          garantia: null,
          precio:"",
          modelo: "",
          marca:null,
          categoria: null,
          marcas: [{id: 1, nombre: "Samsung"}, {id: 2, nombre: "Amazon"}],
          tipo_productos: [{id: 1, nombre: "Televisor"}, {id: 2, nombre: "Videojuego"}, {id: 3, nombre: "Smartwatch"}, , {id: 4, nombre: "Otros"}],

          imgs: '',
          archivos: null
          
      }
      this.handleOpen=this.handleOpen.bind(this);
      this.cancel=this.cancel.bind(this);
      this.addItem=this.addItem.bind(this);
      this.updateItem=this.updateItem.bind(this);
  }
  
  handleOpen=(e)=>{
       this.setState({open: !this.state.open})  
  }

  cancel=()=>{
    this.setState({
      texto: '',
      producto: ''
    });
    this.handleOpen();
  }

  handleChange = e => {
    if(e.target.files[0]){
        this.setState({imgs:  this.state.imgs==''? e.target.files[0].name : this.state.imgs + ', '+ e.target.files[0].name,
        archivos: e.target.files});
        console.log(this.state.imgs);
    }else{
        this.setState({imgs: ''});
    }
  }


addItem = ()=>{
   /* var submitItem = this.props.submit;
    submitItem(this.state.serie);*/
    this.handleOpen();
 }

updateItem = ()=> {
    /*var actItem = this.props.update;
    actItem(this.state.serie);*/
    this.handleOpen();
}

 componentDidMount(){
  const context = this.context;
  this.setState({usuario: context.tipoUsuario});
 }

  render(){
    
  return (
    <div className = "televisor">
        
    </div>
  );
}
}

export default NuevoCatalogo;