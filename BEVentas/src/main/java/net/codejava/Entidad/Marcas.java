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
	
	
	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


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
	
	public Marcas(int id_marca, String nombre, String ip) {
		super();
		this.id_marca = id_marca;
		this.nombre = nombre;
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "Marcas [id_marca=" + id_marca + ", nombre=" + nombre + ", ip=" + ip + "]";
	}
	
	

}
