package frames;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import dominio.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CrearPersonaje extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JLabel destreza;
	private JLabel fuerza;
	private JLabel inteligencia;
	private JLabel salud;
	private JLabel energia;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPersonaje frame = new CrearPersonaje(new Humano(),new Semaphore(0));
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Fallo al abrir la ventana de creación del personaje.");
					e.printStackTrace();
				}
			}
		});
	}

	public CrearPersonaje(final Personaje p1,final Semaphore sem) {
		final String vecSalud[]= {"55","50","60"};
		final String vecEnergia[]= {"55","60","50"};
		final String vecFuerza[]= {"15","10","10"};
		final String vecDestreza[]= {"10","10","15"};
		final String vecInteligencia[]= {"10","15","10"};
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setNombre(nombre.getText());
				sem.release();
				dispose();
			}
		});
		btnAceptar.setBounds(265, 180, 89, 23);
		contentPane.add(btnAceptar);
		
		final JComboBox comboBox1 = new JComboBox();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setNombreRaza((String) comboBox1.getSelectedItem());
				salud.setText(vecSalud[comboBox1.getSelectedIndex()]);
				energia.setText(vecEnergia[comboBox1.getSelectedIndex()]);
				p1.setSaludTope(Integer.parseInt(vecSalud[comboBox1.getSelectedIndex()]));
				p1.setEnergiaTope(Integer.parseInt(vecEnergia[comboBox1.getSelectedIndex()]));
				
			}
		});
		
		
		
		comboBox1.setBounds(32, 48, 76, 20);
		contentPane.add(comboBox1);
		comboBox1.addItem("Humano");
		comboBox1.addItem("Elfo");
		comboBox1.addItem("Orco");
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.getCasta().setNombreCasta((String) comboBox2.getSelectedItem());
				p1.setFuerza(Integer.parseInt(vecFuerza[comboBox2.getSelectedIndex()]));
				p1.setDestreza(Integer.parseInt(vecDestreza[comboBox2.getSelectedIndex()]));
				p1.setInteligencia(Integer.parseInt(vecInteligencia[comboBox2.getSelectedIndex()]));
				fuerza.setText(vecFuerza[comboBox2.getSelectedIndex()]);
				destreza.setText(vecDestreza[comboBox2.getSelectedIndex()]);
				inteligencia.setText(vecInteligencia[comboBox2.getSelectedIndex()]);
			}
		});
		comboBox2.setBounds(142, 48, 76, 20);
		contentPane.add(comboBox2);
		comboBox2.addItem("Guerrero");
		comboBox2.addItem("Hechicero");
		comboBox2.addItem("Asesino");
	}
}