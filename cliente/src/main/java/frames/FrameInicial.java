package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FrameInicial extends JFrame {

	private JPanel contentPane;
	private JButton btnRegistrarse;

	public FrameInicial(final Usuario u1,final Semaphore sem) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					u1.setAccion("salir");
					sem.release();
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		setTitle("WOME - World Of the Middle Earth");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIniciarSesion.setBounds(181, 90, 102, 23);
		contentPane.add(lblIniciarSesion);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegistrarse.setBackground(Color.WHITE);
		lblRegistrarse.setBounds(189, 160, 94, 23);
		contentPane.add(lblRegistrarse);
		
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBackground(Color.BLACK);
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIniciarSesion.setToolTipText("");
		btnIniciarSesion.setIcon(new ImageIcon(FrameInicial.class.getResource("/frames/BotonMenu.png")));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion is = new InicioSesion(u1,sem);
				is.setVisible(true);
				dispose();
			}
		});
		btnIniciarSesion.setBounds(123, 90, 191, 23);
		contentPane.add(btnIniciarSesion);
		
		btnRegistrarse = new JButton("");
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setIcon(new ImageIcon(FrameInicial.class.getResource("/frames/BotonMenu.png")));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro r1 = new Registro (u1,sem);
				r1.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setBounds(123, 160, 191, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(FrameInicial.class.getResource("/frames/menuBackground.jpg")));
		lblBackground.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackground);
	}
}

