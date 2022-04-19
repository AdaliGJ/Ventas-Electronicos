package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Ordenes_compra;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Ordenes_compra permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioOrdenes_compra extends CrudRepository< Ordenes_compra, Integer>{

}
