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
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_cliente;
	@Column
	private String nombre;
	@Column
	private int descuento;
	
	
	public Tipo_clientes() {}
	
	
	public int getId_tipo_cliente() {
		return id_tipo_cliente;
	}
	public void setId_tipo_cliente(int id_tipo_cliente) {
		this.id_tipo_cliente = id_tipo_cliente;
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
	public Tipo_clientes( int id_tipo_cliente ,String nombre, int descuento) {
		super();
		this.id_tipo_cliente = id_tipo_cliente;
		this.nombre = nombre;
		this.descuento = descuento;
	}
	@Override
	public String toString() {
		return "Tipo_clientes [id_tipo_cliente=" + id_tipo_cliente + ", nombre=" + nombre + ", descuento=" + descuento
				+ "]";
	}
	
	

}
