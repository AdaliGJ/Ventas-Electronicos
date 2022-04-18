package net.codejava.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import net.codejava.Entidad.Dispositivos_individuales;
import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Pedidos;
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
	
	@GetMapping("/ObtenerId")
	public @ResponseBody int getId(){
		 String sql = "SELECT max(idpedido) FROM pedidos";
		
		 return jdbcTemplate.queryForObject(
	                sql, new Object[]{}, int.class);
	}
	
	@PostMapping("/Insertar")
	@ResponseBody 
	public void insertar(@RequestParam int nidpedido, @RequestParam String nfecha, @RequestParam int nidInventario, @RequestParam int ncantidad, @RequestParam String nestado, @RequestParam String nfechaEntrega) {
		
		String Sql = "call insertpedido(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(Sql, nidpedido, nfecha, nidInventario, ncantidad, nestado, nfechaEntrega);
	}
	
	@GetMapping("/ObtenerRegistrados")
	public @ResponseBody Iterable<Pedidos> getAllE(@RequestParam String nEstado){
		
		String s1 = "SELECT * FROM pedidos where estado = '" + nEstado+"'";
		
		String sql =s1;
		
		Iterable<Pedidos> pedidos = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pedidos.class));
		return pedidos;
	}
	
	
	

	
	
	

}
