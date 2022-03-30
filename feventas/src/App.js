import {Route, BrowserRouter as Router, Switch, Link, Redirect} from "react-router-dom";
import {LoginContext} from "./context/LoginContext.js";
import React, {useState,useEffect} from 'react';
import './App.css';
import Catalog from "./components/Catalog/catalog.js";
import MenuBar from "./components/MenuBar/menubar.js";
import Login from "./components/Login/login.js";
import Signup from "./components/SignUp/signup.js";
import Clientes from "./components/Clientes/clientes.js";
import Footer from "./components/Footer/footer.js";
import Detalle from "./components/Detalle/detalle";
import Marcas from "./components/Marcas/marcas.js";
import Inventario from "./components/Inventario/inventario.js";

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
          <Route exact path="/productos/:id" component={Detalle}/>
          <Route exact path="/cliente_nuevo" component={Clientes}/>
          <Route exact path="/marcas" component={Marcas}/>
          <Route exact path="/inventario" component={Inventario}/>
          <Route exact path="/signUp" component={Signup}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>
        : tipoUsuario == 2 ?
        <Switch> 
          <Route exact path="/home" component={Catalog}/>
          <Route exact path="/productos/:id" component={Detalle}/>
          <Route exact path="/marcas" component={Marcas}/>
          <Route exact path="/inventario" component={Inventario}/>
          <Redirect path="/" to="/home"></Redirect>
        </Switch>: <Switch> 
          <Route exact path="/login" component={Login}/>
          <Redirect path="/" to="/login"></Redirect>
        </Switch>}
        <Footer/>
      </LoginContext.Provider> 
  </div>
  </Router>

  );
}

export default App;
