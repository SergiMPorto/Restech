package vistas;

import java.awt.Color;
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
        frmPedido.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPedido.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        frmPedido.setTitle("Pedido");
        frmPedido.getContentPane().setBackground(new Color(56, 61, 67));
        frmPedido.getContentPane().setForeground(new Color(56, 61, 67));
        frmPedido.setBounds(730, 50, 750, 750);
        frmPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPedido.getContentPane().setLayout(null);
        frmPedido.setResizable(false);
        

        table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"ID","Usuario","Proveedor","Producto", "Cantidad", "Precio", "Fecha Pedido"}));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 325, 700, 322);
        frmPedido.getContentPane().add(scrollPane);


        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.GRAY);
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(460, 657, 100, 30);
        frmPedido.getContentPane().add(btnGuardar);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(570, 657, 100, 30);
        frmPedido.getContentPane().add(btnBorrar);
        
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
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        lblNewLabel_2.setBounds(41, 42, 56, 46);
        frmPedido.getContentPane().add(lblNewLabel_2);
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
