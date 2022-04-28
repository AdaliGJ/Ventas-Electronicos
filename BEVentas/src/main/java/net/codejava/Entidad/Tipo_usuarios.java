package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla tipo_usuarios definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Table(name = "tipo_usuarios")
public class Tipo_usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_usuario;
	
	@Column
	private String nombre;
	
	public Tipo_usuarios() {}
	
	/**
	 * Obtener id del tipo de usuario
	 * @return id del tipo de usuario
	 */
	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}
/**
 * Agregar id del tipo de usuario
 * @param id_tipo_usuario
 */
	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	/**
	 * Obtener nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Agregar nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Creacion de clase Tipo_usuario
	 * @param id_tipo_usuario
	 * @param nombre
	 */
	public Tipo_usuarios(int id_tipo_usuario, String nombre) {
		super();
		this.id_tipo_usuario = id_tipo_usuario;
		this.nombre = nombre;
	}
	
	/**
	 * Convertir a string el objeto Tipo_usuarios
	 */
	@Override
	public String toString() {
		return "Tipo_usuarios [id_tipo_usuario=" + id_tipo_usuario + ", nombre=" + nombre + "]";
	}
	
	

}
