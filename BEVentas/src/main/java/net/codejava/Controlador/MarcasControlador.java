package net.codejava.Controlador;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Marcas;
import net.codejava.Repositorio.RepositorioMarcas;

@CrossOrigin
@RestController 
@RequestMapping(path="/Marca")
public class MarcasControlador {
	
	@Autowired
	private RepositorioMarcas repositorioMarcas;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Query a la tabla MARCAS para obtener todos los datos de la tabla MARCAS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Marcas> getAll(){
		return repositorioMarcas.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla MARCAS con la ayuda de su identificador
	 * @param nIdMarca
	 * @return Un solo objeto de la tabla 
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Marcas> getOne(@RequestParam int nIdMarca){
		return repositorioMarcas.findById(nIdMarca);
	}
	/**
	 * Creacion de una nueva MARCA en la tabla en la base de datos
	 * @param nNombre
	 * @param nIP
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Marcas insertar(@RequestParam String nNombre, @RequestParam String nIP) {
	
		Marcas n = new Marcas(4,nNombre, nIP);
		
		return repositorioMarcas.save(n);
	}
	
	/**
	 * Creacion de una nueva MARCA en la tabla en la base de datos(Procedimiento almacenado)
	 * @param nNombre
	 * @param nIP
	 * @return Registro de lo insertado en formato JSON
	 */
	
	@PostMapping("/Insertar2")
	@ResponseBody
	public void insertarP(@RequestParam String nNombre, @RequestParam String nIP) {
	
		String Sql = "call marcanueva(?, ?)";
		jdbcTemplate.update(Sql, nNombre, nIP);
		
		
	}
}
