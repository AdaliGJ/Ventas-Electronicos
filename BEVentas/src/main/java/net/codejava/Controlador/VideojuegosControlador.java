package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Videojuegos;
import net.codejava.Repositorio.RepositorioVideojuegos;

@CrossOrigin
@RestController
@RequestMapping(path="/Videojuegos")
public class VideojuegosControlador {

	@Autowired
	private RepositorioVideojuegos repositorioVideojuegos;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Videojuegos> getAll(){
		return repositorioVideojuegos.findAll();
	}
}  
