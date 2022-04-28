package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

/**
 * Esta clase replica la estructura de la vista Imgs definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Immutable
@Table(name = "Imgs")
public class VistaImgs {

	
	@Column
	private String tipodispositivo;
	@Column
	private String nombremarca;
	@Column
	private float preciolista;
	@Column
	private String modelo;
	@Id
	@Column
	private int idinventario;
	@Column
	private String descripcion;
	@Column 
	private String imagen;
	
	
	public VistaImgs() {}
	
	
	/**
	 * Obtener tipo de dispositivo
	 * @return tipo de dispositivo
	 */
	public String getTipodispositivo() {
		return tipodispositivo;
	}
	/**
	 * Agregar tipo de dispositivo
	 * @param tipodispositivo
	 */
	public void setTipodispositivo(String tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
	}
	/**
	 * Obtener Nombre de la marca
	 * @return nombre de la marca
	 */
	public String getNombremarca() {
		return nombremarca;
	}
	/**
	 * Agregar nombre de la marca
	 * @param nombremarca
	 */
	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	/**
	 * Obtener Precio
	 * @return Precio
	 */
	public float getPreciolista() {
		return preciolista;
	}
	/**
	 * Agregar precio
	 * @param preciolista
	 */
	public void setPreciolista(float preciolista) {
		this.preciolista = preciolista;
	}
	/**
	 * Obtener modelo
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Agregar modelo
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * Obtener id inventario 
	 * @return
	 */
	public int getIdinventario() {
		return idinventario;
	}
	/**
	 * Agregar id inventario
	 * @param idinventario
	 */
	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}
	/**
	 * Obtener Descripcion
	 * @return descripcion 
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Agregar descripcion
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtener imagen
	 * @return
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * Agregar imagen
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Creacion de la clase VistaImgs
	 * @param tipodispositivo
	 * @param nombremarca
	 * @param preciolista
	 * @param modelo
	 * @param idinventario
	 * @param descripcion
	 * @param imagen
	 */
	public VistaImgs(String tipodispositivo, String nombremarca, float preciolista, String modelo, int idinventario,
			String descripcion, String imagen) {
		super();
		this.tipodispositivo = tipodispositivo;
		this.nombremarca = nombremarca;
		this.preciolista = preciolista;
		this.modelo = modelo;
		this.idinventario = idinventario;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}




	/**
	 * Convertir a string el objeto VistaImgs
	 */
	@Override
	public String toString() {
		return "VistaImgs [tipodispositivo=" + tipodispositivo + ", nombremarca=" + nombremarca + ", preciolista="
				+ preciolista + ", modelo=" + modelo + ", idinventario=" + idinventario + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + "]";
	}
	
	
	
	
}
