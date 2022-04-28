package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaDispositivosVendidos;
import net.codejava.Repositorio.RepositorioVistaDispositivosVendidos;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la vista VistaDispositivosVendidos en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Las acciones que podemos realizar estan limitadas a solo selects debido a que las vistas no se pueden modificar
 * Las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/VistaDispositivosVendidos")
public class VistaDispositivosVendidosControlador {
	
	@Autowired
	private RepositorioVistaDispositivosVendidos repositorioVistaDispositivosVendidos;
	
	/**
	 * Constructor de la clase VistaDispositivosVendidosControlador
	 */
	public VistaDispositivosVendidosControlador(){}
	
	/**
	 *  Query a la tabla VISTA_DISPOSITIVOS_VENDIDOS para obtener todos los datos de la tabla VISTA_DISPOSITIVOS_VENDIDOS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<VistaDispositivosVendidos> getAll(){
		return repositorioVistaDispositivosVendidos.findAll();
	}
	
	/**
	 * Obtener un solo registro de la tabla VISTA_DISPOSITIVOS_VENDIDOS con la ayuda de su identificador
	 * @param nSerial
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaDispositivosVendidos> getOne(@RequestParam String nSerial){
		return repositorioVistaDispositivosVendidos.findBySerie(nSerial);
	}

}
