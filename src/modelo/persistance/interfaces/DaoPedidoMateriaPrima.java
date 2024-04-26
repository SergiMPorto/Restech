package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.PedidoMateriaPrima;

public interface DaoPedidoMateriaPrima {
	
	boolean insertar(PedidoMateriaPrima pmp);
    boolean borrar(int id);
    boolean modificar(PedidoMateriaPrima pmp);
    PedidoMateriaPrima buscar(int id);
    List<PedidoMateriaPrima> listar();
}


