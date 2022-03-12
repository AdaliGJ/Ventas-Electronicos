package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Inventario;
import net.codejava.Repositorio.RepositorioInventario;

@RestController
@RequestMapping(path="/Inventario")
public class InventarioControlador {

	@Autowired
	private RepositorioInventario repositorioInventario;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Inventario> getAll(){
		return repositorioInventario.findAll();
	}
}
