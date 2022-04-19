package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Table(name = "infocliente")
public class VistaInfoCliente {

	
	@Id
	@Column
	private int nit;
	@Column 
	private int tipocliente;
	@Column 
	private String nombretipocliente;
	@Column
	private String patente;
	@Column
	private String vencimiento;
	@Column
	private String nombrecliente;
	
	
	
	
	
	
	/**
	 * Obtener nit
	 * @return nit
	 */
	public int getNit() {
		return nit;
	}
	/**
	 * Agregar nit
	 * @param nit
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}
	/**
	 * Obtener tipo de cliente
	 * @return tipo de cliente
	 */
	public int getTipocliente() {
		return tipocliente;
	}


	public VistaInfoCliente() {}

	
	
	/**
	 * Agregar tipo de cliente
	 * @param tipocliente
	 */
	public void setTipocliente(int tipocliente) {
		this.tipocliente = tipocliente;
	}
	/**
	 * Obtener tipo de cliente
	 * @return tipo de cliente 
	 */
	public String getNombretipocliente() {
		return nombretipocliente;
	}
	/**
	 * Agregar nombre de tipo de cliente
	 * @param nombretipocliente
	 */
	public void setNombretipocliente(String nombretipocliente) {
		this.nombretipocliente = nombretipocliente;
	}
	/**
	 * Obtener patente
	 * @return patente
	 */
	public String getPatente() {
		return patente;
	}
	/**
	 * Agregar patente
	 * @param patente
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}
	/**
	 * Obtener fecha de vencimiento
	 * @return fecha de vencimiento
	 */
	public String getVencimiento() {
		return vencimiento;
	}
	/**
	 * Agregar fecha de vencimiento
	 * @param vencimiento
	 */
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	/**
	 * Obtener nombre del cliente
	 * @return nombre del cliente
	 */
	public String getNombrecliente() {
		return nombrecliente;
	}
	/**
	 * Agregar nombre del cliente
	 * @param nombrecliente
	 */
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	
	/**
	 * Creacion de clase VistaInfoCliente
	 * @param nit
	 * @param tipocliente
	 * @param nombretipocliente
	 * @param patente
	 * @param vencimiento
	 * @param nombrecliente
	 */
	public VistaInfoCliente(int nit, int tipocliente, String nombretipocliente, String patente, String vencimiento,
			String nombrecliente) {
		super();
		this.nit = nit;
		this.tipocliente = tipocliente;
		this.nombretipocliente = nombretipocliente;
		this.patente = patente;
		this.vencimiento = vencimiento;
		this.nombrecliente = nombrecliente;
	}
	
	/**
	 * Convertir en string objeto VistaInfoCliente
	 */
	@Override
	public String toString() {
		return "VistaInfoCliente [nit=" + nit + ", tipocliente=" + tipocliente + ", nombretipocliente="
				+ nombretipocliente + ", patente=" + patente + ", vencimiento=" + vencimiento + ", nombrecliente="
				+ nombrecliente + "]";
	}
	
	
	
	
	
	
}
