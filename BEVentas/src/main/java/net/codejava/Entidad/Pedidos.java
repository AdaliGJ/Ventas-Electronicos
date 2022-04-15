package net.codejava.Entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpedido;
	@Column
	private String fecha;
	@Column
	private int idInventario;
	@Column
	private int cantidad;
	@Column
	private String estado;
	@Column
	private String fechaEntrega;

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
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

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Pedidos(int idpedido, String fecha, int idInventario, int cantidad, String estado, String fechaEntrega) {
		super();
		this.idpedido = idpedido;
		this.fecha = fecha;
		this.idInventario = idInventario;
		this.cantidad = cantidad;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "Pedidos [idpedido=" + idpedido + ", fecha=" + fecha + ", idInventario=" + idInventario + ", cantidad="
				+ cantidad + ", estado=" + estado + ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
