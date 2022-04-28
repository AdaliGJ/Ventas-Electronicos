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

/**
 * La siguiente clase es el controlador que conforma todos los metodos que iteractuan con la tabla Pedidos en Oracle
 * Por medio de la entidad y el repositorio correspondiente podemos interactuar con la base de datos a traves de servicios RESTfull
 * Por lo que las respuestas otorgadas seran en un formato compatible siendo mayormente Json's
 *
 */
@CrossOrigin
@RestController 
@RequestMapping(path="/Pedidos")
public class PedidosControlador {
	
	@Autowired
	private RepositorioPedidos repositorioPedidos;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Actualizar el Estado de un pedido
	 * @param nEstado Nuevo Estado a utilizar
	 * @param nFecha Fecha De la actualización
	 * @param nId Identificador del pedido
	 */
	@PostMapping("/Estado")
	@ResponseBody
	public void insertarP(@RequestParam String nEstado, @RequestParam String nFecha, @RequestParam int nId) {
	
		String Sql = "call actualizarestado(?, ?, ?)";
		jdbcTemplate.update(Sql, nId, nEstado, nFecha);
		
		
	}
	
	/**
	 * Obtener el ID del último pedido registrado en el sistema de ventas
	 * @return ID del pedido
	 */
	@GetMapping("/ObtenerId")
	public @ResponseBody int getId(){
		 String sql = "SELECT max(idpedido) FROM pedidos";
		
		 return jdbcTemplate.queryForObject(
	                sql, new Object[]{}, int.class);
	}
	
	/**
	 * Creación de un nuevo pedido por medio de un procedimiento almacenado
	 * @param nidpedido Identificador del nuevo pedido
	 * @param nfecha Fecha de realización del pedido
	 * @param nidInventario Tipo de producto a encargar
	 * @param ncantidad Cantidad de dispositivos en el pedido
	 * @param nestado Estado del pedido
	 * @param nfechaEntrega Entrega estimada del pedido
	 */
	@PostMapping("/Insertar")
	@ResponseBody 
	public void insertar(@RequestParam int nidpedido, @RequestParam String nfecha, @RequestParam int nidInventario, @RequestParam int ncantidad, @RequestParam String nestado, @RequestParam String nfechaEntrega) {
		
		String Sql = "call insertpedido(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(Sql, nidpedido, nfecha, nidInventario, ncantidad, nestado, nfechaEntrega);
	}
	
	/**
	 * Obtener los pedidos hechos a fábrica de acuerdo con su estado
	 * @param nEstado Estado por el que se desea filtrar
	 * @return Array de pedidos
	 */
	@GetMapping("/ObtenerRegistrados")
	public @ResponseBody Iterable<Pedidos> getAllE(@RequestParam String nEstado){
		
		String s1 = "SELECT * FROM pedidos where estado = '" + nEstado+"'";
		
		String sql =s1;
		
		Iterable<Pedidos> pedidos = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pedidos.class));
		return pedidos;
	}
	
	
	

	
	
	

}
