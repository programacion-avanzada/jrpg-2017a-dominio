package frames;
import dominio.*;
import mensajeria.Comando;
import mensajeria.Paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
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
		setTitle("WOME - Elegir Mapa");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// Mapa Aubenor
		JLabel lblAubenor = new JLabel("Aubenor");
		lblAubenor.setForeground(Color.WHITE);
		lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAubenor.setBounds(194, 73, 66, 23);
		contentPane.add(lblAubenor);
		
		JButton btnAubenor = new JButton("");
		btnAubenor.setFocusable(false);
		btnAubenor.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnAubenor.setBounds(148, 73, 143, 23);
		btnAubenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(1);
					cliente.notify();
				}
				dispose();
			}
		});

		contentPane.add(btnAubenor);
		
		// Mapa Aris
		JLabel lblAris = new JLabel("Aris");
		lblAris.setForeground(Color.WHITE);
		lblAris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAris.setBounds(204, 130, 32, 23);
		contentPane.add(lblAris);
		
		JButton btnAris = new JButton("");
		btnAris.setFocusable(false);
		btnAris.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnAris.setBounds(148, 130, 143, 23);
		btnAris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(2);
					cliente.notify();
				}
				dispose();
			}
		});
		
		btnAris.setEnabled(false);
		contentPane.add(btnAris);
		
		// Mapa Eodrim
		JLabel lblEodrim = new JLabel("Eodrim");
		lblEodrim.setForeground(Color.WHITE);
		lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEodrim.setBounds(196, 191, 53, 23);
		contentPane.add(lblEodrim);
		
		JButton btnEodrim = new JButton("");
		btnEodrim.setFocusable(false);
		btnEodrim.setEnabled(false);
		btnEodrim.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnEodrim.setBounds(148, 191, 143, 23);
		btnEodrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(cliente){
					cliente.getPaquetePersonaje().setMapa(3);
					cliente.notify();
				}
				dispose();
			}
		});
		
		btnEodrim.setEnabled(false);
		contentPane.add(btnEodrim);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/menuBackground.jpg")));
		lblBackground.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackground);
	}
}

