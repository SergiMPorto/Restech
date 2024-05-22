package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Ingrediente;
import modelo.entidad.MateriaPrima;
import modelo.entidad.Plato;

public interface DaoPlato {
	
	public boolean insertar(Plato pl);
	public boolean insertarMateriaPrima(Plato pl);
	public boolean borrar(int id);
	public boolean borrarMateriaPrima(int idPlato);
	public boolean modificar(Plato pl);
	public Plato buscar(int id);
	public List<MateriaPrima> buscarMateriaPrima(int idPlato);
	public List<Plato> listar();
	public boolean borrarPlato(String nombre);

}
