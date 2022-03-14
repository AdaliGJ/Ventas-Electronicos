package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "Imgs")
public class VistaImgs {

	
	@Column
	private String tipodispositivo;
	@Column
	private String nombremarca;
	@Column
	private float preciolista;
	@Column
	private String modelo;
	@Id
	@Column
	private int idinventario;
	@Column
	private String descripcion;
	@Column 
	private String imagen;
	public String getTipodispositivo() {
		return tipodispositivo;
	}
	public String getNombremarca() {
		return nombremarca;
	}
	public float getPreciolista() {
		return preciolista;
	}
	public String getModelo() {
		return modelo;
	}
	public int getIdinventario() {
		return idinventario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	
	@Override
	public String toString() {
		return "VistaImgs [tipodispositivo=" + tipodispositivo + ", nombremarca=" + nombremarca + ", preciolista="
				+ preciolista + ", modelo=" + modelo + ", idinventario=" + idinventario + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + "]";
	}
	
	
	
	
}
