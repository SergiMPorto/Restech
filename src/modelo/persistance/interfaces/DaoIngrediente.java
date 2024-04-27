package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Ingrediente;

public interface DaoIngrediente {
	
	public boolean insertar(Ingrediente i);
    public boolean borrar(int id);
    public boolean modificar(Ingrediente i);
    public Ingrediente buscar(int id);
    public List<Ingrediente> listar();

}
