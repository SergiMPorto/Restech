package modelo.entidad;

import java.time.LocalDate;

public class Pedido {
	
	private int id; 
    private Usuario idUsuario;
    private Proveedor idProveedor;
    private LocalDate fechaPedido;
    private double costoTotal; 
    
    public Pedido() {
        super();
    }

    public Pedido(int id) {
        this.id = id;
        
    }
    
    public Pedido(Usuario idUsuario, Proveedor idProveedor, LocalDate fechaPedido, double costoTotal) {
        this.idUsuario = idUsuario;
        this.idProveedor = idProveedor;
        this.fechaPedido = fechaPedido;
        this.costoTotal = costoTotal;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", idUsuario=" + idUsuario + ", idProveedor=" + idProveedor + ", fechaPedido="
                + fechaPedido + ", costoTotal=" + costoTotal + "]";
    }
	

}
