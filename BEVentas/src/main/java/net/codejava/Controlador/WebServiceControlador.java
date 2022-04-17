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
	
	@GetMapping("/WebService")
	public Object getApi(@RequestParam String nIP, @RequestParam String nPort) {
		String url = "http://"+nIP+":"+nPort+"/api/cliente";
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	@GetMapping("/WebService2")
	public Iterable<Object> getApi2(@RequestParam String nIP) {
		String url = "http://"+nIP+":4000/api/cliente";
		Object[] forObject = restTemplate.getForObject(url, Object[].class);
		System.out.println("Result: "+ forObject);
		return Arrays.asList(forObject);
	}
	
	@PostMapping("/WebServicePost")
	public Object createPedidos(//@RequestParam String nfecha,
			@RequestParam int nIdPedidoVentas,
			@RequestParam int nIdInventarioVentas,
			@RequestParam String nCliente,
			@RequestParam String nIdInventario,
			@RequestParam int nCantidad
			//@RequestParam String nEstado,
			/*@RequestParam String nFechaEntrega*/) {
		
	    String url = "http://localhost:4000/api/pedidos";

	    HttpHeaders headers;
	   // headers.setContentType(APPLICATION_JSON);
	   // headers.setAccept(Collections.singletonList(APPLICATION_JSON));

	    // create a post object
	    //Pedidos post = new Pedidos(nfecha, nCliente, nIdInventario, nCantidad, nEstado, nEntrega, nFechaEntrega);

	    // build the request
	    //HttpEntity<Pedidos> entity = new HttpEntity<>(post);
	    
	    HashMap<String,Object> post = new HashMap<>();
	    post.put("idPedidoVentas",nIdPedidoVentas);
	    post.put("idInventarioVentas",nIdPedidoVentas);
	    post.put("cliente", nCliente);
	    post.put("idInventario",nIdInventario);
	    post.put("cantidad", nCantidad);
	    //post.put("estado", nEstado);
	    post.put("fechaEntrega","");
	    

	    // send POST request
	    return restTemplate.postForObject(url, post, Object.class);
	}
	
	
	@PostMapping("/AutCliente")
	public Object autCliente(
			@RequestParam String nCliente,
			@RequestParam String nPassword,
			@RequestParam String nIP,
			@RequestParam String nPort) {
		
	    String url = "http://localhost:4000/api/cliente/login";

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
	
	@GetMapping("/CatalogoFabrica")
	public Iterable<Object> getElectronicos() {
		 String url = "http://localhost:4000/api/electronico";
		Object[] forObject = restTemplate.getForObject(url, Object[].class);
		System.out.println("Result: "+ forObject);
		return Arrays.asList(forObject);
	}
	

	
	
	
	//Electronicos
	@GetMapping("/Electronicos")
	public Object getElectronicos(@RequestParam String nIP) {
		String url = "http://"+nIP+":4000/api/electronico";
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	
	@PostMapping("/Reporteria")
	public Object createPedidos(@RequestParam String nSerie, @RequestParam String nPrecioVenta ) {
		
		HashMap<String,String> body = new HashMap<>();
		
		body.put("serie", nSerie);
		body.put("precioVenta", nPrecioVenta);
		
	    String url = "http://localhost:4000/api/reporteria";

	    return restTemplate.postForObject(url, body, Object.class);
	}
	
	@PostMapping("/EstadoPedido")
	public Object estadoPedidos(@RequestParam String nIdPedido,@RequestParam String nEstado) {
		
		HashMap<String,String> body = new HashMap<>();
		
		body.put("idPedidos", nIdPedido);
		body.put("estado", nEstado);
		
	    String url = "http://localhost:4000/api/pedidos/estado/";

	    return restTemplate.postForObject(url, body, Object.class);
	}
	
	
	@GetMapping("/ValidarGarantia")
	public Object validarGarantia(@RequestParam String nIP, @RequestParam String nSerie) {
		String url = "http://"+nIP+":4000/api/garantia/devolver/" + nSerie;
		Object forObject = restTemplate.getForObject(url, Object.class);
		System.out.println("Result: "+ forObject);
		return forObject;
		
	}
	
	
	
}
