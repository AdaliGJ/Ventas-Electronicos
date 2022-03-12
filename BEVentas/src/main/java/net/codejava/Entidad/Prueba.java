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
	public int getId_prueba() {
		return id_prueba;
	}

	public void setId_prueba(int id_prueba) {
		this.id_prueba = id_prueba;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}


	public Prueba(int id_prueba, int valor1, String valor2) {
		super();
		this.id_prueba = id_prueba;
		this.valor1 = valor1;
		this.valor2 = valor2;
	}


	@Override
	public String toString() {
		return "Prueba [id_prueba=" + id_prueba + ", valor1=" + valor1 + ", valor2=" + valor2 + "]";
	}
	
	
	
	

}
