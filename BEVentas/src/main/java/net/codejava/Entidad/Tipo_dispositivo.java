package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_dispositivo")
public class Tipo_dispositivo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_dispositivo;
	@Column
	private String nombre;
	
	
	public int getId_tipo_dispositivo() {
		return id_tipo_dispositivo;
	}
	public void setId_tipo_dispositivo(int id_tipo_dispositivo) {
		this.id_tipo_dispositivo = id_tipo_dispositivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Tipo_dispositivo(int id_tipo_dispositivo, String nombre) {
		super();
		this.id_tipo_dispositivo = id_tipo_dispositivo;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Tipo_dispositivo [id_tipo_dispositivo=" + id_tipo_dispositivo + ", nombre=" + nombre + "]";
	}
	
	
	
	
	

}
