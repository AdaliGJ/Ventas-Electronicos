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

import net.codejava.Entidad.Tipo_dispositivo;
import net.codejava.Repositorio.RepositorioTipo_dispositivo;

@CrossOrigin
@RestController
@RequestMapping(path="/Tipo_dispositivo")
public class Tipo_dispositivoControlador {

	@Autowired
	private RepositorioTipo_dispositivo repositorioTipoDispositivo;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_dispositivo> getAll(){
		return repositorioTipoDispositivo.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Tipo_dispositivo> getOne(@RequestParam int nIdTipoDispositivo){
		return repositorioTipoDispositivo.findById(nIdTipoDispositivo);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Tipo_dispositivo insertar(@RequestParam String nNombre) {
	
		Tipo_dispositivo n = new Tipo_dispositivo(0,nNombre);
		
		return repositorioTipoDispositivo.save(n);
	}
}
