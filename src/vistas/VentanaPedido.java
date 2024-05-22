package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEventosPedido;


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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPedido window = new VentanaPedido();    
                    window.setVisible(true);
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
        frmPedido.setTitle("Pedido");
        frmPedido.getContentPane().setBackground(new Color(56, 61, 67));
        frmPedido.getContentPane().setForeground(new Color(56, 61, 67));
        frmPedido.setBounds(730, 50, 750, 750);
        frmPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPedido.getContentPane().setLayout(null);
        frmPedido.setResizable(false);
        
        
        String[] nombreColumnas = {"ID","Usuario","Proveedor","Producto", "Cantidad", "Precio", "Fecha Pedido"};
        tableModel = new DefaultTableModel(nombreColumnas, 0);
      
        table = new JTable(tableModel);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 325, 700, 322);
        frmPedido.getContentPane().add(scrollPane);
        
        
        String[] proveedores = { "elemento 1", "elemento 2", "elemento 3",
        		"elemento 4", "elemento 5" };
        combo = new JComboBox(proveedores);
        combo.setBounds(226, 97, 427, 27);
        frmPedido.getContentPane().add(combo);


        btnAnadir = new JButton("Añadir");
        btnAnadir.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnAnadir.setBounds(350, 657, 100, 30);
        frmPedido.getContentPane().add(btnAnadir);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(460, 657, 100, 30);
        frmPedido.getContentPane().add(btnBorrar);
          
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(570, 657, 100, 30);
        frmPedido.getContentPane().add(btnGuardar);
        
        JLabel lblNewLabel = new JLabel("Proveedor");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 20));
        lblNewLabel.setBounds(125, 97, 95, 27);
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
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(125, 134, 95, 27);
        frmPedido.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Forte", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(125, 171, 95, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Forte", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(125, 208, 95, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1_1);
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
	


	public void establecerControlador(ControladorEventosPedido controladorEventosPedido) {
		combo.addActionListener(controladorEventosPedido);
		btnAnadir.addActionListener(controladorEventosPedido);
		btnBorrar.addActionListener(controladorEventosPedido);
		btnGuardar.addActionListener(controladorEventosPedido);
	}

	
}
