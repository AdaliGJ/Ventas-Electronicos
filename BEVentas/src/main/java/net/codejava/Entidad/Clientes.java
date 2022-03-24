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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;
	@Column
	private int tipo_cliente;
	@Column
	private int nit;
	
	
	public Clientes() {}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public int getTipo_cliente() {
		return tipo_cliente;
	}


	public void setTipo_cliente(int tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}


	public int getNit() {
		return nit;
	}


	public void setNit(int nit) {
		this.nit = nit;
	}


	public Clientes(int idCliente, int tipo_cliente, int nit) {
		super();
		this.idCliente = idCliente;
		this.tipo_cliente = tipo_cliente;
		this.nit = nit;
	}


	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", tipo_cliente=" + tipo_cliente + ", nit=" + nit + "]";
	}
	
	
	
	
}
