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
	
	
	public Marcas() {}
	
	
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Marcas(int id_marca, String nombre) {
		super();
		this.id_marca = id_marca;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Marcas [id_marca=" + id_marca + ", nombre=" + nombre + "]";
	}
	
	

}
