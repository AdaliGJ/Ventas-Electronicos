package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla inventario definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
@Entity
@Table(name = "inventario")
public class Inventario {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_inventario")
	private int idInventario;
	@Column(name="categoria_dispositivo")
	private int categoriaDispositivo;
	@Column
	private int marca;
	@Column 
	private int existencias;
	@Column(name="precio_lista")
	private float precioLista;
	@Column
	private String color;
	@Column
	private String descripcion;
	@Column
	private String modelo;
	@Column (name="meses_garantia")
	private int mesesGarantia;
	
	public Inventario() {}

	/**
	 * Obtener id del objeto en el inventario
	 * @return id del objeto del inventario
	 */
	public int getIdInventario() {
		return idInventario;
	}
	/**
	 * Agregregar id del inventario
	 * @param idInventario
	 */
	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}
	/**
	 * Obtener categoria del dispositivo
	 * @return categoria del dispositivo
	 */
	public int getCategoriaDispositivo() {
		return categoriaDispositivo;
	}
	/**
	 * Agregar categoria del dispositivo
	 * @param categoriaDispositivo
	 */
	public void setCategoriaDispositivo(int categoriaDispositivo) {
		this.categoriaDispositivo = categoriaDispositivo;
	}
	/**
	 * Obtener marca del dispositivo
	 * @return marca del dispositivo
	 */
	public int getMarca() {
		return marca;
	}
	/**
	 * Agregar marca del dispositivo
	 * @param marca
	 */
	public void setMarca(int marca) {
		this.marca = marca;
	}
	/**
	 * Obtener ecistencias del dispositivo
	 * @return Existencias del dispositivo
	 */
	public int getExistencias() {
		return existencias;
	}
	/**
	 * Agregar existencias del dispositivo
	 * @param existencias
	 */
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
/**
 * Obtener precio 
 * @return Precio
 */
	public float getPrecioLista() {
		return precioLista;
	}
	/**
	 * Agregar precio
	 * @param precioLista
	 */
	public void setPrecioLista(float precioLista) {
		this.precioLista = precioLista;
	}
	/**
	 * Obtener color del dispositivo
	 * @return color del dispositivo
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Agregar color del dispositivo
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Obtener descripcion del dispositivo
	 * @return Descripcion del dispositivo
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Agregar descripcion del dispositivo
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtener modelo del dispositivo
	 * @return Modelo del dispositivo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Agregar modelo del dispositivo
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * Agregar modelo del dispositivo
	 * @return modelo del dispositivo
	 */
	public int getMesesGarantia() {
		return mesesGarantia;
	}
	/**
	 * Agregar Meses de garantia
	 * @param mesesGarantia
	 */
	public void setMesesGarantia(int mesesGarantia) {
		this.mesesGarantia = mesesGarantia;
	}

	/**
	 * Creacion de la clase Inventario
	 * @param idInventario
	 * @param categoriaDispositivo
	 * @param marca
	 * @param existencias
	 * @param precioLista
	 * @param color
	 * @param descripcion
	 * @param modelo
	 * @param mesesGarantia
	 */
	public Inventario(int idInventario, int categoriaDispositivo, int marca, int existencias, float precioLista,
			String color, String descripcion, String modelo, int mesesGarantia) {
		super();
		this.idInventario = idInventario;
		this.categoriaDispositivo = categoriaDispositivo;
		this.marca = marca;
		this.existencias = existencias;
		this.precioLista = precioLista;
		this.color = color;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.mesesGarantia = mesesGarantia;
	}

	/**
	 * Volver string objeto el objeto Inventario
	 */
	@Override
	public String toString() {
		return "Inventario [idInventario=" + idInventario + ", categoriaDispositivo=" + categoriaDispositivo
				+ ", marca=" + marca + ", existencias=" + existencias + ", precioLista=" + precioLista + ", color="
				+ color + ", descripcion=" + descripcion + ", modelo=" + modelo + ", mesesGarantia=" + mesesGarantia
				+ "]";
	}
	
	
	
}
