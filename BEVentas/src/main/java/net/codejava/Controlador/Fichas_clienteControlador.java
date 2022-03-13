package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Fichas_clientes;
import net.codejava.Repositorio.RepositorioFicha_clientes;

@CrossOrigin
@RestController
@RequestMapping(path="/Fichas_clientes")
public class Fichas_clienteControlador {

	@Autowired
	private RepositorioFicha_clientes repositorioFichasClientes;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Fichas_clientes> getAll(){
		return repositorioFichasClientes.findAll();
	}
}
