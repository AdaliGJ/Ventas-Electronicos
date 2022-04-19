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

import net.codejava.Entidad.Televisores;
import net.codejava.Repositorio.RepositorioTelevisores;

@CrossOrigin
@RestController
@RequestMapping(path="/Televisores")
public class TelevisoresControlador {
	
	@Autowired
	private RepositorioTelevisores repositorioTelevisores;
	
	/**
	 * Query a la tabla TELEVISORES para obtener todos los datos de la tabla TELEVISORES
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Televisores> getAll(){
		return repositorioTelevisores.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla TELEVISORES con la ayuda de su identificador
	 * @param nIdInventario
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Televisores> getOne(@RequestParam int nIdInventario){
		return repositorioTelevisores.findById(nIdInventario);
	}
	/**
	 * Creacion de un elemento en la tabla TELEVISORES en la tabla en la base de datos
	 * @param nIdInventario
	 * @param nResolucion
	 * @param nBitsProfundidad
	 * @param nPulgadasPantalla
	 * @param nEntradasHDMI
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Televisores insertar(
			@RequestParam int nIdInventario,
			@RequestParam String nResolucion,
			@RequestParam int nBitsProfundidad,
			@RequestParam int nPulgadasPantalla,
			@RequestParam int nEntradasHDMI
			) {
	
		Televisores n = new Televisores(nIdInventario, nResolucion, nBitsProfundidad, nPulgadasPantalla, nEntradasHDMI);
		
		return repositorioTelevisores.save(n);
	}

}
