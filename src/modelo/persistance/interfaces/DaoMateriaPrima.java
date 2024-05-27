package modelo.persistance.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.entidad.MateriaPrima;

public interface DaoMateriaPrima {
	
	boolean insertar(MateriaPrima mp);
    boolean borrar(int id);
    boolean modificar(MateriaPrima mp);
    MateriaPrima buscar(int id);
    List<MateriaPrima> listar();
    public int obtenerIdMateriaPrima(String nombreMateriaPrima);
    public MateriaPrima obtenerPorNombre(String nombre);
    public boolean actualizarCantidadUtilizada(int id, float nuevaCantidad);

}
