package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.VistaInfoCliente;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad VistaInfoCliente permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioVistaInfoCliente extends CrudRepository<VistaInfoCliente, Integer>{

}
