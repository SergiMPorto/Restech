package modelo.negocio;

import java.util.List;

import modelo.entidad.MateriaPrima;
import modelo.persistance.interfaces.DaoMateriaPrima;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;

public class GestorMateriaPrima {
private DaoMateriaPrima daoMateriaPrima = new DaoMateriaPrimaMySql();
	
	
	public boolean insertar(MateriaPrima mp) {
		
		boolean alta = daoMateriaPrima.insertar(mp);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoMateriaPrima.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(MateriaPrima mp) {
		
		boolean modificado = daoMateriaPrima.modificar(mp);
			
			return modificado;
		}
	
	
	public MateriaPrima buscar(int id) {
		
		MateriaPrima materiaPrima = daoMateriaPrima.buscar(id);
		
		return materiaPrima;
	}
	
	public List<MateriaPrima> listar(){
		
		List<MateriaPrima> listaMateriaPrima = daoMateriaPrima.listar();
		
		return listaMateriaPrima;
	}
}
