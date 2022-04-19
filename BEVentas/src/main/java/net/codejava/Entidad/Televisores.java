package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "televisores")
public class Televisores {
	
	@Id
	private int id_inventario;
	@Column
	private String resolucion;
	@Column
	private int bits_profundidad;
	@Column
	private int pulgadas_pantalla;
	@Column
	private int entradas_HDMI;
	
	
	public Televisores() {}
	
	/**
	 * Obtener id del inventario
	 * @return id del inventario
	 */
	public int getId_inventario() {
		return id_inventario;
	}
	/**
	 * Agregar el id del inventario
	 * @param id_inventario
	 */
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	/**
	 * Obtener resolucion del televisor
	 * @return resolucion del televisor
	 */
	public String getResolucion() {
		return resolucion;
	}
	/**
	 * Agregar resolucion del televisor
	 * @param resolucion
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	/**
	 * Obtener bits
	 * @return bits
	 */
	public int getBits_profundidad_color() {
		return bits_profundidad;
	}
	/**
	 * Agregar bits del televisor
	 * @param bits_profundidad_color
	 */
	public void setBits_profundidad_color(int bits_profundidad_color) {
		this.bits_profundidad = bits_profundidad_color;
	}
	/**
	 * Obtener pulgadas de la pantalla
	 * @return pulgadas de la pantalla
	 */
	public int getPulgadas_pantalla() {
		return pulgadas_pantalla;
	}
	/**
	 * Obtener pulgadas de la pantalla
	 * @param pulgadas_pantalla
	 */
	public void setPulgadas_pantalla(int pulgadas_pantalla) {
		this.pulgadas_pantalla = pulgadas_pantalla;
	}
	/**
	 * Obtener numero de entradas de HDMI de la pantalla
	 * @return numero de entradas de HDMI de la pantalla
	 */
	public int getEntradas_HDMI() {
		return entradas_HDMI;
	}
	/**
	 * Agregar numero de entrdas de HDMI de la pantalla
	 * @param entradas_HDMI
	 */
	public void setEntradas_HDMI(int entradas_HDMI) {
		this.entradas_HDMI = entradas_HDMI;
	}
	
	/**
	 * Creacion de clase Televisores
	 * @param id_inventario
	 * @param resolucion
	 * @param bits_profundidad_color
	 * @param pulgadas_pantalla
	 * @param entradas_HDMI
	 */
	public Televisores(int id_inventario, String resolucion, int bits_profundidad_color, int pulgadas_pantalla,
			int entradas_HDMI) {
		super();
		this.id_inventario = id_inventario;
		this.resolucion = resolucion;
		this.bits_profundidad = bits_profundidad_color;
		this.pulgadas_pantalla = pulgadas_pantalla;
		this.entradas_HDMI = entradas_HDMI;
	}
	@Override
	/**
	 * Convertir objeto Televisores en string
	 */
	public String toString() {
		return "Televisores [id_inventario=" + id_inventario + ", resolucion=" + resolucion
				+ ", bits_profundidad_color=" + bits_profundidad + ", pulgadas_pantalla=" + pulgadas_pantalla
				+ ", entradas_HDMI=" + entradas_HDMI + "]";
	}
	
	

}
