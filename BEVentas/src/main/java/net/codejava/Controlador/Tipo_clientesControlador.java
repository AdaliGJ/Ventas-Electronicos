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


import net.codejava.Entidad.Tipo_clientes;
import net.codejava.Repositorio.RepositorioTipo_clientes;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Tipo_clientes en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Tipo_clientes")
public class Tipo_clientesControlador {

	@Autowired
	private RepositorioTipo_clientes repositorioTipoClientes;
	
	/**
	 * Query a la tabla TIPO_CLIENTES para obtener todos los datos de la tabla TIPO_CLIENTES
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_clientes> getAll(){
		return repositorioTipoClientes.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla TIPO_CLIENTES con la ayuda de su identificador
	 * @param nIdTipoCliente
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Tipo_clientes> getOne(@RequestParam int nIdTipoCliente){
		return repositorioTipoClientes.findById(nIdTipoCliente);
	}
	
	
	
}
