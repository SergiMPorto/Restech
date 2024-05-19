package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Ingrediente;
import modelo.entidad.Plato;

public interface DaoPlato {
	
	public boolean insertar(Plato pl);
	public boolean insertarIngredientes(Plato pl);
	public boolean borrar(int id);
	public boolean modificar(Plato pl);
	public Plato buscar(int id);
	public List<Ingrediente> buscarIngredientes(int idPlato);
	public List<Plato> listar();

}
