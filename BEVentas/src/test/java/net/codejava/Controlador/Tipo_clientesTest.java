package net.codejava.Controlador;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Entidad.Tipo_clientes;
import net.codejava.Repositorio.RepositorioTipo_clientes;


//@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
@AutoConfigureMockMvc
public class Tipo_clientesTest {

	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void prueba() throws Exception {
		
		String clientes[] = {"Individual","Grande","Mayorista"};
		
		System.out.println(clientes[0]);
		
		for(int i = 0; i < clientes.length ;i++) {
			
			int suma = i + 1;
			String id = String.valueOf(suma);
			
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Tipo_clientes/Obtener").param("nIdTipoCliente", id)).andReturn();
			
			//System.out.println(result.getResponse().getContentAsString());
			//assertThat(result.getResponse().getContentAsString()).isEqualTo("{\"id\":1,\"nombre\":\"Individual\",\"descuento\":0}");
			
			ObjectMapper mapper = new ObjectMapper();
			Tipo_clientes response = mapper.readValue(result.getResponse().getContentAsString(), Tipo_clientes.class);
			
			System.out.println();
			System.out.println("El tipo de cliente obtenido fue el Cliente: " + response.getNombre());
			System.out.println();
			
			String obtenido = response.getNombre();
			String expected = clientes[i];
			
			assertThat(obtenido).isEqualTo(expected);
		}
		
		
		
		
		
		
		
		//System.out.println("123");
		
		/*
		Tipo_clientesControlador controlador = new Tipo_clientesControlador();
		Optional<Tipo_clientes> resultadoOptional = controlador.getOneTest(1);
		Tipo_clientes resultadoEntidad = resultadoOptional.get();
		String resultadoString = resultadoEntidad.getNombre();
		assertThat(resultadoString).isEqualTo("Individual");
		*/
	}
}
