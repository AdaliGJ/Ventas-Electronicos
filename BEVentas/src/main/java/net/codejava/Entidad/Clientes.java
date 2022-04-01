package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entidad de clientes utilizada para elementos de la tabla clientes
 * @author Adalí Garrán
 *
 */

@Entity
@Table(name = "clientes")
public class Clientes {

	@Id
	@Column
	/**
	 * Variables de la clase cliente
	 */
	private int nit;
	@Column
	private int tipo_cliente;
	
	
	/**
	 * Constructor para la clase Clientes
	 */
	public Clientes() {}


	/**
	 * Método que para obtener NIT del cliente
	 * @return NIT del cliente
	 */
	public int getNit() {
		return nit;
	}


	/**
	 * Método para asignar NIT al cliente
	 * @param nit a asignar
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}


	/**
	 * Método que para obtener el tipo de cliente (Individual, Mayorista o Grande) 
	 * @return Id del tipo de cliente
	 */
	public int getTipo_cliente() {
		return tipo_cliente;
	}


	/**
	 *  Método para asignar un tipo de cliente
	 * @param tipo_cliente a asignar
	 */
	public void setTipo_cliente(int tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}


/**
 * Constructor de la clase cliente
 * @param nit a asignar
 * @param tipo_cliente (Mayorista, Grande o Individual)
 */
	public Clientes(int nit, int tipo_cliente) {
		super();
		this.nit = nit;
		this.tipo_cliente = tipo_cliente;
	}

	
		/**
		 * Mètodo para volver string al objeto cliente
		 * @return string con variables del Objeto
		 */
		@Override
		public String toString() {
			return "Clientes [nit=" + nit + ", tipo_cliente=" + tipo_cliente + "]";
		}


	
	
	
	
	
}
