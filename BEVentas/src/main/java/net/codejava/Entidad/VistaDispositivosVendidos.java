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
	
	/**
	 * Obtener Numero de serie 
	 * @return numero de serie
	 */
	public String getSerie() {
		return serie;
	}
	/**
	 * Obtener fecha
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Obtener id del propietario
	 * @return id del propietario
	 */
	public int getIdpropietario() {
		return idpropietario;
	}
	/**
	 * Obtener nombre del propietario 
	 * @return nombre del propietario
	 */
	public String getNombrepropietario() {
		return nombrepropietario;
	}
	/**
	 * Obener dispositivo
	 * @return dispositivo
	 */
	public int getDispositivo() {
		return dispositivo;
	}
	
	/**
	 * Agregar numero de serie
	 * @param serie
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	/**
	 * Agregar fecha
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Agregar id propietario 
	 * @param idpropietario
	 */
	public void setIdpropietario(int idpropietario) {
		this.idpropietario = idpropietario;
	}
	
	/**
	 * Agregar nombre propietario
	 * @param nombrepropietario
	 */
	public void setNombrepropietario(String nombrepropietario) {
		this.nombrepropietario = nombrepropietario;
	}
	/**
	 * Agregar dispositivo
	 * @param dispositivo
	 */
	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	/**
	 * Creacion clase VistaDispositivosVendidos
	 * @param serie
	 * @param fecha
	 * @param idpropietario
	 * @param nombrepropietario
	 * @param dispositivo
	 */
	public VistaDispositivosVendidos(String serie, String fecha, int idpropietario, String nombrepropietario,
			int dispositivo) {
		super();
		this.serie = serie;
		this.fecha = fecha;
		this.idpropietario = idpropietario;
		this.nombrepropietario = nombrepropietario;
		this.dispositivo = dispositivo;
	}
	
	/**
	 * Convertir a string el objeto VistaDispositivosVendidos
	 */
	@Override
	public String toString() {
		return "VistaDispositivosVendidos [serie=" + serie + ", fecha=" + fecha + ", idpropietario=" + idpropietario
				+ ", nombrepropietario=" + nombrepropietario + ", dispositivo=" + dispositivo + "]";
	}
	
	

}
