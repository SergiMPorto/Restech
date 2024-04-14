package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.PedidoMateriaPrima;

public interface DaoPedidoMateriaPrima {
	
	public int insertar(PedidoMateriaPrima pmp);
	public int borrar(int id);
	public PedidoMateriaPrima modificar(PedidoMateriaPrima pmp);
	public PedidoMateriaPrima buscar(int id);
	public List<PedidoMateriaPrima> listar();

}
