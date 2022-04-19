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

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.Ordenes_compraControlador;
import net.codejava.Entidad.Ordenes_compra;
import net.codejava.Repositorio.RepositorioOrdenes_compra;

@WebMvcTest(Ordenes_compraControlador.class)
public class OrdenesCompraControladorTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioOrdenes_compra repositorioOrdenes_compra;
	
	Ordenes_compra RECORD_1 = new Ordenes_compra(1, 8434832, false, "23 días", 78, "22/09/2022");
	Ordenes_compra RECORD_2= new Ordenes_compra(2, 9087453, true, "3 días", 756/8, "22/09/2022");
	Ordenes_compra RECORD_3= new Ordenes_compra(3, 7654329, false, "7 días", 97, "22/09/2022");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
	    List<Ordenes_compra> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioOrdenes_compra.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Ordenes_compra/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].credito", is(false)))
	            .andExpect(jsonPath("$[1].nit", is(9087453)))
	            .andExpect(jsonPath("$[2].fecha", is("22/09/2022")));
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();		
		params.add("nNit", "8765453");
		params.add("nCredito", "false");
		params.add("nEntregaEstimada", "56 días");
		params.add("nPrecio", "789.0");
		params.add("nFecha", "22/09/2022");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Ordenes_compra/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void obtener_success() throws Exception {
	    List<Ordenes_compra> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioOrdenes_compra.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Ordenes_compra/Obtener")
	            .param("nIdOrden", "1")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
}
