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
	
}
