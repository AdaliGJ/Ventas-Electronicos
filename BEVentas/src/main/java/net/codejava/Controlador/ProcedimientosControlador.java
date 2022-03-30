package net.codejava.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/Procedimiento")
public class ProcedimientosControlador {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostMapping("/Prueba")
	@ResponseBody
	public void prueba(@RequestParam int nIdInventario, @RequestParam String nDescripcion) {
		String Sql = "call PruebaJava(?,?)";
		jdbcTemplate.update(Sql, nIdInventario, nDescripcion);
		
	}
	
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
	
}
