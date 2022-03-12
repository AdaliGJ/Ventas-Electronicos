package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Smartwatch;
import net.codejava.Repositorio.RepositorioSmartwatch;

@RestController
@RequestMapping(path="/Smartwatch")
public class SmartwatchControlador {

	@Autowired
	private RepositorioSmartwatch repositorioSmartwatch;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Smartwatch> getAll(){
		return repositorioSmartwatch.findAll();
	}
}
