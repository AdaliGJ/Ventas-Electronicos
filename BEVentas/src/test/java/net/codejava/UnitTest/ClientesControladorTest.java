package net.codejava.UnitTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

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
	            .andExpect(jsonPath("$[1].nit", is(9639831)))
	            .andReturn();
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nNit", "1234567");
		params.add("nTipoCliente","2");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Clientes/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void obtener_success() throws Exception {
		
		Mockito.when(repositorioClientes.findById(RECORD_3.getNit())).thenReturn(Optional.of(RECORD_3));
		
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get("/Clientes/Obtener")
	            .param("nNit", Integer.toString(RECORD_3.getNit()))
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
	    
	    ObjectMapper mapperGet = new ObjectMapper();
		Clientes responseGet = mapperGet.readValue(mvcResult.getResponse().getContentAsString(), Clientes.class);
		
		assertThat(RECORD_3.getTipo_cliente()).isEqualTo(responseGet.getTipo_cliente());
	    
	    //System.out.println(mvcResult.getResponse().getContentAsString());
	    
	}
	
	
}
