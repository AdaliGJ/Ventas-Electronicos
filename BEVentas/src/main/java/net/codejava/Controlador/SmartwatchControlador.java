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
import net.codejava.Entidad.Smartwatch;
import net.codejava.Repositorio.RepositorioSmartwatch;

@CrossOrigin
@RestController
@RequestMapping(path="/Smartwatch")
public class 
 {
	@Autowired
	private RepositorioSmartwatch repositorioSmartwatch;
	/**
	 * Peticion a la base de datos para obtener todos los elementos que sean Smart Watch
	 * y que esten registgrados en la base de datos
	 * @return
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Smartwatch> getAll(){
		return repositorioSmartwatch.findAll();
	}
	/**
	 * Peticion para obtener un solo electronico de tipo smartwatch
	 * @param nIdInventario Identificador unico
	 * @return
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Smartwatch> getOne(@RequestParam int nIdInventario){
		return repositorioSmartwatch.findById(nIdInventario);
	}
	/**
	 * Peticion para la creacion de un nuevo electronico de tipo SmartWatch con su respectiva informacion importante
	 * @param nIdInventario Identificador 
	 * @param nPulgadasPantalla Inf importante
	 * @param nSistemaOperativo Inf importante
	 * @param nRamMB Inf importante
	 * @param nMemoriaGB Inf importante
	 * @return
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Smartwatch insertar(
			@RequestParam int nIdInventario,
			@RequestParam int nPulgadasPantalla,
			@RequestParam String nSistemaOperativo,
			@RequestParam int nRamMB,
			@RequestParam int nMemoriaGB
			) {
		Smartwatch n = new Smartwatch(nIdInventario, nPulgadasPantalla, nSistemaOperativo, nRamMB, nMemoriaGB);
		return repositorioSmartwatch.save(n);
	}
}
