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

import net.codejava.Controlador.PruebaControlador;
import net.codejava.Entidad.Prueba;
import net.codejava.Repositorio.RepositorioPrueba;

@WebMvcTest(PruebaControlador.class)
public class PruebaControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioPrueba repositorio;
	
	Prueba RECORD_1 = new Prueba(1,16,"159487");
	Prueba RECORD_2 = new Prueba(2,45,"asdfg");
	Prueba RECORD_3 = new Prueba(3,28,"ABC123");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<Prueba> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].valor1", is(16)));
	}
}
