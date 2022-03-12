package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Imagenes_dispositivos;
import net.codejava.Repositorio.RepositorioImagenes_dispositivos;

@RestController
@RequestMapping(path="/Imagenes_dispositivos")
public class Imagenes_dispositivosControlador {


	@Autowired
	private RepositorioImagenes_dispositivos repositorioImagenesDispositivo;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Imagenes_dispositivos> getAll(){
		return repositorioImagenesDispositivo.findAll();
	}
}
