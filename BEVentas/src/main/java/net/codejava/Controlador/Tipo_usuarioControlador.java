package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Tipo_clientes;
import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioTipo_usuarios;

@RestController
@RequestMapping(path="/Tipo_usuario")
public class Tipo_usuarioControlador {
	
	@Autowired
	private RepositorioTipo_usuarios repositorioTipoUsuario;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_usuarios> getAll(){
		return repositorioTipoUsuario.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Tipo_usuarios> getOne(@RequestParam int nIdTipoUsuario){
		return repositorioTipoUsuario.findById(nIdTipoUsuario);
	}

}
