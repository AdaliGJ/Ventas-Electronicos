import './catalog.css';
import React, {useContext, useParams} from 'react';
import {Link} from "react-router-dom";
import {LoginContext} from "../../context/LoginContext.js";

import Button from '@material-ui/core/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import Comprar from '../comprar/comprar';
import axios from 'axios'



class Products extends React.Component{
    static contextType = LoginContext;
    constructor(props){
      super(props);
      this.state={
          id: props.id,
          inventario:'',
          tipo_disp:'',
          marca:'',
          existencias: 0
          
      }
      
  }

  componentDidMount(){
    const context = this.context;
    this.setState({usuario: context.username,
        tipo_usuario: context.tipoUsuario}); 

        const url= 'http://'+process.env.REACT_APP_IP+':8080/Inventario/Obtener'
        const url2= 'http://'+process.env.REACT_APP_IP+':8080/Marca/Obtener'
        const url3= 'http://'+process.env.REACT_APP_IP+':8080/Tipo_dispositivo/Obtener'
        const url6= 'http://'+process.env.REACT_APP_IP+':8080/Dispositivos_individuales/ObtenerCantidad'
  
        axios.get(url, {params: {nIdInventario: this.props.id}}).then(response => response.data)
          .then((data) => {
            this.setState({inventario: data});
            console.log(data);
            console.log(data.marca);
            axios.get(url2, {params: {nIdMarca: data.marca}}).then((data2) => {
                this.setState({marca: data2.data.nombre});
                console.log(data2);
            });
            axios.get(url3, {params: {nIdTipoDispositivo: data.categoriaDispositivo}}).then((data3) => {
                this.setState({tipo_disp: data3.data.nombre});
                console.log(data3);
            });
            axios.get(url6, {params: {nId: this.props.id}}).then((response) => {
                this.setState({existencias: response.data});
                console.log(response.data);
            });

          });
}

  

    render(){
        return(
            <Card className="productos_cat">
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                       {this.props.modelo}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                       {this.props.desc}
                    </Typography>
                    <br/>
                    <Typography variant="body2" color="text.secondary">
                       {"Precio: Q"+this.props.precio}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Comprar tipo={this.props.id} producto={this.state.tipo_disp+" "+this.state.marca+" "+this.props.modelo} total={this.props.precio} cantidad={1} existencias={this.state.existencias}/>
                    <Link to={`/productos/${this.props.id}`}>
                        <Button size="small">Ver Detalle</Button>
                    </Link>
                </CardActions>
            </Card>
        );
    }
}

export default Products;