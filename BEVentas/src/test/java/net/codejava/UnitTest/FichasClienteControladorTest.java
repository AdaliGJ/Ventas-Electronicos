package net.codejava.UnitTest;
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
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.ClientesControlador;
import net.codejava.Controlador.Fichas_clienteControlador;
import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Fichas_clientes;
import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioClientes;
import net.codejava.Repositorio.RepositorioFicha_clientes;

@WebMvcTest(Fichas_clienteControlador.class)
public class FichasClienteControladorTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioFicha_clientes repositorioFichas_cliente;
	
	Fichas_clientes RECORD_1 = new Fichas_clientes(9887675, "Adalí Garrán", "adaligaji@gmail.com", 44426699, "patente1.jpg", "08/12/2022");
	Fichas_clientes RECORD_2 = new Fichas_clientes(7876342, "Jorge Guerrero", "jorgeg@gmail.com", 78985678, "patente2.jpg", "09/11/2022");
	Fichas_clientes RECORD_3 = new Fichas_clientes(8833789, "Javier López", "javierl@gmail.com", 56783418, "patente3.jpg", "23/06/2022");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
	    List<Fichas_clientes> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioFichas_cliente.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Fichas_clientes/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].nit", is(9887675)))
	            .andExpect(jsonPath("$[1].nombre", is("Jorge Guerrero")))
	            .andExpect(jsonPath("$[2].fecha_de_vencimiento", is("23/06/2022")));
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nNit", "998622");
		params.add("nNombre","Juana Pérez");
		params.add("nEmail","kks@gmail.com");
		params.add("nTelefono","34567892");
		params.add("nPatenteDeComercio", "patente4.png");
		params.add("nFechaDeVencimiento", "22/09/2023");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Fichas_clientes/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void obtener_success() throws Exception {
		
		Mockito.when(repositorioFichas_cliente.findById(RECORD_2.getNit())).thenReturn(Optional.of(RECORD_2));
		
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get("/Fichas_clientes/Obtener")
	            .param("nNit", Integer.toString(RECORD_2.getNit()))
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
	    
	    ObjectMapper mapperGet = new ObjectMapper();
	    Fichas_clientes responseGet = mapperGet.readValue(mvcResult.getResponse().getContentAsString(), Fichas_clientes.class);
		
		assertThat(RECORD_2.getNombre()).isEqualTo(responseGet.getNombre());
	    
	    System.out.println(mvcResult.getResponse().getContentAsString());
	    
	}
	
	
}
