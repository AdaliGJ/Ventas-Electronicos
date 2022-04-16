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

import net.codejava.Controlador.InventarioControlador;
import net.codejava.Entidad.Inventario;
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
	
	
}
