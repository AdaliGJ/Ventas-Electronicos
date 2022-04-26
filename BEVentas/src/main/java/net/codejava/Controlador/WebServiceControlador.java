package net.codejava.Controlador;


import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import net.codejava.Entidad.Pedidos;

@RestController
public class WebServiceControlador {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public WebServiceControlador(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	/**
	 * Web service para obtener clientes de fábrica
	 * @param nIP Dirección IP a conectarse
	 * @param nPort Puerto a conectarse
	 * @return Clientes de Fábrica
	 */
	@GetMapping("/WebService")
	public Object getApi(@RequestParam String nIP, @RequestParam String nPort) {
		String url = "http://"+nIP+":"+nPort+"/api/cliente";
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	/**
	 * Web service para obtener clientes de fábrica
	 * @param nIP Dirección IP a conectarse
	 * @param nPort Puerto a conectarse
	 * @return Clientes de Fábrica
	 */
	@GetMapping("/WebService2")
	public Iterable<Object> getApi2(@RequestParam String nIP, @RequestParam String nPort) {
		String url = "http://"+nIP+":"+nPort+"/api/cliente";
		Object[] forObject = restTemplate.getForObject(url, Object[].class);
		System.out.println("Result: "+ forObject);
		return Arrays.asList(forObject);
	}
	
	
	/**
	 * Web Service de envío de un pedido a fábrica
	 * @param nIdPedidoVentas
	 * @param nIdInventarioVentas
	 * @param nCliente
	 * @param nIdInventario
	 * @param nCantidad
	 * @return
	 */
	@PostMapping("/WebServicePost")
	public Object createPedidos(//@RequestParam String nfecha,
			@RequestParam int nIdPedidoVentas,
			@RequestParam int nIdInventarioVentas,
			@RequestParam String nCliente,
			@RequestParam String nIdInventario,
			@RequestParam int nCantidad,
			@RequestParam String nIP,
			@RequestParam String nPort) {
		
	    String url = "http://"+nIP+":"+nPort+"4000/api/pedidos";

	    HttpHeaders headers;
	   // headers.setContentType(APPLICATION_JSON);
	   // headers.setAccept(Collections.singletonList(APPLICATION_JSON));

	    // create a post object
	    //Pedidos post = new Pedidos(nfecha, nCliente, nIdInventario, nCantidad, nEstado, nEntrega, nFechaEntrega);

	    // build the request
	    //HttpEntity<Pedidos> entity = new HttpEntity<>(post);
	    
	    HashMap<String,Object> post = new HashMap<>();
	    post.put("idPedidoVentas",nIdPedidoVentas);
	    post.put("idInventarioVentas",nIdInventarioVentas);
	    post.put("cliente", nCliente);
	    post.put("idInventario",nIdInventario);
	    post.put("cantidad", nCantidad);
	    //post.put("estado", nEstado);
	    post.put("fechaEntrega","");
	    

	    // send POST request
	    return restTemplate.postForObject(url, post, Object.class);
	}
	
	/**
	 * Web Service de autenticación desde ventas a fábrica como cliente
	 * @param nCliente Identificador del cliente
	 * @param nPassword Contraseña del cliente
	 * @param nIP Dirección IP a conectarse
	 * @param nPort Puerto a conectarse
	 * @return Aceptación o rechazo en la autenticación
	 */
	@PostMapping("/AutCliente")
	public Object autCliente(
			@RequestParam String nCliente,
			@RequestParam String nPassword,
			@RequestParam String nIP,
			@RequestParam String nPort) {
		
	    String url = "http://"+nIP+":"+nPort+"/api/cliente/login";

	    HttpHeaders headers;
	   // headers.setContentType(APPLICATION_JSON);
	   // headers.setAccept(Collections.singletonList(APPLICATION_JSON));

	    // create a post object
	    //Pedidos post = new Pedidos(nfecha, nCliente, nIdInventario, nCantidad, nEstado, nEntrega, nFechaEntrega);

	    // build the request
	    //HttpEntity<Pedidos> entity = new HttpEntity<>(post);
	    
	    HashMap<String,Object> post = new HashMap<>();
	    post.put("cliente", nCliente);
	    post.put("password",nPassword);
	    

	    // send POST request
	    Object loginObj = restTemplate.postForObject(url, post, Object.class);
	    return loginObj;
	}
	
	/**
	 * Web service para obtención del catálogo de dispositivos de una fábrica
	 * @return catálogo de fábrica
	 */
	@GetMapping("/CatalogoFabrica")
	public Iterable<Object> getElectronicos(@RequestParam String nIP,
			@RequestParam String nPort) {
		String url = "http://"+nIP+":"+nPort+"/api/electronico";
		Object[] forObject = restTemplate.getForObject(url, Object[].class);
		System.out.println("Result: "+ forObject);
		return Arrays.asList(forObject);
	}
	

	
	
	
	//Electronicos
	/**
	 * Web service para obtención del catálogo de dispositivos de una fábrica
	 * @return catálogo de fábrica
	 */
	@GetMapping("/Electronicos")
	public Object getElectronicos(@RequestParam String nIP) {
		String url = "http://"+nIP+":4000/api/electronico";
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	/**
	 * Web service de envío de ventas de dispositivos realizadas a fábrica correspondiente
	 * @param nSerie Identificador del dispositivo vendido
	 * @param nPrecioVenta Precio del dispositivo
	 * @return
	 */
	@PostMapping("/Reporteria")
	public Object createPedidos(@RequestParam String nSerie, @RequestParam String nPrecioVenta, @RequestParam String nIP,
			@RequestParam String nPort ) {
		
		HashMap<String,String> body = new HashMap<>();
		
		body.put("serie", nSerie);
		body.put("precioVenta", nPrecioVenta);
		
	    String url = "http://"+nIP+":"+nPort+"/api/reporteria";

	    return restTemplate.postForObject(url, body, Object.class);
	}
	

	/**
	 * Web Service de actualización de estado de un pedido en fábrica
	 * @param nIdPedido Identificador del pedido
	 * @param nCliente Identificador de la tienda que realizó el pedido
	 * @param nEstado Estado a enviar
	 * @param nResponsable Identificador del usuario que realizó el cambio
	 * @return Respuesta de la solicitud
	 */
	@PostMapping("/EstadoPedido")
	public Object estadoPedidos(@RequestParam String nIdPedido, @RequestParam String nCliente,@RequestParam String nEstado,@RequestParam String nResponsable, @RequestParam String nIP,
			@RequestParam String nPort) {
		
		HashMap<String,String> body = new HashMap<>();
		
		body.put("idPedidoVentas", nIdPedido);
		body.put("cliente", nCliente);
		body.put("estado", nEstado);
		body.put("responsable", nResponsable);
		
	    String url = "http://"+nIP+":"+nPort+"/api/pedidos/estado/";

	    return restTemplate.postForObject(url, body, Object.class);
	}
	
	/**
	 * Web Service para validación de la garantía de un dispoitivo 
	 * @param nIP Dirección IP a conectarse
	 * @param nSerie Identificador del dispositivo
	 * @return Respuesta de la solicitud
	 */
	@GetMapping("/ValidarGarantia")
	public Object validarGarantia(@RequestParam String nIP, @RequestParam String nSerie) {
		String url = "http://"+nIP+":4000/api/garantia/devolver/" + nSerie;
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	
	
}
