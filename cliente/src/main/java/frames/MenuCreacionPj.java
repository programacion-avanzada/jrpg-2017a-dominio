package frames;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import dominio.*;
import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MenuCreacionPj extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JLabel destreza;
	private JLabel fuerza;
	private JLabel inteligencia;
	private JLabel salud;
	private JLabel energia;
	
	private JComboBox<String> cbxCasta;
	private JComboBox<String> cbxRaza;

	public MenuCreacionPj(final Cliente cliente, final PaquetePersonaje personaje) {
		final String vecSalud[]= {"55","50","60"};
		final String vecEnergia[]= {"55","60","50"};
		final String vecFuerza[]= {"15","10","10"};
		final String vecDestreza[]= {"10","10","15"};
		final String vecInteligencia[]= {"10","15","10"};
		
		// En caso de cerrar
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				personaje.setNombre(nombre.getText());
				if(nombre.getText().equals(""))
					personaje.setNombre("nameless");
				personaje.setRaza((String)cbxRaza.getSelectedItem());
				personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
				personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
				personaje.setCasta((String) cbxCasta.getSelectedItem());
				personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
				personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
				personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
				synchronized(cliente){
					cliente.notify();
				}
				dispose();
			}
		});
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Raza");
		lblNewLabel.setBounds(33, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setBounds(142, 23, 46, 14);
		contentPane.add(lblCasta);
		
		destreza = new JLabel("10");
		destreza.setBounds(142, 120, 46, 14);
		contentPane.add(destreza);
		
		inteligencia = new JLabel("10");
		inteligencia.setBounds(245, 120, 46, 14);
		contentPane.add(inteligencia);
		
		fuerza = new JLabel("15");
		fuerza.setBounds(32, 120, 46, 14);
		contentPane.add(fuerza);
		
		energia = new JLabel("55");
		energia.setBounds(142, 184, 46, 14);
		contentPane.add(energia);
		
		salud = new JLabel("55");
		salud.setBounds(32, 184, 46, 14);
		contentPane.add(salud);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(265, 23, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		nombre = new JTextField();
		nombre.setBounds(265, 48, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fuerza");
		lblNewLabel_5.setBounds(33, 100, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setBounds(142, 100, 46, 14);
		contentPane.add(lblDestreza);
		
		JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setBounds(245, 100, 66, 14);
		contentPane.add(lblInteligencia);
		
		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setBounds(33, 159, 46, 14);
		contentPane.add(lblSalud);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(142, 159, 46, 14);
		contentPane.add(lblEnergia);
		
		// En caso de apretar el boton aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personaje.setNombre(nombre.getText());
				if(nombre.getText().equals(""))
					personaje.setNombre("nameless");
				personaje.setRaza((String)cbxRaza.getSelectedItem());
				personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
				personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
				personaje.setCasta((String) cbxCasta.getSelectedItem());
				personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
				personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
				personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
				synchronized(cliente){
					cliente.notify();
				}
				dispose();
			}
		});
		btnAceptar.setBounds(265, 180, 89, 23);
		contentPane.add(btnAceptar);
		
		cbxRaza = new JComboBox<>();
		cbxRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
				energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
			}
		});
		
		cbxRaza.setBounds(32, 48, 76, 20);
		cbxRaza.addItem("Humano");
		cbxRaza.addItem("Elfo");
		cbxRaza.addItem("Orco");
		contentPane.add(cbxRaza);
		
		cbxCasta = new JComboBox<>();
		cbxCasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
				destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
				inteligencia.setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
			}
		});
		cbxCasta.setBounds(142, 48, 76, 20);
		cbxCasta.addItem("Guerrero");
		cbxCasta.addItem("Hechicero");
		cbxCasta.addItem("Asesino");
		contentPane.add(cbxCasta);
	}
}