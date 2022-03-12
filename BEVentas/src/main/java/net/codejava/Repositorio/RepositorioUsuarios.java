package net.codejava.Repositorio;

import org.springframework.data.repository.CrudRepository;
import net.codejava.Entidad.Usuarios;

public interface RepositorioUsuarios extends CrudRepository<Usuarios, Integer>{

}
