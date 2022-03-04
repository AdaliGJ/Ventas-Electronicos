import {Route, BrowserRouter as Router, Switch, Link, Redirect} from "react-router-dom";
import {LoginContext} from "./context/LoginContext.js";
import React, {useState,useEffect} from 'react';
import './App.css';
import Catalog from "./components/Catalog/catalog.js";
import MenuBar from "./components/MenuBar/menubar.js";

function App() {
  const getTipoUsuario=()=>{
    const localTipoUsuario = localStorage.getItem('tipoUsuario');
    return localTipoUsuario ? JSON.parse(localTipoUsuario) : null;
  }

  const[tipoUsuario, setTipoUsuario]=useState(getTipoUsuario);

  useEffect(()=>{
    localStorage.setItem('tipoUsuario', JSON.stringify(tipoUsuario));
  })
  
  
  return (
    <Router>
    <div className="App"> 
    <LoginContext.Provider value={{setTipoUsuario, tipoUsuario}}> 
    <MenuBar/> 
      { tipoUsuario == 1 ? <Switch> 
          <Route exact path="/home" component={Catalog}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>
        :
        <Switch> 
          <Route exact path="/home" component={Catalog}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>}
      </LoginContext.Provider>  
  </div>
  </Router>

  );
}

export default App;
