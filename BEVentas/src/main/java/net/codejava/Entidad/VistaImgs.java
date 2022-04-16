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
	
	
	public VistaImgs() {}
	

	public String getTipodispositivo() {
		return tipodispositivo;
	}
	public void setTipodispositivo(String tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
	}
	public String getNombremarca() {
		return nombremarca;
	}
	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
	public float getPreciolista() {
		return preciolista;
	}
	public void setPreciolista(float preciolista) {
		this.preciolista = preciolista;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public VistaImgs(String tipodispositivo, String nombremarca, float preciolista, String modelo, int idinventario,
			String descripcion, String imagen) {
		super();
		this.tipodispositivo = tipodispositivo;
		this.nombremarca = nombremarca;
		this.preciolista = preciolista;
		this.modelo = modelo;
		this.idinventario = idinventario;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}





	@Override
	public String toString() {
		return "VistaImgs [tipodispositivo=" + tipodispositivo + ", nombremarca=" + nombremarca + ", preciolista="
				+ preciolista + ", modelo=" + modelo + ", idinventario=" + idinventario + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + "]";
	}
	
	
	
	
}
