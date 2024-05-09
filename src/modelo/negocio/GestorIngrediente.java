package modelo.negocio;

import java.util.List;

import modelo.entidad.Ingrediente;
import modelo.persistance.interfaces.DaoIngrediente;
import modelo.persistance.mysql.DaoIngredienteMySql;

public class GestorIngrediente {
	
private DaoIngrediente daoIngrediente = new DaoIngredienteMySql();
	
	
	public boolean insertar(Ingrediente i) {
		
		boolean alta = daoIngrediente.insertar(i);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoIngrediente.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Ingrediente i) {
		
		boolean modificado = daoIngrediente.modificar(i);
			
			return modificado;
		}
	
	
	public Ingrediente buscar(int id) {
		
		Ingrediente ingrediente = daoIngrediente.buscar(id);
		
		return ingrediente;
	}
	
	public List<Ingrediente> listar(){
		
		List<Ingrediente> listaIngrediente = daoIngrediente.listar();
		
		return listaIngrediente;
	}

}
