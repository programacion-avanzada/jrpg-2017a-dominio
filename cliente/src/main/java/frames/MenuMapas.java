package frames;
import dominio.*;
import mensajeria.Comando;
import mensajeria.Paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;

public class MenuMapas extends JFrame {

	private JPanel contentPane;

	public MenuMapas(final Cliente cliente) {
		setTitle("Elegir Mapa");
		setBounds(100, 100, 450, 300);
		
		// En caso de cerrar
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
		
		// Panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Mapa 1
		JButton btnMapaUno = new JButton("Mapa 1");
		btnMapaUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(1);
					cliente.notify();
				}
				dispose();
			}
		});
		btnMapaUno.setBounds(172, 73, 89, 23);
		contentPane.add(btnMapaUno);
		
		// Mapa 2
		JButton btnMapaDos = new JButton("Mapa 2");
		btnMapaDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(2);
					cliente.notify();
				}
				dispose();
			}
		});
		btnMapaDos.setBounds(172, 133, 89, 23);
		btnMapaDos.setEnabled(false);
		contentPane.add(btnMapaDos);
		
		// Mapa 3
		JButton btnMapaTres = new JButton("Mapa 3");
		btnMapaTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(3);
					cliente.notify();
				}
				dispose();
			}
		});
		btnMapaTres.setBounds(172, 191, 89, 23);
		btnMapaTres.setEnabled(false);
		contentPane.add(btnMapaTres);
	}
}

