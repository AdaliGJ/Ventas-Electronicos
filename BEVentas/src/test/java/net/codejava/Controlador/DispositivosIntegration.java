package net.codejava.Controlador;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Tipo_clientes;
import net.codejava.Entidad.Tipo_dispositivo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DispositivosIntegration {
	
	@Autowired
	MockMvc mockMvc;

	
	
	@Test
	void dispositivosIntegracion() throws Exception {
		
    String tipo_dispositivo = "Electrodomestico";
		
			
			
			MvcResult resultPost = mockMvc.perform(MockMvcRequestBuilders.post("/Tipo_dispositivo/Insertar").param("nNombre", tipo_dispositivo)).andReturn();
			
			
			ObjectMapper mapper = new ObjectMapper();
			Tipo_dispositivo responsePost = mapper.readValue(resultPost.getResponse().getContentAsString(), Tipo_dispositivo.class);
			
			
			MvcResult resultGet = mockMvc.perform(MockMvcRequestBuilders.get("/Tipo_dispositivo/Obtener").param("nIdTipoDispositivo", String.valueOf(responsePost.getId_tipo_dispositivo()) )).andReturn();
			
			ObjectMapper mapperGet = new ObjectMapper();
			Tipo_dispositivo responseGet = mapperGet.readValue(resultGet.getResponse().getContentAsString(), Tipo_dispositivo.class);
			
			
			
			assertThat(tipo_dispositivo).isEqualTo(responseGet.getNombre());
			
			
			
		}
			
			
		
	

}
