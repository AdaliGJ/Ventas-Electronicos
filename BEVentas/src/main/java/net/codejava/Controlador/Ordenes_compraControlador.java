package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Ordenes_compra;
import net.codejava.Repositorio.RepositorioOrdenes_compra;

@RestController
@RequestMapping(path="/Ordenes_compra")
public class Ordenes_compraControlador {

	@Autowired
	private RepositorioOrdenes_compra repositorioOrdenesCompra;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Ordenes_compra> getAll(){
		return repositorioOrdenesCompra.findAll();
	}
}
