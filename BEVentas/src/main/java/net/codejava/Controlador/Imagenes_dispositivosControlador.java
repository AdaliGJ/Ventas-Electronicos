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

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Fichas_clientes;
import net.codejava.Entidad.Imagenes_dispositivos;
import net.codejava.Repositorio.RepositorioImagenes_dispositivos;

@CrossOrigin
@RestController
@RequestMapping(path="/Imagenes_dispositivos")
public class Imagenes_dispositivosControlador {


	@Autowired
	private RepositorioImagenes_dispositivos repositorioImagenesDispositivo;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Imagenes_dispositivos> getAll(){
		return repositorioImagenesDispositivo.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Imagenes_dispositivos> getOne(@RequestParam int nIdImagen){
		return repositorioImagenesDispositivo.findById(nIdImagen);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Imagenes_dispositivos insertar(
			@RequestParam int nIdInventario,
			@RequestParam String nImagen
			) {
	
		Imagenes_dispositivos n = new Imagenes_dispositivos(4,nIdInventario,nImagen);
		
		return repositorioImagenesDispositivo.save(n);
	}
	
	@GetMapping("/ObtenerA")
	public @ResponseBody Iterable<Imagenes_dispositivos> getArray(@RequestParam int nIdInventario){
		return repositorioImagenesDispositivo.findByidInventario(nIdInventario);
	}
	
	
}
