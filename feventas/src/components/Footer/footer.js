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
                                <FooterBox link='/marcas' title="Marcas"/>
                                <FooterBox link='/inventario' title="Inventario"/>
                            </Grid>
                            <Grid item xs={4}> 
                                <Box borderBottom={1}>Usuarios</Box>
                                {!this.state.usuario?
                                    <div>
                                        <FooterBox link='/login' title="Login" />
                                    </div>:
                                    this.context.tipoUsuario==1?
                                    <div>
                                        <FooterBox link='/cliente_nuevo' title="Clientes"/>
                                        <FooterBox link='/signUp' title="Usuarios"/>
                                        <FooterBox link='/credito' title="Ventas Crédito"/>
                                    </div>:
                                    <div>
                                        <FooterBox link='/cliente_nuevo' title="Clientes"/>
                                        <FooterBox link='/credito' title="Ventas Crédito"/>
                                    </div>
                                    }
                            </Grid>
                            <Grid item xs={4}> 
                                <Box borderBottom={1}>Pedidos</Box>
                                {this.context.tipoUsuario==1?
                                     <div>
                                        <FooterBox link='/pedir' title="Pedir"/>
                                        <FooterBox link='/pedidos' title="Pedidos"/>
                                    </div>:this.context.tipoUsuario==2?
                                     <div>
                                        <FooterBox link='/pedidos' title="Pedidos"/>
                                    </div>:null
                                    }
                                    
                            </Grid>
                        </Grid>
                    </Container>
                    
                </Box>
            </footer>
        );
    }
}

export default Footer;