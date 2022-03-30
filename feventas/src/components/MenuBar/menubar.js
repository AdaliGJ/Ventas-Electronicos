import React, {useContext} from 'react';
import AppBar from '@material-ui/core/AppBar';
import Box from '@material-ui/core/Box';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import IconButton from '@material-ui/core/IconButton';
import {useHistory} from "react-router-dom";
import { LoginContext } from '../../context/LoginContext';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import './menubar.css'

 function MenuBar() {
     const history = useHistory();
     const {tipoUsuario, setUsername, setTipoUsuario, username }=useContext(LoginContext);

     const inicio = () =>{
        history.push('/home');
    }

    const login = ()=>{
      history.push('/login');
    }

    const cliente = ()=>{
        history.push('/cliente_nuevo');
      }

   const signout=()=>{
        setTipoUsuario(null);
        setUsername(null);
        history.push('/home');
   } 

    return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar id="appbar" position="static">
        <Toolbar>
          <IconButton id="icon">
            
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Sistema de ventas
          </Typography>
          <ButtonGroup variant="contained" id="appbar_button">
            <Button id={tipoUsuario? "home_button":"nohome"} onClick={inicio}>Catálogo</Button>
            <Button id={tipoUsuario==1? "cliente_reg":"nocliente"} onClick={cliente}>Registro Clientes</Button>
            <IconButton id={tipoUsuario?"siout":"noout"} onClick={signout}>
              <ExitToAppIcon />
            </IconButton>
            <Button id={tipoUsuario? "silog":"nolog"} onClick={login}>Iniciar Sesión</Button>
        </ButtonGroup>
        </Toolbar>
      </AppBar>
    </Box>
  );
}

export default MenuBar;