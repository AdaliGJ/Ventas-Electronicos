package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Repositorio.RepositorioPedidos;

@CrossOrigin
@RestController 
@RequestMapping(path="/Pedidos")
public class PedidosControlador {
	
	@Autowired
	private RepositorioPedidos repositorioPedidos;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostMapping("/Estado")
	@ResponseBody
	public void insertarP(@RequestParam String nEstado, @RequestParam String nFecha, @RequestParam int nId) {
	
		String Sql = "call actualizarestado(?, ?, ?)";
		jdbcTemplate.update(Sql, nId, nEstado, nFecha);
		
		
	}
	

}
