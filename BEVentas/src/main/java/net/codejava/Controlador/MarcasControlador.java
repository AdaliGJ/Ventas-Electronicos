package net.codejava.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Marcas;
import net.codejava.Repositorio.MarcaServiceApi;

@RestController 
@RequestMapping(path="/Marca")
public class MarcasControlador {
	
	@Autowired
	private MarcaServiceApi marcaServiceApi;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Marcas> getAll(){
		return marcaServiceApi.findAll();
	}
}
