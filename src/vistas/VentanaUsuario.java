package vistas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEventos;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoProveedorMySql;
import modelo.persistance.mysql.DaoUsuarioMySql;

import javax.swing.JFrame;

public class VentanaUsuario {

	private JFrame frmUsuario;
	private JTextField textID;
	private JTextField textNombre;
	private JButton btnBorrar;
	private JLabel lblNewLabel_3;
	private JTextField Permiso;
	private JLabel lblPermiso;
	private JButton btnGuardar;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblId;
	private JTextField Codigo;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
					window.frmUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUsuario= new JFrame();
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Restech\\Imagenes\\RESTECHVENTANA.jpg"));
		frmUsuario.getContentPane().setBackground(new Color(56, 61, 67));
		frmUsuario.getContentPane().setForeground(new Color(56, 61, 67));
		frmUsuario.setForeground(new Color(102, 153, 204));
		frmUsuario.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		frmUsuario.setTitle("PLATO");
		frmUsuario.setBounds(750, 50, 750, 750);
		frmUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		frmUsuario.setResizable(false);
		
		
		table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Id","Nombre", "Permiso", "Codigo"}));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(14, 332, 700, 265);
        frmUsuario.getContentPane().add(scrollPane);
		
		JLabel Nombre = new JLabel("NOMBRE");
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(new Color(255, 255, 255));
		Nombre.setFont(new Font("Forte", Font.BOLD, 20));
		Nombre.setBounds(187, 176, 117, 27);
		frmUsuario.getContentPane().add(Nombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(314, 176, 400, 27);
		frmUsuario.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		Nombre.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		
	    btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(Color.GRAY);
		btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setBounds(410, 630, 150, 27);
		frmUsuario.getContentPane().add(btnGuardar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(Color.GRAY);
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnBorrar.setBounds(570, 630, 150, 27);
		frmUsuario.getContentPane().add(btnBorrar);
		
		lblNewLabel_3 = new JLabel("USUARIO");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_3.setBounds(320, 53, 462, 47);
		frmUsuario.getContentPane().add(lblNewLabel_3);
		
		Permiso = new JTextField();
		Permiso.setColumns(10);
		Permiso.setBounds(314, 227, 55, 27);
		frmUsuario.getContentPane().add(Permiso);
		
		lblPermiso = new JLabel("PERMISO");
	    lblPermiso.setForeground(new Color(255, 255, 255));
		lblPermiso.setFont(new Font("Forte", Font.BOLD, 20));
		lblPermiso.setBounds(204, 224, 90, 27);
		frmUsuario.getContentPane().add(lblPermiso);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(314, 131, 55, 27);
		frmUsuario.getContentPane().add(textID);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Forte", Font.BOLD, 20));
		lblId.setBounds(259, 131, 55, 30);
		frmUsuario.getContentPane().add(lblId);
		
		Codigo = new JTextField();
		Codigo.setColumns(10);
		Codigo.setBounds(314, 276, 150, 27);
		frmUsuario.getContentPane().add(Codigo);
		
		JLabel lblCdigo = new JLabel("CÓDIGO");
		lblCdigo.setForeground(new Color(255, 255, 255));
		lblCdigo.setFont(new Font("Forte", Font.BOLD, 20));
		lblCdigo.setBounds(204, 276, 90, 27);
		frmUsuario.getContentPane().add(lblCdigo);
		
	}

	
	
	

	public void setVisible(boolean b) {
		frmUsuario.setVisible(b);
		
		
		   
	}
	
	// Getter and Setter
	
	
	

	public JTable getTable() {
		return table;
	}

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JFrame getFrmUsuario() {
		return frmUsuario;
	}

	public void setFrmUsuario(JFrame frmUsuario) {
		this.frmUsuario = frmUsuario;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	public JTextField getPermiso() {
		return Permiso;
	}

	public JTextField getCodigo() {
		return Codigo;
	}

	public void setCodigo(JTextField codigo) {
		Codigo = codigo;
	}

	public void setPermiso(JTextField permiso) {
		Permiso = permiso;
	}

	public JLabel getLblPermiso() {
		return lblPermiso;
	}

	public void setLblPermiso(JLabel lblPermiso) {
		this.lblPermiso = lblPermiso;
	}

	@Override
	public String toString() {
		return "VentanaUsuario [textID=" + textID + ", textNombre=" + textNombre + ", Permiso=" + Permiso
				+ ", lblPermiso=" + lblPermiso + "]";
	}



	public VentanaUsuario(JTextField textID, JTextField textNombre, JTextField permiso, JTextField codigo) {
		super();
		this.textID = textID;
		this.textNombre = textNombre;
		Permiso = permiso;
		Codigo = codigo;
	}

	public void inciarListener(ControladorEventos controladorEventos) {
		btnGuardar.addActionListener(controladorEventos);
		btnBorrar.addActionListener(controladorEventos);
		
	}
	
    public void llenarTabla(List<Usuario> listaUsuario) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (Usuario pv : listaUsuario) {
            modelo.addRow(new Object[]{pv.getId(), pv.getNombre(), pv.getPermisos() ,pv.getCodigo() });
        }
    }
    
    public void cargarUsuario() {
        DaoUsuarioMySql daoUsuario = new DaoUsuarioMySql();
        List<Usuario> listaUsuario = daoUsuario.listar();
        llenarTabla(listaUsuario);
    }
}