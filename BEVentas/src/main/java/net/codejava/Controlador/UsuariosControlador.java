package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Usuarios;
import net.codejava.Repositorio.RepositorioUsuarios;

@CrossOrigin
@RestController
@RequestMapping(path="/Usuarios")
public class UsuariosControlador {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Usuarios> getAll(){
		return repositorioUsuarios.findAll();
	}
}
