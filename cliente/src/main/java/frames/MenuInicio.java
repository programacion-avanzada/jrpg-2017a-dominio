package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;

public class MenuInicio extends JFrame {

	private JPanel contentPane;

	public MenuInicio() {

		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
				new Point(0,0),"custom cursor"));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Propiedades de la ventana
		setTitle("WOME - World Of the Middle Earth");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
		lblLogo.setBounds(109, 39, 216, 90);
		contentPane.add(lblLogo);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 444, 271);
		contentPane.add(layeredPane);
		
		// Boton Jugar
		JLabel lblRegistrarse = new JLabel("Jugar");
		lblRegistrarse.setBounds(205, 162, 82, 23);
		layeredPane.add(lblRegistrarse, new Integer(2));
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarse.setBackground(Color.WHITE);
		
		// Boton Salir
		JLabel lblIniciarSesion = new JLabel("Salir");
		lblIniciarSesion.setBounds(210, 202, 91, 23);
		layeredPane.add(lblIniciarSesion, new Integer(2));
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegistrar = new JButton("Jugar");
		btnRegistrar.setBounds(127, 162, 191, 23);
		layeredPane.add(btnRegistrar, new Integer(1));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.start();
				dispose();
			}
		});
		
		JButton btnIniciarSesion = new JButton("Salir");
		btnIniciarSesion.setBounds(127, 202, 191, 23);
		layeredPane.add(btnIniciarSesion, new Integer(1));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 444, 271);
		lblBackground.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
		layeredPane.add(lblBackground, new Integer(0));
	}
	
	public static void main(String[] args) {
		new MenuInicio().setVisible(true);
	}
	
}
