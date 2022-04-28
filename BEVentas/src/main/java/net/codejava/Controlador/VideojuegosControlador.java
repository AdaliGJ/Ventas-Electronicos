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

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Videojuegos en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Videojuegos")
public class VideojuegosControlador {

	@Autowired
	private RepositorioVideojuegos repositorioVideojuegos;
	
	/**
	 * Constructor de la clase VideojuegosControlador
	 */
	public VideojuegosControlador(){}
	
	/**
	 * Query a la tabla VIDEOJUEGOS para obtener todos los datos de la tabla VIDEOJUEGOS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Videojuegos> getAll(){
		return repositorioVideojuegos.findAll();
	}
	
	/**
	 * Obtener un solo registro de la tabla VIDEOJUEGOS con la ayuda de su identificador
	 * @param nIdInventario
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Videojuegos> getOne(@RequestParam int nIdInventario){
		return repositorioVideojuegos.findById(nIdInventario);
	}
	/**
	 * Creacion de un elemento en la tabla VIDEOJUEGOS en la tabla en la base de datos
	 * @param nIdInventario
	 * @param nMaxJugadores
	 * @param nGraficos
	 * @param nConsola
	 * @return Registro de lo insertado en formato JSON
	 */
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
