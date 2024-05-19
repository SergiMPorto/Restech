package modelo.entidad;

public class Ingrediente {
	
	 	private int id_ingrediente;
	 	private String nombre;
	    private Plato id_plato;
	    private MateriaPrima id_materiaPrima;
	    private float cantidad;
	    
	    public Ingrediente() {
	        super();
	    }
	    
	    public Ingrediente(int id_ingrediente, Plato id_plato, MateriaPrima id_materiaPrima, float cantidad) {
	        super();
	        this.id_ingrediente = id_ingrediente;
	        this.id_plato = id_plato;
	        this.id_materiaPrima = id_materiaPrima;
	        this.cantidad = cantidad;
	    }
	    
	    public int getId_ingrediente() {
	        return id_ingrediente;
	    }
	    
	    public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setId_ingrediente(int id_ingrediente) {
	        this.id_ingrediente = id_ingrediente;
	    }
	    
	    public Plato getId_plato() {
	        return id_plato;
	    }
	    
	    public void setId_plato(Plato id_plato) {
	        this.id_plato = id_plato;
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
			return "Ingrediente [id_ingrediente=" + id_ingrediente + ", nombre=" + nombre + ", id_plato=" + id_plato
					+ ", id_materiaPrima=" + id_materiaPrima + ", cantidad=" + cantidad + "]";
		}
	    
	   
	

}
