package modelo.entidad;

public class PedidoMateriaPrima {
	
	private Pedido id_pedido;
	private MateriaPrima id_materiaPrima;
	private float cantidad;
	private float costoUnitario;
	private float costoTotal;
	
	
	public PedidoMateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PedidoMateriaPrima(Pedido id_pedido, MateriaPrima id_materiaPrima, float cantidad, float costoUnitario,
			float costoTotal) {
		super();
		this.id_pedido = id_pedido;
		this.id_materiaPrima = id_materiaPrima;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
		this.costoTotal = costoTotal;
	}
	
	
	public Pedido getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Pedido id_pedido) {
		this.id_pedido = id_pedido;
	}
	public MateriaPrima getId_materiaPrima() {
		return id_materiaPrima;
	}
	public void setId_materiaPrima(MateriaPrima id_materiaPrima) {
		this.id_materiaPrima = id_materiaPrima;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(float costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public float getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
	@Override
	public String toString() {
		return "PedidoMateriaPrima [id_pedido=" + id_pedido + ", id_materiaPrima=" + id_materiaPrima + ", cantidad="
				+ cantidad + ", costoUnitario=" + costoUnitario + ", costoTotal=" + costoTotal + "]";
	}
	
	

}
