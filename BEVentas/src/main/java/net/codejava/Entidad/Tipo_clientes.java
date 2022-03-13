package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public Tipo_clientes(int id, String nombre, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
	}


	@Override
	public String toString() {
		return "Tipo_clientes [id=" + id + ", nombre=" + nombre + ", descuento=" + descuento + "]";
	}
	
	
	
	
	

}
