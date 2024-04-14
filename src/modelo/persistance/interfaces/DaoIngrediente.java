package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Ingrediente;

public interface DaoIngrediente {
	
	public int insertar(Ingrediente i);
	public int borrar(int id);
	public Ingrediente modificar(Ingrediente i);
	public Ingrediente buscar(int id);
	public List<Ingrediente> listar();

}
