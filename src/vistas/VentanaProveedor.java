package vistas;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import modelo.entidad.Proveedor;
import modelo.persistance.mysql.DaoProveedorMySql;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controlador.ControladorEventos;
import modelo.entidad.Proveedor;
import modelo.persistance.mysql.DaoProveedorMySql;
import java.awt.Toolkit;

public class VentanaProveedor {

    private JFrame proveedor;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextField id;
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

    private JButton btnExportar; 

    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;

    public VentanaProveedor( String nombre, String descripcion, String telefono, String direccion) {
        initialize(); 
        
        
      
        this.nombre.setText(nombre);
        this.descripcion.setText(descripcion);
        this.telefono.setText(telefono);
        this.direccion.setText(direccion);
        
        cargarProveedores();
        
        lblNewLabel_4 = new JLabel("Proveedor");
        lblNewLabel_4.setBackground(new Color(0, 0, 0));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel_4.setBounds(238, 13, 280, 47);
        proveedor.getContentPane().add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
        lblNewLabel_5.setBounds(661, 0, 75, 75);
        proveedor.getContentPane().add(lblNewLabel_5);
    }

    private void initialize() {
        proveedor = new JFrame();
        proveedor.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaProveedor.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
        proveedor.setBounds(100, 100, 750, 750);
        proveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        proveedor.getContentPane().setLayout(null);
        proveedor.getContentPane().setBackground(new Color(54,217,187));
        proveedor.setResizable(false);
        proveedor.setForeground(new Color(102, 153, 204));
        proveedor.addWindowListener(new WindowAdapter() {
    	    @Override
    	    public void windowClosing(WindowEvent e) {
    	        limpiarCampos();
    	    }
    	});
       
       
        table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"ID","Nombre", "Descripción", "Teléfono", "Dirección"}));
        
        
        //Cambiar tamaño columnas
        table.setPreferredScrollableViewportSize(new Dimension(750,400));
        
        TableColumn column = null;
        
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(5);
            } else if (i == 1) {
                column.setPreferredWidth(200); 
            } else if (i == 2) {
                column.setPreferredWidth(75); 
            } else if (i == 3) {
                column.setPreferredWidth(70); 
            } else if (i == 4) {
                column.setPreferredWidth(200);
            } 
        }
        
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(26, 90, 700, 281);
        proveedor.getContentPane().add(scrollPane);
        proveedor.setResizable(false);

        nombre = new JTextField();
        nombre.setBounds(187, 469, 427, 27);
        proveedor.getContentPane().add(nombre);
        nombre.setColumns(10);

        descripcion = new JTextField();
        descripcion.setColumns(10);
        descripcion.setBounds(187, 506, 427, 27);
        proveedor.getContentPane().add(descripcion);

        telefono = new JTextField();
        telefono.setColumns(10);
        telefono.setBounds(187, 543, 427, 27);
        proveedor.getContentPane().add(telefono);

        direccion = new JTextField();
        direccion.setColumns(10);
        direccion.setBounds(187, 580, 498, 27);
        proveedor.getContentPane().add(direccion);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel.setBounds(102, 469, 75, 27);
        proveedor.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Descripción");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_1.setBounds(45, 506, 132, 31);
        proveedor.getContentPane().add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Teléfono");
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_2.setBounds(77, 546, 100, 24);
        proveedor.getContentPane().add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Dirección");
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblNewLabel_3.setBounds(67, 585, 110, 22);
        proveedor.getContentPane().add(lblNewLabel_3);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(514, 666, 100, 30);
        proveedor.getContentPane().add(btnGuardar);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(626, 666, 100, 30);
        proveedor.getContentPane().add(btnBorrar);
        
        btnExportar = new JButton("Exportar a Excel");
        btnExportar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnExportar.setBounds(298, 666, 208, 30);
        proveedor.getContentPane().add(btnExportar);

        btnExportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportarExcel();
            }
        });
    }

   
  //Getter & Setter
    public JFrame getProveedor() {
        return proveedor;
    }

    public void setProveedor(JFrame proveedor) {
        this.proveedor = proveedor;
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

    public JLabel getLblNewLabel() {
        return lblNewLabel;
    }

    public void setLblNewLabel(JLabel lblNewLabel) {
        this.lblNewLabel = lblNewLabel;
    }

    public JLabel getLblNewLabel_1() {
        return lblNewLabel_1;
    }

    public void setLblNewLabel_1(JLabel lblNewLabel_1) {
        this.lblNewLabel_1 = lblNewLabel_1;
    }

    public JLabel getLblNewLabel_2() {
        return lblNewLabel_2;
    }

    public void setLblNewLabel_2(JLabel lblNewLabel_2) {
        this.lblNewLabel_2 = lblNewLabel_2;
    }

    public JLabel getLblNewLabel_3() {
        return lblNewLabel_3;
    }

    public void setLblNewLabel_3(JLabel lblNewLabel_3) {
        this.lblNewLabel_3 = lblNewLabel_3;
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
    
    public JButton getBtnExportar() {
        return btnExportar;
    }

    public void setBtnExportar(JButton btnExportar) {
        this.btnExportar = btnExportar;
    }

    public void setVisible(boolean b) {
        proveedor.setVisible(b);
    }

    public void iniciarListener(ControladorEventos controlador) {
        btnGuardar.addActionListener(controlador);
        btnBorrar.addActionListener(controlador);
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }
    
    public VentanaProveedor(JTextField id, JTextField nombre, JTextField descripcion, JTextField telefono,
            JTextField direccion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "VentanaProveedor [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", telefono="
                + telefono + ", direccion=" + direccion + "]";
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaProveedor window = new VentanaProveedor("Nombre", "Descripción", "Teléfono", "Dirección");
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    

    public void llenarTabla(List<Proveedor> listaProveedores) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (Proveedor pv : listaProveedores) {
            modelo.addRow(new Object[]{pv.getId(), pv.getNombre(), pv.getDescripcion(), pv.getTelefono(), pv.getDireccion()});
        }
    }
    

    public void cargarProveedores() {

        DaoProveedorMySql daoProveedor = new DaoProveedorMySql();
        List<Proveedor> listaProveedores = daoProveedor.listar();
        llenarTabla(listaProveedores);
    }

    
    private void exportarExcel() {
        // Crear un objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        // Mostrar el diálogo de guardar archivo
        int seleccion = fileChooser.showSaveDialog(proveedor);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado por el usuario
            java.io.File file = fileChooser.getSelectedFile();
            // Guardar los datos de la tabla en un archivo Excel
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Proveedores");

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    XSSFRow row = sheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }

                FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath() + ".xlsx");
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                System.out.println("Exportación a Excel exitosa.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void limpiarCampos() {
        nombre.setText("");
        descripcion.setText("");
        telefono.setText("");
        direccion.setText("");
    }


}