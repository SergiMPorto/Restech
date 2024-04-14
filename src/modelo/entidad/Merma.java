package modelo.entidad;

public class Merma {
	
	private MateriaPrima id_materiaPrima;
	private float cantidad;
	
	
	public Merma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Merma(MateriaPrima id_materiaPrima, float cantidad) {
		super();
		this.id_materiaPrima = id_materiaPrima;
		this.cantidad = cantidad;
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
	
	
	@Override
	public String toString() {
		return "Merma [id_materiaPrima=" + id_materiaPrima + ", cantidad=" + cantidad + "]";
	}
	
	
	

}
