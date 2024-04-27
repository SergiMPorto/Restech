package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Pedido;

public interface DaoPedido {
	
	public boolean insertar(Pedido pd);
	public boolean borrar(int id);
	public boolean modificar(Pedido pd);
	public Pedido buscar(int id);
	public List<Pedido> listar();

}
