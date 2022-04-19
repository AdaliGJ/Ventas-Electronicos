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
import net.codejava.Entidad.Prueba;
import net.codejava.Entidad.Usuarios;
import net.codejava.Repositorio.RepositorioPrueba;

/**
 * Repositorio de prueba de CRUD
 * @author Adalí Garrán, Jorge Guerrero, Javier López
 *
 */

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class PruebaControlador {

	@Autowired
	private RepositorioPrueba repositorioPrueba;
	/*
	@Autowired
	private JdbcTemplate jdbcTemplate;
	*/
	@GetMapping("/prueba")
	public @ResponseBody Iterable<Prueba> getAllPruebas(){
		return repositorioPrueba.findAll();
	}
	
	/*
	@GetMapping("/valor")
	public void buscarValor(@RequestParam String nValor2){
		
		String query = "select * from prueba";
		
		jdbcTemplate.execute(query);
	}
	*/
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Prueba> getOne(@RequestParam String nValor2){
		return repositorioPrueba.findByValor2(nValor2);
	}
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Prueba> getAll(){
		return repositorioPrueba.findAll();
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Prueba insertarPrueba (@RequestParam int nValor1, @RequestParam String nValor2) {
	
		Prueba n = new Prueba(4,nValor1,nValor2);
		
		return repositorioPrueba.save(n);
	}
	
	@PostMapping("/Modificar")
	public @ResponseBody String Modificar(@RequestParam int nId, @RequestParam int nValor1, @RequestParam String nValor2) {
		
		Optional<Prueba> n = repositorioPrueba.findById(nId);
		Prueba _n = n.get();
		_n.setValor1(nValor1);
		_n.setValor2(nValor2);
		repositorioPrueba.save(_n);
		
		return "Se ha modificado correctamente";
	}
	
	@PostMapping("/borrar")
	public @ResponseBody String BorrarPrueba (@RequestParam int nId) {
	
		if(repositorioPrueba.existsById(nId)) {
			
			repositorioPrueba.deleteById(nId);
			
			if(repositorioPrueba.existsById(nId)) {
				return "No se ha logrado borrar el usuario";
			} 
			else 
			{
				return "Se ha borrado correctamente";
			}
			
		} else {
			return "El usuario no existe";
		}	
	}
}
