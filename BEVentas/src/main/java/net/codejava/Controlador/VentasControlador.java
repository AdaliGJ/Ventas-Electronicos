package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Ventas;
import net.codejava.Repositorio.RepositorioVentas;

@RestController
@RequestMapping(path="/Ventas")
public class VentasControlador {

	@Autowired
	private RepositorioVentas repositorioVentas;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Ventas> getAll(){
		return repositorioVentas.findAll();
	}
}
