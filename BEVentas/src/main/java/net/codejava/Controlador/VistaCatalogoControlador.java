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

@CrossOrigin
@RestController
@RequestMapping(path="/VistaCatalogo")
public class VistaCatalogoControlador {
	
	@Autowired
	private RepositorioVistaCatalogo repositorioVistaCatalogo;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/ObtenerInventarioAsc")
	public @ResponseBody Iterable<VistaCatalogo> getInventarioAsc(){
		return repositorioVistaCatalogo.findByOrderByIdinventarioAsc();
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping("/ObtenerInventarioDesc")
	public @ResponseBody Iterable<VistaCatalogo> getInventarioDesc(){
		return repositorioVistaCatalogo.findByOrderByIdinventarioDesc();
	}
	
	
	
	
	@GetMapping("/ObtenerExistenciasAsc")
	public @ResponseBody Iterable<VistaCatalogo> getExistenciasAsc(){
		return repositorioVistaCatalogo.findByOrderByExistenciasAsc();
	}
	
	@GetMapping("/ObtenerExistenciasDesc")
	public @ResponseBody Iterable<VistaCatalogo> getExistenciasDesc(){
		return repositorioVistaCatalogo.findByOrderByExistenciasDesc();
	}
	
	@GetMapping("/BuscarMenorMayor")
	public @ResponseBody Iterable<VistaCatalogo> buscarMenorMayor(@RequestParam String nBusqueda){
		return repositorioVistaCatalogo.findByTipodispositivoContainingOrNombremarcaContainingOrDescripcionContainingOrModeloContainingOrColorContainingOrderByPreciolistaAsc(nBusqueda,nBusqueda,nBusqueda,nBusqueda,nBusqueda);
	}
	
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
