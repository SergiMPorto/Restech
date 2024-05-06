package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.HistorialPrecio;

public interface DaoHistorialPrecios {
	
	boolean insertar(HistorialPrecio hp);
    boolean borrar(int id);
    boolean modificar(HistorialPrecio hp);
    HistorialPrecio buscar(int id);
    List<HistorialPrecio> listar();


}
