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

public class SmartwatchControlador {

	@Autowired
	private RepositorioSmartwatch repositorioSmartwatch;
	
	/**
	 * Query a la tabla SMARTWATCH para obtener todos los datos de la tabla SMARTWATCH
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Smartwatch> getAll(){
		return repositorioSmartwatch.findAll();
	}
	
	/**
	 * Obtener un solo registro de la tabla SMARTWATCH con la ayuda de su identificador
	 * @param nIdInventario
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Smartwatch> getOne(@RequestParam int nIdInventario){
		return repositorioSmartwatch.findById(nIdInventario);
	}
	
	/**
	 * Creacion de un elemento en la tabla SMARTWATCH en la tabla en la base de datos
	 * @param nIdInventario
	 * @param nPulgadasPantalla
	 * @param nSistemaOperativo
	 * @param nRamMB
	 * @param nMemoriaGB
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
