package net.codejava.Controlador;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Marcas;
import net.codejava.Repositorio.RepositorioMarcas;

@CrossOrigin
@RestController 
@RequestMapping(path="/Marca")
public class MarcasControlador {
	
	@Autowired
	private RepositorioMarcas repositorioMarcas;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Marcas> getAll(){
		return repositorioMarcas.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Marcas> getOne(@RequestParam int nIdMarca){
		return repositorioMarcas.findById(nIdMarca);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Marcas insertar(@RequestParam String nNombre) {
	
		Marcas n = new Marcas(4,nNombre);
		
		return repositorioMarcas.save(n);
	}
}
