package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
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

public class VentanaPedido {

    private JFrame frmPedido;
    private JButton btnGuardar;
    private JButton btnBorrar;
    private JTextField Producto;
    private JTextField Cantidad;
    private JTextField Precio;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel lblNewLabel_2;

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
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPedido = new JFrame();
        frmPedido.setBackground(Color.WHITE);
        frmPedido.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPedido.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        frmPedido.setTitle("Pedido");
        frmPedido.getContentPane().setBackground(new Color(41,166,153));
        frmPedido.getContentPane().setForeground(new Color(41,166,153));
        frmPedido.setBounds(730, 50, 750, 750);
        frmPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPedido.getContentPane().setLayout(null);
        frmPedido.setResizable(false);
        

        table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"ID","Usuario","Proveedor","Producto", "Cantidad", "Precio", "Fecha Pedido"}));
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
        
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 325, 700, 322);
        frmPedido.getContentPane().add(scrollPane);


        btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(Color.BLACK);
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(460, 657, 100, 30);
        frmPedido.getContentPane().add(btnGuardar);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(570, 657, 100, 30);
        frmPedido.getContentPane().add(btnBorrar);
        
        JLabel lblNewLabel = new JLabel("Proveedor");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
        lblNewLabel.setBounds(125, 94, 119, 30);
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
        lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(135, 134, 83, 27);
        frmPedido.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Cambria", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(133, 171, 83, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
        lblNewLabel_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_1.setFont(new Font("Cambria", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(160, 208, 56, 27);
        frmPedido.getContentPane().add(lblNewLabel_1_1_1);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
        lblNewLabel_2.setBounds(10, 10, 75, 75);
        frmPedido.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("PEDIDO");
        lblNewLabel_3.setFont(new Font("Constantia", Font.BOLD, 33));
        lblNewLabel_3.setBounds(285, 17, 150, 49);
        frmPedido.getContentPane().add(lblNewLabel_3);
    }
    
    //Getter and Setter

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

	public void setVisible(boolean b) {
        frmPedido.setVisible(b);
    }

	public VentanaPedido(JTextField producto, JTextField cantidad, JTextField precio) {
		super();
		Producto = producto;
		Cantidad = cantidad;
		Precio = precio;
	}
}
