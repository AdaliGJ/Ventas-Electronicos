package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Prueba;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Prueba permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioPrueba extends CrudRepository<Prueba, Integer>{
	

	Optional<Prueba> findByValor2(String valor2);

}
