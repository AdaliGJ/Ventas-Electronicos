package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaImgs;
import net.codejava.Repositorio.RepositorioVistaImgs;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la vista VistaImgs en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Las acciones que podemos realizar estan limitadas a solo selects debido a que las vistas no se pueden modificar
 * Las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/VistaImgs")
public class VistaImgsControlador {
	
	@Autowired
	private RepositorioVistaImgs repositorioVistaImgs;
	
	/**
	 * Constructor de la clase VistaImgsControlador
	 */
	public VistaImgsControlador(){}
	
	/**
	 * Query a la tabla VISTAIMGS para obtener todos los datos de la tabla VISTAIMGS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<VistaImgs> getAll(){
		return repositorioVistaImgs.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla VISTAIMGS con la ayuda de su identificador
	 * @param nIdInventario
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaImgs> getOne(@RequestParam int nIdInventario){
		return repositorioVistaImgs.findById(nIdInventario);
	}

}
