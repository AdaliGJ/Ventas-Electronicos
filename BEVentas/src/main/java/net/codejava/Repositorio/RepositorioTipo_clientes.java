package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Tipo_clientes;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Tipo_clientes permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioTipo_clientes extends CrudRepository<Tipo_clientes, Integer>{

}
