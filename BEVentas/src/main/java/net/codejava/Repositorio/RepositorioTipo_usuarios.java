package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Tipo_usuarios;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Tipo_usuario permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioTipo_usuarios extends CrudRepository<Tipo_usuarios, Integer>{

}
