package net.codejava.Repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.codejava.Entidad.Usuarios;

public interface RepositorioUsuarios extends CrudRepository<Usuarios, Integer>{

	Optional<Usuarios> findByIdUsuarioAndPassword(int IdUsuario,String Contraseña);
}
