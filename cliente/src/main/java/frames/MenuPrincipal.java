package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	public MenuPrincipal(final Cliente cliente) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// En caso de cerrar la ventana
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
		
		// Propiedadesd de la ventana
		setTitle("WOME - World Of the Middle Earth");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Boton Registrarse
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarse.setBackground(Color.WHITE);
		lblRegistrarse.setBounds(189, 160, 94, 23);
		contentPane.add(lblRegistrarse);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setFocusable(false);
		btnRegistrar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/frames/BotonMenu.png")));
		btnRegistrar.setBounds(123, 160, 191, 23);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRegistro menuRegistro = new MenuRegistro(cliente);
				menuRegistro.setVisible(true);
				dispose();
			}
		});
		
		contentPane.add(btnRegistrar);
		
		// Boton Iniciar sesion
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIniciarSesion.setBounds(181, 90, 102, 23);
		contentPane.add(lblIniciarSesion);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/frames/BotonMenu.png")));
		btnIniciarSesion.setBounds(123, 90, 191, 23);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
				menuInicioSesion.setVisible(true);
				dispose();
			}
		});
		
		contentPane.add(btnIniciarSesion);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/frames/menuBackground.jpg")));
		lblBackground.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackground);
	}
}


