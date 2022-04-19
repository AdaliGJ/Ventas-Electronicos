package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Usuarios;


/**
 * Esta Interfaz permite agregar funcionalidades CRUD a la entidad Usuarios permitiendo definir tambien sus propios querys hacia la DB de Oracle por medio de la sintaxis que define JDBC
 *
 */
public interface RepositorioUsuarios extends CrudRepository<Usuarios, Integer>{

	Optional<Usuarios> findByIdUsuarioAndPassword(int IdUsuario,String Contraseña);
}
