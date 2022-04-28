package net.codejava.Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Prueba;
import net.codejava.Entidad.Ventas;
import net.codejava.Repositorio.RepositorioVentas;

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Ventas en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/Ventas")
public class VentasControlador {

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private RepositorioVentas repositorioVentas;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Constructor de la clase VentasControlador
	 */
	public VentasControlador(){}
	
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
	
	/**
	 * Creación de una nueva orden de compra y factura
	 * @param nCredito Booleano que indica si la venta es al crédito o al contado
	 * @param nFecha Fecha de la orden
	 * @param nCategoria Tipo de dispositivo
	 * @param nCliente Identificador del cliente que hizo la compra
	 * @param nPrecio Precio total de la orden
	 * @param nFactura Identificador de la factura
	 */
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
	
	/**
	 * Creación de una nueva venta y actualización de inventario a vendidos
	 * @param nCredito Booleano que indica si la venta es al crédito o al contado
	 * @param nFecha Fecha de la orden
	 * @param nCategoria Tipo de dispositivo
	 * @param nCliente Identificador del cliente que hizo la compra
	 * @param nPrecio Precio total de la orden
	 * @param nFactura Identificador de la factura
	 * @param nSuma 
	 * @param nOff Identificador del Offset
	 */
	@PostMapping("/Orden2")
	@ResponseBody
	public void ordenar2(
			@RequestParam char nCredito,
			@RequestParam String nFecha,
			@RequestParam int nCategoria,
			@RequestParam int nCliente,
			@RequestParam String nPrecio,
			@RequestParam String nFactura,
			@RequestParam String nSuma,
			@RequestParam int nOff
			) {
	
		String Sql = "call venta(?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(Sql, nCredito, nFecha, nCategoria, nCliente, nPrecio, nFactura, nSuma, nOff);
	}
	
	
	/*@PostMapping("/Orden3")
	@ResponseBody
	public int ordenar3(
			@RequestParam char nCredito,
			@RequestParam String nSeries,
			@RequestParam String nFecha,
			@RequestParam String nPrecioVenta,
			@RequestParam int nCantidad
			) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		Dispositivos_individuales[] responseG = mapper.readValue(nSeries, Dispositivos_individuales[].class);
		
		
		if(responseG.length <= nCantidad) {
	
			for(int i = 0; i < responseG.length ;i++) {
			
			String Sql = "call ventas2(?, ?, ?)";
			jdbcTemplate.update(Sql, responseG[i].getSerie_dispositivo(), nFecha, nCredito);
			
			HashMap<String,String> body = new HashMap<>();
					
					body.put("serie", responseG[i].getSerie_dispositivo());
					body.put("precioVenta", nPrecioVenta);
					
				    String url = "http://localhost:4000/api/reporteria";
			
				    restTemplate.postForObject(url, body, Object.class);
				    
				   
			
			}
			 return nCantidad - responseG.length;
		}else {
			for(int i = 0; i < nCantidad ;i++) {
				
				String Sql = "call ventas2(?, ?, ?)";
				jdbcTemplate.update(Sql, responseG[i].getSerie_dispositivo(), nFecha, nCredito);
				
				HashMap<String,String> body = new HashMap<>();
						
						body.put("serie", responseG[i].getSerie_dispositivo());
						body.put("precioVenta", nPrecioVenta);
						
					    String url = "http://localhost:4000/api/reporteria";
				
					    restTemplate.postForObject(url, body, Object.class);
				
				}
			return 0;
			
		}
	}*/
	
	
	
	
}
