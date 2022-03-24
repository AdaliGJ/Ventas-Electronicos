package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class Clientes {

	@Id
	@Column
	private int nit;
	@Column
	private int tipo_cliente;
	
	
	
	public Clientes() {}



	public int getNit() {
		return nit;
	}



	public void setNit(int nit) {
		this.nit = nit;
	}



	public int getTipo_cliente() {
		return tipo_cliente;
	}



	public void setTipo_cliente(int tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}



	public Clientes(int nit, int tipo_cliente) {
		super();
		this.nit = nit;
		this.tipo_cliente = tipo_cliente;
	}



	@Override
	public String toString() {
		return "Clientes [nit=" + nit + ", tipo_cliente=" + tipo_cliente + "]";
	}


	
	
	
	
	
}
