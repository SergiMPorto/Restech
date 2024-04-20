package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.PedidoMateriaPrima;

public interface DaoPedidoMateriaPrima {
	
	public boolean insertar(PedidoMateriaPrima pmp);
	public boolean borrar(int id);
	public boolean modificar(PedidoMateriaPrima pmp);
	public PedidoMateriaPrima buscar(int id);
	public List<PedidoMateriaPrima> listar();

}
