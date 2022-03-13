package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "smartwatch")
public class Smartwatch {

	@Id
	private int id_inventario;
	@Column
	private int pulgadas_pantalla;
	@Column
	private String sistema_operativo;
	@Column
	private int ram_MB;
	@Column 
	private int memoria_GB;
	
	
	public Smartwatch() {}
	
	
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	public int getPulgadas_pantalla() {
		return pulgadas_pantalla;
	}
	public void setPulgadas_pantalla(int pulgadas_pantalla) {
		this.pulgadas_pantalla = pulgadas_pantalla;
	}
	public String getSistema_operativo() {
		return sistema_operativo;
	}
	public void setSistema_operativo(String sistema_operativo) {
		this.sistema_operativo = sistema_operativo;
	}
	public int getRam_MB() {
		return ram_MB;
	}
	public void setRam_MB(int ram_MB) {
		this.ram_MB = ram_MB;
	}
	public int getMemoria_GB() {
		return memoria_GB;
	}
	public void setMemoria_GB(int memoria_GB) {
		this.memoria_GB = memoria_GB;
	}
	public Smartwatch(int id_inventario, int pulgadas_pantalla, String sistema_operativo, int ram_MB, int memoria_GB) {
		super();
		this.id_inventario = id_inventario;
		this.pulgadas_pantalla = pulgadas_pantalla;
		this.sistema_operativo = sistema_operativo;
		this.ram_MB = ram_MB;
		this.memoria_GB = memoria_GB;
	}
	@Override
	public String toString() {
		return "Smartwatch [id_inventario=" + id_inventario + ", pulgadas_pantalla=" + pulgadas_pantalla
				+ ", sistema_operativo=" + sistema_operativo + ", ram_MB=" + ram_MB + ", memoria_GB=" + memoria_GB
				+ "]";
	}
	
	
	
	
}
