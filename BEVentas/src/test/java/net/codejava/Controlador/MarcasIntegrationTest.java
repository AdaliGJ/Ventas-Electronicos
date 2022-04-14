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

import net.codejava.Entidad.Marcas;
import net.codejava.Entidad.Tipo_clientes;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarcasIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void pruebaIntegracion() throws Exception {
		
		String marcas[] = {"Asus","Acer","HP"};
		
		for(int i = 0; i < marcas.length ;i++) {
			
			int suma = i + 1;
			String id = String.valueOf(suma);
			
			MvcResult resultPost = mockMvc.perform(MockMvcRequestBuilders.post("/Marca/Insertar").param("nNombre", marcas[i])).andReturn();
			
			
			ObjectMapper mapper = new ObjectMapper();
			Marcas responsePost = mapper.readValue(resultPost.getResponse().getContentAsString(), Marcas.class);
			
			
			MvcResult resultGet = mockMvc.perform(MockMvcRequestBuilders.get("/Marca/Obtener").param("nIdMarca", String.valueOf(responsePost.getId_marca()) )).andReturn();
			
			ObjectMapper mapperGet = new ObjectMapper();
			Marcas responseGet = mapperGet.readValue(resultGet.getResponse().getContentAsString(), Marcas.class);
			
			
			
			assertThat(marcas[i]).isEqualTo(responseGet.getNombre());
			
			System.out.println();
			System.out.println("La marca insertada fue " + responseGet.getNombre() + " con el idMarca " + responseGet.getId_marca());
			System.out.println();
			
			
		}
		
	}
}
