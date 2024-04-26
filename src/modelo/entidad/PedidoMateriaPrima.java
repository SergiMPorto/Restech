package modelo.entidad;

public class PedidoMateriaPrima {
	
	private Pedido pedido; // Referencia al pedido
    private MateriaPrima materiaPrima; // Referencia a la materia prima
    private float cantidad; // Cantidad de materia prima
    private float costoUnitario; // Costo unitario de la materia prima
    private float costoTotal; // Costo total de la materia prima
    private int id; // Identificador único de PedidoMateriaPrima

    // Constructor por defecto
    public PedidoMateriaPrima() {
    }

    // Constructor con parámetros
    public PedidoMateriaPrima(Pedido pedido, MateriaPrima materiaPrima, float cantidad, float costoUnitario, float costoTotal) {
        this.pedido = pedido;
        this.materiaPrima = materiaPrima;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
    }

    // Getters y setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PedidoMateriaPrima [pedido=" + pedido + ", materiaPrima=" + materiaPrima + ", cantidad=" + cantidad + ", costoUnitario=" + costoUnitario + ", costoTotal=" + costoTotal + ", id=" + id + "]";
    }
    
}

