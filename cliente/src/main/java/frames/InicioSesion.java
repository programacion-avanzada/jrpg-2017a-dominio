package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public InicioSesion(final Usuario user,final Semaphore sem) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				user.setAccion("cerrar");
				sem.release();
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
				user.setAccion("inicioSesion");
				user.setNombreUsuario(textField.getText());
				user.setPassword(passwordField.getText());
				user.setOpcion(1);
				sem.release();
				dispose();
			}
		});
		btnNewButton.setBounds(177, 204, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 156, 86, 20);
		contentPane.add(passwordField);
	}
}
