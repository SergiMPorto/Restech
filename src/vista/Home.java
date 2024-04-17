package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Home {

	private JFrame frmMen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmMen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Menú");
		frmMen.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Restech\\Imagenes\\RESTECHVENTANA.jpg"));
		frmMen.getContentPane().setBackground(new Color(56, 61, 67));
		frmMen.getContentPane().setForeground(new Color(56, 61, 67));
		frmMen.setBounds(100, 100, 750, 750);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		lblNewLabel.setBounds(325, 50, 100, 30);
		frmMen.getContentPane().add(lblNewLabel);
		
		JButton btnProducto = new JButton("Producto");
		btnProducto.setToolTipText("Producto");
		btnProducto.setSelectedIcon(new ImageIcon("D:\\Restech\\Imagenes\\Producto(2).jpg"));
		btnProducto.setIcon(new ImageIcon("D:\\Restech\\Imagenes\\Producto(2).jpg"));
		btnProducto.setForeground(new Color(0, 0, 0));
		btnProducto.setBackground(new Color(128, 128, 128));
		btnProducto.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnProducto.setBounds(250, 147, 250, 50);
		frmMen.getContentPane().add(btnProducto);
		
		JButton btnNewButton = new JButton("Platos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton.setBounds(250, 228, 250, 50);
		frmMen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Provedores ");
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton_1.setBounds(250, 309, 250, 50);
		frmMen.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usuario");
		btnNewButton_2.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton_2.setBounds(250, 390, 250, 50);
		frmMen.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCTO");
		lblNewLabel_1.setForeground(new Color(128, 128, 0));
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(142, 163, 167, 30);
		frmMen.getContentPane().add(lblNewLabel_1);
	}
}
