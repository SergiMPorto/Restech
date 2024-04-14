package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Pedido;

public interface DaoPedido {
	
	public int insertar(Pedido pd);
	public int borrar(int id);
	public Pedido modificar(Pedido pd);
	public Pedido buscar(int id);
	public List<Pedido> listar();

}
