package net.codejava.Controlador;

import java.util.ArrayList;
import java.util.List;
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
import net.codejava.Repositorio.RepositorioDispositivos_individuales;

@CrossOrigin
@RestController
@RequestMapping(path="/Dispositivos_individuales")
public class Dispositivos_individualesControlador {

	@Autowired
	private RepositorioDispositivos_individuales repositorioDispositivosIndividuales;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Dispositivos_individuales> getAll(){
		return repositorioDispositivosIndividuales.findAll();
	}
	
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Dispositivos_individuales> getOne(@RequestParam String nSerial){
		return repositorioDispositivosIndividuales.findBySerie(nSerial);
	}
	
	
	@PostMapping("/Registrar")
	public @ResponseBody List<Dispositivos_individuales> registrar(@RequestParam int nIdInventario, @RequestParam int nCantidad) {
	
		List<Dispositivos_individuales> nList = new ArrayList<Dispositivos_individuales>();
		
		for(int i = 0; i < nCantidad; i++) {
			Dispositivos_individuales n = new Dispositivos_individuales("0",nIdInventario);
			nList.add(repositorioDispositivosIndividuales.save(n));	
		}
		
		return nList;
	}
	
	
	
}