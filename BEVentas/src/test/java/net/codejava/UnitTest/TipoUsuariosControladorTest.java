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

import net.codejava.Controlador.Tipo_usuarioControlador;
import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioTipo_usuarios;

@WebMvcTest(Tipo_usuarioControlador.class)
public class TipoUsuariosControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioTipo_usuarios repositorio;
	
	Tipo_usuarios RECORD_1 = new Tipo_usuarios(1,"Andres");
	Tipo_usuarios RECORD_2 = new Tipo_usuarios(3,"Amanda");
	Tipo_usuarios RECORD_3 = new Tipo_usuarios(2,"Ernesto");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		List<Tipo_usuarios> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Tipo_usuario/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[1].nombre", is("Amanda")));
	}
}
