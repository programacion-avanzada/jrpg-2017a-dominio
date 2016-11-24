package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.PaquetePersonaje;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
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
		final String vecSalud[] = { "55", "50", "60" };
		final String vecEnergia[] = { "55", "60", "50" };
		final String vecFuerza[] = { "15", "10", "10" };
		final String vecDestreza[] = { "10", "10", "15" };
		final String vecInteligencia[] = { "10", "15", "10" };

		// En caso de cerrar
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				personaje.setNombre(nombre.getText());
				if (nombre.getText().equals(""))
					personaje.setNombre("nameless");
				personaje.setRaza((String) cbxRaza.getSelectedItem());
				personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
				personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
				personaje.setCasta((String) cbxCasta.getSelectedItem());
				personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
				personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
				personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
				synchronized (cliente) {
					cliente.notify();
				}
				dispose();
			}
		});

		setTitle("WOME - Crear personaje");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblAceptar = new JLabel("Aceptar");
		lblAceptar.setForeground(Color.WHITE);
		lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAceptar.setBounds(280, 173, 50, 24);
		contentPane.add(lblAceptar);

		JLabel lblNewLabel = new JLabel("Raza");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(33, 23, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setForeground(Color.WHITE);
		lblCasta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCasta.setBounds(161, 23, 46, 14);
		contentPane.add(lblCasta);

		destreza = new JLabel("10");
		destreza.setForeground(Color.GREEN);
		destreza.setBounds(110, 127, 46, 14);
		contentPane.add(destreza);

		inteligencia = new JLabel("10");
		inteligencia.setForeground(Color.GREEN);
		inteligencia.setBounds(110, 156, 46, 14);
		contentPane.add(inteligencia);

		fuerza = new JLabel("15");
		fuerza.setForeground(Color.GREEN);
		fuerza.setBounds(110, 102, 46, 14);
		contentPane.add(fuerza);

		energia = new JLabel("55");
		energia.setForeground(Color.GREEN);
		energia.setBounds(110, 208, 46, 14);
		contentPane.add(energia);

		salud = new JLabel("55");
		salud.setForeground(Color.GREEN);
		salud.setBounds(110, 183, 46, 14);
		contentPane.add(salud);

		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(207, 125, 60, 14);
		contentPane.add(lblNewLabel_4);

		nombre = new JTextField();
		nombre.setBounds(277, 122, 122, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Fuerza");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(33, 100, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestreza.setBounds(33, 126, 60, 14);
		contentPane.add(lblDestreza);

		JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setBounds(33, 152, 66, 21);
		contentPane.add(lblInteligencia);

		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setBounds(33, 183, 46, 14);
		contentPane.add(lblSalud);

		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setForeground(Color.WHITE);
		lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnergia.setBounds(33, 204, 46, 20);
		contentPane.add(lblEnergia);

		// En caso de apretar el boton aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFocusable(false);
		btnAceptar.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/BotonMenu.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personaje.setNombre(nombre.getText());
				if (nombre.getText().equals(""))
					personaje.setNombre("nameless");
				personaje.setRaza((String) cbxRaza.getSelectedItem());
				personaje.setSaludTope(Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
				personaje.setEnergiaTope(Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
				personaje.setCasta((String) cbxCasta.getSelectedItem());
				personaje.setFuerza(Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
				personaje.setDestreza(Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
				personaje.setInteligencia(Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
				synchronized (cliente) {
					cliente.notify();
				}
				dispose();
			}
		});
		btnAceptar.setBounds(230, 174, 153, 23);
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
		cbxCasta.setBounds(161, 48, 76, 20);
		cbxCasta.addItem("Guerrero");
		cbxCasta.addItem("Hechicero");
		cbxCasta.addItem("Asesino");
		contentPane.add(cbxCasta);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/menuBackground.jpg")));
		label.setBounds(0, 0, 444, 271);
		contentPane.add(label);
	}
}