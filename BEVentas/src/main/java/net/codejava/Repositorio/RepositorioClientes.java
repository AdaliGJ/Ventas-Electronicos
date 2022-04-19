package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Clientes;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Clientes permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioClientes extends CrudRepository<Clientes, Integer> {

	//Optional<Clientes> findByIdClienteAndPassword(int IdCliente,String Contraseña);
}
