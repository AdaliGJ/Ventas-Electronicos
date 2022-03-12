package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioTipo_usuarios;

@RestController
@RequestMapping(path="/tipo_usuario")
public class Tipo_usuarioControlador {
	
	@Autowired
	private RepositorioTipo_usuarios repositorioTipoUsuario;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_usuarios> getAllPruebas(){
		return repositorioTipoUsuario.findAll();
	}

}
