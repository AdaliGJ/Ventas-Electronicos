package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase replica la estructura de la tabla videojuegos definida en Oracle
 * Esta entidad permitira formar la estructura con los key/values para las respuestas Json
 * Y permitira la obtencion y modificacion del objeto a traves de sus metodos publicos 
 *
 */
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
	
	/**
	 * Obtener id del inventario
	 * @return id del inventario
	 */
	public int getId_inventario() {
		return id_inventario;
	}
	/**
	 * Agregar id del inventario
	 * @param id_inventario
	 */
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	/**
	 * Obtener numero maximo de jugadores
	 * @return numero maximo de jugadores
	 */
	public int getMax_jugadores() {
		return max_jugadores;
	}
	/**
	 * Agregar numero maximo de jugadores
	 * @param max_jugadores
	 */
	public void setMax_jugadores(int max_jugadores) {
		this.max_jugadores = max_jugadores;
	}
	/**
	 * Obtener graficos del videojuego
	 * @return graficos del videojuego
	 */
	public String getGraficos() {
		return graficos;
	}
	/**
	 * Agregar graficos del videojuego
	 * @param graficos
	 */
	public void setGraficos(String graficos) {
		this.graficos = graficos;
	}
	
	/**
	 * Obtener consola del videojuego
	 * @return consola del videojuego
	 */
	public String getConsola() {
		return consola;
	}
	/**
	 * Agregar consola del videojuego
	 * @param consola
	 */
	public void setConsola(String consola) {
		this.consola = consola;
	}
	/**
	 * Creacion de clase Vieojuego
	 * @param id_inventario
	 * @param max_jugadores
	 * @param graficos
	 * @param consola
	 */
	public Videojuegos(int id_inventario, int max_jugadores, String graficos, String consola) {
		super();
		this.id_inventario = id_inventario;
		this.max_jugadores = max_jugadores;
		this.graficos = graficos;
		this.consola = consola;
	}
	@Override
	/**
	 * Convertir en string objeto videojuego 
	 */
	public String toString() {
		return "Videojuegos [id_inventario=" + id_inventario + ", max_jugadores=" + max_jugadores + ", graficos="
				+ graficos + ", consola=" + consola + "]";
	}
	
	

	
	

}
