package modelo.entidad;

import java.util.List;

public class Plato {
	
	private int id;
    private String nombre;
    private float precio;
    private int tiempoPreparacion;
    private List<MateriaPrima> materia_prima;

    public Plato() {
        
    }
    
    public Plato(int id, String nombre, float precio, int tiempoPreparacion) {
    	
    }

    public Plato(int id, String nombre, float precio, int tiempoPreparacion, List<MateriaPrima> materia_prima) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.materia_prima = materia_prima;
    }

    public Plato(String nombre, float precio, int tiempoPreparacion, List<MateriaPrima> materia_prima) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.materia_prima = materia_prima;
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
    
    public List<MateriaPrima> getMateriaPrima() {
        return materia_prima;
    }

    public void setMateriaPrima(List<MateriaPrima> materia_prima) {
        this.materia_prima = materia_prima;
    }

    @Override
    public String toString() {
        return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tiempoPreparacion=" + tiempoPreparacion + ", materia_prima=" + materia_prima + "]";
    }
	
	

}