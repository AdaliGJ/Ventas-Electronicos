package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Tipo_dispositivo;
import net.codejava.Repositorio.RepositorioTipo_dispositivo;

@RestController
@RequestMapping(path="/Tipo_dispositivo")
public class Tipo_dispositivoControlador {

	@Autowired
	private RepositorioTipo_dispositivo repositorioTipoDispositivo;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Tipo_dispositivo> getAll(){
		return repositorioTipoDispositivo.findAll();
	}
}
