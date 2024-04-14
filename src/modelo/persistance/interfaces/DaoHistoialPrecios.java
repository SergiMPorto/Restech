package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.HistorialPrecio;

public interface DaoHistoialPrecios {
	
	public int insertar(HistorialPrecio hp);
	public int borrar(int id);
	public HistorialPrecio modificar(HistorialPrecio hp);
	public HistorialPrecio buscar(int id);
	public List<HistorialPrecio> listar();

}
