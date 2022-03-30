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
import net.codejava.Entidad.Prueba;
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
	public @ResponseBody Optional<Inventario> getOne(@RequestParam int nId){
		return repositorioInventario.findById(nId);
	}
	
	@GetMapping("/ObtenerCategoria")
	public @ResponseBody Iterable<Inventario> getCategoria(@RequestParam int nCategoriaDispositivo){
		return repositorioInventario.findAllByCategoriaDispositivo(nCategoriaDispositivo);
	}
	
	@GetMapping("/ObtenerCategoriaMenor")
	public @ResponseBody Iterable<Inventario> getCategoriaMenor(){
		return repositorioInventario.findByOrderByCategoriaDispositivoDesc();
	}
	
	@PostMapping("/PruebaPost")
	public String pruebaPost() {
		return "el post funciono";
	}
	
	@PostMapping("/PruebaPost2")
	public @ResponseBody Iterable<Inventario> pruebaPost2(){
		return repositorioInventario.findAll();
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
	
	
	@PostMapping("/Modificar")
	public @ResponseBody String Modificar(
			@RequestParam int nIdInventario, 
			@RequestParam String nCategoriaDipositivo,
			@RequestParam String nMarca,
			@RequestParam String nExistencias,
			@RequestParam String nPrecioLista,
			@RequestParam String nColor,
			@RequestParam String nDescripcion,
			@RequestParam String nModelo,
			@RequestParam String nMesesGarantia
			) {
		
		Optional<Inventario> n = repositorioInventario.findById(nIdInventario);
		Inventario _n = n.get();
		

		if(nCategoriaDipositivo != "") {
			_n.setCategoriaDispositivo(Integer.parseInt(nCategoriaDipositivo));
		}
		
		if(nMarca != "") {
			_n.setCategoriaDispositivo(Integer.parseInt(nMarca));
		}
		
		if(nExistencias != "") {
			_n.setExistencias(Integer.parseInt(nExistencias));
		}
		
		if(nPrecioLista != "") {
			_n.setPrecioLista(Float.parseFloat(nPrecioLista));
		}
		
		
		if(nColor != "") {
			_n.setColor(nColor);
		}
		
		if(nDescripcion != "") {
			_n.setDescripcion(nDescripcion);
		}
		
		if(nModelo != "") {
			_n.setModelo(nModelo);
		}
		
		if(nMesesGarantia != "") {
			_n.setMesesGarantia(Integer.parseInt(nMesesGarantia));
		}
		
		
		repositorioInventario.save(_n);
		
		return "Se ha modificado correctamente";
	}
	
	
	@PostMapping("/ModificarUnidades")
	public @ResponseBody String ModificarUnidades(@RequestParam int nIdInventario, @RequestParam int nCantidad, @RequestParam String nOperacion) {
		
		Optional<Inventario> n = repositorioInventario.findById(nIdInventario);
		Inventario _n = n.get();
		
		
		if(nOperacion.equals("Agregar")) {
			
			int nuevasUnidades = nCantidad + _n.getExistencias();
			_n.setExistencias(nuevasUnidades);
			
			repositorioInventario.save(_n);
			
			return "Se han agregado las unidades";
			
		}else if(nOperacion.equals("Restar")) {
			int nuevasUnidades = _n.getExistencias() - nCantidad;
			_n.setExistencias(nuevasUnidades);
			
			repositorioInventario.save(_n);
			
			return "Se han restado las unidades";
			
		} else {
			
			return "No se ha modificado ningun valor" + nOperacion;
		}
		
		
	}
	
	
}
