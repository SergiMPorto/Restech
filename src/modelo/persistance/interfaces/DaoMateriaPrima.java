package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.MateriaPrima;

public interface DaoMateriaPrima {
	
	boolean insertar(MateriaPrima mp);
    boolean borrar(int id);
    boolean modificar(MateriaPrima mp);
    MateriaPrima buscar(int id);
    List<MateriaPrima> listar();
    public int obtenerIdMateriaPrima(String nombreMateriaPrima);

}
