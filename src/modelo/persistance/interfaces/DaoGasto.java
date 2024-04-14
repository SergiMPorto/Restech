package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Gasto;

public interface DaoGasto {
	
	public int insertar(Gasto g);
	public int borrar(int id);
	public Gasto modificar(Gasto g);
	public Gasto buscar(int id);
	public List<Gasto> listar();

}
