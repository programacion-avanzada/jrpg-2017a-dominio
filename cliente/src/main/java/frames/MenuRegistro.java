package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

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

public class MenuRegistro extends JFrame {
	
	private JTextField txtUsuario;
	private JPasswordField pwPassword;
	private Cliente cli;

	public MenuRegistro(final Cliente cliente) {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				synchronized(cliente){
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				dispose();
			}
		});
		
		setTitle("Registro de Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(171, 71, 86, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(181, 53, 65, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(181, 118, 65, 14);
		getContentPane().add(lblPassword);
		
		pwPassword = new JPasswordField();
		pwPassword.setBounds(171, 133, 86, 20);
		getContentPane().add(pwPassword);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
					cliente.getPaqueteUsuario().setPassword(pwPassword.getText());
					cliente.setAccion(Comando.REGISTRO);
					cliente.notify();
				}
				dispose();
			}
		});
		btnRegistrarse.setBounds(157, 194, 114, 23);
		getContentPane().add(btnRegistrarse);
		
		
	}

	public JTextField gettxtUsuario() {
		return txtUsuario;
	}

	public void settxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPasswordField() {
		return pwPassword;
	}

	public void setPasswordField(JPasswordField pwPassword) {
		this.pwPassword = pwPassword;
	}
}