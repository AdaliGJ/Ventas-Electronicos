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

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Entidad.Tipo_dispositivo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Tipo_dispositivoTest {


	@Autowired
	MockMvc mockMvc;
	
	@Test
	void prueba() throws Exception {
		
		String dispositivos[] = {"Televisor","Videojuego","Smartwatch","Computadora","Monitor","Celular","Equipo de Sonido"};
		
		for(int i = 0; i < dispositivos.length ;i++) {
			
			int suma = i + 1;
			String id = String.valueOf(suma);
			
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Tipo_dispositivo/Obtener").param("nIdTipoDispositivo", id)).andReturn();
			
			ObjectMapper mapper = new ObjectMapper();
			Tipo_dispositivo response = mapper.readValue(result.getResponse().getContentAsString(), Tipo_dispositivo.class);
			
			System.out.println();
			System.out.println("El tipo de dispositivo obtenido fue el Dispositivo: " + response.getNombre());
			System.out.println();
			
			String obtenido = response.getNombre();
			String expected = dispositivos[i];
			
			assertThat(obtenido).isEqualTo(expected);
			
		}
		
	}
	
}
