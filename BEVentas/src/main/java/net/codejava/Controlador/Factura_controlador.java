package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Factura;
import net.codejava.Repositorio.RepositorioFactura;

@CrossOrigin
@RestController
@RequestMapping(path="/Factura")
public class Factura_controlador {
	
	@Autowired
	private RepositorioFactura repositorioFactura;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Factura> getAll(){
		return repositorioFactura.findAll();
	}

	/*
	@PostMapping("/Insertar")
	public @ResponseBody Factura insertar(@RequestParam int n, @RequestParam String nContraseña) {
	
		Factura n = new Factura(4,nTipoCliente,nContraseña);
		
		return repositorioFactura.save(n);
	}*/
}
