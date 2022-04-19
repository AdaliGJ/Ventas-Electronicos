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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.Tipo_dispositivoControlador;
import net.codejava.Entidad.Tipo_dispositivo;
import net.codejava.Entidad.Tipo_usuarios;
import net.codejava.Repositorio.RepositorioTipo_dispositivo;

@WebMvcTest(Tipo_dispositivoControlador.class)
public class TipoDispositivoControladorTest {
	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioTipo_dispositivo repositorio;
	
	Tipo_dispositivo RECORD_1 = new Tipo_dispositivo(1,"Televisor");
	Tipo_dispositivo RECORD_2 = new Tipo_dispositivo(1,"SmartWatch");
	Tipo_dispositivo RECORD_3 = new Tipo_dispositivo(1,"Videojuego");
	
	@Test
	public void obtenerRegistros_success() throws Exception {
		
		List<Tipo_dispositivo> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorio.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Tipo_dispositivo/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].nombre", is("Televisor")));
	}
	
	@Test
	public void obtener_success() throws Exception {
		
		Mockito.when(repositorio.findById(RECORD_3.getId_tipo_dispositivo())).thenReturn(Optional.of(RECORD_3));
		
	    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	            .get("/Tipo_dispositivo/Obtener")
	            .param("nIdTipoDispositivo", Integer.toString(RECORD_3.getId_tipo_dispositivo()))
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andReturn();
	    
	    ObjectMapper mapperGet = new ObjectMapper();
		Tipo_dispositivo responseGet = mapperGet.readValue(mvcResult.getResponse().getContentAsString(), Tipo_dispositivo.class);
		
		assertThat(RECORD_3.getNombre()).isEqualTo(responseGet.getNombre());
	    
	    //System.out.println(mvcResult.getResponse().getContentAsString());
	    
	}
}
