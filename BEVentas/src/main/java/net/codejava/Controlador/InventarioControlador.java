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

import net.codejava.Entidad.Inventario;
import net.codejava.Repositorio.RepositorioInventario;

@CrossOrigin
@RestController
@RequestMapping(path="/Inventario")
public class InventarioControlador {

	@Autowired
	private RepositorioInventario repositorioInventario;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Inventario> getAll(){
		return repositorioInventario.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Inventario> getOne(@RequestParam int nIdInventario){
		return repositorioInventario.findById(nIdInventario);
	}
	
	@GetMapping("/ObtenerCategoria")
	public @ResponseBody Iterable<Inventario> getCategoria(@RequestParam int nCategoriaDispositivo){
		return repositorioInventario.findAllByCategoriaDispositivo(nCategoriaDispositivo);
	}
	
	@GetMapping("/ObtenerCategoriaMenor")
	public @ResponseBody Iterable<Inventario> getCategoriaMenor(){
		return repositorioInventario.findByOrderByCategoriaDispositivoDesc();
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Inventario insertar(
			@RequestParam int nCategoriaDispositivo,
			@RequestParam int nMarca, 
			@RequestParam int nExistencias,
			@RequestParam float nPrecioLista,
			@RequestParam String nColor,
			@RequestParam String nDescripcion,
			@RequestParam String nModelo,
			@RequestParam int nMesesGarantia
			) {
	
		Inventario n = new Inventario(
				4,
				nCategoriaDispositivo,
				nMarca,
				nExistencias,
				nPrecioLista,
				nColor,
				nDescripcion,
				nModelo,
				nMesesGarantia
				);
		
		return repositorioInventario.save(n);
	}
}
