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

import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Fichas_clientes;
import net.codejava.Repositorio.RepositorioFicha_clientes;

@CrossOrigin
@RestController
@RequestMapping(path="/Fichas_clientes")
public class Fichas_clienteControlador {

	@Autowired
	private RepositorioFicha_clientes repositorioFichasClientes;
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Fichas_clientes> getAll(){
		return repositorioFichasClientes.findAll();
	}
	
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Fichas_clientes> getOne(@RequestParam int nNit){
		return repositorioFichasClientes.findById(nNit);
	}
	
	@PostMapping("/Insertar")
	public @ResponseBody Fichas_clientes insertar(
			@RequestParam int nNit,
			@RequestParam String nNombre,
			@RequestParam String nEmail,
			@RequestParam int nTelefono,
			@RequestParam String nPatenteDeComercio,
			@RequestParam String nFechaDeVencimiento
			) {
	
		Fichas_clientes n = new Fichas_clientes(nNit,nNombre,nEmail, nTelefono, nPatenteDeComercio, nFechaDeVencimiento);
		
		return repositorioFichasClientes.save(n);
	}
	
	
}
