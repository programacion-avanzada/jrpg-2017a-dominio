package frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import cliente.Paquete;

public class ElegirMapa extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirMapa frame = new ElegirMapa(new Paquete(null,null),new Semaphore(0));
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Fallo al abrir la ventana de selección del mapa.");
					e.printStackTrace();
				}
			}
		});
	}

	public ElegirMapa(final Paquete p,final Semaphore sem) {
		setTitle("WOME - Elegir Mapa");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnAubenor = new JButton("");
		btnAubenor.setFocusable(false);
		btnAubenor.setIcon(new ImageIcon(ElegirMapa.class.getResource("/frames/BotonMenu.png")));
		btnAubenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setMensaje("1");
				sem.release();
				dispose();
			}
		});
		
		JLabel lblEodrim = new JLabel("Eodrim");
		lblEodrim.setForeground(Color.WHITE);
		lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEodrim.setBounds(196, 191, 53, 23);
		contentPane.add(lblEodrim);
		
		JLabel lblAris = new JLabel("Aris");
		lblAris.setForeground(Color.WHITE);
		lblAris.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAris.setBounds(204, 130, 32, 23);
		contentPane.add(lblAris);
		
		JLabel lblAubenor = new JLabel("Aubenor");
		lblAubenor.setForeground(Color.WHITE);
		lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAubenor.setBounds(194, 73, 66, 23);
		contentPane.add(lblAubenor);
		btnAubenor.setBounds(148, 73, 143, 23);
		contentPane.add(btnAubenor);
		
		JButton btnAris = new JButton("");
		btnAris.setFocusable(false);
		btnAris.setIcon(new ImageIcon(ElegirMapa.class.getResource("/frames/BotonMenu.png")));
		btnAris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setMensaje("2");
				sem.release();
				dispose();
			}
		});
		btnAris.setBounds(148, 130, 143, 23);
		contentPane.add(btnAris);
		
		JButton btnEodrim = new JButton("");
		btnEodrim.setFocusable(false);
		btnEodrim.setEnabled(false);
		btnEodrim.setIcon(new ImageIcon(ElegirMapa.class.getResource("/frames/BotonMenu.png")));
		btnEodrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setMensaje("3");
				sem.release();
				dispose();
			}
		});
		btnEodrim.setBounds(148, 191, 143, 23);
		contentPane.add(btnEodrim);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ElegirMapa.class.getResource("/frames/menuBackground.jpg")));
		lblBackground.setBounds(0, 0, 444, 271);
		contentPane.add(lblBackground);
	}
}

