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

import net.codejava.Controlador.VideojuegosControlador;
import net.codejava.Controlador.VistaImgsControlador;
import net.codejava.Entidad.Videojuegos;
import net.codejava.Entidad.VistaImgs;
import net.codejava.Repositorio.RepositorioVideojuegos;
import net.codejava.Repositorio.RepositorioVistaImgs;

@WebMvcTest(VistaImgsControlador.class)
public class VistaImgsControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioVistaImgs repositorio;
	
	VistaImgs RECORD_1 = new VistaImgs("Televisor", "LG", 12,"ABV", 1,"Television 4k","TV.jpg");
	VistaImgs RECORD_2 = new VistaImgs("Smartwatch", "Apple", 12,"GRE", 1,"Alta duracion","Smartwatch.jpg");
	VistaImgs RECORD_3 = new VistaImgs("Videojuego", "Nintendo", 12,"X456", 1,"Juego Familiar","Videojuego.jpg");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<VistaImgs> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/VistaImgs/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[1].nombremarca", is("Apple")));
	}
}
