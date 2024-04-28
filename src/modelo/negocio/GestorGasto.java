package modelo.negocio;

import java.util.List;

import modelo.entidad.Gasto;
import modelo.persistance.interfaces.DaoGasto;
import modelo.persistance.mysql.DaoGastoMySql;



public class GestorGasto {
	
private DaoGasto daoGasto = new DaoGastoMySql();
	
	
	public boolean insertar(Gasto g) {
		
		boolean alta = daoGasto.insertar(g);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoGasto.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Gasto g) {
		
		boolean modificado = daoGasto.modificar(g);
			
			return modificado;
		}
	
	
	public Gasto buscar(int id) {
		
		Gasto gasto = daoGasto.buscar(id);
		
		return gasto;
	}
	
	public List<Gasto> listar(){
		
		List<Gasto> listaGasto = daoGasto.listar();
		
		return listaGasto;
	}

}
