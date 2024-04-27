package modelo.entidad;

public class Proveedor {
	
	private int id;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String direccion;

    public Proveedor() {
        super();
    }
    
    public Proveedor(int id) {
        this.id = id;
        
    }

    public Proveedor(String nombre, String descripcion, String telefono, String direccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

}
