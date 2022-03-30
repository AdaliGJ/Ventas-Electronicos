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

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_inventario")
	private int idInventario;
	@Column(name="categoria_dispositivo")
	private int categoriaDispositivo;
	@Column
	private int marca;
	@Column 
	private int existencias;
	@Column(name="precio_lista")
	private float precioLista;
	@Column
	private String color;
	@Column
	private String descripcion;
	@Column
	private String modelo;
	@Column (name="meses_garantia")
	private int mesesGarantia;
	
	public Inventario() {}

	
	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getCategoriaDispositivo() {
		return categoriaDispositivo;
	}

	public void setCategoriaDispositivo(int categoriaDispositivo) {
		this.categoriaDispositivo = categoriaDispositivo;
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

	public float getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(float precioLista) {
		this.precioLista = precioLista;
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

	public int getMesesGarantia() {
		return mesesGarantia;
	}

	public void setMesesGarantia(int mesesGarantia) {
		this.mesesGarantia = mesesGarantia;
	}


	public Inventario(int idInventario, int categoriaDispositivo, int marca, int existencias, float precioLista,
			String color, String descripcion, String modelo, int mesesGarantia) {
		super();
		this.idInventario = idInventario;
		this.categoriaDispositivo = categoriaDispositivo;
		this.marca = marca;
		this.existencias = existencias;
		this.precioLista = precioLista;
		this.color = color;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.mesesGarantia = mesesGarantia;
	}


	@Override
	public String toString() {
		return "Inventario [idInventario=" + idInventario + ", categoriaDispositivo=" + categoriaDispositivo
				+ ", marca=" + marca + ", existencias=" + existencias + ", precioLista=" + precioLista + ", color="
				+ color + ", descripcion=" + descripcion + ", modelo=" + modelo + ", mesesGarantia=" + mesesGarantia
				+ "]";
	}
	
	
	
}
