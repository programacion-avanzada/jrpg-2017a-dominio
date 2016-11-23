package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
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

		setTitle("Iniciar Sesion");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(180, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(198, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(198, 117, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(177, 204, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 156, 86, 20);
		contentPane.add(passwordField);
	}
}
