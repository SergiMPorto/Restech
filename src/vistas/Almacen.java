package vistas;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEventos;
import modelo.entidad.MateriaPrima;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Almacen {

	private JFrame frame;
    private JFrame almacen;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnBorrar;
  
    private JLabel lblNewLabel_3;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextField ID;
    private JTextField Producto;
    private JTextField Cantidad;
    private JTextField FechaCaducidad;
    private JTextField Precio;
    private JTextField Proveedor;
    private JTextField Merma;
    private JLabel lblNewLabel;
  

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Almacen window = new Almacen();
                    window.almacen.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Almacen() {
        initialize();
    }

    private void initialize() {
        almacen = new JFrame();
        almacen.setBounds(700, 70, 750, 750);
        almacen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        almacen.getContentPane().setLayout(null);
        almacen.getContentPane().setBackground(new Color(56, 61, 67));
        almacen.setResizable(false);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(275, 653, 150, 27);
        almacen.getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnCancelar.setBounds(570, 653, 150, 27);
        almacen.getContentPane().add(btnCancelar);

        lblNewLabel_3 = new JLabel("Almacén");
        lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 45));
        lblNewLabel_3.setBounds(286, 21, 185, 47);
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        almacen.getContentPane().add(lblNewLabel_3);

        // Inicializar la tabla con un DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, 
            new String[] { "ID", "Producto", "Precio", "Proveedor", "Fecha Caducidad", "Cantidad Utilizada", "Merma" }
        );
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 70, 700, 281);
        almacen.getContentPane().add(scrollPane);

        Producto = new JTextField();
        Producto.setBounds(203, 426, 222, 27);
        almacen.getContentPane().add(Producto);
        Producto.setColumns(10);

        Cantidad = new JTextField();
        Cantidad.setBounds(203, 574, 63, 27);
        almacen.getContentPane().add(Cantidad);
        Cantidad.setColumns(10);

        FechaCaducidad = new JTextField();
        FechaCaducidad.setBounds(203, 537, 115, 27);
        almacen.getContentPane().add(FechaCaducidad);
        FechaCaducidad.setColumns(10);

        JLabel JlProducto = new JLabel("Producto");
        JlProducto.setForeground(new Color(255, 255, 255));
        JlProducto.setFont(new Font("Forte", Font.ITALIC, 20));
        JlProducto.setBounds(110, 429, 341, 20);
        almacen.getContentPane().add(JlProducto);

        JLabel JlCantidad = new JLabel("Cantidad");
        JlCantidad.setForeground(new Color(255, 255, 255));
        JlCantidad.setFont(new Font("Forte", Font.PLAIN, 20));
        JlCantidad.setBounds(110, 581, 115, 20);
        almacen.getContentPane().add(JlCantidad);

        JLabel FechaCaducidad_1 = new JLabel("Fecha Caducidad");
        FechaCaducidad_1.setForeground(new Color(255, 255, 255));
        FechaCaducidad_1.setFont(new Font("Forte", Font.PLAIN, 20));
        FechaCaducidad_1.setBounds(43, 533, 150, 35);
        almacen.getContentPane().add(FechaCaducidad_1);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(435, 653, 125, 27);
        almacen.getContentPane().add(btnBorrar);

        Precio = new JTextField();
        Precio.setBounds(203, 463, 96, 27);
        almacen.getContentPane().add(Precio);
        Precio.setColumns(10);

        Proveedor = new JTextField();
        Proveedor.setBounds(203, 500, 96, 27);
        almacen.getContentPane().add(Proveedor);
        Proveedor.setColumns(10);

        Merma = new JTextField();
        Merma.setColumns(10);
        Merma.setBounds(203, 611, 63, 27);
        almacen.getContentPane().add(Merma);

        JLabel JlPrecio = new JLabel("Precio");
        JlPrecio.setForeground(new Color(255, 255, 255));
        JlPrecio.setFont(new Font("Forte", Font.PLAIN, 20));
        JlPrecio.setBounds(140, 470, 83, 20);
        almacen.getContentPane().add(JlPrecio);

        JLabel JlProveedor = new JLabel("Proveedor");
        JlProveedor.setForeground(new Color(255, 255, 255));
        JlProveedor.setFont(new Font("Forte", Font.PLAIN, 20));
        JlProveedor.setBounds(110, 503, 96, 20);
        almacen.getContentPane().add(JlProveedor);

        JLabel JlMerma = new JLabel("Merma");
        JlMerma.setForeground(new Color(255, 255, 255));
        JlMerma.setFont(new Font("Forte", Font.PLAIN, 20));
        JlMerma.setBounds(123, 613, 83, 23);
        almacen.getContentPane().add(JlMerma);
        
        ID = new JTextField();
        ID.setColumns(10);
        ID.setBounds(203, 392, 63, 27);
        almacen.getContentPane().add(ID);
        
        JLabel lblId = new JLabel("ID");
        lblId.setForeground(new Color(255, 255, 255));
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("Forte", Font.PLAIN, 20));
        lblId.setBounds(123, 396, 83, 23);
        almacen.getContentPane().add(lblId);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Almacen.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        lblNewLabel.setBounds(20, 21, 49, 39);
        almacen.getContentPane().add(lblNewLabel);
    }

    public JTextField getID() {
		return ID;
	}

	public void setID(JTextField iD) {
		ID = iD;
	}

	public JFrame getAlmacen() {
        return almacen;
    }

    public void setAlmacen(JFrame almacen) {
        this.almacen = almacen;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JLabel getLblNewLabel_3() {
        return lblNewLabel_3;
    }

    public void setLblNewLabel_3(JLabel lblNewLabel_3) {
        this.lblNewLabel_3 = lblNewLabel_3;
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

    public JTextField getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(JTextField fechaCaducidad) {
        FechaCaducidad = fechaCaducidad;
    }

    public JTextField getPrecio() {
        return Precio;
    }

    public void setPrecio(JTextField precio) {
        Precio = precio;
    }

    public JTextField getProveedor() {
        return Proveedor;
    }

    public void setProveedor(JTextField proveedor) {
        Proveedor = proveedor;
    }

    public JTextField getMerma() {
        return Merma;
    }

    public void setMerma(JTextField merma) {
        Merma = merma;
    }

  

    public void setVisible(boolean b) {
        almacen.setVisible(b);
    }


    
 

	public Almacen(JTextField iD, JTextField producto, JTextField cantidad, JTextField fechaCaducidad,
			JTextField precio, JTextField proveedor, JTextField merma) {
		super();
		ID = iD;
		Producto = producto;
		Cantidad = cantidad;
		FechaCaducidad = fechaCaducidad;
		Precio = precio;
		Proveedor = proveedor;
		Merma = merma;
	}

	@Override
	public String toString() {
		return "Almacen [ID=" + ID + ", Producto=" + Producto + ", Cantidad=" + Cantidad + ", FechaCaducidad="
				+ FechaCaducidad + ", Precio=" + Precio + ", Proveedor=" + Proveedor + ", Merma=" + Merma + "]";
	}

	public void iniciarListener(ControladorEventos controlador) {
        btnGuardar.addActionListener(controlador);
        btnBorrar.addActionListener(controlador);

    }
	
	public void llenarTabla(List<MateriaPrima> listaMateriasPrimas) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (MateriaPrima pv : listaMateriasPrimas) {
            modelo.addRow(new Object[]{pv.getId(), pv.getNombre(), pv.getPrecio(), pv.getProveedor(), pv.getFechaCaducidad(), pv.getCantidadUtilizada(),pv.getMerma()});
        }
    }
    
    public void cargarMateriasPrimas() {
        DaoMateriaPrimaMySql daoMateriaPrima = new DaoMateriaPrimaMySql();
        List<MateriaPrima> listaMateriasPrimas = daoMateriaPrima.listar();
        llenarTabla(listaMateriasPrimas);
    }

	
}