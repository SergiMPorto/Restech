package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import modelo.entidad.MateriaPrima;

import modelo.entidad.Proveedor;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;
import modelo.persistance.mysql.DaoProveedorMySql;

import modelo.persistance.mysql.DaoMateriaPrimaMySql;


import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.io.FileOutputStream;
import java.io.IOException;
//Agregar este import a tu clase Almacen
import java.io.InputStream;
import java.awt.Toolkit;

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
    private DefaultTableModel model;

    private JButton btnExportar; // Declaración del botón de exportación

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
        cargarMateriasPrimas();    }

    private void initialize() {
        almacen = new JFrame();
        almacen.setIconImage(Toolkit.getDefaultToolkit().getImage(Almacen.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
        almacen.setBounds(700, 70, 750, 750);
        almacen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        almacen.getContentPane().setLayout(null);
        almacen.getContentPane().setBackground(new Color(54,217,187));
        almacen.setResizable(false);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(300, 660, 125, 27);
        almacen.getContentPane().add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnCancelar.setBounds(570, 660, 150, 27);
        almacen.getContentPane().add(btnCancelar);

        lblNewLabel_3 = new JLabel("Almacén");
        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel_3.setBounds(266, 13, 207, 47);
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        almacen.getContentPane().add(lblNewLabel_3);

        // Inicializar la tabla con un DefaultTableModel
        model = new DefaultTableModel(
            new Object[][] {}, 
            new String[] { "ID", "Producto", "Precio", "Proveedor", "Fecha Caducidad", "Cantidad Disponible", "Merma" }
        );
        table = new JTable(model);
        
        //Establecer tamaño columnas
        table.setPreferredScrollableViewportSize(new Dimension(750,400));
        
        TableColumn column = null;
        for(int i= 0; i <table.getColumnCount(); i++) {
        	column = table.getColumnModel().getColumn(i);
        	   if (i == 0) {
                   column.setPreferredWidth(25);
               } else if (i == 1) {
                   column.setPreferredWidth(200); 
               } else if (i == 2) {
                   column.setPreferredWidth(25); 
                  
               } else if (i == 4) {
                   column.setPreferredWidth(120); 
               } else if (i == 5) {
                   column.setPreferredWidth(100); 
               } else if (i == 6) {
                   column.setPreferredWidth(25); 
               }
           }
        
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 70, 700, 281);
        almacen.getContentPane().add(scrollPane);

        Producto = new JTextField();
        Producto.setBounds(250, 426, 222, 27);
        almacen.getContentPane().add(Producto);
        Producto.setColumns(10);

        Cantidad = new JTextField();
        Cantidad.setBounds(250, 574, 63, 27);
        almacen.getContentPane().add(Cantidad);
        Cantidad.setColumns(10);

        FechaCaducidad = new JTextField();
        FechaCaducidad.setBounds(250, 537, 115, 27);
        almacen.getContentPane().add(FechaCaducidad);
        FechaCaducidad.setColumns(10);

        JLabel JlProducto = new JLabel("Producto");
        JlProducto.setForeground(new Color(0, 0, 0));
        JlProducto.setFont(new Font("DialogInput", Font.BOLD, 20));
        JlProducto.setBounds(144, 423, 96, 30);
        almacen.getContentPane().add(JlProducto);

        JLabel JlCantidad = new JLabel("Cantidad");
        JlCantidad.setForeground(new Color(0, 0, 0));
        JlCantidad.setFont(new Font("DialogInput", Font.BOLD, 20));
        JlCantidad.setBounds(139, 581, 101, 20);
        almacen.getContentPane().add(JlCantidad);

        JLabel FechaCaducidad_1 = new JLabel("Fecha Caducidad");
        FechaCaducidad_1.setForeground(new Color(0, 0, 0));
        FechaCaducidad_1.setFont(new Font("DialogInput", Font.BOLD, 20));
        FechaCaducidad_1.setBounds(57, 536, 183, 35);
        almacen.getContentPane().add(FechaCaducidad_1);

        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnBorrar.setBounds(435, 660, 125, 27);
        almacen.getContentPane().add(btnBorrar);

        Precio = new JTextField();
        Precio.setBounds(250, 463, 96, 27);
        almacen.getContentPane().add(Precio);
        Precio.setColumns(10);

        Proveedor = new JTextField();
        Proveedor.setBounds(250, 500, 96, 27);
        almacen.getContentPane().add(Proveedor);
        Proveedor.setColumns(10);

        Merma = new JTextField();
        Merma.setColumns(10);
        Merma.setBounds(250, 611, 63, 27);
        almacen.getContentPane().add(Merma);

        JLabel JlPrecio = new JLabel("Precio");
        JlPrecio.setForeground(new Color(0, 0, 0));
        JlPrecio.setFont(new Font("DialogInput", Font.BOLD, 20));
        JlPrecio.setBounds(168, 470, 72, 20);
        almacen.getContentPane().add(JlPrecio);

        JLabel JlProveedor = new JLabel("Proveedor");
        JlProveedor.setForeground(new Color(0, 0, 0));
        JlProveedor.setFont(new Font("DialogInput", Font.BOLD, 20));
        JlProveedor.setBounds(132, 506, 108, 20);
        almacen.getContentPane().add(JlProveedor);

        JLabel JlMerma = new JLabel("Merma");
        JlMerma.setForeground(new Color(0, 0, 0));
        JlMerma.setFont(new Font("DialogInput", Font.BOLD, 20));
        JlMerma.setBounds(177, 615, 63, 23);
        almacen.getContentPane().add(JlMerma);
        
        ID = new JTextField();
        ID.setColumns(10);
        ID.setBounds(250, 392, 63, 27);
        almacen.getContentPane().add(ID);
        
        JLabel lblId = new JLabel("ID");
        lblId.setBackground(new Color(0, 0, 0));
        lblId.setForeground(new Color(0, 0, 0));
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("DialogInput", Font.BOLD, 20));
        lblId.setBounds(216, 399, 29, 20);
        almacen.getContentPane().add(lblId);
        

        btnExportar = new JButton("Exportar a Excel");
        btnExportar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnExportar.setBounds(120, 660, 170, 27);
        almacen.getContentPane().add(btnExportar);

        btnExportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportarExcel();
            }
        });

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Almacen.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
        lblNewLabel.setBounds(687, 0, 49, 39);
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
    
    public JButton getBtnExportar() {
		return btnExportar;
	}

	public void setBtnExportar(JButton btnExportar) {
		this.btnExportar = btnExportar;
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
	
	//Llenar en tabla. 
	
	public void llenarTabla(List<MateriaPrima> listaMateriasPrimas) {
        model.setRowCount(0); // Limpiar la tabla

        for (MateriaPrima pv : listaMateriasPrimas) {
            model.addRow(new Object[]{
                pv.getId(), 
                pv.getNombre(), 
                pv.getPrecio(), 
                pv.getProveedor(), 
                pv.getFechaCaducidad(), 
                pv.getCantidadUtilizada(),
                pv.getMerma()
            });
        }
    }

    public void cargarMateriasPrimas() {
        DaoMateriaPrimaMySql daoMateriaPrima = new DaoMateriaPrimaMySql();
        List<MateriaPrima> listaMateriasPrimas = daoMateriaPrima.listar();
        llenarTabla(listaMateriasPrimas);
    }
    
    
    //Exportar en Excel

    
    private void exportarExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo Excel");
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                // Crear un libro de Excel
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Almacen");

                // Obtener el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                // Obtener el número de filas y columnas
                int rowCount = model.getRowCount();
                int columnCount = model.getColumnCount();

                // Crear las filas y celdas en el archivo Excel
                for (int i = 0; i < rowCount; i++) {
                    XSSFRow row = sheet.createRow(i);
                    for (int j = 0; j < columnCount; j++) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }

                // Obtener la ruta y nombre de archivo seleccionados por el usuario
                String savePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!savePath.endsWith(".xlsx")) {
                    savePath += ".xlsx"; // Asegurar que la extensión del archivo sea .xlsx
                }

                // Guardar el archivo Excel
                FileOutputStream outputStream = new FileOutputStream(savePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                JOptionPane.showMessageDialog(null, "Datos exportados a Excel con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al exportar los datos a Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

}