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
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controlador.ControladorEventos;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaPlato {

	 private JFrame frmPlato;
	    private JTextField nombre;
	    private JLabel precio;
	    private JTextField Precio;
	    private JLabel lblNewLabel_2;
	    private JTextField tiempoPreparacion;
	    private JButton guardar;
	    private JButton borrar;
	    private JButton ingredientes;
	    private JLabel lblNewLabel_3;
	    private JTable table;
	    private JScrollPane scrollPane;
	    private JButton listarPlatos;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    VentanaPlato window = new VentanaPlato();
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
	    public VentanaPlato() {
	        initialize();
	    }

	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	        frmPlato = new JFrame();
	        frmPlato.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
	        frmPlato.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPlato.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
	        frmPlato.setTitle("PLATO");
	        frmPlato.setBounds(750, 50, 750, 750);
	        frmPlato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frmPlato.getContentPane().setBackground(new Color(54,217,187));
	        SpringLayout springLayout = new SpringLayout();
	        frmPlato.getContentPane().setLayout(springLayout);
	        frmPlato.setResizable(false);

	        JLabel nombre_1 = new JLabel("NOMBRE");
	        springLayout.putConstraint(SpringLayout.NORTH, nombre_1, 137, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, nombre_1, 227, SpringLayout.WEST, frmPlato.getContentPane());
	        nombre_1.setHorizontalAlignment(SwingConstants.CENTER);
	        nombre_1.setForeground(new Color(0, 0, 0));
	        nombre_1.setFont(new Font("DialogInput", Font.BOLD, 20));
	        frmPlato.getContentPane().add(nombre_1);

	        nombre = new JTextField();
	        springLayout.putConstraint(SpringLayout.WEST, nombre, 320, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, nombre_1, 0, SpringLayout.SOUTH, nombre);
	        springLayout.putConstraint(SpringLayout.EAST, nombre_1, -12, SpringLayout.WEST, nombre);
	        springLayout.putConstraint(SpringLayout.NORTH, nombre, 137, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, nombre, 164, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.EAST, nombre, 570, SpringLayout.WEST, frmPlato.getContentPane());
	        frmPlato.getContentPane().add(nombre);
	        nombre.setColumns(10);

	        precio = new JLabel("PRECIO");
	        springLayout.putConstraint(SpringLayout.WEST, precio, 0, SpringLayout.WEST, nombre_1);
	        precio.setHorizontalAlignment(SwingConstants.CENTER);
	        precio.setForeground(new Color(0, 0, 0));
	        precio.setFont(new Font("DialogInput", Font.BOLD, 20));
	        frmPlato.getContentPane().add(precio);

	        Precio = new JTextField();
	        springLayout.putConstraint(SpringLayout.SOUTH, precio, 0, SpringLayout.SOUTH, Precio);
	        springLayout.putConstraint(SpringLayout.EAST, precio, -6, SpringLayout.WEST, Precio);
	        springLayout.putConstraint(SpringLayout.NORTH, Precio, 187, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, Precio, 320, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, Precio, 214, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.EAST, Precio, 420, SpringLayout.WEST, frmPlato.getContentPane());
	        frmPlato.getContentPane().add(Precio);
	        Precio.setColumns(10);

	        lblNewLabel_2 = new JLabel("TIEMPO DE PREPARACIÓN");
	        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 55, SpringLayout.WEST, frmPlato.getContentPane());
	        lblNewLabel_2.setForeground(new Color(0, 0, 0));
	        lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 20));
	        frmPlato.getContentPane().add(lblNewLabel_2);

	        tiempoPreparacion = new JTextField();
	        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, tiempoPreparacion);
	        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -8, SpringLayout.WEST, tiempoPreparacion);
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
	        springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 32, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 290, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -52, SpringLayout.NORTH, nombre_1);
	        lblNewLabel_3.setForeground(new Color(0, 0, 0));
	        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
	        frmPlato.getContentPane().add(lblNewLabel_3);

	        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Producto", "Cantidad"});
	        table = new JTable(tableModel);

	        scrollPane = new JScrollPane(table);
	        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 319, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 620, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.EAST, scrollPane, 726, SpringLayout.WEST, frmPlato.getContentPane());
	        frmPlato.getContentPane().add(scrollPane);

	        
	        ingredientes = new JButton("Ingredientes");
	        springLayout.putConstraint(SpringLayout.NORTH, ingredientes, 278, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, ingredientes, 574, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, ingredientes, -10, SpringLayout.NORTH, scrollPane);
	        springLayout.putConstraint(SpringLayout.EAST, ingredientes, -10, SpringLayout.EAST, frmPlato.getContentPane());
	        ingredientes.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	      
	        frmPlato.getContentPane().add(ingredientes);
	        
	        JLabel lblNewLabel = new JLabel("New label");
	        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -235, SpringLayout.WEST, lblNewLabel);
	        springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 682, SpringLayout.WEST, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 47, SpringLayout.NORTH, frmPlato.getContentPane());
	        springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, frmPlato.getContentPane());
	        lblNewLabel.setIcon(new ImageIcon(VentanaPlato.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
	        frmPlato.getContentPane().add(lblNewLabel);
	        
	        listarPlatos = new JButton("LISTA PLATOS");
	        springLayout.putConstraint(SpringLayout.NORTH, listarPlatos, 0, SpringLayout.NORTH, guardar);
	        springLayout.putConstraint(SpringLayout.EAST, listarPlatos, -12, SpringLayout.WEST, guardar);
	        listarPlatos.setForeground(Color.BLACK);
	        listarPlatos.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        listarPlatos.setBackground(Color.GRAY);
	        frmPlato.getContentPane().add(listarPlatos);

	        ajustarTamañoColumnaCantidad();

	    }

	    public JButton getListarPlatos() {
			return listarPlatos;
		}

		public void setListarPlatos(JButton listarPlatos) {
			this.listarPlatos = listarPlatos;
		}

		private void ajustarTamañoColumnaCantidad() {
	        TableColumnModel columnModel = table.getColumnModel();
	        columnModel.getColumn(0).setPreferredWidth(50); 
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

	

		public void setPrecio(JTextField precio) {
			Precio = precio;
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
			guardar.addActionListener(controlador);
			listarPlatos.addActionListener(controlador);
			
			
		}
		
		 public void agregarProducto(String producto, int cantidad) {
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object[]{producto, cantidad});
		    }
	}