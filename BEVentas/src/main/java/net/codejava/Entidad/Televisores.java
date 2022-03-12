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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_inventario;
	@Column
	private String resolucion;
	@Column
	private int bits_profundidad_color;
	@Column
	private int pulgadas_pantalla;
	@Column
	private int entradas_HDMI;
	
	
	public Televisores() {}
	
	
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public int getBits_profundidad_color() {
		return bits_profundidad_color;
	}
	public void setBits_profundidad_color(int bits_profundidad_color) {
		this.bits_profundidad_color = bits_profundidad_color;
	}
	public int getPulgadas_pantalla() {
		return pulgadas_pantalla;
	}
	public void setPulgadas_pantalla(int pulgadas_pantalla) {
		this.pulgadas_pantalla = pulgadas_pantalla;
	}
	public int getEntradas_HDMI() {
		return entradas_HDMI;
	}
	public void setEntradas_HDMI(int entradas_HDMI) {
		this.entradas_HDMI = entradas_HDMI;
	}
	public Televisores(int id_inventario, String resolucion, int bits_profundidad_color, int pulgadas_pantalla,
			int entradas_HDMI) {
		super();
		this.id_inventario = id_inventario;
		this.resolucion = resolucion;
		this.bits_profundidad_color = bits_profundidad_color;
		this.pulgadas_pantalla = pulgadas_pantalla;
		this.entradas_HDMI = entradas_HDMI;
	}
	@Override
	public String toString() {
		return "Televisores [id_inventario=" + id_inventario + ", resolucion=" + resolucion
				+ ", bits_profundidad_color=" + bits_profundidad_color + ", pulgadas_pantalla=" + pulgadas_pantalla
				+ ", entradas_HDMI=" + entradas_HDMI + "]";
	}
	
	

}
