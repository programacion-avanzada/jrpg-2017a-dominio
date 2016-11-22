package frames;


import javax.swing.JFrame;

import cliente.*;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Registro extends JFrame {
	
	private JTextField textfield_usuario;
	private JPasswordField passwordField;

	public Registro(final Usuario u1,final Semaphore sem) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				u1.setAccion("cerrar");
				sem.release();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		setTitle("WOME - Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarse.setBounds(186, 182, 82, 23);
		getContentPane().add(lblRegistrarse);
		
		textfield_usuario = new JTextField();
		textfield_usuario.setBounds(199, 69, 118, 20);
		getContentPane().add(textfield_usuario);
		textfield_usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(113, 70, 57, 19);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(113, 121, 65, 17);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 120, 118, 20);
		getContentPane().add(passwordField);
		
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setIcon(new ImageIcon(Registro.class.getResource("/frames/BotonMenu.png")));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u1.setNombreUsuario(textfield_usuario.getText());
				u1.setPassword(passwordField.getText());
				u1.setAccion("registro");
				u1.setOpcion(0);
				sem.release();
				dispose();
			}
		});
		btnRegistrarse.setBounds(143, 182, 153, 23);
		getContentPane().add(btnRegistrarse);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(Registro.class.getResource("/frames/menuBackground.jpg")));
		labelBackground.setBounds(0, 0, 444, 271);
		getContentPane().add(labelBackground);
		
		
	}

	public JTextField getTextfield_usuario() {
		return textfield_usuario;
	}

	public void setTextfield_usuario(JTextField textfield_usuario) {
		this.textfield_usuario = textfield_usuario;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
}