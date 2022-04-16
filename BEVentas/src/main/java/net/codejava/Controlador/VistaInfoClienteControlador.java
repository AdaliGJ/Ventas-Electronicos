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
