package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;

public class MenuInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public MenuInicioSesion(final Cliente cliente) {
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuPrincipal.class.getResource("/cursor.png")).getImage(),
				new Point(0,0),"custom cursor"));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				synchronized(cliente){
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});

		setTitle("WOME - Iniciar Sesion");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 444, 271);
		contentPane.add(layeredPane);
				
				JLabel lblNewLabel_1 = new JLabel("Password");
				lblNewLabel_1.setBounds(111, 118, 68, 21);
				layeredPane.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_1.setForeground(Color.WHITE);
				
				JLabel lblNewLabel = new JLabel("Usuario");
				lblNewLabel.setBounds(111, 66, 55, 23);
				layeredPane.add(lblNewLabel, new Integer(2));
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JLabel lblIngresar = new JLabel("Ingresar");
				lblIngresar.setBounds(193, 183, 68, 23);
				layeredPane.add(lblIngresar, new Integer(2));
				lblIngresar.setForeground(Color.WHITE);
				lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				textField = new JTextField();
				textField.setBounds(198, 69, 118, 20);
				layeredPane.add(textField, new Integer(1));
				textField.setColumns(10);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(198, 119, 118, 20);
				layeredPane.add(passwordField, new Integer(1));
				passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
				
				JButton btnConectar = new JButton("");
				btnConectar.setBounds(141, 182, 153, 23);
				layeredPane.add(btnConectar, new Integer(1));
				btnConectar.setFocusable(false);
				btnConectar.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
				btnConectar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						synchronized(cliente){
							cliente.setAccion(Comando.INICIOSESION);
							cliente.getPaqueteUsuario().setUsername(textField.getText());
							cliente.getPaqueteUsuario().setPassword(passwordField.getText());
							cliente.notify();
							dispose();
						}
						
					}
				});
		
				
				JLabel labelBackground = new JLabel("");
				labelBackground.setBounds(0, 0, 444, 271);
				labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/menuBackground.jpg")));
				layeredPane.add(labelBackground, new Integer(0));
	}
}
