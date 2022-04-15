package net.codejava.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Prueba;
import net.codejava.Entidad.Ventas;
import net.codejava.Repositorio.RepositorioVentas;

@CrossOrigin
@RestController
@RequestMapping(path="/Ventas")
public class VentasControlador {

	@Autowired
	private RepositorioVentas repositorioVentas;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Query a la tabla VENTAS para obtener todos los datos de la tabla VENTAS
	 * @return objeto JSON con todos los registros
	 */
	@GetMapping("/ObtenerTodos")
	public @ResponseBody Iterable<Ventas> getAll(){
		return repositorioVentas.findAll();
	}
	/**
	 * Obtener un solo registro de la tabla VENTAS con la ayuda de su identificador
	 * @param nIdVenta
	 * @return Un solo objeto de la tabla
	 */
	@GetMapping("/Obtener")
	public @ResponseBody Optional<Ventas> getOne(@RequestParam int nIdVenta){
		return repositorioVentas.findById(nIdVenta);
	}
	/**
	 * Creacion de un elemento en la tabla VENTAS en la tabla en la base de datos
	 * @param nIdOrden
	 * @param nSerie
	 * @param nCredito
	 * @param nFecha
	 * @return Registro de lo insertado en formato JSON
	 */
	@PostMapping("/Insertar")
	public @ResponseBody Ventas insertar(
			@RequestParam int nIdOrden,
			@RequestParam String nSerie,
			@RequestParam boolean nCredito, 
			@RequestParam String nFecha
			) {
	
		Ventas n = new Ventas(4,nIdOrden,nSerie,nCredito,nFecha);
		
		return repositorioVentas.save(n);
	}
	
	@PostMapping("/Orden")
	@ResponseBody
	public void ordenar(
			@RequestParam char nCredito,
			@RequestParam String nFecha,
			@RequestParam int nCategoria,
			@RequestParam int nCliente,
			@RequestParam String nPrecio,
			@RequestParam String nFactura
			) {
	
		String Sql = "call orden_ventas(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(Sql, nCredito, nFecha, nCategoria, nCliente, nPrecio, nFactura);
	}
	
	
}
