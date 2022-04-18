package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Pedidos;

public interface RepositorioPedidos extends CrudRepository<Pedidos, Integer>{
	Iterable<Pedidos> findByEstado(String estado);
}
