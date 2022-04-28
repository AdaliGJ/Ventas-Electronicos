package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioTipo_usuarios;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Tipo_usuario en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Tipo_usuario")
public class Tipo_usuarioControlador {
	
	@Autowired
	private RepositorioTipo_usuarios repositorioTipoUsuario;
	
	/**
	 * Constructor de la clase Tipo_usuarioControlador
	 */
	public Tipo_usuarioControlador(){}
	
	/**
	 * Query a la tabla TIPO_USUARIO para obtener todos los datos de la tabla TIPO_USUARIO
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_usuarios> getAll(){
		return repositorioTipoUsuario.findAll();
	}
	
	/**
	 * Obtener un solo registro de la tabla TIPO_USUARIO con la ayuda de su identificador
	 * @param nIdTipoUsuario
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Tipo_usuarios> getOne(@RequestParam int nIdTipoUsuario){
		return repositorioTipoUsuario.findById(nIdTipoUsuario);
	}

}
