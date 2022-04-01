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
import net.codejava.Entidad.Ventas;
import net.codejava.Repositorio.RepositorioDispositivos_individuales;

@CrossOrigin
@RestController
@RequestMapping(path="/Dispositivos_individuales")
public class Dispositivos_individualesControlador {

	@Autowired
	private RepositorioDispositivos_individuales repositorioDispositivosIndividuales;
	
	
	
	
	/**
	 * Query para obtener todos los dispositivos en la base de datos
	 * 
	 * @return Lista de todos los dispositivos individuales en formato Json
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Dispositivos_individuales> getAll(){
		return repositorioDispositivosIndividuales.findAll();
	}
	
	/**
	 * Query para obtener el registro de un solo dispositivo individual por medio de su numero de serie
	 * 
	 * @param nSerial Consta de un string de 20 digitos el cual corresponde a un numero serial del dispositvo en la base de datos
	 * @return Al ingresar un numero serial valido, devuelve el registro correspondiente a ese dispositivo en formato Json
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Dispositivos_individuales> getOne(@RequestParam String nSerial){
		return repositorioDispositivosIndividuales.findBySerie(nSerial);
	}
	
	/**
	 * Query iterativo que se va a encargar de registrar nuevos dispositivos individuales en la base de datos
	 * @param nIdInventario Es el numero de inventario del cual corresponde al nuevo dispositivo ingresado en la base de datos
	 * @param nCantidad Cantidad de dispositivos que se desean ingresar en la base de datos
	 * @return Devuelve todos los dipositivos generados con su numero de serie en un Json
	 */
	@PostMapping("/Registrar")
	public @ResponseBody List<Dispositivos_individuales> registrar(@RequestParam int nIdInventario, @RequestParam int nCantidad) {
	
		List<Dispositivos_individuales> nList = new ArrayList<Dispositivos_individuales>();
		
		for(int i = 0; i < nCantidad; i++) {
			Dispositivos_individuales n = new Dispositivos_individuales("0",nIdInventario);
			nList.add(repositorioDispositivosIndividuales.save(n));	
		}
		
		return nList;
	}
	
	/*@PostMapping("/Insertar")
	public @ResponseBody Dispositivos_individuales insertar(
			@RequestParam int nId,
			@RequestParam String nSerie
			) {
	
		Dispositivos_individuales n = new Dispositivos_individuales(nSerie,nId);
		
		return RepositorioDispositivos_individuales.save(n);
	}*/
	
	
	
}
