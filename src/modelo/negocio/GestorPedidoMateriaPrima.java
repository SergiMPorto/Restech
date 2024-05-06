package modelo.negocio;

import java.util.List;

import modelo.entidad.PedidoMateriaPrima;
import modelo.persistance.interfaces.DaoPedidoMateriaPrima;
import modelo.persistance.mysql.DaoPedidoMateriaPrimaMySql;

public class GestorPedidoMateriaPrima {
private DaoPedidoMateriaPrima daoPedidoMateriaPrima = new DaoPedidoMateriaPrimaMySql();
	
	
	public boolean insertar(PedidoMateriaPrima pmp) {
		
		boolean alta = daoPedidoMateriaPrima.insertar(pmp);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoPedidoMateriaPrima.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(PedidoMateriaPrima pmp) {
		
		boolean modificado = daoPedidoMateriaPrima.modificar(pmp);
			
			return modificado;
		}
	
	
	public PedidoMateriaPrima buscar(int id) {
		
		PedidoMateriaPrima pedidoMateriaPrima = daoPedidoMateriaPrima.buscar(id);
		
		return pedidoMateriaPrima;
	}
	
	public List<PedidoMateriaPrima> listar(){
		
		List<PedidoMateriaPrima> listaPedidoMateriaPrima = daoPedidoMateriaPrima.listar();
		
		return listaPedidoMateriaPrima;
	}

}
