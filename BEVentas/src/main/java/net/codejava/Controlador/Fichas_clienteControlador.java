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
	
	/**
	 * Query a la tabla FICHAS_CLIENTES para obtener todos los datos de la tabla FICHAS_CLIENTES
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Fichas_clientes> getAll(){
		return repositorioFichasClientes.findAll();
	}
	
	/**
	 * Obtener un solo registro de la tabla FICHAS_CLIENTES con la ayuda de su identificador
	 * @param nNit
	 * @return Un solo objeto de la tabla FICHAS_CLIENTES
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Fichas_clientes> getOne(@RequestParam int nNit){
		return repositorioFichasClientes.findById(nNit);
	}
	
	/**
	 * Creacion de una nueva FICHA_CLIENTES en la tabla en la base de datos
	 * @param nNit
	 * @param nNombre
	 * @param nEmail
	 * @param nTelefono
	 * @param nPatenteDeComercio
	 * @param nFechaDeVencimiento
	 * @return Registro de lo insertado en formato JSON
	 */
	
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
