package net.codejava.Controlador;


import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.Collections;
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
	public Object getApi(@RequestParam String nIP) {
		String url = "http://"+nIP+":4000/api/cliente";
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
	public Pedidos createPedidos(@RequestParam String nfecha,
			@RequestParam String nCliente,
			@RequestParam String nIdInventario,
			@RequestParam int nCantidad,
			@RequestParam String nEstado,
			@RequestParam int nEntrega,
			@RequestParam String nFechaEntrega) {
		
	    String url = "http://localhost:4000/api/pedidos";

	    HttpHeaders headers;
	   // headers.setContentType(APPLICATION_JSON);
	   // headers.setAccept(Collections.singletonList(APPLICATION_JSON));

	    // create a post object
	    Pedidos post = new Pedidos(nfecha, nCliente, nIdInventario, nCantidad, nEstado, nEntrega, nFechaEntrega);

	    // build the request
	    //HttpEntity<Pedidos> entity = new HttpEntity<>(post);

	    // send POST request
	    return restTemplate.postForObject(url, post, Pedidos.class);
	}
	
}
