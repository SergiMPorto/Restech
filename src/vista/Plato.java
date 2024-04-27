package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.ControladorEventos;

public class Plato {

    private JFrame frmPlato;
    private JTextField nombre;
    private JLabel precio;
    private JTextField apellidos;
    private JLabel lblNewLabel_2;
    private JTextField tiempoPreparacion;
    private JButton guardar;
    private JButton borrar;
    private JButton ingredientes;
    private JLabel lblNewLabel_3;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Plato window = new Plato();
                    window.frmPlato.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Plato() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPlato = new JFrame();
        frmPlato.setTitle("PLATO");
        frmPlato.setBounds(750, 50, 750, 750);
        frmPlato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        frmPlato.getContentPane().setLayout(springLayout);

        JLabel nombre_1 = new JLabel("NOMBRE");
        springLayout.putConstraint(SpringLayout.NORTH, nombre_1, 137, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, nombre_1, 207, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, nombre_1, 164, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, nombre_1, 324, SpringLayout.WEST, frmPlato.getContentPane());
        nombre_1.setHorizontalAlignment(SwingConstants.CENTER);
        nombre_1.setForeground(new Color(128, 128, 128));
        nombre_1.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        frmPlato.getContentPane().add(nombre_1);

        nombre = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, nombre, 137, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, nombre, 320, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, nombre, 164, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, nombre, 570, SpringLayout.WEST, frmPlato.getContentPane());
        frmPlato.getContentPane().add(nombre);
        nombre.setColumns(10);

        precio = new JLabel("PRECIO");
        springLayout.putConstraint(SpringLayout.NORTH, precio, 187, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, precio, 207, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, precio, 214, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, precio, 324, SpringLayout.WEST, frmPlato.getContentPane());
        precio.setHorizontalAlignment(SwingConstants.CENTER);
        precio.setForeground(new Color(128, 128, 128));
        precio.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        frmPlato.getContentPane().add(precio);

        apellidos = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, apellidos, 187, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, apellidos, 320, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, apellidos, 214, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, apellidos, 420, SpringLayout.WEST, frmPlato.getContentPane());
        frmPlato.getContentPane().add(apellidos);
        apellidos.setColumns(10);

        lblNewLabel_2 = new JLabel("TIEMPO DE PREPARACIÓN");
        springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 244, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 60, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 271, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 310, SpringLayout.WEST, frmPlato.getContentPane());
        lblNewLabel_2.setForeground(new Color(128, 128, 128));
        lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
        frmPlato.getContentPane().add(lblNewLabel_2);

        tiempoPreparacion = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH, tiempoPreparacion, 244, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, tiempoPreparacion, 320, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, tiempoPreparacion, 271, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, tiempoPreparacion, 420, SpringLayout.WEST, frmPlato.getContentPane());
        frmPlato.getContentPane().add(tiempoPreparacion);
        tiempoPreparacion.setColumns(10);

        guardar = new JButton("GUARDAR");
        springLayout.putConstraint(SpringLayout.NORTH, guardar, 630, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, guardar, 400, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, guardar, 550, SpringLayout.WEST, frmPlato.getContentPane());
        guardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        guardar.setBackground(Color.GRAY);
        guardar.setForeground(Color.BLACK);
        frmPlato.getContentPane().add(guardar);

        borrar = new JButton("BORRAR");
        springLayout.putConstraint(SpringLayout.NORTH, borrar, 630, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, borrar, 560, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, borrar, 710, SpringLayout.WEST, frmPlato.getContentPane());
        borrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        borrar.setBackground(Color.GRAY);
        borrar.setForeground(Color.BLACK);
        frmPlato.getContentPane().add(borrar);

        lblNewLabel_3 = new JLabel("PLATO");
        springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 53, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 320, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 100, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 782, SpringLayout.WEST, frmPlato.getContentPane());
        lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 45));
        frmPlato.getContentPane().add(lblNewLabel_3);

        table = new JTable(new Object[][]{}, new String[]{"Producto", "Cantidad"});

        scrollPane = new JScrollPane(table);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 319, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 620, SpringLayout.NORTH, frmPlato.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, scrollPane, 726, SpringLayout.WEST, frmPlato.getContentPane());
        frmPlato.getContentPane().add(scrollPane);
        
        ingredientes = new JButton("Ingredientes");
        springLayout.putConstraint(SpringLayout.NORTH, ingredientes, 34, SpringLayout.NORTH, lblNewLabel_2);
        springLayout.putConstraint(SpringLayout.WEST, ingredientes, 14, SpringLayout.WEST, borrar);
        springLayout.putConstraint(SpringLayout.SOUTH, ingredientes, -6, SpringLayout.NORTH, scrollPane);
        springLayout.putConstraint(SpringLayout.EAST, ingredientes, 0, SpringLayout.EAST, scrollPane);
        ingredientes.setFont(new Font("Lucida Sans", Font.BOLD, 15));
      
        frmPlato.getContentPane().add(ingredientes);

        ajustarTamañoColumnaCantidad();

    }

    private void ajustarTamañoColumnaCantidad() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50); // Ajustar ancho de la columna Producto
        columnModel.getColumn(1).setPreferredWidth(150);
    }

    public void setVisible(boolean b) {
        frmPlato.setVisible(b);
    }

	public JFrame getFrmPlato() {
		return frmPlato;
	}

	public void setFrmPlato(JFrame frmPlato) {
		this.frmPlato = frmPlato;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JLabel getPrecio() {
		return precio;
	}

	public void setPrecio(JLabel precio) {
		this.precio = precio;
	}

	public JTextField getApellidos() {
		return apellidos;
	}

	public void setApellidos(JTextField apellidos) {
		this.apellidos = apellidos;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JTextField getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(JTextField tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	

	public JButton getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(JButton ingredientes) {
		ingredientes = ingredientes;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		guardar = guardar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		borrar = borrar;
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
	
	public void iniciarListerner(ControladorEventos controlador) {
		ingredientes.addActionListener(controlador);
		
		
	}
    
    
}
