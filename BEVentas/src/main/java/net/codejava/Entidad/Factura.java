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
	
	
	public int getId_entrada_factura() {
		return id_entrada_factura;
	}
	public void setId_entrada_factura(int id_entrada_factura) {
		this.id_entrada_factura = id_entrada_factura;
	}
	public String getId_factura() {
		return id_factura;
	}
	public void setId_factura(String id_factura) {
		this.id_factura = id_factura;
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getNit_cliente() {
		return nit_cliente;
	}
	public void setNit_cliente(int nit_cliente) {
		this.nit_cliente = nit_cliente;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Factura(int id_entrada_factura, String id_factura, int id_venta, int nit_cliente, float precio) {
		super();
		this.id_entrada_factura = id_entrada_factura;
		this.id_factura = id_factura;
		this.id_venta = id_venta;
		this.nit_cliente = nit_cliente;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Factura [id_entrada_factura=" + id_entrada_factura + ", id_factura=" + id_factura + ", id_venta="
				+ id_venta + ", nit_cliente=" + nit_cliente + ", precio=" + precio + "]";
	}
	
	
	
}
