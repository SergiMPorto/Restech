package modelo.entidad;

import java.time.LocalDate;

public class MateriaPrima {
	
	private int id; 
    private String nombre;
    private float precio;
    private String proveedor;
    private LocalDate fechaCaducidad;
    private float cantidadUtilizada;
    private float merma;
    
    public MateriaPrima() {
        super();
    }

    public MateriaPrima(int id, String nombre, float precio, String proveedor, LocalDate fechaCaducidad, float cantidadUtilizada, float merma) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidadUtilizada = cantidadUtilizada;
        this.merma = merma;
    }
    
    public MateriaPrima( String nombre, float precio, String proveedor, LocalDate fechaCaducidad, float cantidadUtilizada, float merma) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidadUtilizada = cantidadUtilizada;
        this.merma = merma;
    }
    
    public MateriaPrima(String nombre, float cantidadUtilizada) {
    	super();
    	this.nombre = nombre;
    	this.cantidadUtilizada = cantidadUtilizada;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public float getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(float cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public float getMerma() {
        return merma;
    }

    public void setMerma(float merma) {
        this.merma = merma;
    }

    @Override
    public String toString() {
        return "MateriaPrima [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", proveedor=" + proveedor + ", fechaCaducidad=" + fechaCaducidad + ", cantidadUtilizada=" + cantidadUtilizada + ", merma=" + merma + "]";
    }
    
    public float getPrecioUnitario() {
        // Calculamos el precio unitario dividiendo el precio total entre la cantidad utilizada
        if (cantidadUtilizada != 0) {
            return precio / cantidadUtilizada;
        } else {
            // En caso de que la cantidad utilizada sea 0, devolvemos 0 para evitar divisiones por cero
            return 0;
        }
    }
	
	
	
}
