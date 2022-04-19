package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Inventario;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Inventario permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioInventario extends CrudRepository< Inventario, Integer>{

	Iterable<Inventario> findAllByCategoriaDispositivo(int categoriaDispositivo);
	
	//Iterable<Inventario> findAllByCategoriaDispositivo(int categoriaDispositivo);
	
	Iterable<Inventario> findByOrderByCategoriaDispositivoDesc();
}
