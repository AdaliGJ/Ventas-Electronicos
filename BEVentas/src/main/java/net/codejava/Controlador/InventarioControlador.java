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
	
	/**
	 * Query a la tabla INVENTARIO para obtener todos los datos de la tabla INVENTARIO
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Inventario> getAll(){
		return repositorioInventario.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla INVENTARIO con la ayuda de su identificador
	 * @param nId
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Inventario> getOne(@RequestParam int nId){
		return repositorioInventario.findById(nId);
	}
	/**
	 * Obtener Categoria de un elemento del INVENTARIO
	 * @param nCategoriaDispositivo
	 * @return Inventario
	 */
	@GetMapping("/ObtenerCategoria")
	public @ResponseBody Iterable<Inventario> getCategoria(@RequestParam int nCategoriaDispositivo){
		return repositorioInventario.findAllByCategoriaDispositivo(nCategoriaDispositivo);
	}
	
	/**
	 * Obtener Categoria MENOR de un elemento del INVENTARIO
	 * @return
	 */
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
	
	
	/**
	 * Creacion de un elemento en la tabla INVENTARIO en la tabla en la base de datos
	 * @param nCategoriaDispositivo
	 * @param nMarca
	 * @param nExistencias
	 * @param nPrecioLista
	 * @param nColor
	 * @param nDescripcion
	 * @param nModelo
	 * @param nMesesGarantia
	 * @return Registro de lo insertado en formato JSON
	 */
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
	
	/**
	 * Modificacion de un elemento del inventario con ayuda de su identificador 
	 * @param nIdInventario
	 * @param nCategoriaDipositivo
	 * @param nMarca
	 * @param nExistencias
	 * @param nPrecioLista
	 * @param nColor
	 * @param nDescripcion
	 * @param nModelo
	 * @param nMesesGarantia
	 * @return Mensaje de confirmacion del cambio
	 */
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
	
	/**
	 * Modificacion de unidades disponibles en la tabla INVENTARIO
	 * @param nIdInventario
	 * @param nCantidad
	 * @param nOperacion
	 * @return Confirmacion de la edicion de unidades disponibles en el INVENTARIO
	 */
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
