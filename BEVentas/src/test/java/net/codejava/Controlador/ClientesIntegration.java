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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientesIntegration {
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void clientesIntegracion() throws Exception {
		
		LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nNit", "1234567");
		params.add("nTipoCliente","2");
		
			//Prueba post
			MvcResult post = mockMvc.perform(MockMvcRequestBuilders.post("/Clientes/Insertar").params(params)).andReturn();
			
			
			ObjectMapper mapper = new ObjectMapper();
			Clientes responseP = mapper.readValue(post.getResponse().getContentAsString(), Clientes.class);
			
			//Prueba get
			MvcResult get = mockMvc.perform(MockMvcRequestBuilders.get("/Clientes/Obtener").param("nNit", String.valueOf(responseP.getNit()) )).andReturn();
			
			ObjectMapper mapper2 = new ObjectMapper();
			Clientes responseG = mapper2.readValue(get.getResponse().getContentAsString(), Clientes.class);
			
			
			//Resultados
			assertThat(2).isEqualTo(responseG.getTipo_cliente());
			assertThat(1234567).isEqualTo(responseG.getNit());
			
	
		
	}

}
