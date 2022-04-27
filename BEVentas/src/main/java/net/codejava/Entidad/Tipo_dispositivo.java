package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla tipo_dispositivo definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Table(name = "tipo_dispositivo")
public class Tipo_dispositivo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_dispositivo;
	@Column
	private String nombre;
	
	
	public Tipo_dispositivo() {} 
	
	
	/**
	 * Obtener id del tipo de dispositivo
	 * @return  id del tipo del dispositivo
	 */
	public int getId_tipo_dispositivo() {
		return id_tipo_dispositivo;
	}
	/**
	 * Agregar tipo de dispositivo
	 * @param id_tipo_dispositivo
	 */
	public void setId_tipo_dispositivo(int id_tipo_dispositivo) {
		this.id_tipo_dispositivo = id_tipo_dispositivo;
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
	 * Creacion de clase Tipo_dispositivo
	 * @param id_tipo_dispositivo
	 * @param nombre
	 */
	public Tipo_dispositivo(int id_tipo_dispositivo, String nombre) {
		super();
		this.id_tipo_dispositivo = id_tipo_dispositivo;
		this.nombre = nombre;
	}
	@Override
	/**
	 * Convertir a stgring la clase Tipo_dispositivo
	 */
	public String toString() {
		return "Tipo_dispositivo [id_tipo_dispositivo=" + id_tipo_dispositivo + ", nombre=" + nombre + "]";
	}
	
	
	
	
	

}
