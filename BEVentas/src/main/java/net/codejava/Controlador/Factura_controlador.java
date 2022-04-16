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

import net.codejava.Entidad.Factura;
import net.codejava.Repositorio.RepositorioFactura;

@CrossOrigin
@RestController
@RequestMapping(path="/Factura")
public class Factura_controlador {
	
	@Autowired
	private RepositorioFactura repositorioFactura;
	
	
	/**
	 * Query a la tabla FACTURA para obtener todos los datos de la tabla FACTURA
	 * @return  objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Factura> getAll(){
		return repositorioFactura.findAll();
	}
	
	/**
	 *  Obtener un solo registro de la tabla FACTURA con la ayuda de su identificador
	 * @param nIdEntradaFactura Identificador de la tupla
	 * @return Un solo objeto de la tabla FACTURA
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Factura> getOne(@RequestParam int nIdEntradaFactura){
		return repositorioFactura.findById(nIdEntradaFactura);
	}

	/**
	 * Creacion de una nueva FACTURA en la tabla en la base de datos
	 * @param nIdFactura  
	 * @param nIdVenta
	 * @param nNitCliente
	 * @param nPrecio
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Factura insertar(
			@RequestParam String nIdFactura, 
			@RequestParam int nIdVenta,
			@RequestParam int nNitCliente,
			@RequestParam float nPrecio
			) {
	
		Factura n = new Factura(4,nIdFactura,nIdVenta,nNitCliente,nPrecio);
		
		return repositorioFactura.save(n);
	}
}
