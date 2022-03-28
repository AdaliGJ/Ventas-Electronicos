package net.codejava.Controlador;

import java.util.List;

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

import net.codejava.Entidad.Dispositivos_individuales;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Dispositivos_individualesTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void prueba() throws Exception {
		
		LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nIdInventario", "1");
		params.add("nCantidad","2");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/Dispositivos_individuales/Registrar").params(params)).andReturn();
		//System.out.println(result.getResponse().getContentAsString());
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		Dispositivos_individuales[] response = mapper.readValue(result.getResponse().getContentAsString(), Dispositivos_individuales[].class);
		//Dispositivos_individuales response = mapper.reader().forType(Dispositivos_individuales.class).readValue(result.getResponse().getContentAsString());
		
		
		//System.out.println(response[1].getId_inventario());
		
		for(int i = 0; i < response.length; i++) {
			
			System.out.println();
			System.out.println("Se ingreso un dispositivo con el numero de serie " + response[i].getSerie_dispositivo() + " para el producto con el id " + response[i].getId_inventario());
			System.out.println();
			
			
		}
		
	}

}
