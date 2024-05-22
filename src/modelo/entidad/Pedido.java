package modelo.entidad;

import java.time.LocalDate;

public class Pedido {
	
	private int id; 
    private int idUsuario;
    private int idProveedor;
    private String materiaPrima;
    private double cantidad;
    private LocalDate fechaPedido;
    private double costoTotal; 
    
    public Pedido() {
        super();
    }

    public Pedido(int id) {
        this.id = id;
        
    }
    
    public Pedido(int id, int idUsuario, int idProveedor, String materiaPrima, double cantidad,
			LocalDate fechaPedido, double costoTotal) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idProveedor = idProveedor;
		this.materiaPrima = materiaPrima;
		this.cantidad = cantidad;
		this.fechaPedido = fechaPedido;
		this.costoTotal = costoTotal;
	}

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
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
