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

import net.codejava.Controlador.VistaDispositivosVendidosControlador;
import net.codejava.Entidad.VistaDispositivosVendidos;
import net.codejava.Repositorio.RepositorioVistaDispositivosVendidos;

@WebMvcTest(VistaDispositivosVendidosControlador.class)
public class VistaDispositivosVendidosTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioVistaDispositivosVendidos repositorio;
	
	VistaDispositivosVendidos RECORD_1 = new VistaDispositivosVendidos("XHDBZ", "15/02/2022", 1, "Jaime Ruiz", 2);
	VistaDispositivosVendidos RECORD_2 = new VistaDispositivosVendidos("KJ73D", "18/03/2021", 2, "Amelia Perez", 4);
	VistaDispositivosVendidos RECORD_3 = new VistaDispositivosVendidos("5ETYS", "11/04/2022", 3, "Jorge Lopez", 3);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<VistaDispositivosVendidos> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/VistaDispositivosVendidos/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].serie", is("XHDBZ")));
	}
}
