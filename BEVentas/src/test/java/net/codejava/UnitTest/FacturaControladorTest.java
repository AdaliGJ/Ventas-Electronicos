package net.codejava.UnitTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.codejava.Controlador.ClientesControlador;
import net.codejava.Controlador.Factura_controlador;
import net.codejava.Entidad.Clientes;
import net.codejava.Entidad.Factura;
import net.codejava.Repositorio.RepositorioClientes;
import net.codejava.Repositorio.RepositorioFactura;

@WebMvcTest(Factura_controlador.class)
public class FacturaControladorTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    RepositorioFactura repositorioFactura;
	
	Factura RECORD_1 = new Factura(1, "256fr3", 32, 6789652, 10/6);
	Factura RECORD_2 = new Factura(2, "834hju", 6, 8434832, 10);
	Factura RECORD_3 = new Factura(3, "09l9ju", 67, 9030033, 5/2);
	
	@Test
	public void obtenerRegistros_success() throws Exception {
	    List<Factura> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    
	    
	    Mockito.when(repositorioFactura.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/Factura/ObtenerTodos")
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].id_entrada_factura", is(1)))
	            .andExpect(jsonPath("$[1].precio", is(10.0)))
	            .andExpect(jsonPath("$[2].nit_cliente", is(9030033)));
	}
	
	@Test
	public void insertarRegistro() throws Exception {
	    
	    LinkedMultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("nIdFactura", "57fwd");
		params.add("nIdVenta","2");
		params.add("nNitCliente","9030033");
		params.add("nPrecio","22");
		
		
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .post("/Factura/Insertar")
	            .params(params)
	            .contentType(APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
	
	
}
