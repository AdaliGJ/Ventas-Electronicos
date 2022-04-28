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
import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Ordenes_compra;
import net.codejava.Repositorio.RepositorioOrdenes_compra;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Ordenes_compra en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Ordenes_compra")
public class Ordenes_compraControlador {

	@Autowired
	private RepositorioOrdenes_compra repositorioOrdenesCompra;
	
	/**
	 * Constructor de la clase Ordenes_compraControlador
	 */
	public Ordenes_compraControlador(){}
	
	/**
	 * Query a la tabla ORDENES_COMPRA para obtener todos los datos de la tabla ORDENES_COMPRA
	 * @return objeto JSON con todos los registros
	 */
	
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Ordenes_compra> getAll(){
		return repositorioOrdenesCompra.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla ORDENES_COMPRA con la ayuda de su identificador
	 * @param nIdOrden
	 * @return  Un solo objeto de la tabla 
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Ordenes_compra> getOne(@RequestParam int nIdOrden){
		return repositorioOrdenesCompra.findById(nIdOrden);
	}
	/**
	 * Creacion de una nueva ORDEN_COMPRA en la tabla en la base de datos
	 * @param nNit
	 * @param nCredito
	 * @param nEntregaEstimada
	 * @param nPrecio
	 * @param nFecha
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Ordenes_compra insertar(
			@RequestParam int nNit, 
			@RequestParam boolean nCredito,
			@RequestParam String nEntregaEstimada,
			@RequestParam float nPrecio,
			@RequestParam String nFecha
			) {
	
		Ordenes_compra n = new Ordenes_compra(4,nNit,nCredito,nEntregaEstimada,nPrecio,nFecha);
		
		return repositorioOrdenesCompra.save(n);
	}
}
