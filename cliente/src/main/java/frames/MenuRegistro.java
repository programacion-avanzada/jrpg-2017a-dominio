package frames;

import java.awt.Color;

import javax.swing.JFrame;

import cliente.*;
import mensajeria.Comando;

import javax.swing.JTextField;
import java.awt.Font;

/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
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
		
		setTitle("WOME - Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarse.setBounds(186, 182, 82, 23);
		getContentPane().add(lblRegistrarse);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(199, 69, 118, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
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
		
		pwPassword = new JPasswordField();
		pwPassword.setBounds(199, 120, 118, 20);
		getContentPane().add(pwPassword);
		
		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/BotonMenu.png")));
		btnRegistrarse.setBounds(143, 182, 153, 23);
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
		
		getContentPane().add(btnRegistrarse);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
		labelBackground.setBounds(0, 0, 444, 271);
		getContentPane().add(labelBackground);
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