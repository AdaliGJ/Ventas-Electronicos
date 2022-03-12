package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Televisores;
import net.codejava.Repositorio.RepositorioTelevisores;

@RestController
@RequestMapping(path="/Televisores")
public class TelevisoresControlador {
	
	@Autowired
	private RepositorioTelevisores repositorioTelevisores;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Televisores> getAll(){
		return repositorioTelevisores.findAll();
	}

}
