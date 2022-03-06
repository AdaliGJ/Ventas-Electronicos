import React, {Component} from 'react';
import './footer.css';
import {Container} from '@material-ui/core';
import  {Grid}  from '@material-ui/core';
import  {Box}  from '@material-ui/core';
import { Link } from 'react-router-dom';
import { LoginContext } from '../../context/LoginContext';

class FooterBox extends Component{
    

    render(){
        return(
            <Box className={this.props.name}>
                <Link to={this.props.link}>
                    {this.props.title}
                </Link>
            </Box>
        );
    }
}




class Footer extends Component{

    static contextType = LoginContext;
    constructor(props){
        super(props);
        this.state = {
            usuario: null,
            tipo_usuario: null
        };
    }
    
    
    componentDidMount(){
        const context = this.context;
        this.setState({usuario: context.username,
        tipo_usuario: context.tipoUsuario});
        
    }    


    render(){
        return(
            <footer className="footer">
                <Box >
                    <Container>
                        <Grid container spacing={2}>
                            <Grid item xs={4}> 
                                <Box borderBottom={1}>Productos</Box>
                                <FooterBox link='/home' title="Catálogo"/>
                                <FooterBox link='/home' title="Marcas"/>
                                <FooterBox link='/' title="Inventario"/>
                            </Grid>
                            <Grid item xs={4}> 
                                <Box borderBottom={1}>Usuarios</Box>
                                {!this.state.usuario?
                                    <div>
                                        <FooterBox link='/login' title="Login" />
                                    </div>:
                                    this.state.usuario==1?
                                    <div>
                                        <FooterBox link='/clientes' title="Clientes"/>
                                        <FooterBox link='/permisos_usuario' title="Usuarios"/>
                                    </div>:
                                    <div>
                                        <FooterBox link='/clientes' title="Clientes"/>
                                    </div>
                                    }
                            </Grid>
                            <Grid item xs={4}> 
                                <Box borderBottom={1}>Compras</Box>
                            </Grid>
                        </Grid>
                    </Container>
                    
                </Box>
            </footer>
        );
    }
}

export default Footer;