package modelo.negocio;

import java.util.List;

import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoUsuario;
import modelo.persistance.mysql.DaoUsuarioMySql;

public class GestorUsuario {
	
private DaoUsuario daoUsuario = new DaoUsuarioMySql();
	
	
	public boolean insertar(Usuario u) {
		
		boolean alta = daoUsuario.insertar(u);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoUsuario.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Usuario u) {
		
		boolean modificado = daoUsuario.modificar(u);
			
			return modificado;
		}
	
	
	public Usuario buscar(int id) {
		
		Usuario usuario = daoUsuario.buscar(id);
		
		return usuario;
	}
	
	public List<Usuario> listar(){
		
		List<Usuario> listaUsuario = daoUsuario.listar();
		
		return listaUsuario;
	}

}
