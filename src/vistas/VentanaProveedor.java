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
	import javax.swing.table.DefaultTableModel;

	import controlador.ControladorEventos;

	public class VentanaProveedor {

	    private JFrame proveedor;
	    private JTable table;
	    private JScrollPane scrollPane;
	    private JTextField nombre;
	    private JTextField descripcion;
	    private JTextField telefono;
	    private JTextField direccion;
	    private JLabel lblNewLabel;
	    private JLabel lblNewLabel_1;
	    private JLabel lblNewLabel_2;
	    private JLabel lblNewLabel_3;
	    private JButton btnGuardar;
	    private JButton btnBorrar;

	    public VentanaProveedor(String nombre2, String descripcion2, String telefono2, String direccion2) {
	        initialize();
	    }

	    private void initialize() {
	        proveedor = new JFrame();
	        proveedor.setBounds(100, 100, 750, 750);
	        proveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        proveedor.getContentPane().setLayout(null);

	        table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Nombre", "Descripción", "Número de Contacto", "Dirección"}));
	        scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 70, 700, 281);
	        proveedor.getContentPane().add(scrollPane);

	        nombre = new JTextField();
	        nombre.setBounds(185, 382, 427, 27);
	        proveedor.getContentPane().add(nombre);
	        nombre.setColumns(10);

	        descripcion = new JTextField();
	        descripcion.setColumns(10);
	        descripcion.setBounds(185, 431, 427, 27);
	        proveedor.getContentPane().add(descripcion);

	        telefono = new JTextField();
	        telefono.setColumns(10);
	        telefono.setBounds(185, 482, 427, 27);
	        proveedor.getContentPane().add(telefono);

	        direccion = new JTextField();
	        direccion.setColumns(10);
	        direccion.setBounds(185, 526, 498, 27);
	        proveedor.getContentPane().add(direccion);

	        lblNewLabel = new JLabel("Nombre");
	        lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 20));
	        lblNewLabel.setBounds(109, 382, 91, 27);
	        proveedor.getContentPane().add(lblNewLabel);

	        lblNewLabel_1 = new JLabel("Descripción");
	        lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 20));
	        lblNewLabel_1.setBounds(81, 431, 119, 27);
	        proveedor.getContentPane().add(lblNewLabel_1);

	        lblNewLabel_2 = new JLabel("Teléfono");
	        lblNewLabel_2.setFont(new Font("Forte", Font.PLAIN, 20));
	        lblNewLabel_2.setBounds(94, 482, 119, 27);
	        proveedor.getContentPane().add(lblNewLabel_2);

	        lblNewLabel_3 = new JLabel("Dirección");
	        lblNewLabel_3.setFont(new Font("Forte", Font.PLAIN, 20));
	        lblNewLabel_3.setBounds(94, 529, 119, 20);
	        proveedor.getContentPane().add(lblNewLabel_3);

	        btnGuardar = new JButton("Guardar");
	        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        btnGuardar.setBounds(563, 664, 150, 27);
	        proveedor.getContentPane().add(btnGuardar);

	        btnBorrar = new JButton("Borrar");
	        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        btnBorrar.setBounds(403, 664, 150, 27);
	        proveedor.getContentPane().add(btnBorrar);
	    }

	    public JFrame getProveedor() {
	        return proveedor;
	    }

	    public void setProveedor(JFrame proveedor) {
	        this.proveedor = proveedor;
	    }

	    public JTextField getNombre() {
	        return nombre;
	    }

	    public void setNombre(JTextField nombre) {
	        this.nombre = nombre;
	    }

	    public JTextField getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(JTextField descripcion) {
	        this.descripcion = descripcion;
	    }

	    public JTextField getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(JTextField telefono) {
	        this.telefono = telefono;
	    }

	    public JTextField getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(JTextField direccion) {
	        this.direccion = direccion;
	    }

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

	    public void setVisible(boolean b) {
	        proveedor.setVisible(b);
	    }

	    public void iniciarListener(ControladorEventos controlador) {
	        btnGuardar.addActionListener(controlador);
	        btnBorrar.addActionListener(controlador);
	    }

	    @Override
	    public String toString() {
	        return "Proveedor [nombre=" + nombre + ", descripcion=" + descripcion + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    VentanaProveedor window = new VentanaProveedor();
	                    window.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	}