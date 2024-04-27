package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaIngredientes {
	
	  private JFrame frmIngredientes;
	    private JList<String> listaProductos;
	    private JTextField txtCantidad;
	    private ArrayList<String> productos;
	    private ArrayList<Integer> cantidades;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    VentanaIngredientes window = new VentanaIngredientes();
	                    window.mostrarVentana();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the application.
	     */
	    public VentanaIngredientes() {
	        // Inicializar productos y cantidades
	        productos = new ArrayList<String>();
	        cantidades = new ArrayList<Integer>();
	        initialize();
	    }

	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	        frmIngredientes = new JFrame();
	        frmIngredientes.setTitle("Ingredientes Disponibles");
	        frmIngredientes.setBounds(100, 100, 750, 750);
	        frmIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmIngredientes.getContentPane().setLayout(new BorderLayout(0, 0));
	        frmIngredientes.getContentPane().setBackground(new Color(56, 61, 67));
	        frmIngredientes.getContentPane().setForeground(new Color(56, 61, 67));

	        JScrollPane scrollPane = new JScrollPane();
	        frmIngredientes.getContentPane().add(scrollPane, BorderLayout.CENTER);

	        listaProductos = new JList<>(productos.toArray(new String[0]));
	        scrollPane.setViewportView(listaProductos);

	        JPanel panelBotones = new JPanel();
	        panelBotones.setBackground(new Color(56, 61, 67));
	        panelBotones.setForeground(new Color(56, 61, 67));
	        frmIngredientes.getContentPane().add(panelBotones, BorderLayout.SOUTH);
	        
	        JLabel lblCantidad = new JLabel("Cantidad:");
	        lblCantidad.setForeground(Color.WHITE);
	        lblCantidad.setFont(new Font("Lucida Sans", Font.BOLD, 16));

	        txtCantidad = new JTextField();
	        txtCantidad.setSize(150, 27);
	        txtCantidad.setColumns(5);

	        JButton btnGuardar = new JButton("Guardar");
	        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        btnGuardar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               // guardarCantidad();
	            }
	        });

	        JButton btnCancelar = new JButton("Cancelar");
	        btnCancelar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Aquí puedes agregar la lógica para cancelar la operación
	            }
	        });

	        JButton btnBorrar = new JButton("Borrar");
	        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
	        btnBorrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            }
	        });
	        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	        panelBotones.add(lblCantidad);
	        panelBotones.add(txtCantidad);
	        panelBotones.add(btnGuardar);
	        panelBotones.add(btnBorrar);
	        panelBotones.add(btnCancelar);
	    }

	    // Método para mostrar la ventana
	    public void mostrarVentana() {
	        frmIngredientes.setVisible(true);
	    }

	    // Método para establecer la visibilidad del JFrame
	    public void setVisible(boolean b) {
	         frmIngredientes.setVisible(b);
	    }
	}