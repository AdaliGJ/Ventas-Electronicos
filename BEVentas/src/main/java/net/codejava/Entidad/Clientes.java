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
	private int id_cliente;
	@Column
	private int tipo_cliente;
	@Column
	private String contraseña;
	
	
	public Clientes() {}
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getTipo_cliente() {
		return tipo_cliente;
	}
	public void setTipo_cliente(int tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Clientes(int id_cliente, int tipo_cliente, String contraseña) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_cliente = tipo_cliente;
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", tipo_cliente=" + tipo_cliente + ", contraseña=" + contraseña
				+ "]";
	}
	
	
}
