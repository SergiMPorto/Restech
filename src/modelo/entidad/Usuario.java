package modelo.entidad;

public class Usuario {
	
	private int id; 
    private String nombre;
    private int permisos;

    public Usuario() {
        
    }
    
    public Usuario(int id) {
        this.id = id;
        
    }

    public Usuario(int id, String nombre, int permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public Usuario(String nombre, int permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
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

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", permisos=" + permisos + "]";
    }
	

}
