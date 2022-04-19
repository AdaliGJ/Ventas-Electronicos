package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prueba")
public class Prueba {

	//Atributos de la tabla
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prueba;
	@Column
	private int valor1;
	@Column
	private String valor2;
	
	public Prueba() {}

	
	//Getters y Setters
	/**
	 * Obtener Id 
	 * @return Id
	 */
	public int getId_prueba() {
		return id_prueba;
	}
	/**
	 * Agregar id
	 * @param id_prueba
	 */
	public void setId_prueba(int id_prueba) {
		this.id_prueba = id_prueba;
	}
	/**
	 * Obtener valor
	 * @return valir
	 */
	public int getValor1() {
		return valor1;
	}

	/**
	 * Agregar valor
	 * @param valor1
	 */
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	/**
	 * Obtener valor 2
	 * @return valor 2
	 */
	public String getValor2() {
		return valor2;
	}
	/**
	 * Agregar valor 2
	 * @param valor2
	 */
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	/**
	 * Creacion de clase Prueba
	 * @param id_prueba
	 * @param valor1
	 * @param valor2
	 */
	public Prueba(int id_prueba, int valor1, String valor2) {
		super();
		this.id_prueba = id_prueba;
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	/**
	 * Convertir a string el objeto Prueba
	 */
	@Override
	public String toString() {
		return "Prueba [id_prueba=" + id_prueba + ", valor1=" + valor1 + ", valor2=" + valor2 + "]";
	}
	
	
	
	

}
