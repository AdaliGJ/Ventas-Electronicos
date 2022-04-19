package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_entrada_factura;
	@Column
	private String id_factura;
	@Column
	private int id_venta;
	@Column
	private int nit_cliente;
	@Column 
	private float precio;
	
	public Factura() {}
	
	
	/**
	 * Metodo para obtener el ID de la entrada de la factura
	 * @return entrada de la factura
	 */ 
	public int getId_entrada_factura() {
		return id_entrada_factura;
	}
	
	/**
	 * Metodo para agregar el ID de la entrada de la factura
	 * @param id_entrada_factura 
	 */
	public void setId_entrada_factura(int id_entrada_factura) {
		this.id_entrada_factura = id_entrada_factura;
	}
	/**
	 * Metodo para obtenter el id de la factura
	 * @return id de la factura
	 */
	public String getId_factura() {
		return id_factura;
	}
	/**
	 * Metodo para agregar el id de la factura
	 * @param id_factura
	 */
	public void setId_factura(String id_factura) {
		this.id_factura = id_factura;
	}
	/**
	 * Metodo para obtener el ID de la venta
	 * @return Id de la venta
	 */
	public int getId_venta() {
		return id_venta;
	}
	/**
	 * Metodo para agregar el id de la venta
	 * @param id_venta
	 */
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	/**
	 * Metodo para obtener el nit del cliente
	 * @return nit del cliente
	 */
	public int getNit_cliente() {
		return nit_cliente;
	}
	/**
	 * Metodo para agregar el Nit del cliente
	 * @param nit_cliente
	 */
	public void setNit_cliente(int nit_cliente) {
		this.nit_cliente = nit_cliente;
	}
	/**
	 * Metodo para obtener el precio
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * Metodo para agregar el precio
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Constructor de la calase Factura
	 * @param id_entrada_factura
	 * @param id_factura
	 * @param id_venta
	 * @param nit_cliente
	 * @param precio
	 */
	public Factura(int id_entrada_factura, String id_factura, int id_venta, int nit_cliente, float precio) {
		super();
		this.id_entrada_factura = id_entrada_factura;
		this.id_factura = id_factura;
		this.id_venta = id_venta;
		this.nit_cliente = nit_cliente;
		this.precio = precio;
	}
	@Override
	/**
	 * Mètodo para volver string al objeto Factura
	 */
	public String toString() {
		return "Factura [id_entrada_factura=" + id_entrada_factura + ", id_factura=" + id_factura + ", id_venta="
				+ id_venta + ", nit_cliente=" + nit_cliente + ", precio=" + precio + "]";
	}
	
	
	
}
