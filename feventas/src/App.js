import {Route, BrowserRouter as Router, Switch, Link, Redirect} from "react-router-dom";
import {LoginContext} from "./context/LoginContext.js";
import React, {useState,useEffect} from 'react';
import './App.css';
import Catalog from "./components/Catalog/catalog.js";
import MenuBar from "./components/MenuBar/menubar.js";
import Login from "./components/Login/login.js";
import Clientes from "./components/Clientes/clientes.js";

function App() {
  const getUsername=()=>{
    const localUsername = localStorage.getItem('username');
    return localUsername ? JSON.parse(localUsername) : null;
  }

  const getTipoUsuario=()=>{
    const localTipoUsuario = localStorage.getItem('tipoUsuario');
    return localTipoUsuario ? JSON.parse(localTipoUsuario) : null;
  }


  const[username, setUsername] = useState(getUsername);
  const[tipoUsuario, setTipoUsuario]=useState(getTipoUsuario);

  useEffect(()=>{
    localStorage.setItem('username', JSON.stringify(username));
    localStorage.setItem('tipoUsuario', JSON.stringify(tipoUsuario));
  })
  
  
  return (
    <Router>
    <div className="App"> 
    <LoginContext.Provider value={{username, setUsername, setTipoUsuario, tipoUsuario}}> 
    <MenuBar/> 
      { tipoUsuario == 1 ? <Switch> 
          <Route exact path="/home" component={Catalog}/>
          <Route exact path="/login" component={Login}/>
          <Route exact path="/cliente_nuevo" component={Clientes}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>
        :
        <Switch> 
          <Route exact path="/home" component={Catalog}/>
          <Route exact path="/login" component={Login}/>
          <Route exact path="/cliente_nuevo" component={Clientes}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>}
      </LoginContext.Provider>  
  </div>
  </Router>

  );
}

export default App;
