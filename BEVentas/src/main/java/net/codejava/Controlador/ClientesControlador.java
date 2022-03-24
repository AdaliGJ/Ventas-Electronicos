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
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Clientes> getAll(){
		return repositorioClientes.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Clientes> getOne(@RequestParam int nId_cliente){
		return repositorioClientes.findById(nId_cliente);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Clientes insertar(@RequestParam int nTipoCliente, @RequestParam int nNit) {
	
		Clientes n = new Clientes(4,nTipoCliente,nNit);
		
		return repositorioClientes.save(n);
	}
	
	@GetMapping("/Login")
	public @ResponseBody Map<String,String> registrar(@RequestParam int nIdCliente, @RequestParam String nPassword) {
	
		HashMap<String,String> response = new HashMap<>();
		
		Optional<Clientes> n = repositorioClientes.findByIdClienteAndPassword(nIdCliente,nPassword);
		//Clientes _n = n.get();
		
		/*
		String usuarioPassword = _n.getContraseña();
		
		if( usuarioPassword == nPassword) {
			response.put("respuesta", "ok");
		}else {
			response.put("respuesta", "error");
			response.put("contraseña", _n.getContraseña());
		}
		*/
		
		if(n.isEmpty()) {
			
			response.put("respuesta", "error");
		}else {
			response.put("respuesta", "ok");
		}
		
		
		return response;
	}
	
}
