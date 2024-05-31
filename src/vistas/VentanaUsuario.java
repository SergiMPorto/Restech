package vistas;


import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.table.TableColumn;

import controlador.ControladorEventos;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoProveedorMySql;
import modelo.persistance.mysql.DaoUsuarioMySql;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class VentanaUsuario {

	private JFrame frmUsuario;
	private JTextField textNombre;
	private JButton btnBorrar;
	private JLabel lblNewLabel_3;
	private JTextField Permiso;
	private JLabel lblPermiso;
	private JButton btnGuardar;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField Codigo;
	private JLabel lblNewLabel;



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
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
		frmUsuario.getContentPane().setBackground(new Color(54,217,187));
		frmUsuario.getContentPane().setForeground(new Color(54,217,187));
		frmUsuario.setForeground(new Color(102, 153, 204));
		frmUsuario.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		frmUsuario.setTitle("PLATO");
		frmUsuario.setBounds(750, 50, 750, 750);
		frmUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		frmUsuario.setResizable(false);
		
		 // Add window listener to clear fields on close
        frmUsuario.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                limpiarCampos();
            }
        });
		
		
		table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Id","Nombre", "Permiso", "Codigo"}));
		
		//Cambiar tamaño columnas
		table.setPreferredScrollableViewportSize(new Dimension(750,400));
		
		TableColumn column = null;
		 for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            if (i == 0) {
	                column.setPreferredWidth(50); 
	            } else if (i == 1) {
	                column.setPreferredWidth(300); 
	            } else if (i == 2) {
	                column.setPreferredWidth(50); 
	            } else if (i == 3) {
	                column.setPreferredWidth(150); 
	            }
		 }
		
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(14, 332, 712, 267);
        frmUsuario.getContentPane().add(scrollPane);
		
		JLabel Nombre = new JLabel("NOMBRE");
		Nombre.setForeground(new Color(0, 0, 0));
		Nombre.setFont(new Font("DialogInput", Font.BOLD, 20));
		
		Nombre.setBounds(220, 176, 75, 27);
		frmUsuario.getContentPane().add(Nombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(305, 176, 400, 27);
		frmUsuario.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		
	    btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnGuardar.setBounds(466, 630, 125, 30);
		frmUsuario.getContentPane().add(btnGuardar);
		
		btnBorrar = new JButton("BORRAR");
		
		btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnBorrar.setBounds(601, 630, 125, 30);
		frmUsuario.getContentPane().add(btnBorrar);
		
		lblNewLabel_3 = new JLabel("USUARIO");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblNewLabel_3.setBounds(292, 49, 221, 47);
		frmUsuario.getContentPane().add(lblNewLabel_3);
		
		Permiso = new JTextField();
		Permiso.setColumns(10);
		Permiso.setBounds(305, 227, 55, 27);
		frmUsuario.getContentPane().add(Permiso);
		
		lblPermiso = new JLabel("PERMISO");
	    lblPermiso.setForeground(new Color(0, 0, 0));
		lblPermiso.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblPermiso.setBounds(207, 227, 88, 27);
		frmUsuario.getContentPane().add(lblPermiso);
		
		Codigo = new JTextField();
		Codigo.setColumns(10);
		Codigo.setBounds(305, 276, 150, 27);
		frmUsuario.getContentPane().add(Codigo);
		
		JLabel lblCdigo = new JLabel("CÓDIGO");
		lblCdigo.setForeground(new Color(0, 0, 0));
		lblCdigo.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblCdigo.setBounds(223, 276, 72, 27);
		frmUsuario.getContentPane().add(lblCdigo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
		lblNewLabel.setBounds(661, 0, 75, 75);
		frmUsuario.getContentPane().add(lblNewLabel);
		
	}

	
	
	

	public void setVisible(boolean b) {
		frmUsuario.setVisible(b);
		
		
		   
	}
	
	// Getter and Setter
	
	
	

	public JTable getTable() {
		return table;
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
		return "VentanaUsuario [textNombre=" + textNombre + ", Permiso=" + Permiso
				+ ", lblPermiso=" + lblPermiso + "]";
	}




	public VentanaUsuario(JTextField textNombre, JTextField permiso, JTextField codigo) {
		super();
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
    
 // Método para limpiar los campos
    public void limpiarCampos() {
        textNombre.setText("");
        Permiso.setText("");
        Codigo.setText("");
    }
}