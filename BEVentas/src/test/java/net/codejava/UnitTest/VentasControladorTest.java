package net.codejava.UnitTest;

import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.VentasControlador;
import net.codejava.Entidad.Ventas;
import net.codejava.Repositorio.RepositorioVentas;
/*
@WebMvcTest(VentasControlador.class)
public class VentasControladorTest {
	
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioVentas repositorio;
	
	Ventas RECORD_1 = new Ventas(1,4,"123456789",false,"2000-01-01");
	Ventas RECORD_2 = new Ventas(2,2,"987654321",true,"2001-01-01");
	Ventas RECORD_3 = new Ventas(3,3,"147258369",false,"2002-01-01");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		List<Ventas> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Ventas/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].serie", is("12345678")));
	}
}*/
