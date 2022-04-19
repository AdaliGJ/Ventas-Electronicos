package net.codejava.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.VideojuegosControlador;
import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Videojuegos;
import net.codejava.Repositorio.RepositorioVideojuegos;

@WebMvcTest(VideojuegosControlador.class)
public class VideojuegosControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioVideojuegos repositorio;
	
	Videojuegos RECORD_1 = new Videojuegos(1,1,"1440p","PlayStation");
	Videojuegos RECORD_2 = new Videojuegos(2,4,"720p","Nintendo");
	Videojuegos RECORD_3 = new Videojuegos(3,2,"1080p","Xbox");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<Videojuegos> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Videojuegos/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].consola", is("Xbox")));
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nIdInventario", "123");
		params.add("nMaxJugadores","2");
		params.add("nGraficos","4k");
		params.add("nConsola","Ninetendo");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Videojuegos/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void obtener_success() throws Exception {
	   
		Videojuegos record = new Videojuegos(3,2,"1080p","Xbox");
	    
		Mockito.when(repositorio.findById(3)).thenReturn(Optional.of(record));
		
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get("/Videojuegos/Obtener")
	            .param("nIdInventario", "3")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
	    
	    ObjectMapper mapperGet = new ObjectMapper();
		Videojuegos responseGet = mapperGet.readValue(mvcResult.getResponse().getContentAsString(), Videojuegos.class);
		
		assertThat(record.getConsola()).isEqualTo(responseGet.getConsola());
	    
	    //System.out.println(mvcResult.getResponse().getContentAsString());
	    
	}
	
}
