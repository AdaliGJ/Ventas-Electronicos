package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Tipo_clientes;
import net.codejava.Repositorio.RepositorioTipo_clientes;

@RestController
@RequestMapping(path="/Tipo_clientes")
public class Tipo_clientesControlador {

	@Autowired
	private RepositorioTipo_clientes repositorioTipoClientes;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_clientes> getAll(){
		return repositorioTipoClientes.findAll();
	}
}
