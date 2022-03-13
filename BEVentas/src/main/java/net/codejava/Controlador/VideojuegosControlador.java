package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Videojuegos> getOne(@RequestParam int nIdInventario){
		return repositorioVideojuegos.findById(nIdInventario);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Videojuegos insertar(
			@RequestParam int nIdInventario,
			@RequestParam int nMaxJugadores,
			@RequestParam String nGraficos,
			@RequestParam String nConsola
			) {
	
		Videojuegos n = new Videojuegos(nIdInventario, nMaxJugadores, nGraficos, nConsola);
		
		return repositorioVideojuegos.save(n);
	}
	
	
}  
