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
//GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;
	@Column
	private int tipo_usuario;
	@Column
	private String password;
	@Column 
	private String nombre;
	
	
	public Usuarios() {}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getTipo_usuario() {
		return tipo_usuario;
	}


	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Usuarios(int idUsuario, int tipo_usuario, String password, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.tipo_usuario = tipo_usuario;
		this.password = password;
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", tipo_usuario=" + tipo_usuario + ", password=" + password
				+ ", nombre=" + nombre + "]";
	}


	
	
	
	
	

}
