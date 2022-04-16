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

import net.codejava.Controlador.UsuariosControlador;
import net.codejava.Entidad.Usuarios;
import net.codejava.Entidad.Videojuegos;
import net.codejava.Repositorio.RepositorioUsuarios;

@WebMvcTest(UsuariosControlador.class)
public class UsuariosControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioUsuarios repositorio;
	
	Usuarios RECORD_1 = new Usuarios(1,1,"1234","Juan");
	Usuarios RECORD_2 = new Usuarios(2,2,"ABC","Pedro");
	Usuarios RECORD_3 = new Usuarios(3,3,"1234ABC","Sara");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		List<Usuarios> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Usuarios/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[2].nombre", is("Sara")));
	}
}
