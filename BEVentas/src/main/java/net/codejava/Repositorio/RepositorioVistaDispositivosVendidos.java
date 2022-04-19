package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.VistaDispositivosVendidos;



/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad VistaDispositivosVendidos permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */

public interface RepositorioVistaDispositivosVendidos extends CrudRepository<VistaDispositivosVendidos, Integer>{
	
	Optional<VistaDispositivosVendidos> findBySerie(String serie_dispositivo);

}
