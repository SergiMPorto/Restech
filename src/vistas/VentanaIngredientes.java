package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.persistance.interfaces.*;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEventos;
import modelo.entidad.MateriaPrima;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;


public class VentanaIngredientes {

    private JFrame frmIngredientes;
    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;
    private JTable tablaIngredientes;
    private DefaultTableModel modeloIngredientes;
    private DaoMateriaPrima daoMateriaPrima;
    private JTextField cantidad;
    private JButton guardar;
    private JButton borrar;

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

    public VentanaIngredientes() {
        productos = new ArrayList<String>();
        cantidades = new ArrayList<Integer>();
        daoMateriaPrima = new DaoMateriaPrimaMySql();
        initialize();
        cargarDatosEnTablaIngredientes();
        
    }

    private void initialize() {
        frmIngredientes = new JFrame();
        frmIngredientes.setForeground(new Color(0, 128, 128));
        frmIngredientes.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaIngredientes.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        frmIngredientes.setBackground(new Color(255, 255, 255));
        frmIngredientes.setTitle("Ingredientes Disponibles");
        frmIngredientes.setBounds(100, 100, 750, 750);
        frmIngredientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmIngredientes.getContentPane().setBackground(new Color(56, 61, 67));

        modeloIngredientes = new DefaultTableModel();
        modeloIngredientes.setColumnIdentifiers(new Object[]{"Producto", "Cantidad Utilizada"});
        frmIngredientes.getContentPane().setLayout(null);
        tablaIngredientes = new JTable(modeloIngredientes);
        JScrollPane scrollPane = new JScrollPane(tablaIngredientes);
        scrollPane.setBounds(0, 0, 736, 666);
        frmIngredientes.getContentPane().add(scrollPane);
        
        cantidad = new JTextField();
        cantidad.setBounds(301, 676, 100, 27);
        frmIngredientes.getContentPane().add(cantidad);
        cantidad.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Cantidad");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 20));
        lblNewLabel.setBounds(211, 676, 80, 27);
        frmIngredientes.getContentPane().add(lblNewLabel);
        
        guardar = new JButton("Guardar");
        guardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        guardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        guardar.setBounds(416, 676, 150, 27);
        frmIngredientes.getContentPane().add(guardar);
        
        borrar = new JButton("Borrar");
        borrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        
        borrar.setBounds(576, 676, 150, 27);
        frmIngredientes.getContentPane().add(borrar);
       
    }

    public void setTableModel(DefaultTableModel model) {
        modeloIngredientes = model;
        tablaIngredientes.setModel(modeloIngredientes);
    }

    public void populateTableModelFromAlmacen(DefaultTableModel modelAlmacen) {
        int columnaNombre = modelAlmacen.findColumn("Producto");
        int columnaCantidadUtilizada = modelAlmacen.findColumn("Cantidad Utilizada");

        modeloIngredientes.setRowCount(0);

        for (int i = 0; i < modelAlmacen.getRowCount(); i++) {
            String producto = (String) modelAlmacen.getValueAt(i, columnaNombre);
            Object cantidadUtilizada = modelAlmacen.getValueAt(i, columnaCantidadUtilizada);
            modeloIngredientes.addRow(new Object[]{producto, cantidadUtilizada});
        }
    }

    
    
    public JFrame getFrmIngredientes() {
		return frmIngredientes;
	}

	public void setFrmIngredientes(JFrame frmIngredientes) {
		this.frmIngredientes = frmIngredientes;
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> productos) {
		this.productos = productos;
	}

	public ArrayList<Integer> getCantidades() {
		return cantidades;
	}

	public void setCantidades(ArrayList<Integer> cantidades) {
		this.cantidades = cantidades;
	}

	public JTable getTablaIngredientes() {
		return tablaIngredientes;
	}

	public void setTablaIngredientes(JTable tablaIngredientes) {
		this.tablaIngredientes = tablaIngredientes;
	}

	public DefaultTableModel getModeloIngredientes() {
		return modeloIngredientes;
	}

	public void setModeloIngredientes(DefaultTableModel modeloIngredientes) {
		this.modeloIngredientes = modeloIngredientes;
	}


	public void mostrarVentana() {
        frmIngredientes.setVisible(true);
    }

    public void setVisible(boolean b) {
    	
    	cargarDatosEnTablaIngredientes();
        frmIngredientes.setVisible(b);
    }
    
    
    
    public JTextField getCantidad() {
		return cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		this.cantidad = cantidad;
	}

	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	public void iniciarListener(ControladorEventos controlador) {
       
        borrar.addActionListener(controlador);
        guardar.addActionListener(controlador);
    }
    public void cargarDatosEnTablaIngredientes() {
        //Obtén la lista de Materias Primas desde la base de datos
        List<MateriaPrima> listadoMateriasPrimas = daoMateriaPrima.listar();

        //Consigue el modelo de la tabla desde la ventana de ingredientes
        DefaultTableModel modeloTablaIngredientes = (DefaultTableModel) getTablaIngredientes().getModel();

        //Limpia la tabla actual
        modeloTablaIngredientes.setRowCount(0);

        //Llena la tabla con los datos obtenidos
        for (MateriaPrima materiaPrima : listadoMateriasPrimas) {
            modeloTablaIngredientes.addRow(new Object[]{
                materiaPrima.getNombre(),
                materiaPrima.getCantidadUtilizada()
            });
        }
        //Actualiza la tabla con el nuevo modelo
        getTablaIngredientes().setModel(modeloTablaIngredientes);
    }
    }

