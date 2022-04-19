package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordenes_compra")
public class Ordenes_compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_orden;
	@Column
	private int nit;
	@Column
	private boolean credito;
	@Column
	private String entrega_estimada;
	@Column
	private float precio;
	@Column
	private String fecha;
	
	
	public Ordenes_compra() {}

	
	/**
	 * Obtener id de la orden
	 * @return id de la orden
	 */
	public int getId_orden() {
		return id_orden;
	}

	/**
	 * Agregar id de la orden
	 * @param id_orden
	 */
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}

	/**
	 * Obtener nit
	 * @return nit
	 */
	public int getNit() {
		return nit;
	}

	/**
	 * Agregar Nit
	 * @param nit
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}

	
	public boolean isCredito() {
		return credito;
	}

	/**
	 * Agregar credito
	 * @param credito
	 */
	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	/**
	 * Obtener tiempo de entrega estimado 
	 * @return tiempo de entrga estimado
	 */
	public String getEntrega_estimada() {
		return entrega_estimada;
	}

	/**
	 * Agregar tiempo de entrega estimada
	 * @param entrega_estimada
	 */
	public void setEntrega_estimada(String entrega_estimada) {
		this.entrega_estimada = entrega_estimada;
	}

	/**
	 * Obtener precio
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Agregar precio
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtener fecha
	 * @return fecha
 	 */ 
	public String getFecha() {
		return fecha;
	}

	/**
	 * Agregar fecha 
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Crecion de clase Ordenes_compra
	 * @param id_orden
	 * @param nit
	 * @param credito
	 * @param entrega_estimada
	 * @param precio
	 * @param fecha
	 */
	public Ordenes_compra(int id_orden, int nit, boolean credito, String entrega_estimada, float precio, String fecha) {
		super();
		this.id_orden = id_orden;
		this.nit = nit;
		this.credito = credito;
		this.entrega_estimada = entrega_estimada;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	/**
	 * Convertir objeto Ordenes_compra en string
	 */
	@Override
	public String toString() {
		return "Ordenes_compra [id_orden=" + id_orden + ", nit=" + nit + ", credito=" + credito + ", entrega_estimada="
				+ entrega_estimada + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	
	
	
}
