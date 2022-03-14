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
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Factura> getOne(@RequestParam int nIdEntradaFactura){
		return repositorioFactura.findById(nIdEntradaFactura);
	}

	
	@PostMapping("/Insertar")
	public @ResponseBody Factura insertar(
			@RequestParam String nIdFactura, 
			@RequestParam int nIdVenta,
			@RequestParam int nNitCliente,
			@RequestParam float nPrecio
			) {
	
		Factura n = new Factura(4,nIdFactura,nIdVenta,nNitCliente,nPrecio);
		
		return repositorioFactura.save(n);
	}
}
