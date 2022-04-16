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
	
	public VistaCatalogo() {}
	
	
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
	
	
	public void setIdtipodispositivo(int idtipodispositivo) {
		this.idtipodispositivo = idtipodispositivo;
	}


	public void setTipodispositivo(String tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
	}


	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}


	public void setCategoriadispositivo(int categoriadispositivo) {
		this.categoriadispositivo = categoriadispositivo;
	}


	public void setMarca(int marca) {
		this.marca = marca;
	}


	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}


	public void setPreciolista(float preciolista) {
		this.preciolista = preciolista;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public void setMesesgarantia(int mesesgarantia) {
		this.mesesgarantia = mesesgarantia;
	}


	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}

	

	public VistaCatalogo(int idtipodispositivo, String tipodispositivo, int idinventario, int categoriadispositivo,
			int marca, int existencias, float preciolista, String color, String descripcion, String modelo,
			int mesesgarantia, String nombremarca) {
		super();
		this.idtipodispositivo = idtipodispositivo;
		this.tipodispositivo = tipodispositivo;
		this.idinventario = idinventario;
		this.categoriadispositivo = categoriadispositivo;
		this.marca = marca;
		this.existencias = existencias;
		this.preciolista = preciolista;
		this.color = color;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.mesesgarantia = mesesgarantia;
		this.nombremarca = nombremarca;
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
