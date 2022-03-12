package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Clientes;

public interface RepositorioClientes extends CrudRepository<Clientes, Integer> {

}
