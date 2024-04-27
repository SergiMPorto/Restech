package modelo.entidad;

import java.time.LocalDate;

public class Gasto {
	
	private Pedido pedido; 
    private float costo;
    private LocalDate fecha;
    private int idGasto;
    
    public Gasto() {
    }
    
    public Gasto(Pedido pedido, float costo, LocalDate fecha) {
        super();
        this.pedido = pedido;
        this.costo = costo;
        this.fecha = fecha;
    }

    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    @Override
    public String toString() {
        return "Gasto [pedido=" + pedido + ", costo=" + costo + ", fecha=" + fecha + "]";
    }

}
