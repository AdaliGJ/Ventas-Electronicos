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

import net.codejava.Entidad.Tipo_dispositivo;
import net.codejava.Repositorio.RepositorioTipo_dispositivo;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Tipo_dipositivo en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Tipo_dispositivo")
public class Tipo_dispositivoControlador {

	@Autowired
	private RepositorioTipo_dispositivo repositorioTipoDispositivo;
	
	/**
	 * Constructor de la clase Tipo_dispositivoControlador
	 */
	public Tipo_dispositivoControlador(){}
	
	/**
	 * Query a la tabla TIPO_DISPOSITIVO para obtener todos los datos de la tabla TIPO_DISPOSITIVO
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_dispositivo> getAll(){
		return repositorioTipoDispositivo.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla TIPO_DISPOSITIVO con la ayuda de su identificador
	 * @param nIdTipoDispositivo
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Tipo_dispositivo> getOne(@RequestParam int nIdTipoDispositivo){
		return repositorioTipoDispositivo.findById(nIdTipoDispositivo);
	}
	/**
	 * Creacion de un elemento en la tabla TIPO_DISPOSITIVO en la tabla en la base de datos
	 * @param nNombre
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Tipo_dispositivo insertar(@RequestParam String nNombre) {
	
		Tipo_dispositivo n = new Tipo_dispositivo(0,nNombre);
		
		return repositorioTipoDispositivo.save(n);
	}
}
