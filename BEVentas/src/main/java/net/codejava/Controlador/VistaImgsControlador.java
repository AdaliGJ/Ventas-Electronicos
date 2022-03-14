package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaImgs;
import net.codejava.Repositorio.RepositorioVistaImgs;

@CrossOrigin
@RestController
@RequestMapping(path="/VistaImgs")
public class VistaImgsControlador {
	
	@Autowired
	private RepositorioVistaImgs repositorioVistaImgs;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<VistaImgs> getAll(){
		return repositorioVistaImgs.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaImgs> getOne(@RequestParam int nIdInventario){
		return repositorioVistaImgs.findById(nIdInventario);
	}

}
