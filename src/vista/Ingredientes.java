package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ingredientes {

    private JFrame frmIngredientes;
    private JList<String> listaProductos;
    private JTextField txtCantidad;
    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;

    public Ingredientes(ArrayList<String> productos) {
        this.productos = productos;
        initialize();
    }
    
    public void setProductos(ArrayList<String> productos) {
        this.productos = productos;
        
        listaProductos.setListData(productos.toArray(new String[0]));
    }




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

   

    public void mostrarVentana() {
        frmIngredientes.setVisible(true);
   
}

	public void setVisible(boolean b) {
         frmIngredientes.setVisible(b);
		
	}

		
		
	}
    
