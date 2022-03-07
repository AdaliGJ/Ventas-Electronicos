import React, {Component} from 'react';
import { marcaService } from '../../service/marcaService';

class  Marcas extends React.Component {
    constructor(){
        super();
        this.state = {};

        this.marcaService = new marcaService();
    }

    componentDidMount(){
        this.marcaService.getAll().then(data => {
            console.log(data);
        })

        console.log("Hola mundo");
    }

    render(){
        return(
            <h1>Hola mundo</h1>
        );
    }
}
export default Marcas;