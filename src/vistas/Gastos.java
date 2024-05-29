package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEventos;
import modelo.entidad.Gasto;
import modelo.entidad.Pedido;
import modelo.entidad.Proveedor;
import modelo.persistance.interfaces.DaoProveedor;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Gastos {

    private JFrame frameGastos;
    private JLabel titulo;
    private JTable table;
    private JComboBox<String> proveedores;
    private JComboBox<String> meses;
    private JComboBox<String> seleccion;
    private JButton btnBuscar;
    private DaoProveedor daoProveedor;
    private DefaultTableModel model;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gastos window = new Gastos();
                    window.frameGastos.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Gastos() {
        initialize();
   
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frameGastos = new JFrame();
        frameGastos.setBackground(Color.WHITE);
        frameGastos.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPedido.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
        frameGastos.setTitle("Gastos");
        frameGastos.getContentPane().setBackground(new Color(54,217,187));
        frameGastos.getContentPane().setForeground(new Color(54,217,187));
        frameGastos.setBounds(730, 50, 750, 750);
        frameGastos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameGastos.getContentPane().setLayout(null);
        frameGastos.setResizable(false);
        

        JLabel lblNewLabel_3 = new JLabel("Gastos");
        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel_3.setBounds(277, 38, 178, 63);
        frameGastos.getContentPane().add(lblNewLabel_3);
    
        titulo = new JLabel("New label");
        titulo.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
        titulo.setBounds(661, 0, 75, 75);
        frameGastos.getContentPane().add(titulo);
     
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(607, 673, 100, 30);
        frameGastos.getContentPane().add(btnBorrar);
     
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBuscar.setBounds(497, 673, 100, 30);
        frameGastos.getContentPane().add(btnBuscar);
        
        
     
    
     
        String[] seleccionArray = {"Seleccione", "Listar por Proveedor", "Listar Por Meses"};
        seleccion = new JComboBox<>(seleccionArray);
        seleccion.setBounds(242, 104, 453, 30);
        frameGastos.getContentPane().add(seleccion);
     
        proveedores = new JComboBox<>();
        proveedores.setBounds(242, 144, 453, 30);
        frameGastos.getContentPane().add(proveedores);
        proveedores.setEnabled(false); // Inicialmente deshabilitado
     
        String[] mesesArray = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        meses = new JComboBox<>(mesesArray);
        meses.setBounds(459, 177, 236, 30);
        frameGastos.getContentPane().add(meses);
        meses.setEnabled(false);
        
        model = new DefaultTableModel(null, new String[]{"ID Gasto", "ID Pedido", "Precio", "Fecha"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 255, 716, 408);
        frameGastos.getContentPane().add(scrollPane);
    }

    public JComboBox<String> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(JComboBox<String> seleccion) {
        this.seleccion = seleccion;
    }

    public void setVisible(boolean b) {
        frameGastos.setVisible(b);
    }
    
    public void actualizarTablaGastos(List<Gasto> gastos) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        for (Gasto gasto : gastos) {
            model.addRow(new Object[]{
                gasto.getIdGasto(),
                gasto.getPedido().getId(),
                gasto.getCosto(),
                gasto.getFecha()
            });
        }
    }
    
    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JComboBox<String> getProveedores() {
        return proveedores;
    }

    public void setProveedores(JComboBox<String> proveedores) {
        this.proveedores = proveedores;
    }

    public JComboBox<String> getMeses() {
        return meses;
    }

    public void setMeses(JComboBox<String> meses) {
        this.meses = meses;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void mostrarSumaGastos(float sumaGastos) {
        JOptionPane.showMessageDialog(frameGastos, "Suma de gastos: " + sumaGastos, "Total Gastos", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void iniciarListener(ControladorEventos controlador) {
        proveedores.addActionListener(controlador);
        meses.addActionListener(controlador);
        seleccion.addActionListener(controlador);
        btnBuscar.addActionListener(controlador);
    }
    
    public void actualizarTablaGastosConPedidos(List<Gasto> gastosPorProveedor) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  
        for (Gasto gasto : gastosPorProveedor) {
            model.addRow(new Object[]{
                gasto.getIdGasto(),
                gasto.getPedido().getId(),
                gasto.getCosto(),
                gasto.getFecha()
            });
        }
    }

}
