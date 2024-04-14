package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Plato;

public interface DaoPlato {
	
	public int insertar(Plato pl);
	public int borrar(int id);
	public Plato modificar(Plato pl);
	public Plato buscar(int id);
	public List<Plato> listar();

}
