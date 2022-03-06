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



class Products extends React.Component{
    static contextType = LoginContext;
    constructor(props){
      super(props);
      this.state={
          id: null,
          
      }
      
  }

  

    render(){
        return(
            <Card className="productos_cat">
                <CardMedia
                    component="img"
                    height="140"
                    image="https://definicion.de/wp-content/uploads/2009/06/producto.png"
                    alt="green iguana"
                />
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        Producto
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        Descripción del producto
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small">Comprar</Button>
                    <Link to={`/productos/${this.props.id}`}>
                        <Button size="small">Ver Detalle</Button>
                    </Link>
                </CardActions>
            </Card>
        );
    }
}

export default Products;