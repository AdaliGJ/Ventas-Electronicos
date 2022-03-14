package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes_dispositivos")
public class Imagenes_dispositivos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_imagen;
	@Column
	private int id_inventario;
	@Column
	private String imagen;
	
	public Imagenes_dispositivos() {}

	
	public int getId_imagen() {
		return id_imagen;
	}

	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Imagenes_dispositivos(int id_imagen, int id_inventario, String imagen) {
		super();
		this.id_imagen = id_imagen;
		this.id_inventario = id_inventario;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Imagenes_dispositivos [id_imagen=" + id_imagen + ", id_inventario=" + id_inventario + ", imagen="
				+ imagen + "]";
	}
	
	
	
	
	
	

}
