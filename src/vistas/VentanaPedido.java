package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

import controlador.ControladorEventos;
import modelo.entidad.Proveedor;


public class VentanaPedido  {

    private JFrame frmPedido;
    private JButton btnAnadir;
    private JButton btnGuardar;
    private JButton btnBorrar;
    private JTextField Producto;
    private JTextField Cantidad;
    private JTextField Precio;
    private JComboBox combo;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JLabel lblNewLabel_2;
    JButton btnGastos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPedido window = new VentanaPedido();    
                    //window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public VentanaPedido() {
        initialize();
        frmPedido.setVisible(true);  // no borrar, si no no funciona MainPedido
    }
   	/**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	
        frmPedido = new JFrame();
        frmPedido.setBackground(Color.WHITE);
        frmPedido.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPedido.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
        frmPedido.setTitle("Pedido");
        frmPedido.getContentPane().setBackground(new Color(54,217,187));
        frmPedido.getContentPane().setForeground(new Color(54,217,187));
        frmPedido.setBounds(730, 50, 750, 750);
        frmPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPedido.getContentPane().setLayout(null);
        frmPedido.setResizable(false);

        

        // Inicializar el DefaultTableModel
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID","Usuario","Proveedor","Producto", "Cantidad", "Precio", "Fecha Pedido"});
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(750,400));
        
        TableColumn column = null;
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> column.setPreferredWidth(5);
                case 1 -> column.setPreferredWidth(5);
                case 2 -> column.setPreferredWidth(75);
                case 3 -> column.setPreferredWidth(100);
                case 4, 5 -> column.setPreferredWidth(10);
                case 6 -> column.setPreferredWidth(75);
            }
        }
        
        

        
        
  /*      String[] nombreColumnas = {"ID","Usuario","Proveedor","Producto", "Cantidad", "Precio", "Fecha Pedido"};
        tableModel = new DefaultTableModel(nombreColumnas, 0);
      
        table = new JTable(tableModel);
*/        

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 308, 716, 322);
        frmPedido.getContentPane().add(scrollPane);
        
        
        String[] proveedores = { };
        combo = new JComboBox(proveedores);
        combo.setBounds(226, 97, 427, 27);
        frmPedido.getContentPane().add(combo);



        btnAnadir = new JButton("Añadir");
        btnAnadir.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnAnadir.setBounds(331, 657, 125, 30);
        frmPedido.getContentPane().add(btnAnadir);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(new Color(0, 0, 0));
        
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(466, 657, 125, 30);
        frmPedido.getContentPane().add(btnGuardar);
          
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(601, 657, 125, 30);
        frmPedido.getContentPane().add(btnBorrar);
        
        JLabel lblNewLabel = new JLabel("Proveedor");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel.setBounds(109, 94, 119, 30);
        frmPedido.getContentPane().add(lblNewLabel);
        
        Producto = new JTextField();
        Producto.setColumns(10);
        Producto.setBounds(226, 134, 427, 27);
        frmPedido.getContentPane().add(Producto);
        
        Cantidad = new JTextField();
        Cantidad.setColumns(10);
        Cantidad.setBounds(226, 171, 119, 27);
        frmPedido.getContentPane().add(Cantidad);
        
        Precio = new JTextField();
        Precio.setColumns(10);
        Precio.setBounds(226, 208, 119, 27);
        frmPedido.getContentPane().add(Precio);
        
        JLabel lblNewLabel_1 = new JLabel("Producto");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_1.setBounds(116, 134, 100, 27);
        frmPedido.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(116, 167, 100, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
        lblNewLabel_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_1.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_1_1_1.setBounds(131, 204, 85, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1_1);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
        lblNewLabel_2.setBounds(661, 0, 75, 75);
        frmPedido.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("PEDIDO");
        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel_3.setBounds(285, 17, 199, 63);
        frmPedido.getContentPane().add(lblNewLabel_3);
        
        btnGastos = new JButton("Gestión Gastos");
        btnGastos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGastos.setBounds(577, 268, 157, 30);
        frmPedido.getContentPane().add(btnGastos);
    }
   
    
	
	 public JButton getBtnGastos() {
		return btnGastos;
	}
	public void setBtnGastos(JButton btnGastos) {
		this.btnGastos = btnGastos;
	}
	public void setVisible(boolean b) {
	        frmPedido.setVisible(b);
	    }
	 
	//Getter and Setter
	
	public JFrame getFrmPedido() {
		return frmPedido;
	}

	public void setFrmPedido(JFrame frmPedido) {
		this.frmPedido = frmPedido;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAñadir) {
		this.btnAnadir = btnAñadir;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}
	

	public JTextField getProducto() {
		return Producto;
	}

	public void setProducto(JTextField producto) {
		Producto = producto;
	}

	public JTextField getCantidad() {
		return Cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		Cantidad = cantidad;
	}

	public JTextField getPrecio() {
		return Precio;
	}

	public void setPrecio(JTextField precio) {
		Precio = precio;
	}

	public JComboBox getCombo() {
		return combo;
	}

	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	


	public void establecerControlador(ControladorEventos controladorEventosPedido) {
		combo.addActionListener(controladorEventosPedido);
		btnAnadir.addActionListener(controladorEventosPedido);
		btnBorrar.addActionListener(controladorEventosPedido);
		btnGuardar.addActionListener(controladorEventosPedido);
		btnGastos.addActionListener(controladorEventosPedido);
	}
	 public void cargarProveedoresEnCombo(List<Proveedor> proveedores) {
	        combo.removeAllItems();
	        for (Proveedor proveedor : proveedores) {
	            combo.addItem(proveedor.getNombre());
	        }
	    }
}
