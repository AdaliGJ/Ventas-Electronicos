package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.VistaDispositivosVendidos;

public interface RepositorioVistaDispositivosVendidos extends CrudRepository<VistaDispositivosVendidos, Integer>{
	
	Optional<VistaDispositivosVendidos> findBySerie(String serie_dispositivo);

}
