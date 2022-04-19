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

	/**
	 * Obtener id del usuario
	 * @return
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Agregar id del usuario
	 * @param idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtener tipo de usuario
	 * @return tipo de usuario
	 */
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	
	/**
	 * Agregar tipo de usuario 
	 * @param tipo_usuario
	 */
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	/**
	 * Obtener contrasena
	 * @return contrasena
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Agregar contrasena
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtener nombre del usuario
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Agregar nombre del usuario
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Creacion de la clase usuario 
	 * @param idUsuario
	 * @param tipo_usuario
	 * @param password
	 * @param nombre
	 */
	public Usuarios(int idUsuario, int tipo_usuario, String password, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.tipo_usuario = tipo_usuario;
		this.password = password;
		this.nombre = nombre;
	}

	/**
	 * Convertir objeto Usuario a string
	 */
	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", tipo_usuario=" + tipo_usuario + ", password=" + password
				+ ", nombre=" + nombre + "]";
	}


	
	
	
	
	

}
