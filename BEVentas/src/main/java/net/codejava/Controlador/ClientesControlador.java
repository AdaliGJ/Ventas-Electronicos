package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Clientes;
import net.codejava.Repositorio.RepositorioClientes;

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
	
}
