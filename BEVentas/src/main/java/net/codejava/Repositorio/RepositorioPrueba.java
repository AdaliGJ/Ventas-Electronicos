package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Prueba;



public interface RepositorioPrueba extends CrudRepository<Prueba, Integer>{
	

	Optional<Prueba> findByValor2(String valor2);

}
