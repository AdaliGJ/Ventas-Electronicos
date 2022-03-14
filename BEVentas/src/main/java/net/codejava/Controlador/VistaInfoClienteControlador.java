package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaInfoCliente;
import net.codejava.Repositorio.RepositorioVistaInfoCliente;

@CrossOrigin
@RestController
@RequestMapping(path="/VistaInfoCliente")
public class VistaInfoClienteControlador {

	
	@Autowired
	private RepositorioVistaInfoCliente repositorioVistaInfoCliente;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<VistaInfoCliente> getAll(){
		return repositorioVistaInfoCliente.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaInfoCliente> getOne(@RequestParam int nIdCliente){
		return repositorioVistaInfoCliente.findById(nIdCliente);
	}
	
}
