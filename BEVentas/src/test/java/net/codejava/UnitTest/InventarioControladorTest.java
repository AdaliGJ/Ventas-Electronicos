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

import net.codejava.Controlador.InventarioControlador;
import net.codejava.Entidad.Inventario;
import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioInventario;

@WebMvcTest(InventarioControlador.class)
public class InventarioControladorTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioInventario repositorioInventario;
	
	Inventario RECORD_1 = new Inventario(1, 2, 3, 100, 10/6, "rojo", "descripcion1", "xer3a",24);
	Inventario RECORD_2 = new Inventario(2, 8, 1, 45, 89/3, "verde", "descripcion2", "igr2b",36);
	Inventario RECORD_3 = new Inventario(3, 1, 6, 78, 50, "negro", "descripcion3", "89juy",12);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
	    List<Inventario> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioInventario.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Inventario/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].categoriaDispositivo", is(2)))
	            .andExpect(jsonPath("$[1].modelo", is("igr2b")))
	            .andExpect(jsonPath("$[2].mesesGarantia", is(12)));
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();		
		params.add("nCategoriaDispositivo", "6");
		params.add("nMarca", "3");
		params.add("nExistencias", "43");
		params.add("nPrecioLista", "595.59");
		params.add("nColor", "amarillo");
		params.add("nDescripcion", "Dispositivo Amarillo");
		params.add("nModelo", "shd32d");
		params.add("nMesesGarantia", "48");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Inventario/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	@Test
	public void obtener_success() throws Exception {
		
		Mockito.when(repositorioInventario.findById(RECORD_3.getIdInventario())).thenReturn(Optional.of(RECORD_3));
		
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get("/Inventario/Obtener")
	            .param("nId", Integer.toString(RECORD_3.getIdInventario()))
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
	    
	    ObjectMapper mapperGet = new ObjectMapper();
		Inventario responseGet = mapperGet.readValue(mvcResult.getResponse().getContentAsString(), Inventario.class);
		
		assertThat(RECORD_3.getColor()).isEqualTo(responseGet.getColor());
	    
	    //System.out.println(mvcResult.getResponse().getContentAsString());
	    
	}
	
	@Test
	public void obtenerCategoria_success() throws Exception {
	    List<Inventario> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioInventario.findAllByCategoriaDispositivo(1)).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Inventario/ObtenerCategoria")
	            .param("nCategoriaDispositivo", "1")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].categoriaDispositivo", is(1)));
	}
	
	@Test
	public void obtenerMenor_success() throws Exception {
	    List<Inventario> records2 = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioInventario.findByOrderByCategoriaDispositivoDesc()).thenReturn(records2);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Inventario/ObtenerCategoriaMenor")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].categoriaDispositivo", is(1)));
	}
	
	
	
}
