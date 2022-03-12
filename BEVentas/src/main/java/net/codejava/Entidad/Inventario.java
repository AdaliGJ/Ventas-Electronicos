package net.codejava.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_inventario;
	@Column
	private int categoria_dispositivo;
	@Column
	private int marca;
	@Column 
	private int existencias;
	@Column
	private float precio_lista;
	@Column
	private String color;
	@Column
	private String descripcion;
	@Column
	private String modelo;
	
	
	
	public int getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}
	public int getCategoria_dispositivo() {
		return categoria_dispositivo;
	}
	public void setCategoria_dispositivo(int categoria_dispositivo) {
		this.categoria_dispositivo = categoria_dispositivo;
	}
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	public float getPrecio_lista() {
		return precio_lista;
	}
	public void setPrecio_lista(float precio_lista) {
		this.precio_lista = precio_lista;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Inventario(int id_inventario, int categoria_dispositivo, int marca, int existencias, float precio_lista,
			String color, String descripcion, String modelo) {
		super();
		this.id_inventario = id_inventario;
		this.categoria_dispositivo = categoria_dispositivo;
		this.marca = marca;
		this.existencias = existencias;
		this.precio_lista = precio_lista;
		this.color = color;
		this.descripcion = descripcion;
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Inventario [id_inventario=" + id_inventario + ", categoria_dispositivo=" + categoria_dispositivo
				+ ", marca=" + marca + ", existencias=" + existencias + ", precio_lista=" + precio_lista + ", color="
				+ color + ", descripcion=" + descripcion + ", modelo=" + modelo + "]";
	}
	
	
	
	
	
}
