package net.codejava;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.ClientesControlador;
import net.codejava.Entidad.Clientes;
import net.codejava.Repositorio.RepositorioClientes;

@WebMvcTest(ClientesControlador.class)
public class ClientesControladorTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioClientes repositorioClientes;
	
	Clientes RECORD_1 = new Clientes(8434832,1);
	Clientes RECORD_2= new Clientes(9639831,2);
	Clientes RECORD_3= new Clientes(5678960,2);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
	    List<Clientes> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioClientes.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Clientes/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[1].nit", is(9639831)));
	}
	
	
}
