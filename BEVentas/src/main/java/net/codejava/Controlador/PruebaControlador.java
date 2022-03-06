package net.codejava.Controlador;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import net.codejava.Entidad.Prueba;
import net.codejava.Repositorio.RepositorioPrueba;


@RestController
@RequestMapping(path="/api")
public class PruebaControlador {

	@Autowired
	private RepositorioPrueba repositorioPrueba;
	
	
	@PostMapping("/insertar")
	public @ResponseBody String insertarPrueba (@RequestParam int nValor1, @RequestParam String nValor2) {
	

		
		Prueba n = new Prueba(4,nValor1,nValor2);
		//n.setId_prueba(4);
		//n.setValor_1(nValor1);
		//n.setValor_2(nValor2);
		repositorioPrueba.save(n);
		
		return "ok";
	}
	
	
	@GetMapping("/prueba")
	public @ResponseBody Iterable<Prueba> getAllPruebas(){
		return repositorioPrueba.findAll();
	}
	
}
