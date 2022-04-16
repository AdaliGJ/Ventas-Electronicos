package net.codejava.Controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Clientes;
import net.codejava.Repositorio.RepositorioClientes;

@CrossOrigin
@RestController
@RequestMapping(path="/Clientes")
public class ClientesControlador {

	@Autowired
	private RepositorioClientes repositorioClientes;
	
	
	/**
	 * Realizacion de query a la tabla CLIENTES para obtener todos los datos de la tabla CLIENTES
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Clientes> getAll(){
		return repositorioClientes.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla CLIENTES con la ayuda de su identificador
	 * @param nNit NIT del CLIENTE el cual es el identificador de la tupla
	 * @return Un CLIENTE segun el ID
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Clientes> getOne(@RequestParam int nNit){
		return repositorioClientes.findById(nNit);
	}
	
	/**
	 * Creacion de un nuevo CLIENTE en la tabla en la base de datos
	 * @param nNit Identificador del CLIENTE
	 * @param nTipoCliente Puede ser: Mayorista, Grandes CLIENTE y CLIENTE individual
	 * @return
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Clientes insertar(@RequestParam int nNit, @RequestParam int nTipoCliente) {
	
		Clientes n = new Clientes(nNit, nTipoCliente);
		
		return repositorioClientes.save(n);
	}
	
	
	/*
	@GetMapping("/Login")
	public @ResponseBody Map<String,String> registrar(@RequestParam int nNit, @RequestParam String nPassword) {
	
		HashMap<String,String> response = new HashMap<>();
		
		Optional<Clientes> n = repositorioClientes.findByIdClienteAndPassword(nNit,nPassword);
		//Clientes _n = n.get();
		
		
		String usuarioPassword = _n.getContraseña();
		
		if( usuarioPassword == nPassword) {
			response.put("respuesta", "ok");
		}else {
			response.put("respuesta", "error");
			response.put("contraseña", _n.getContraseña());
		}
		
		
		if(n.isEmpty()) {
			
			response.put("respuesta", "error");
		}else {
			response.put("respuesta", "ok");
		}
		
		
		return response;
	}*/
	
}
