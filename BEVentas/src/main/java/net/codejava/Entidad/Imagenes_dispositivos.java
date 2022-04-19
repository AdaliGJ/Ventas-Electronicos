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
	@Column(name="id_inventario")
	private int idInventario;
	@Column
	private String imagen;
	
	public Imagenes_dispositivos() {}

	/**
	 * Metodo para obtener el Id de la imagen
	 * @return id de la imagen
	 */
	public int getId_imagen() {
		return id_imagen;
	}
	/**
	 * Metodo para agregar el id de la imagen
	 * @param id_imagen
	 */
	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}
	/**
	 * Metodo para obtener el id del inventario 
	 * @return id del inventario
	 */
	public int getId_inventario() {
		return idInventario;
	}
	/**
	 * Meoto para agregar el id del inventaro
	 * @param id_inventario
	 */
	public void setId_inventario(int id_inventario) {
		this.idInventario = id_inventario;
	}
	/**
	 * Metodo para obtener imagen
	 * @return imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Metodo para agregar imagen
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * Metodo para crear la clase Imagenes_dispositivos
	 * @param id_imagen
	 * @param id_inventario
	 * @param imagen
	 */
	public Imagenes_dispositivos(int id_imagen, int id_inventario, String imagen) {
		super();
		this.id_imagen = id_imagen;
		this.idInventario = id_inventario;
		this.imagen = imagen;
	}

	@Override
	/**
	 * Metodo para convertir en string la clase Imagenes_dispositivos
	 */
	public String toString() {
		return "Imagenes_dispositivos [id_imagen=" + id_imagen + ", id_inventario=" + idInventario + ", imagen="
				+ imagen + "]";
	}
	
	
	
	
	
	

}
