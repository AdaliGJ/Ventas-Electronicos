package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Factura;
import net.codejava.Repositorio.RepositorioFactura;

@RestController
@RequestMapping(path="/Factura")
public class Factura_controlador {
	
	@Autowired
	private RepositorioFactura repositorioFactura;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Factura> getAll(){
		return repositorioFactura.findAll();
	}

}
