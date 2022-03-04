import './catalog.css';
import React, {useContext} from 'react';
import {LoginContext} from "../../context/LoginContext.js";

class Catalog extends React.Component{
    
    static contextType = LoginContext;
   
    
    componentDidMount(){
        const context = this.context;
        this.setState({tipo_usuario: context.tipoUsuario});
        
    }
    
    render(){
        return(
            <div>
                <div className="page">
                    
                    
                </div>
            </div>
        );
    }
}

export default Catalog;