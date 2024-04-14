package modelo.entidad;

public class Plato {
	
	private String nombre;
	private float precio;
	private int tiempoPreparacion;
	
	
	
	public Plato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Plato(String nombre, float precio, int tiempoPreparacion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.tiempoPreparacion = tiempoPreparacion;
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
	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}
	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
	
	
	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", precio=" + precio + ", tiempoPreparacion=" + tiempoPreparacion + "]";
	}
	
	
	

}
