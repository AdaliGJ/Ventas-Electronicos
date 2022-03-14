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
	private int idcliente;
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
	@Column
	private int nit;
	
	
	
	public int getIdcliente() {
		return idcliente;
	}
	public int getTipocliente() {
		return tipocliente;
	}
	public String getNombretipocliente() {
		return nombretipocliente;
	}
	public String getPatente() {
		return patente;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public int getNit() {
		return nit;
	}
	
	
	@Override
	public String toString() {
		return "VistaInfoCliente [idcliente=" + idcliente + ", tipocliente=" + tipocliente + ", nombretipocliente="
				+ nombretipocliente + ", patente=" + patente + ", vencimiento=" + vencimiento + ", nombrecliente="
				+ nombrecliente + ", nit=" + nit + "]";
	}
	
	
	
	
	
}
