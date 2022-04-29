package net.codejava.Controlador;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@CrossOrigin
@RestController
@RequestMapping(path="/Email")
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
	private JdbcTemplate jdbcTemplate;

    @PostMapping("/Insertar")
    public void sendSimpleMessage() {
    	
    	List<Map<String, Object>> emails = jdbcTemplate.queryForList("select ord.*, f.email from (select deuda(id_cliente) deuda, id_cliente from ordenes_compra group by id_cliente having deuda(id_cliente)>0) ord inner join fichas_clientes f on f.nit = ord.id_cliente");
       
    	for(int i = 0; i < emails.size(); i++) {
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("sistema@ventas.com");
	        message.setTo(emails.get(i).get("email").toString()); 
	        message.setSubject("Crédito en Ventas"); 
	        message.setText("Buenas tardes, Queríamos informarle que su crédito en la venta de electrónicos (como cliente mayorista) hasta esta fecha es de Q"+emails.get(i).get("deuda").toString()+". Muchas Gracias");
	        emailSender.send(message);
    	 }
        
    }
}
