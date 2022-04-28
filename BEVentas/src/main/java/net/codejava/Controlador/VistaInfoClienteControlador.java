package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaInfoCliente;
import net.codejava.Repositorio.RepositorioVistaInfoCliente;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la vista VistaInfoCliente en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Las acciones que podemos realizar estan limitadas a solo selects debido a que las vistas no se pueden modificar
 * Las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/VistaInfoCliente")
public class VistaInfoClienteControlador {

	
	@Autowired
	private RepositorioVistaInfoCliente repositorioVistaInfoCliente;
	
	/**
	 *  Query a la tabla VISTAINFO para obtener todos los datos de la tabla VISTAINFO
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<VistaInfoCliente> getAll(){
		return repositorioVistaInfoCliente.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla VISTAINFOCLIENTE con la ayuda de su identificador
	 * @param nNit
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaInfoCliente> getOne(@RequestParam int nNit){
		return repositorioVistaInfoCliente.findById(nNit);
	}
	
}
