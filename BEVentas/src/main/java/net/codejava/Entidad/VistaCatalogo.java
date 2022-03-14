package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "catalogo")
public class VistaCatalogo {

	
	@Column
	private int idtipodispositivo;
	@Column
	private String tipodispositivo;
	@Id
	@Column
	private int idinventario;
	@Column
	private int categoriadispositivo;
	@Column 
	private int marca;
	@Column
	private int existencias;
	@Column
	private float preciolista;
	@Column 
	private String color;
	@Column
	private String descripcion;
	@Column
	private String modelo;
	@Column 
	private int mesesgarantia;
	@Column
	private String nombremarca;
	
	
	public int getIdtipodispositivo() {
		return idtipodispositivo;
	}
	public String getTipodispositivo() {
		return tipodispositivo;
	}
	public int getIdinventario() {
		return idinventario;
	}
	public int getCategoriadispositivo() {
		return categoriadispositivo;
	}
	public int getMarca() {
		return marca;
	}
	public int getExistencias() {
		return existencias;
	}
	public float getPreciolista() {
		return preciolista;
	}
	public String getColor() {
		return color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getModelo() {
		return modelo;
	}
	public int getMesesgarantia() {
		return mesesgarantia;
	}
	public String getNombremarca() {
		return nombremarca;
	}
	@Override
	public String toString() {
		return "VistaCatalogo [idtipodispositivo=" + idtipodispositivo + ", tipodispositivo=" + tipodispositivo
				+ ", idinventario=" + idinventario + ", categoriadispositivo=" + categoriadispositivo + ", marca="
				+ marca + ", existencias=" + existencias + ", preciolista=" + preciolista + ", color=" + color
				+ ", descripcion=" + descripcion + ", modelo=" + modelo + ", mesesgarantia=" + mesesgarantia
				+ ", nombremarca=" + nombremarca + "]";
	}
	
	
	
	
	
	
}
