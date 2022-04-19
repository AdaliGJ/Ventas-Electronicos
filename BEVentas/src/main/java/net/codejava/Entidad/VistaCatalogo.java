package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "catalogo")
public class VistaCatalogo {

	
	@Column
	private int idtipodispositivo;
	@Column
	private String tipodispositivo;
	@Id
	@Column
	private int idinventario;
	@Column
	private int categoriadispositivo;
	@Column 
	private int marca;
	@Column
	private int existencias;
	@Column
	private float preciolista;
	@Column 
	private String color;
	@Column
	private String descripcion;
	@Column
	private String modelo;
	@Column 
	private int mesesgarantia;
	@Column
	private String nombremarca;
	
	public VistaCatalogo() {}
	
	
	/**
	 * Obtener id tipo de dispositivo
	 * @return id tipo de dispositivo
	 */
	public int getIdtipodispositivo() {
		return idtipodispositivo;
	}
	/**
	 * Obtener tipo de dispositivo
	 * @return tipo de dispositivo
	 */
	public String getTipodispositivo() {
		return tipodispositivo;
	}
	/**
	 * Obtener id del inventario
	 * @return id del inventario
	 */
	public int getIdinventario() {
		return idinventario;
	}
	/**
	 * Obtener categoria del dispositivo
	 * @return categoria del dispositivo
	 */
	public int getCategoriadispositivo() {
		return categoriadispositivo;
	}
	/**
	 * Obtener marca 
	 * @return marca
	 */
	public int getMarca() {
		return marca;
	}
	/**
	 * Obtener existencias
	 * @return existencias
	 */
	public int getExistencias() {
		return existencias;
	}
	/**
	 * Obtener Precio
	 * @return Precio
	 */
	public float getPreciolista() {
		return preciolista;
	}
	/**
	 * Obtener color
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Obtener color
	 * @return color
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Obtener Modelo
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Obtener numero de meses de la garantia
	 * @return numero de meses de la garantia
	 */
	public int getMesesgarantia() {
		return mesesgarantia;
	}
	/**
	 * Obtener nombre de la marca
	 * @return nombre de la marca
	 */
	public String getNombremarca() {
		return nombremarca;
	}
	
	/**
	 * Agregar id tipo de dispositivo  
	 * @param id 
	 */
	public void setIdtipodispositivo(int idtipodispositivo) {
		this.idtipodispositivo = idtipodispositivo;
	}

	/**
	 * Agregar tipo de dispositivo
	 * @param tipodispositivo
	 */
	public void setTipodispositivo(String tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
	}

	/**
	 * Agregar id inventario
	 * @param idinventario
	 */
	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}

	/**
	 * Agregar categoria de dispositivo
	 * @param categoriadispositivo
	 */
	public void setCategoriadispositivo(int categoriadispositivo) {
		this.categoriadispositivo = categoriadispositivo;
	}

	/**
	 * Agregar marca
	 * @param marca
	 */
	public void setMarca(int marca) {
		this.marca = marca;
	}

	/**
	 * Agregar existencias
	 * @param existencias
	 */
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	/**
	 * Agregar precio 
	 * @param preciolista
	 */
	public void setPreciolista(float preciolista) {
		this.preciolista = preciolista;
	}

	/**
	 * Agregar color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Agregar descipcion
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Agregar modelo
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Agregar meses de garantia
	 * @param mesesgarantia
	 */
	public void setMesesgarantia(int mesesgarantia) {
		this.mesesgarantia = mesesgarantia;
	}

	/**
	 * Agregar nombre de la marca
	 * @param nombremarca
	 */
	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}

	
	/**
	 *  Creacin de la clase VistaCatalogo
	 * @param idtipodispositivo
	 * @param tipodispositivo
	 * @param idinventario
	 * @param categoriadispositivo
	 * @param marca
	 * @param existencias
	 * @param preciolista
	 * @param color
	 * @param descripcion
	 * @param modelo
	 * @param mesesgarantia
	 * @param nombremarca
	 */
	public VistaCatalogo(int idtipodispositivo, String tipodispositivo, int idinventario, int categoriadispositivo,
			int marca, int existencias, float preciolista, String color, String descripcion, String modelo,
			int mesesgarantia, String nombremarca) {
		super();
		this.idtipodispositivo = idtipodispositivo;
		this.tipodispositivo = tipodispositivo;
		this.idinventario = idinventario;
		this.categoriadispositivo = categoriadispositivo;
		this.marca = marca;
		this.existencias = existencias;
		this.preciolista = preciolista;
		this.color = color;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.mesesgarantia = mesesgarantia;
		this.nombremarca = nombremarca;
	}

	/**
	 * Convertir en string la clase VistaCatalogo
	 */
	@Override
	public String toString() {
		return "VistaCatalogo [idtipodispositivo=" + idtipodispositivo + ", tipodispositivo=" + tipodispositivo
				+ ", idinventario=" + idinventario + ", categoriadispositivo=" + categoriadispositivo + ", marca="
				+ marca + ", existencias=" + existencias + ", preciolista=" + preciolista + ", color=" + color
				+ ", descripcion=" + descripcion + ", modelo=" + modelo + ", mesesgarantia=" + mesesgarantia
				+ ", nombremarca=" + nombremarca + "]";
	}
	
	
	
	
	
	
}
