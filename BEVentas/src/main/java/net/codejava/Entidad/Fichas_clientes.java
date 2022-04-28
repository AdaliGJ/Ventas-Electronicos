package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla fichas_clientes definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Table(name = "fichas_clientes")
public class Fichas_clientes {
	
	@Id
	@Column
	private int nit;
	@Column
	private String nombre;
	@Column
	private String email;
	@Column
	private int telefono;
	@Column
	private String patente_de_comercio;
	@Column
	private String fecha_de_vencimiento;
	
	
	public Fichas_clientes() {}

	
	/**
	 * Metodo para obtener el nit del cliente
	 * @return nit
	 */
	public int getNit() {
		return nit;
	}

	/**
	 * Metodo para agregar el nit del cliente
	 * @param nit
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}

	/**
	 * Metodo para obtener el nombre del cliente
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para agregar el nombre del cliente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo para obtewner el correo del cliente
	 * @return correo 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo agregar el correo del cliente
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo para obtener el telefono del cliente
	 * @return
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Metodo para agregar el telefono del cliente
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo para obtener la patente de comercio
	 * @return Patente de comercio
	 */
	public String getPatente_de_comercio() {
		return patente_de_comercio;
	}

	/**
	 * Metodo para agregar la patnte de comercio
	 * @param patente_de_comercio
	 */
	public void setPatente_de_comercio(String patente_de_comercio) {
		this.patente_de_comercio = patente_de_comercio;
	}

	/**
	 * Metodo para obtener la fecha de vencimiento
	 * @return fecha de vencimiento 
	 */
	public String getFecha_de_vencimiento() {
		return fecha_de_vencimiento;
	}

	/**
	 * Metodo para agregar la fecha de vencimiento
	 * @param fecha_de_vencimiento
	 */
	public void setFecha_de_vencimiento(String fecha_de_vencimiento) {
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}

	/**
	 * Meoto para crear la clase Ficha_clientes
	 * @param nit
	 * @param nombre
	 * @param email
	 * @param telefono
	 * @param patente_de_comercio
	 * @param fecha_de_vencimiento
	 */
	public Fichas_clientes(int nit, String nombre, String email, int telefono, String patente_de_comercio,
			String fecha_de_vencimiento) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.patente_de_comercio = patente_de_comercio;
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}


	@Override
	/**
	 * Metodo para converti a string el objeto Fichas_clientes
	 */
	public String toString() {
		return "Fichas_clientes [nit=" + nit + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", patente_de_comercio=" + patente_de_comercio + ", fecha_de_vencimiento=" + fecha_de_vencimiento
				+ "]";
	}


	

}
