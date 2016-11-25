package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuCarga extends JFrame {
	
	private JPanel contentPane;
	private JLabel barraCargando;

	public MenuCarga(final Cliente cliente) {

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
		
		// Propiedades de la ventana
		setTitle("WOME - World Of the Middle Earth");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		barraCargando = new JLabel("");
		barraCargando.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/Barra.png")));
		barraCargando.setBounds(52, 160, 0, 27);
		contentPane.add(barraCargando);
		
		JLabel lblBarraCarga = new JLabel("");
		lblBarraCarga.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/BarraCarga.png")));
		lblBarraCarga.setBounds(47, 154, 355, 40);
		contentPane.add(lblBarraCarga);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
		lblLogo.setBounds(109, 39, 216, 90);
		contentPane.add(lblLogo);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackground);
		lblBackground.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/menuBackground.jpg")));
	}
	
	public void setBarraCargando(int ancho) {
		barraCargando.setSize(ancho, 27);
	}
}


