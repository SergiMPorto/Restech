package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Plato;

public interface DaoPlato {
	
	public boolean insertar(Plato pl);
	public boolean borrar(int id);
	public boolean modificar(Plato pl);
	public Plato buscar(int id);
	public List<Plato> listar();

}
