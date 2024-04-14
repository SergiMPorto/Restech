package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.MateriaPrima;

public interface DaoMateriaPrima {
	
	public int insertar(MateriaPrima mp);
	public int borrar(int id);
	public MateriaPrima modificar(MateriaPrima mp);
	public MateriaPrima buscar(int id);
	public List<MateriaPrima> listar();

}
