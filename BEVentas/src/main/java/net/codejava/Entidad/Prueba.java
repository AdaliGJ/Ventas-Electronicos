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
	private int valor_1;
	@Column
	private String valor_2;
	
	public Prueba() {}
	
	//Getters y Setters
	public int getId_prueba() {
		return id_prueba;
	}
	public void setId_prueba(int id_prueba) {
		this.id_prueba = id_prueba;
	}
	public int getValor_1() {
		return valor_1;
	}
	public void setValor_1(int valor_1) {
		this.valor_1 = valor_1;
	}
	public String getValor_2() {
		return valor_2;
	}
	public void setValor_2(String valor_2) {
		this.valor_2 = valor_2;
	}
	
	
	public Prueba(int id_prueba, int valor_1, String valor_2) {
		super();
		this.id_prueba = id_prueba;
		this.valor_1 = valor_1;
		this.valor_2 = valor_2;
	}
	
	@Override
	public String toString() {
		return "Prueba [id_prueba=" + id_prueba + ", valor_1=" + valor_1 + ", valor_2=" + valor_2 + "]";
	}
	

}
