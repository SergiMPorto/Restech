package modelo.entidad;

public class Proveedor {
	
	private String nombre;
	private String descripcionString; // --> Podemos mirar de hacer una List con las cosas que vende cada proveedor
	private String numeroContacto; //--> Mirar de hacerlo int para facilitar insercción de dato en modelo de negocio
	private String direccion;
	
	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Proveedor(String nombre, String descripcionString, String numeroContacto, String direccion) {
		super();
		this.nombre = nombre;
		this.descripcionString = descripcionString;
		this.numeroContacto = numeroContacto;
		this.direccion = direccion;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionString() {
		return descripcionString;
	}
	public void setDescripcionString(String descripcionString) {
		this.descripcionString = descripcionString;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", descripcionString=" + descripcionString + ", numeroContacto="
				+ numeroContacto + ", direccion=" + direccion + "]";
	}
	
	

}
