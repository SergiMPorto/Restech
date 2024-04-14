package modelo.entidad;

import java.time.LocalDate;

public class HistorialPrecio {
	
	private MateriaPrima id_materiaPrima;
	private float precio;
	private LocalDate fecha;
	
	
	public HistorialPrecio() {
		super();


	}


	public HistorialPrecio(MateriaPrima id_materiaPrima, float precio, LocalDate fecha) {
		super();
		this.id_materiaPrima = id_materiaPrima;
		this.precio = precio;
		this.fecha = fecha;
	}


	public MateriaPrima getId_materiaPrima() {
		return id_materiaPrima;
	}


	public void setId_materiaPrima(MateriaPrima id_materiaPrima) {
		this.id_materiaPrima = id_materiaPrima;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "HistorialPrecio [id_materiaPrima=" + id_materiaPrima + ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	
	

}
