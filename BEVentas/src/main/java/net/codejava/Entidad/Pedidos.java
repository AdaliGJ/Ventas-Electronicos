package net.codejava.Entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos{
	@Id
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
	
	/**
	 * Obtener id del los pedidos
	 * @return id de los pedidos
	 */
	public int getIdpedido() {
		return idpedido;
	}
	/**
	 * Agregar id del pedido
	 * @param idpedido
	 */
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
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
	 * Obtener id inventario
	 * @return id inventario
	 */
	public int getIdInventario() {
		return idInventario;
	}
	/**
	 * Agregar id inventario
	 * @param idInventario
	 */
	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}
	/**
	 * Obtener cantidad de pedidos
	 * @return
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * Agregar cantidad de pedidos
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Obtener estado
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Agregar estado 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Obtener fecha de entrega
	 * @return fecha de entrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * Agregar fecha de entrega
	 * @param fechaEntrega
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * Creacio de clase Pedidos
	 * @param idpedido
	 * @param fecha
	 * @param idInventario
	 * @param cantidad
	 * @param estado
	 * @param fechaEntrega
	 */
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
	/**
	 * Convertir a string objeto Pedidos
	 */
	public String toString() {
		return "Pedidos [idpedido=" + idpedido + ", fecha=" + fecha + ", idInventario=" + idInventario + ", cantidad="
				+ cantidad + ", estado=" + estado + ", fechaEntrega=" + fechaEntrega + "]";
	}

	public Pedidos() {}
	
	
	
	
	
	
	
	
	
	
}
