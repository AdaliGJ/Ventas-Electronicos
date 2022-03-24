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

import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Ordenes_compra;
import net.codejava.Repositorio.RepositorioOrdenes_compra;

@CrossOrigin
@RestController
@RequestMapping(path="/Ordenes_compra")
public class Ordenes_compraControlador {

	@Autowired
	private RepositorioOrdenes_compra repositorioOrdenesCompra;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Ordenes_compra> getAll(){
		return repositorioOrdenesCompra.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Ordenes_compra> getOne(@RequestParam int nIdOrden){
		return repositorioOrdenesCompra.findById(nIdOrden);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Ordenes_compra insertar(
			@RequestParam int nNit, 
			@RequestParam boolean nCredito,
			@RequestParam String nEntregaEstimada,
			@RequestParam float nPrecio,
			@RequestParam String nFecha
			) {
	
		Ordenes_compra n = new Ordenes_compra(4,nNit,nCredito,nEntregaEstimada,nPrecio,nFecha);
		
		return repositorioOrdenesCompra.save(n);
	}
}
