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
	private int id_cliente;
	@Column
	private boolean credito;
	@Column
	private String entrega_estimada;
	@Column
	private float precio;
	@Column
	private String fecha;
	
	
	public Ordenes_compra() {}
	
	
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public boolean isCredito() {
		return credito;
	}
	public void setCredito(boolean credito) {
		this.credito = credito;
	}
	public String getEntrega_estimada() {
		return entrega_estimada;
	}
	public void setEntrega_estimada(String entrega_estimada) {
		this.entrega_estimada = entrega_estimada;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Ordenes_compra(int id_orden, int id_cliente, boolean credito, String entrega_estimada, float precio,
			String fecha) {
		super();
		this.id_orden = id_orden;
		this.id_cliente = id_cliente;
		this.credito = credito;
		this.entrega_estimada = entrega_estimada;
		this.precio = precio;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Ordenes_compra [id_orden=" + id_orden + ", id_cliente=" + id_cliente + ", credito=" + credito
				+ ", entrega_estimada=" + entrega_estimada + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	
}