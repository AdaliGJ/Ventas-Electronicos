package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Fichas_clientes;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Ficha_clientes permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioFicha_clientes extends CrudRepository< Fichas_clientes, Integer> {

}
