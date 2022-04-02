package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivos_individuales")
public class Dispositivos_individuales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serie_dispositivo")
	private String serie;
	@Column
	private int id_inventario;
	@Column
	private int vendido;
	
	public int getVendido() {
		return vendido;
	}


	public void setVendido(int vendido) {
		this.vendido = vendido;
	}


	public Dispositivos_individuales() {}
	
	
	public String getSerie_dispositivo() {
		return serie;
	}
	public void setSerie_dispositivo(String serie_dispositivo) {
		this.serie= serie_dispositivo;
	}
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	/*public Dispositivos_individuales(String serie, int id_inventario) {
		super();
		this.serie = serie;
		this.id_inventario = id_inventario;
	}*/
	
	public Dispositivos_individuales(String serie, int id_inventario, int vendido) {
		super();
		this.serie = serie;
		this.id_inventario = id_inventario;
		this.vendido = vendido;
	}


	@Override
	public String toString() {
		return "Dispositivos_individuales [serie=" + serie + ", id_inventario=" + id_inventario + ", vendido=" + vendido
				+ "]";
	}
	
	

	
	

}
