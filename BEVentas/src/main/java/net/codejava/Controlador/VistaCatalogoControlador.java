package net.codejava.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.VistaCatalogo;
import net.codejava.Repositorio.RepositorioVistaCatalogo;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la vista VistaCatalogo en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Las acciones que podemos realizar estan limitadas a solo selects debido a que las vistas no se pueden modificar
 * Las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/VistaCatalogo")
public class VistaCatalogoControlador {
	
	@Autowired
	private RepositorioVistaCatalogo repositorioVistaCatalogo;
	
	/**
	 * Obtener catálogo de dispositivos de menor a mayor
	 * @return Catálogo ordenado
	 */
	@GetMapping("/ObtenerInventarioAsc")
	public @ResponseBody Iterable<VistaCatalogo> getInventarioAsc(){
		return repositorioVistaCatalogo.findByOrderByIdinventarioAsc();
	}
	/**
	 * Obtener catálogo de dispositivos de mayor a menor
	 * @return Catálogo ordenado
	 */
	@GetMapping("/ObtenerInventarioDesc")
	public @ResponseBody Iterable<VistaCatalogo> getInventarioDesc(){
		return repositorioVistaCatalogo.findByOrderByIdinventarioDesc();
	}
	
	
	
	/**
	 * Obtener catálogo ordenado de menos a más existencias
	 * @return Catálogo ordenado
	 */
	@GetMapping("/ObtenerExistenciasAsc")
	public @ResponseBody Iterable<VistaCatalogo> getExistenciasAsc(){
		return repositorioVistaCatalogo.findByOrderByExistenciasAsc();
	}
	
	/**
	 * Obtener catálogo de más a menos existencias
	 * @return Catalógo ordenado
	 */
	@GetMapping("/ObtenerExistenciasDesc")
	public @ResponseBody Iterable<VistaCatalogo> getExistenciasDesc(){
		return repositorioVistaCatalogo.findByOrderByExistenciasDesc();
	}
	
	/**
	 * Buscar dispositivos que contengan cierto parámetro
	 * @param nBusqueda Valor a buscar en el catálogo
	 * @return Catálogo filtrado y ordenado de menor a mayor
	 */
	@GetMapping("/BuscarMenorMayor")
	public @ResponseBody Iterable<VistaCatalogo> buscarMenorMayor(@RequestParam String nBusqueda){
		return repositorioVistaCatalogo.findByTipodispositivoContainingOrNombremarcaContainingOrDescripcionContainingOrModeloContainingOrColorContainingOrderByPreciolistaAsc(nBusqueda,nBusqueda,nBusqueda,nBusqueda,nBusqueda);
	}
	
	/**
	 * Buscar dispositivos que contengan cierto parámetro
	 * @param nBusqueda Valor a buscar en el catálogo
	 * @return Catálogo filtrado y ordenado de mayor a menor
	 */
	@GetMapping("/BuscarMayorMenor")
	public @ResponseBody Iterable<VistaCatalogo> buscar(@RequestParam String nBusqueda){
		return repositorioVistaCatalogo.findByTipodispositivoContainingOrNombremarcaContainingOrDescripcionContainingOrModeloContainingOrColorContainingOrderByPreciolistaDesc(nBusqueda,nBusqueda,nBusqueda,nBusqueda,nBusqueda);
	}
	
	
	/*
	@GetMapping("/Obtener")
	public @ResponseBody Optional<VistaCatalogo> getOne(@RequestParam int nIdTipoDispositivo){
		return repositorioVistaCatalogo.findById(nIdTipoDispositivo);
	}*/

}
