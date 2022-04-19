package net.codejava.Repositorio;


import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Videojuegos;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Videojuegos permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioVideojuegos extends CrudRepository<Videojuegos, Integer>{
	


}