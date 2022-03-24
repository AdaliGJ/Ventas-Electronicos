package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Clientes;

public interface RepositorioClientes extends CrudRepository<Clientes, Integer> {

	//Optional<Clientes> findByIdClienteAndPassword(int IdCliente,String Contraseña);
}
