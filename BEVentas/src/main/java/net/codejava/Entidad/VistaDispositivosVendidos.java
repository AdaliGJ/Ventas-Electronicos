package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "dispositivosvendidos")
public class VistaDispositivosVendidos {
	
	@Id
	@Column
	private String serie;
	@Column 
	private String fecha;
	@Column 
	private int idpropietario;
	@Column
	private String nombrepropietario;
	@Column
	private int dispositivo;
	
	
	public VistaDispositivosVendidos() {}
	
	public String getSerie() {
		return serie;
	}
	public String getFecha() {
		return fecha;
	}
	public int getIdpropietario() {
		return idpropietario;
	}
	public String getNombrepropietario() {
		return nombrepropietario;
	}
	public int getDispositivo() {
		return dispositivo;
	}
	
	
	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdpropietario(int idpropietario) {
		this.idpropietario = idpropietario;
	}

	public void setNombrepropietario(String nombrepropietario) {
		this.nombrepropietario = nombrepropietario;
	}

	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	
	public VistaDispositivosVendidos(String serie, String fecha, int idpropietario, String nombrepropietario,
			int dispositivo) {
		super();
		this.serie = serie;
		this.fecha = fecha;
		this.idpropietario = idpropietario;
		this.nombrepropietario = nombrepropietario;
		this.dispositivo = dispositivo;
	}

	@Override
	public String toString() {
		return "VistaDispositivosVendidos [serie=" + serie + ", fecha=" + fecha + ", idpropietario=" + idpropietario
				+ ", nombrepropietario=" + nombrepropietario + ", dispositivo=" + dispositivo + "]";
	}
	
	

}
