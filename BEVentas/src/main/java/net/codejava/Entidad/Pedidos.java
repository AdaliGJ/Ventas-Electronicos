package net.codejava.Entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

public class Pedidos implements Serializable {
	private String fecha;
	
	private String cliente;
	
	private String idInventario;
	
	private int cantidad;
	
	private String estado;
	
	private int entrega;
	
	private String fechaEntrega;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(String idInventario) {
		this.idInventario = idInventario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEntrega() {
		return entrega;
	}
	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public Pedidos() {}
	
	public Pedidos(String fecha, String cliente, String idInventario, int cantidad, String estado, int entrega,
			String fechaEntrega) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.idInventario = idInventario;
		this.cantidad = cantidad;
		this.estado = estado;
		this.entrega = entrega;
		this.fechaEntrega = fechaEntrega;
	}
	
	@Override
	public String toString() {
		return "Pedidos [fecha=" + fecha + ", cliente=" + cliente + ", idInventario=" + idInventario + ", cantidad="
				+ cantidad + ", estado=" + estado + ", entrega=" + entrega + ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
	
}
