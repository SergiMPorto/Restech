package modelo.negocio;

import java.util.List;

import modelo.entidad.HistorialPrecio;
import modelo.persistance.interfaces.DaoHistorialPrecios;
import modelo.persistance.mysql.DaoHistorialPreciosMySql;
public class GestorHistorialPrecio {
	
private DaoHistorialPrecios daoHistorialPrecio = new DaoHistorialPreciosMySql();
	
	
	public boolean insertar(HistorialPrecio hp) {
		
		boolean alta = daoHistorialPrecio.insertar(hp);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoHistorialPrecio.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(HistorialPrecio hp) {
		
		boolean modificado = daoHistorialPrecio.modificar(hp);
			
			return modificado;
		}
	
	
	public HistorialPrecio buscar(int id) {
		
		HistorialPrecio historialPrecio = daoHistorialPrecio.buscar(id);
		
		return historialPrecio;
	}
	
	public List<HistorialPrecio> listar(){
		
		List<HistorialPrecio> listaHistorialPrecio = daoHistorialPrecio.listar();
		
		return listaHistorialPrecio;
	}
}
