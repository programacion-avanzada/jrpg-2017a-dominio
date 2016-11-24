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
import javax.swing.JLayeredPane;

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

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 444, 271);
		contentPane.add(layeredPane);

		JLabel lblNewLabel_5 = new JLabel("Fuerza");
		lblNewLabel_5.setBounds(33, 100, 46, 14);
		layeredPane.add(lblNewLabel_5, new Integer(1));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));

		fuerza = new JLabel("15");
		fuerza.setBounds(110, 102, 22, 14);
		layeredPane.add(fuerza, new Integer(1));
		fuerza.setForeground(Color.GREEN);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setBounds(33, 126, 60, 14);
		layeredPane.add(lblDestreza, new Integer(1));
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, 13));

		destreza = new JLabel("10");
		destreza.setBounds(110, 127, 22, 14);
		layeredPane.add(destreza, new Integer(1));
		destreza.setForeground(Color.GREEN);

		JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setBounds(33, 151, 66, 22);
		layeredPane.add(lblInteligencia, new Integer(1));
		lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInteligencia.setForeground(Color.WHITE);

		inteligencia = new JLabel("10");
		inteligencia.setBounds(110, 156, 22, 14);
		layeredPane.add(inteligencia, new Integer(1));
		inteligencia.setForeground(Color.GREEN);

		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setBounds(33, 183, 46, 14);
		layeredPane.add(lblSalud, new Integer(1));
		lblSalud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalud.setForeground(Color.WHITE);

		salud = new JLabel("55");
		salud.setBounds(110, 183, 22, 14);
		layeredPane.add(salud, new Integer(1));
		salud.setForeground(Color.GREEN);

		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(33, 204, 46, 20);
		layeredPane.add(lblEnergia, new Integer(1));
		lblEnergia.setForeground(Color.WHITE);
		lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, 13));

		energia = new JLabel("55");
		energia.setBounds(110, 208, 22, 14);
		layeredPane.add(energia, new Integer(1));
		energia.setForeground(Color.GREEN);

		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(207, 125, 60, 14);
		layeredPane.add(lblNewLabel_4, new Integer(1));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		nombre = new JTextField();
		nombre.setBounds(277, 122, 122, 20);
		layeredPane.add(nombre, new Integer(1));
		nombre.setColumns(10);

		JLabel lblAceptar = new JLabel("Aceptar");
		lblAceptar.setBounds(280, 173, 50, 24);
		layeredPane.add(lblAceptar, new Integer(2));
		lblAceptar.setForeground(Color.WHITE);
		lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// En caso de apretar el boton aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(230, 174, 153, 23);
		layeredPane.add(btnAceptar, new Integer(1));
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
		
		JLabel lblNewLabel = new JLabel("Raza");
		lblNewLabel.setBounds(33, 23, 46, 14);
		layeredPane.add(lblNewLabel, new Integer(1));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setBounds(161, 23, 46, 14);
		layeredPane.add(lblCasta, new Integer(1));
		lblCasta.setForeground(Color.WHITE);
		lblCasta.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbxCasta = new JComboBox<>();
		cbxCasta.setBounds(161, 48, 76, 20);
		layeredPane.add(cbxCasta, new Integer(1));
		cbxCasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
				destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
				inteligencia.setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
			}
		});
		cbxCasta.addItem("Guerrero");
		cbxCasta.addItem("Hechicero");
		cbxCasta.addItem("Asesino");

		cbxRaza = new JComboBox<>();
		cbxRaza.setBounds(32, 48, 76, 20);
		layeredPane.add(cbxRaza, new Integer(1));
		cbxRaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
				energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
			}
		});
		cbxRaza.addItem("Humano");
		cbxRaza.addItem("Elfo");
		cbxRaza.addItem("Orco");
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 444, 271);
		layeredPane.add(lblBackground, new Integer(0));
		lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class.getResource("/frames/menuBackground.jpg")));
	}
}