package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoUsuario;

public class DaoUsuarioMySql implements DaoUsuario {
	
	private Connection conexion;

    private boolean abrirConexion() {

        String url = "jdbc:mysql://localhost:3306/bbdd";
        		

        String usuario = "root";
        String password = "";
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insertar(Usuario u) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertado = true;
        String query = "INSERT INTO usuarios (nombre, permisos, codigo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getPermisos());
            ps.setString(3,u.getCodigo());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Usuario: " + u);
            insertado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return insertado;
    }
    
    @Override
    public int insertarDevolucionId(Usuario u) {
        if (!abrirConexion()) {
            return -1; // Devolver -1 si hay un error al abrir la conexión
        }

        int idAsignado = -1; // Valor por defecto si la inserción falla
        String query = "INSERT INTO usuarios (nombre, permisos, codigo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS); // Obtener las claves generadas
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getPermisos());
            ps.setString(3, u.getCodigo());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas > 0) {
                ResultSet rs = ps.getGeneratedKeys(); // Obtener las claves generadas
                if (rs.next()) {
                    idAsignado = rs.getInt(1); // Obtener el ID asignado
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Usuario: " + u);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return idAsignado; // Devolver el ID asignado
    }


    @Override
    public boolean borrar(int id) {
        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar Usuario con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(Usuario u) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE usuarios SET nombre = ?, permisos = ?, codigo = ? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getPermisos());
            ps.setString(3, u.getCodigo());
            ps.setInt(4, u.getId());
           

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar Usuario: " + u);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public Usuario buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Usuario u = null;
        String query = "SELECT id_usuario, nombre, permisos, codigo FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setPermisos(rs.getInt("permisos"));
                u.setCodigo(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar Usuario con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return u;
    }

    @Override
    public List<Usuario> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Usuario> listaUsuarios = new ArrayList<>();
        String query = "SELECT id_usuario, nombre, permisos, codigo FROM usuarios";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setPermisos(rs.getInt("permisos"));
                u.setCodigo(rs.getString("codigo"));
                listaUsuarios.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Usuarios");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaUsuarios;
    }
    
    
   

	@Override
	public int obtenerPermisoPorId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscarNombre(String nombre) {
	    if (!abrirConexion()) {
	        return null;
	    }

	    Usuario u = null;
	    String query = "SELECT id_usuario, codigo, nombre, permisos FROM usuarios WHERE nombre = ?";
	    try {
	        PreparedStatement ps = conexion.prepareStatement(query);
	        ps.setString(1, nombre); 

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            u = new Usuario();
	            u.setId(rs.getInt("id_usuario"));
	            u.setNombre(rs.getString("nombre"));
	            u.setPermisos(rs.getInt("permisos"));
	            u.setCodigo(rs.getString("codigo"));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al buscar Usuario con nombre " + nombre);
	        e.printStackTrace();
	    } finally {
	        cerrarConexion();
	    }

	    return u;
	}

	public int buscarIdUsuarioPorNombre(String nombreUsuario) {
	    if (!abrirConexion()) {
	        return -1; // Devolver un valor por defecto o lanzar una excepción, dependiendo de tus necesidades
	    }

	    int idUsuario = -1; // Valor por defecto si no se encuentra el usuario

	    String query = "SELECT id_usuario FROM usuarios WHERE nombre = ?";
	    try (PreparedStatement ps = conexion.prepareStatement(query)) {
	        ps.setString(1, nombreUsuario);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            idUsuario = rs.getInt("id_usuario");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al buscar ID de usuario por nombre: " + nombreUsuario);
	        e.printStackTrace();
	    } finally {
	        cerrarConexion();
	    }
	    return idUsuario;
	}

	


}
