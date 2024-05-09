package modelo.negocio;

import java.util.List;

import modelo.entidad.Pedido;
import modelo.persistance.interfaces.DaoPedido;
import modelo.persistance.mysql.DaoPedidoMySql;

public class GestorPedido {
	
	private DaoPedido daoPedido = new DaoPedidoMySql();
	
	
	public boolean insertar(Pedido p) {
		
		boolean alta = daoPedido.insertar(p);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoPedido.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Pedido p) {
		
		boolean modificado = daoPedido.modificar(p);
			
			return modificado;
		}
	
	
	public Pedido buscar(int id) {
		
		Pedido pedido = daoPedido.buscar(id);
		
		return pedido;
	}
	
	public List<Pedido> listar(){
		
		List<Pedido> listaPedido = daoPedido.listar();
		
		return listaPedido;
	}

}
