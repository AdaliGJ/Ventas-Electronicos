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

import net.codejava.Controlador.SmartwatchControlador;
import net.codejava.Entidad.Smartwatch;
import net.codejava.Repositorio.RepositorioSmartwatch;

@WebMvcTest(SmartwatchControlador.class)
public class SmartwatchControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioSmartwatch repositorio;
	
	Smartwatch RECORD_1 = new Smartwatch(1,1,"Android",2048,16);
	Smartwatch RECORD_2 = new Smartwatch(2,2,"Android",2048,16);
	Smartwatch RECORD_3 = new Smartwatch(3,3,"Apple",4096,32);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<Smartwatch> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Smartwatch/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].ram_MB", is(4096)));
	}
}
