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
	
	
	
	
	
	
	
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public int getTipocliente() {
		return tipocliente;
	}


	public VistaInfoCliente() {}


	public void setTipocliente(int tipocliente) {
		this.tipocliente = tipocliente;
	}
	public String getNombretipocliente() {
		return nombretipocliente;
	}
	public void setNombretipocliente(String nombretipocliente) {
		this.nombretipocliente = nombretipocliente;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

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
	
	@Override
	public String toString() {
		return "VistaInfoCliente [nit=" + nit + ", tipocliente=" + tipocliente + ", nombretipocliente="
				+ nombretipocliente + ", patente=" + patente + ", vencimiento=" + vencimiento + ", nombrecliente="
				+ nombrecliente + "]";
	}
	
	
	
	
	
	
}
