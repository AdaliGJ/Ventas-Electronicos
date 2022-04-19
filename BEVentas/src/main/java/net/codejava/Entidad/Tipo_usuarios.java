package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuarios")
public class Tipo_usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_usuario;
	
	@Column
	private String nombre;
	
	public Tipo_usuarios() {}

	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo_usuarios(int id_tipo_usuario, String nombre) {
		super();
		this.id_tipo_usuario = id_tipo_usuario;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tipo_usuarios [id_tipo_usuario=" + id_tipo_usuario + ", nombre=" + nombre + "]";
	}
	
	

}
