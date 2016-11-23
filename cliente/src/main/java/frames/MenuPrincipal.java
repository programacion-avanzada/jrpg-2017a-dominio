package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
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
		setTitle("Inicio");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Boton Registrarse
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRegistro menuRegistro = new MenuRegistro(cliente);
				menuRegistro.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(58, 119, 118, 23);
		contentPane.add(btnRegistrar);
		
		// Boton Iniciar sesion
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
				menuInicioSesion.setVisible(true);
				dispose();
			}
		});
		btnIniciarSesion.setBounds(242, 119, 128, 23);
		contentPane.add(btnIniciarSesion);
	}
}


