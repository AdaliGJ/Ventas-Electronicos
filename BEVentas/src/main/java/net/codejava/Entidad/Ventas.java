package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_venta;
	@Column
	private int id_orden;
	@Column
	private String serie;
	@Column
	private boolean credito;
	@Column
	private String fecha;
	
	
	public Ventas() {}
	
	
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_orden() {
		return id_orden;
	}
	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public boolean isCredito() {
		return credito;
	}
	public void setCredito(boolean credito) {
		this.credito = credito;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Ventas(int id_venta, int id_orden, String serie, boolean credito, String fecha) {
		super();
		this.id_venta = id_venta;
		this.id_orden = id_orden;
		this.serie = serie;
		this.credito = credito;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Ventas [id_venta=" + id_venta + ", id_orden=" + id_orden + ", serie=" + serie + ", credito=" + credito
				+ ", fecha=" + fecha + "]";
	} 
	
	
	
}
