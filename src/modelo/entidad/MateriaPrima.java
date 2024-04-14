package modelo.entidad;

import java.time.LocalDate;

public class MateriaPrima {
	
	private String nombre;
	private float precio;
	private String proveedor;
	private LocalDate fechaCaducidad;
	private float cantidadUtilizada;
	private float merma;
	
	
	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MateriaPrima(String nombre, float precio, String proveedor, LocalDate fechaCaducidad,
			float cantidadUtilizada, float merma) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.proveedor = proveedor;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidadUtilizada = cantidadUtilizada;
		this.merma = merma;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public float getCantidadUtilizada() {
		return cantidadUtilizada;
	}


	public void setCantidadUtilizada(float cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}


	public float getMerma() {
		return merma;
	}


	public void setMerma(float merma) {
		this.merma = merma;
	}


	@Override
	public String toString() {
		return "MateriaPrima [nombre=" + nombre + ", precio=" + precio + ", proveedor=" + proveedor
				+ ", fechaCaducidad=" + fechaCaducidad + ", cantidadUtilizada=" + cantidadUtilizada + ", merma=" + merma
				+ "]";
	}
	
	
	
}
