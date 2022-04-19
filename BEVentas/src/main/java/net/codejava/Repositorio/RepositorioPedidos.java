package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Pedidos;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Pedidos permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioPedidos extends CrudRepository<Pedidos, Integer>{
	Iterable<Pedidos> findByEstado(String estado);
}
