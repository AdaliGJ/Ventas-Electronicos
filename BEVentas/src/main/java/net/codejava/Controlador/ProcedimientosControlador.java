package net.codejava.Controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.Entidad.Ventas;

@CrossOrigin
@RestController
@RequestMapping(path="/Procedimiento")
public class ProcedimientosControlador {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Constructor de la clase ProcedimientosControlador
	 */
	public ProcedimientosControlador(){}
	
	/**
	 * Prueba de POST
	 * @param nIdInventario
	 * @param nDescripcion
	 */
	@PostMapping("/Prueba")
	@ResponseBody
	public void prueba(@RequestParam int nIdInventario, @RequestParam String nDescripcion) {
		String Sql = "call PruebaJava(?,?)";
		jdbcTemplate.update(Sql, nIdInventario, nDescripcion);
		
	}
	
	/**
	 * Administración de usuarios del sistema de ventas
	 * @param nId Identificador del usuario
	 * @param nAccion Acción a realizar (eliminar o cambiar permisos de usuario)
	 */
	@PostMapping("/CambioPermisos")
	@ResponseBody
	public void cambio(@RequestParam int nId, @RequestParam String nAccion) {
		String Sql = "call cambiopermisos(?, ?)";
		jdbcTemplate.update(Sql, nId, nAccion);
		
	}
	
	@PostMapping("/CambioFecha")
	@ResponseBody
	public void cambioF(@RequestParam int nId, @RequestParam int nAccion, @RequestParam String nFecha) {
		String Sql = "call clientesuscrito(?, ?, ?)";
		jdbcTemplate.update(Sql, nId, nAccion, nFecha);
		
	}
	
	@PostMapping("/Mapeo")
	@ResponseBody
	public void mapeo(@RequestParam String nId, @RequestParam int nMarca, @RequestParam int nCategoria) {
		String Sql = "insert into mapeotabla values (?, ?, ?)";
		jdbcTemplate.update(Sql, nCategoria, nId, nMarca);
		
	}
	
	
	
	/**
	 * Procedimiento almacenado para insertar electronicos en el catalogo ingresando los datos en todas las tablas necesarias
	 * @param nCategoriaDispositivo
	 * @param nMarca
	 * @param nExistencias
	 * @param nPrecioLista
	 * @param nColor
	 * @param nDescripcion
	 * @param nModelo
	 * @param nMesesGarantia
	 * @param nResolucion
	 * @param nBitsProfundidad
	 * @param nPulgadasPantalla
	 * @param nEntradasHDMI
	 * @param nSistemaOperativo
	 * @param nRamMB
	 * @param nMemoriaGB
	 * @param nMaxJugadores
	 * @param nGraficos
	 * @param nConsola
	 * @param nAccion
	 * @param nImg1
	 * @param nImg2
	 * @param nImg3
	 */ 
	
	@PostMapping("/Insertar")
	@ResponseBody
	public void insertarInv(@RequestParam int nCategoriaDispositivo,
			@RequestParam int nMarca, 
			@RequestParam int nExistencias,
			@RequestParam String nPrecioLista,
			@RequestParam String nColor,
			@RequestParam String nDescripcion,
			@RequestParam String nModelo,
			@RequestParam int nMesesGarantia,
			@RequestParam String nResolucion,
			@RequestParam int nBitsProfundidad,
			@RequestParam int nPulgadasPantalla,
			@RequestParam int nEntradasHDMI,
			@RequestParam String nSistemaOperativo,
			@RequestParam int nRamMB,
			@RequestParam int nMemoriaGB,
			@RequestParam int nMaxJugadores,
			@RequestParam String nGraficos,
			@RequestParam String nConsola,
			@RequestParam String nAccion,
			@RequestParam String nImg1,
			@RequestParam String nImg2,
			@RequestParam String nImg3
			) {
		String Sql = "call insertarinv(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(Sql, nCategoriaDispositivo, nMarca, nExistencias, nPrecioLista, nColor, nDescripcion, nModelo, nMesesGarantia,
				nResolucion, nBitsProfundidad, nPulgadasPantalla, nEntradasHDMI, nSistemaOperativo, nRamMB, nMemoriaGB, nMaxJugadores,
				nGraficos, nConsola, nAccion, nImg1, nImg2, nImg3);
		//jdbcTemplate.update(Sql, 4, 1, 0, "80.87", "rojo", "rojo", "1234", 45, "90", 1, 1, 1, "90", 1, 1, 1, "90", "90", "ins", "link", "link", "link" );
		
	}
	
	@GetMapping("/Credito")
	public @ResponseBody List<Map<String, Object>> getCant(){
		 String sql = "select deuda(id_cliente), id_cliente from ordenes_compra group by id_cliente having deuda(id_cliente)>0";
		
		 return jdbcTemplate.queryForList("select deuda(id_cliente) deuda, id_cliente from ordenes_compra group by id_cliente having deuda(id_cliente)>0");
	}
	
	
	@GetMapping("/GetMap")
	public @ResponseBody int getVenta(@RequestParam String nId){
		 String sql = "SELECT idinventario from mapeotabla where idfabrica = ? FETCH NEXT 1 ROWS ONLY";
		
		 return jdbcTemplate.queryForObject(
	                sql, new Object[]{nId}, int.class);
	}
	
	@GetMapping("/GetIP")
	public @ResponseBody String getIp(@RequestParam int nId){
		
		 String sql1 = "SELECT count(*) from mapeotabla where idinventario = ? FETCH NEXT 1 ROWS ONLY";
			
		 int count= jdbcTemplate.queryForObject(
	                sql1, new Object[]{nId}, int.class);
		 
		 if(count == 1) {
		
		 String sql = "SELECT ip from mapeotabla inner join marcas on marca = id_marca where idinventario = ? FETCH NEXT 1 ROWS ONLY";
		
		 return jdbcTemplate.queryForObject(
	                sql, new Object[]{nId}, String.class);
		 }else {
			 return "no";
		 }
	}
	
	
}


