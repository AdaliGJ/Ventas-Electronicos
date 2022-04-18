package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Dispositivos_individuales;

public interface RepositorioDispositivos_individuales extends CrudRepository<Dispositivos_individuales, Integer>{
	Optional<Dispositivos_individuales> findBySerie(String serie_dispositivo);
	Iterable<Dispositivos_individuales> findByVendido(int vendido);
	Iterable<Dispositivos_individuales> findByVendidoAndIdInventario(int id_inventario, int vendido);
	

}
