package modelo.entidad;

import java.time.LocalDate;

public class Gasto {
	
	private Pedido id_pedidoPedido;
	private float costo;
	private LocalDate fecha;
	
	public Gasto() {
		
	}
	
	public Gasto(Pedido id_pedidoPedido, float costo, LocalDate fecha) {
		super();
		this.id_pedidoPedido = id_pedidoPedido;
		this.costo = costo;
		this.fecha = fecha;
	}

	public Pedido getId_pedidoPedido() {
		return id_pedidoPedido;
	}

	public void setId_pedidoPedido(Pedido id_pedidoPedido) {
		this.id_pedidoPedido = id_pedidoPedido;
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

	@Override
	public String toString() {
		return "Gasto [id_pedidoPedido=" + id_pedidoPedido + ", costo=" + costo + ", fecha=" + fecha + "]";
	}
	
	

}
