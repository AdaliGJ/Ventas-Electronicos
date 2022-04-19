package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Smartwatch;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Smartwatch permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioSmartwatch extends CrudRepository< Smartwatch, Integer>{

}
