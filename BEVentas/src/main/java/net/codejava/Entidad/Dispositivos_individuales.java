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
	private String serie_dispositivo;
	@Column
	private int id_inventario;
	
	public Dispositivos_individuales() {}
	
	
	public String getSerie_dispositivo() {
		return serie_dispositivo;
	}
	public void setSerie_dispositivo(String serie_dispositivo) {
		this.serie_dispositivo = serie_dispositivo;
	}
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	public Dispositivos_individuales(String serie_dispositivo, int id_inventario) {
		super();
		this.serie_dispositivo = serie_dispositivo;
		this.id_inventario = id_inventario;
	}
	
	@Override
	public String toString() {
		return "Dispositivos_individuales [serie_dispositivo=" + serie_dispositivo + ", id_inventario=" + id_inventario
				+ "]";
	}
	
	

	
	

}
