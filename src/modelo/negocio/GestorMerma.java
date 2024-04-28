package modelo.negocio;

import java.util.List;

import modelo.entidad.Merma;
import modelo.persistance.interfaces.DaoMerma;
import modelo.persistance.mysql.DaoMermaMySql;



public class GestorMerma {

private DaoMerma daoMerma = new DaoMermaMySql();
	
	
	public boolean insertar(Merma m) {
		
		boolean alta = daoMerma.insertar(m);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoMerma.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Merma m) {
		
		boolean modificado = daoMerma.modificar(m);
			
			return modificado;
		}
	
	
	public Merma buscar(int id) {
		
		Merma merma = daoMerma.buscar(id);
		
		return merma;
	}
	
	public List<Merma> listar(){
		
		List<Merma> listaMerma = daoMerma.listar();
		
		return listaMerma;
	}
}
