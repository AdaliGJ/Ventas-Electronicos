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

import net.codejava.Controlador.VistaInfoClienteControlador;
import net.codejava.Entidad.VistaInfoCliente;
import net.codejava.Repositorio.RepositorioVistaInfoCliente;

@WebMvcTest(VistaInfoClienteControlador.class)
public class VistaInfoClienteControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioVistaInfoCliente repositorio;
	
	VistaInfoCliente RECORD_1 = new VistaInfoCliente(1,1,"Cliente Individual","Patente1.jpg","2023-01-01","Arturo");
	VistaInfoCliente RECORD_2 = new VistaInfoCliente(2,3,"Gran Cliente","Patente2.jpg","2023-01-01","Pedro");
	VistaInfoCliente RECORD_3 = new VistaInfoCliente(3,2,"Distribuidora Mayorista","Patente3.jpg","2023-01-01","Amelia");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<VistaInfoCliente> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/VistaInfoCliente/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].nombretipocliente", is("Cliente Individual")));
	}
}
