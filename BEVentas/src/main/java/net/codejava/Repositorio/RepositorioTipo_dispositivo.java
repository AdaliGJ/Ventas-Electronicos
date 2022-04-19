package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Tipo_dispositivo;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Tipo_dispositivo permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioTipo_dispositivo extends CrudRepository<Tipo_dispositivo, Integer>{

}
