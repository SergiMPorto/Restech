package modelo.negocio;

import java.util.List;

import modelo.entidad.Plato;
import modelo.persistance.interfaces.DaoPlato;
import modelo.persistance.mysql.DaoPlatoMySql;


public class GestorPlato {
private DaoPlato daoPlato = new DaoPlatoMySql();
	
	
	public boolean insertar(Plato p) {
		
		boolean alta = daoPlato.insertar(p);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoPlato.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Plato p) {
		
		boolean modificado = daoPlato.modificar(p);
			
			return modificado;
		}
	
	
	public Plato buscar(int id) {
		
		Plato plato = daoPlato.buscar(id);
		
		return plato;
	}
	
	public List<Plato> listar(){
		
		List<Plato> listaPlato = daoPlato.listar();
		
		return listaPlato;
	}
}
