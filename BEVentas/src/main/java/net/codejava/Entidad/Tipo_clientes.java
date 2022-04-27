package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla tipo_clientes definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Table(name = "tipo_clientes")
public class Tipo_clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private int descuento;
	
	
	public Tipo_clientes() {}

	/**
	 * Obtener id del cliente
	 * @return id del cliente
	 */
	public int getId() {
		return id;
	}

	/**
	 * Agregar id del cliente
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtener nombre del cliente
	 * @return nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Agregar nombre del cliente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener descuento segun tipo de cliente
	 * @return descuento segun tipo de cliente
	 */
	public int getDescuento() {
		return descuento;
	}

	/**
	 * Agregar descuento segun tipo de cliente
	 * @param descuento
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	/**
	 * Creacion de clase Tipo_clientes
	 * @param id
	 * @param nombre
	 * @param descuento
	 */
	public Tipo_clientes(int id, String nombre, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
	}

	/**
	 * Convertir a string el objeto Tipo_cliente
	 */
	@Override
	public String toString() {
		return "Tipo_clientes [id=" + id + ", nombre=" + nombre + ", descuento=" + descuento + "]";
	}
	
	
	
	
	

}
