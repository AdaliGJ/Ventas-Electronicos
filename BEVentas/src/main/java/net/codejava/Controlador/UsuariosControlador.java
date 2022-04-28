package net.codejava.Controlador;

import java.util.HashMap;
import java.util.Map;
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
import net.codejava.Entidad.Usuarios;
import net.codejava.Repositorio.RepositorioUsuarios;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Usuarios en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Usuarios")
public class UsuariosControlador {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	/**
	 * Constructor de la clase UsuariosControlador
	 */
	public UsuariosControlador(){}
	
	/**]
	 * Query a la tabla USUARIOS para obtener todos los datos de la tabla USUARIOS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Usuarios> getAll(){
		return repositorioUsuarios.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla USUARIOS con la ayuda de su identificador
	 * @param nNit
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Usuarios> getOne(@RequestParam int nNit){
		return repositorioUsuarios.findById(nNit);
	}
	
	/**
	 *  Creacion de un elemento en la tabla USUARIOS en la tabla en la base de datos
	 * @param nNit
	 * @param nTipoUsuario
	 * @param nPassword
	 * @param nNombre
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Usuarios insertar(@RequestParam int nNit, @RequestParam int nTipoUsuario ,@RequestParam String nPassword, @RequestParam String nNombre) {
	
		Usuarios n = new Usuarios(nNit,nTipoUsuario,nPassword,nNombre);
		
		return repositorioUsuarios.save(n);
	}
	
	/**
	 * Query para obtener datos del usuario y poder comparar los datos enviados con los datos de la tabla
	 * @param nIdUsuario
	 * @param nPassword
	 * @return Retorna una respuesta si los datos son correctos o no
	 */
	@GetMapping("/Login")
	public @ResponseBody Map<String,String> registrar(@RequestParam int nIdUsuario, @RequestParam String nPassword) {
	
		HashMap<String,String> response = new HashMap<>();
		
		Optional<Usuarios> n = repositorioUsuarios.findByIdUsuarioAndPassword(nIdUsuario,nPassword);

		if(n.isEmpty()) {
			response.put("respuesta", "error");
		}else {
			response.put("respuesta", "ok");
		}
		
		
		return response;
	}
}
