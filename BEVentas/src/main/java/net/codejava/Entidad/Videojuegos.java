package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videojuegos")
public class Videojuegos {
	
	@Id
	private int id_inventario;
	@Column
	private int max_jugadores;
	@Column
	private String graficos;
	@Column
	private String consola;
	
	
	public Videojuegos() {}
	
	
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	public int getMax_jugadores() {
		return max_jugadores;
	}
	public void setMax_jugadores(int max_jugadores) {
		this.max_jugadores = max_jugadores;
	}
	public String getGraficos() {
		return graficos;
	}
	public void setGraficos(String graficos) {
		this.graficos = graficos;
	}
	public String getConsola() {
		return consola;
	}
	public void setConsola(String consola) {
		this.consola = consola;
	}
	public Videojuegos(int id_inventario, int max_jugadores, String graficos, String consola) {
		super();
		this.id_inventario = id_inventario;
		this.max_jugadores = max_jugadores;
		this.graficos = graficos;
		this.consola = consola;
	}
	@Override
	public String toString() {
		return "Videojuegos [id_inventario=" + id_inventario + ", max_jugadores=" + max_jugadores + ", graficos="
				+ graficos + ", consola=" + consola + "]";
	}
	
	

	
	

}
