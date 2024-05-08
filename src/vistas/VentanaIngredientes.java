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


public class VentanaIngredientes {

    private JFrame frmIngredientes;
    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;
    private JTable tablaIngredientes;
    private DefaultTableModel modeloIngredientes;
    private JButton btnGuardar;
    private JButton btnBorrar;
    private DaoMateriaPrima daoMateriaPrima;

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
        frmIngredientes.setTitle("Ingredientes Disponibles");
        frmIngredientes.setBounds(100, 100, 750, 750);
        frmIngredientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmIngredientes.getContentPane().setLayout(new BorderLayout());
        frmIngredientes.getContentPane().setBackground(new Color(56, 61, 67));

        modeloIngredientes = new DefaultTableModel();
        modeloIngredientes.setColumnIdentifiers(new Object[]{"Producto", "Cantidad Utilizada"});
        tablaIngredientes = new JTable(modeloIngredientes);
        JScrollPane scrollPane = new JScrollPane(tablaIngredientes);
        frmIngredientes.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(56, 61, 67));
        frmIngredientes.getContentPane().add(panelBotones, BorderLayout.SOUTH);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        panelBotones.add(btnGuardar);
      
        

        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        panelBotones.add(btnBorrar);
       
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

	public void mostrarVentana() {
        frmIngredientes.setVisible(true);
    }

    public void setVisible(boolean b) {
    	
    	cargarDatosEnTablaIngredientes();
        frmIngredientes.setVisible(b);
    }
    
    public void iniciarListener(ControladorEventos controlador) {
       
        btnBorrar.addActionListener(controlador);
        btnGuardar.addActionListener(controlador);
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

