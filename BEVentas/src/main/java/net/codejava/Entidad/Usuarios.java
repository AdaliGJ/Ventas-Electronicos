package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@Column
	private int tipo_usuario;
	@Column
	private String contraseña;
	@Column 
	private String nombre;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuarios(int id_usuario, int tipo_usuario, String contraseña, String nombre) {
		super();
		this.id_usuario = id_usuario;
		this.tipo_usuario = tipo_usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + id_usuario + ", tipo_usuario=" + tipo_usuario + ", contraseña=" + contraseña
				+ ", nombre=" + nombre + "]";
	}
	

}
