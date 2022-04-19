package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marcas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_marca;
	@Column
	private String nombre;
	@Column
	private String ip;
	
	
	public Marcas() {}
	
	/**
	 * Obtener ip 
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Agregar ip 
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * Obtener id de la marca
	 * @return id de la marca
	 */
	public int getId_marca() {
		return id_marca;
	}
	/**
	 * Agregar id de la marca
	 * @param id_marca
	 */
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	
	/**
	 * Obtener nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Creacion de la clase Marcas
	 * @param id_marca
	 * @param nombre
	 */
	public Marcas(int id_marca, String nombre) {
		super();
		this.id_marca = id_marca;
		this.nombre = nombre;
	}
	
	public Marcas(int id_marca, String nombre, String ip) {
		super();
		this.id_marca = id_marca;
		this.nombre = nombre;
		this.ip = ip;
	}

	/**
	 * Convertir en string el objeto Marcas
	 */
	@Override
	public String toString() {
		return "Marcas [id_marca=" + id_marca + ", nombre=" + nombre + ", ip=" + ip + "]";
	}
	
	

}
