package modelo.entidad;

import java.time.LocalDate;

public class Pedido {
	
	private Usuario id_usuario;
	private Proveedor id_proveedor;
	private LocalDate fechaPedidoDate;
	private float costoTotal;
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pedido(Usuario id_usuario, Proveedor id_proveedor, LocalDate fechaPedidoDate, float costoTotal) {
		super();
		this.id_usuario = id_usuario;
		this.id_proveedor = id_proveedor;
		this.fechaPedidoDate = fechaPedidoDate;
		this.costoTotal = costoTotal;
	}
	
	
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Proveedor getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(Proveedor id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public LocalDate getFechaPedidoDate() {
		return fechaPedidoDate;
	}
	public void setFechaPedidoDate(LocalDate fechaPedidoDate) {
		this.fechaPedidoDate = fechaPedidoDate;
	}
	public float getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	@Override
	public String toString() {
		return "Pedido [id_usuario=" + id_usuario + ", id_proveedor=" + id_proveedor + ", fechaPedidoDate="
				+ fechaPedidoDate + ", costoTotal=" + costoTotal + "]";
	}
	
	

}
