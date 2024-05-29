package modelo.entidad;

public class Usuario {
	
	private int id; 
    private String nombre;
    private int permisos;
    private String codigo;

    public Usuario() {
        
    }
    
    public Usuario(int id) {
        this.id = id;
        
    }

   
   
    public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Usuario(int id, String nombre, int permisos, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.permisos = permisos;
		this.codigo = codigo;
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

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }
    

    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", permisos=" + permisos + ", codigo=" + codigo + "]";
	}

	
	

}
