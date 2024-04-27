package modelo.entidad;

public class Merma {
	
	 private MateriaPrima materiaPrima;
	    private float cantidad;
	    private int id;

	    public Merma() {
	    }

	    public Merma(MateriaPrima materiaPrima, float cantidad) {
	        this.materiaPrima = materiaPrima;
	        this.cantidad = cantidad;
	    }

	    public MateriaPrima getMateriaPrima() {
	        return materiaPrima;
	    }

	    public void setMateriaPrima(MateriaPrima materiaPrima) {
	        this.materiaPrima = materiaPrima;
	    }

	    public float getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(float cantidad) {
	        this.cantidad = cantidad;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    @Override
	    public String toString() {
	        return "Merma [materiaPrima=" + materiaPrima + ", cantidad=" + cantidad + "]";
	    }
	
	

}
