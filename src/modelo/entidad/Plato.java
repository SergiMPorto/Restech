package modelo.entidad;

import java.util.List;

public class Plato {
	
	private int id;
    private String nombre;
    private float precio;
    private int tiempoPreparacion;
    private List<Ingrediente> ingredientes;

    public Plato() {
        
    }
    
    public Plato(int id, String nombre, float precio, int tiempoPreparacion) {
    	
    }

    public Plato(int id, String nombre, float precio, int tiempoPreparacion, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = ingredientes;
    }

    public Plato(String nombre, float precio, int tiempoPreparacion, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = ingredientes;
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
    
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tiempoPreparacion=" + tiempoPreparacion + ", ingredientes=" + ingredientes + "]";
    }
	
	

}