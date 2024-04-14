package modelo.entidad;

public class Usuario {
	
	private String nombre;
	private int permisos;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(String nombre, int permisos) {
		super();
		this.nombre = nombre;
		this.permisos = permisos;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPermisos() {
		return permisos;
	}
	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", permisos=" + permisos + "]";
	}
	
	

}
