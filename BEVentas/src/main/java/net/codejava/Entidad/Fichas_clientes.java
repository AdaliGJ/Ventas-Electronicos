package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fichas_clientes")
public class Fichas_clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	@Column
	private String nombre;
	@Column
	private int nit;
	@Column
	private String email;
	@Column
	private int telefono;
	@Column
	private int patente_de_comercio;
	@Column
	private String fecha_de_vencimiento;
	
	
	public Fichas_clientes() {}
	
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getPatente_de_comercio() {
		return patente_de_comercio;
	}
	public void setPatente_de_comercio(int patente_de_comercio) {
		this.patente_de_comercio = patente_de_comercio;
	}
	public String getFecha_de_vencimiento() {
		return fecha_de_vencimiento;
	}
	public void setFecha_de_vencimiento(String fecha_de_vencimiento) {
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}
	public Fichas_clientes(int id_cliente, String nombre, int nit, String email, int telefono, int patente_de_comercio,
			String fecha_de_vencimiento) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.nit = nit;
		this.email = email;
		this.telefono = telefono;
		this.patente_de_comercio = patente_de_comercio;
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}
	@Override
	public String toString() {
		return "Fichas_clientes [id_cliente=" + id_cliente + ", nombre=" + nombre + ", nit=" + nit + ", email=" + email
				+ ", telefono=" + telefono + ", patente_de_comercio=" + patente_de_comercio + ", fecha_de_vencimiento="
				+ fecha_de_vencimiento + "]";
	}
	
	

}
