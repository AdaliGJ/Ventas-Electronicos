package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad de clientes utilizada para elementos de la tabla DISPOSITIVOS_INDIVIDUALES
 * @author javie
 *
 */
@Entity
@Table(name = "dispositivos_individuales")
public class Dispositivos_individuales {
	
	@Id
	@Column(name="serie_dispositivo")
	private String serie;
	@Column(name="id_inventario")
	private int idInventario;
	@Column
	private int vendido;
	
	public int getVendido() {
		return vendido;
	}

	/**
	 * Metodo para asignar dispositivo Vendido
	 * @param vendido
	 */
	public void setVendido(int vendido) {
		this.vendido = vendido;
	}


	public Dispositivos_individuales() {}
	
	/**
	 * Metodo para obtener numero de serie de los dispositivos
	 * @return
	 */
	public String getSerie_dispositivo() {
		return serie;
	}
	/**
	 * Metodo para inbresar numero de serie del dispositivo
	 * @param serie_dispositivo
	 */
	public void setSerie_dispositivo(String serie_dispositivo) {
		this.serie= serie_dispositivo;
	}
	/**
	 * Metodo para obtener el ID_Inventario del dispositivo individual
	 * @return
	 */
	public int getId_inventario() {
		return idInventario;
	}
	
	/**
	 * Metodo para ingresar el id del inventario
	 * @param id_inventario
	 */
	public void setId_inventario(int id_inventario) {
		this.idInventario = id_inventario;
	}
	/*public Dispositivos_individuales(String serie, int id_inventario) {
		super();
		this.serie = serie;
		this.id_inventario = id_inventario;
	}*/
	
	/**
	 * Constructor de la clase Dispositivos_individuales
	 * @param serie
	 * @param id_inventario
	 * @param vendido
	 */
	public Dispositivos_individuales(String serie, int id_inventario, int vendido) {
		super();
		this.serie = serie;
		this.idInventario = id_inventario;
		this.vendido = vendido;
	}
	
	/**
	 * Mètodo para volver string al objeto Dispositivos_individuales
	 */

	
	@Override
	public String toString() {
		return "Dispositivos_individuales [serie=" + serie + ", id_inventario=" + idInventario + ", vendido=" + vendido
				+ "]";
	}
	
	

	
	

}
