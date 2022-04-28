package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Esta clase es la encargada de realizar la ejecucion de la instancia de la aplicacion cargando toda la configuracion y las clases de los otros paquetes
 * Se cargan las configuraciones de Springboot, Tomcat, los drivers de Oracle, JUnit4/JUnit5, etc.
 *
 */
@SpringBootApplication
public class VentasApplication {

	/**
	 * Esta clase es la encargade de levantar la instancia de la aplicacion cargando todas las dependencias
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
	}

	/**
	 * Esta clase es una configuracion adicional la cual busca resolver el problema de Cross-Origin 
	 * @return Devuelve la configuracion establecida permitiendo los mapping, metodos, headers y origenes en los browsers
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("POST","GET").allowedHeaders("Access-Control-Allow-Headers",
	                    "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
			}
		};
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
