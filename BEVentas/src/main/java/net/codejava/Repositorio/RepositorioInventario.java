package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Inventario;

public interface RepositorioInventario extends CrudRepository< Inventario, Integer>{

	Iterable<Inventario> findAllByCategoriaDispositivo(int categoriaDispositivo);
	
	//Iterable<Inventario> findAllByCategoriaDispositivo(int categoriaDispositivo);
	
	Iterable<Inventario> findByOrderByCategoriaDispositivoDesc();
}
