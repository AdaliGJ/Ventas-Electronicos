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

@CrossOrigin
@RestController
@RequestMapping(path="/Usuarios")
public class UsuariosControlador {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Usuarios> getAll(){
		return repositorioUsuarios.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Usuarios> getOne(@RequestParam int nNit){
		return repositorioUsuarios.findById(nNit);
	}
	
	
	@PostMapping("/Insertar")
	public @ResponseBody Usuarios insertar(@RequestParam int nNit, @RequestParam int nTipoUsuario ,@RequestParam String nPassword, @RequestParam String nNombre) {
	
		Usuarios n = new Usuarios(nNit,nTipoUsuario,nPassword,nNombre);
		
		return repositorioUsuarios.save(n);
	}
	
	
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
