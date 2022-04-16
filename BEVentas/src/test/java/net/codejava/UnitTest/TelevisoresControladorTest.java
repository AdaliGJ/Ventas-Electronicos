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

import net.codejava.Controlador.TelevisoresControlador;
import net.codejava.Entidad.Televisores;
import net.codejava.Repositorio.RepositorioTelevisores;

@WebMvcTest(TelevisoresControlador.class)
public class TelevisoresControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioTelevisores repositorio;
	
	Televisores RECORD_1 = new Televisores(1,"4k",128,56,2);
	Televisores RECORD_2 = new Televisores(2,"2k",128,32,2);
	Televisores RECORD_3 = new Televisores(3,"8k",128,64,3);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<Televisores> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Televisores/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].resolucion", is("8k")));
	}
}
