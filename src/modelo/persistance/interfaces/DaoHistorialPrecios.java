package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.HistorialPrecio;

public interface DaoHistorialPrecios {
	
	public boolean insertar(HistorialPrecio hp);
	public boolean borrar(int id);
	public boolean modificar(HistorialPrecio hp);
	public HistorialPrecio buscar(int id);
	public List<HistorialPrecio> listar();

}
