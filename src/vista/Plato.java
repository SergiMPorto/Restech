package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Plato {

	private JFrame frmPlato;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;

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
		frmPlato.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Restech\\Imagenes\\RESTECHVENTANA.jpg"));
		frmPlato.getContentPane().setBackground(new Color(56, 61, 67));
		frmPlato.getContentPane().setForeground(new Color(56, 61, 67));
		frmPlato.setForeground(new Color(102, 153, 204));
		frmPlato.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		frmPlato.setTitle("PLATO");
		frmPlato.setBounds(100, 100, 750, 750);
		frmPlato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlato.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel.setBounds(207, 137, 117, 27);
		frmPlato.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(320, 137, 250, 27);
		frmPlato.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("PRECIO");
		lblNewLabel_1.setBackground(new Color(128, 128, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_1.setBounds(207, 253, 117, 27);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		frmPlato.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(320, 253, 100, 27);
		frmPlato.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("TIEMPO DE PREPARACIÓN");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblNewLabel_2.setBounds(52, 370, 250, 27);
		frmPlato.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(320, 370, 100, 27);
		frmPlato.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnGuardar.setForeground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(256, 629, 150, 27);
		frmPlato.getContentPane().add(btnGuardar);
		
		btnNewButton = new JButton("CANCELAR");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnNewButton.setBounds(420, 630, 150, 27);
		frmPlato.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("BORRAR");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnNewButton_1.setBounds(584, 630, 150, 27);
		frmPlato.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("PLATO");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_3.setBounds(320, 53, 462, 47);
		frmPlato.getContentPane().add(lblNewLabel_3);
		
	}
}
