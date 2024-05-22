package vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modelo.entidad.Plato;
import modelo.persistance.interfaces.DaoPlato;
import modelo.persistance.mysql.DaoPlatoMySql;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ListaPlatos {

	private JFrame frmPlatos;
    private JTable tablaPlatos;
    private DefaultTableModel modeloPlatos;
    private JButton borrar;
    private JButton btnExportar;

    private DaoPlato daoPlato;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListaPlatos window = new ListaPlatos();
                    window.frmPlatos.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ListaPlatos() {
        daoPlato = new DaoPlatoMySql();
        initialize();
        cargarDatosEnTablaPlatos();
    }

    private void initialize() {
        frmPlatos = new JFrame();
        frmPlatos.setTitle("Lista de Platos");
        frmPlatos.setBounds(100, 100, 750, 750);
        frmPlatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPlatos.getContentPane().setLayout(new BorderLayout());

        modeloPlatos = new DefaultTableModel();
        modeloPlatos.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Tiempo de Preparación"});
        tablaPlatos = new JTable(modeloPlatos);
        JScrollPane scrollPane = new JScrollPane(tablaPlatos);
        frmPlatos.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        frmPlatos.getContentPane().add(panelBotones, BorderLayout.SOUTH);

        borrar = new JButton("Borrar");
        panelBotones.add(borrar);
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarPlato();
            }
        });

        btnExportar = new JButton("Exportar a Excel");
        panelBotones.add(btnExportar);
        btnExportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportarExcel();
            }
        });
    }

    public void setVisible(boolean b) {
        frmPlatos.setVisible(b);
    }

    public void cargarDatosEnTablaPlatos() {
        List<Plato> listaPlatos = daoPlato.listar();
        modeloPlatos.setRowCount(0);
        for (Plato plato : listaPlatos) {
            modeloPlatos.addRow(new Object[]{
                plato.getNombre(),
                plato.getPrecio(),
                plato.getTiempoPreparacion()
            });
        }
    }

    private void borrarPlato() {
        int selectedRow = tablaPlatos.getSelectedRow();
        if (selectedRow != -1) {
            String nombrePlato = (String) modeloPlatos.getValueAt(selectedRow, 0);
            modeloPlatos.removeRow(selectedRow);
            daoPlato.borrarPlato(nombrePlato);
        }
    }


    private void exportarExcel() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(frmPlatos);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Platos");

                for (int i = 0; i < tablaPlatos.getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i);
                    for (int j = 0; j < tablaPlatos.getColumnCount(); j++) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(tablaPlatos.getValueAt(i, j).toString());
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
}
