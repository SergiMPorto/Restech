package modelo.entidad;

import java.time.LocalDate;

public class HistorialPrecio {
	
	private int id; 
    private MateriaPrima materiaPrima;
    private float precio;
    private LocalDate fecha;
	
    public HistorialPrecio() {
        super();
    }

    public HistorialPrecio(int id, MateriaPrima materiaPrima, float precio, LocalDate fecha) {
        this.id = id;
        this.materiaPrima = materiaPrima;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        return "HistorialPrecio [id=" + id + ", materiaPrima=" + materiaPrima + ", precio=" + precio + ", fecha=" + fecha + "]";
    }
	
	

}
