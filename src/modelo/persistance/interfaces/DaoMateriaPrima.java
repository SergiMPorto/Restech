package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.MateriaPrima;

public interface DaoMateriaPrima {
	
	public boolean insertar(MateriaPrima mp);
	public boolean borrar(int id);
	public boolean modificar(MateriaPrima mp);
	public MateriaPrima buscar(int id);
	public List<MateriaPrima> listar();

}
