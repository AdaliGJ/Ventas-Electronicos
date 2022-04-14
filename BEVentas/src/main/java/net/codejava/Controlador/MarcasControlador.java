package net.codejava.Controlador;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Marcas> getAll(){
		return repositorioMarcas.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Marcas> getOne(@RequestParam int nIdMarca){
		return repositorioMarcas.findById(nIdMarca);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Marcas insertar(@RequestParam String nNombre, @RequestParam String nIP) {
	
		Marcas n = new Marcas(4,nNombre, nIP);
		
		return repositorioMarcas.save(n);
	}
	
	@PostMapping("/Insertar2")
	@ResponseBody
	public void insertarP(@RequestParam String nNombre, @RequestParam String nIP) {
	
		String Sql = "call marcanueva(?, ?)";
		jdbcTemplate.update(Sql, nNombre, nIP);
		
		
	}
}
