package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Registro extends JFrame {
	
	private JTextField textfield_usuario;
	private JPasswordField passwordField;
	private Cliente cli;

	public Registro(final Usuario u1,final Semaphore sem) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				u1.setAccion("cerrar");
				sem.release();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		setTitle("Registro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textfield_usuario = new JTextField();
		textfield_usuario.setBounds(171, 71, 86, 20);
		getContentPane().add(textfield_usuario);
		textfield_usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("  Usuario");
		lblUsuario.setBounds(181, 53, 65, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(181, 118, 65, 14);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 133, 86, 20);
		getContentPane().add(passwordField);
		
		JButton btnRegistrarse = new JButton(" Registrarse");
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
		btnRegistrarse.setBounds(157, 194, 114, 23);
		getContentPane().add(btnRegistrarse);
		
		
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