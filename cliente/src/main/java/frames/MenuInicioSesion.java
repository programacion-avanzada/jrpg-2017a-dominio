package frames;

import java.awt.Color;
import java.awt.Font;

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

public class MenuInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public MenuInicioSesion(final Cliente cliente) {
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
		
		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setForeground(Color.WHITE);
		lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngresar.setBounds(194, 182, 68, 23);
		contentPane.add(lblIngresar);
		
		textField = new JTextField();
		textField.setBounds(199, 69, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(113, 68, 55, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(113, 120, 68, 21);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBounds(199, 120, 118, 20);
		contentPane.add(passwordField);
		
		JButton btnConectar = new JButton("");
		btnConectar.setFocusable(false);
		btnConectar.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
		btnConectar.setBounds(143, 182, 153, 23);
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
		contentPane.add(btnConectar);

		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/menuBackground.jpg")));
		labelBackground.setBounds(0, 0, 444, 271);
		contentPane.add(labelBackground);
	}
}
