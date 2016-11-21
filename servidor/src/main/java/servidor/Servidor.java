package servidor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cliente.PaquetePersonaje;

public class Servidor extends Thread {

	private static ArrayList<AtencionCliente> conectados = new ArrayList<>();
	private static Map<Integer, PaquetePersonaje> personajes = new HashMap<>();

	private static ServerSocket server;
	private static Conector conexionDB;
	private final int PUERTO = 9999;

	private final static int ANCHO = 700;
	private final static int ALTO = 640;
	private final static int ALTO_LOG = 520;
	private final static int ANCHO_LOG = ANCHO - 25;

	public static JTextArea log;

	public static void main(String[] args) {
		cargarInterfaz();
	}

	private static void cargarInterfaz() {
		JFrame ventana = new JFrame("Servidor WOME");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(ANCHO, ALTO);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);

		JLabel titulo = new JLabel("Log del servidor...");
		titulo.setFont(new Font("Courier New", Font.BOLD, 16));
		titulo.setBounds(10, 0, 200, 30);
		ventana.add(titulo);

		log = new JTextArea();
		log.setEditable(false);
		log.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		JScrollPane scroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 40, ANCHO_LOG, ALTO_LOG);
		ventana.add(scroll);

		JButton botonIniciar = new JButton();
		JButton botonDetener = new JButton();
		botonIniciar.setText("Iniciar");
		botonIniciar.setBounds(220, ALTO - 70, 100, 30);
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Servidor()).start();
				botonIniciar.setEnabled(false);
				botonDetener.setEnabled(true);
			}
		});

		ventana.add(botonIniciar);

		botonDetener.setText("Detener");
		botonDetener.setBounds(360, ALTO - 70, 100, 30);
		botonDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (AtencionCliente cliente : conectados) {
						cliente.getSalida().close();
						cliente.getEntrada().close();
						cliente.getSocket().close();
					}
					server.close();
				} catch (IOException e1) {
					log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
					e1.printStackTrace();
				}
				conexionDB.close();
				botonDetener.setEnabled(false);
				botonIniciar.setEnabled(true);
			}
		});

		ventana.add(botonDetener);

		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				if (server != null) {
					try {
						for (AtencionCliente cliente : conectados) {
							cliente.getSalida().close();
							cliente.getEntrada().close();
							cliente.getSocket().close();
						}
						server.close();
					} catch (IOException e) {
						log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
						e.printStackTrace();
						System.exit(1);
					}
				}
				if (conexionDB != null)
					conexionDB.close();
				System.exit(0);
			}
		});

		ventana.setVisible(true);
	}

	public void run() {
		try {

			log.append("Iniciando el servidor..." + System.lineSeparator());
			server = new ServerSocket(PUERTO);
			log.append("Servidor esperando conexiones..." + System.lineSeparator());
			String ipRemota;
			conexionDB = new Conector();
			conexionDB.connect();

			while (true) {
				Socket cliente = server.accept();
				ipRemota = cliente.getInetAddress().getHostAddress();
				log.append(ipRemota + " se ha conectado" + System.lineSeparator());

				ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				AtencionCliente atencion = new AtencionCliente(ipRemota, cliente, entrada, salida);
				atencion.start();
				conectados.add(atencion);
			}
		} catch (Exception e) {
			log.append("Fallo la conexión." + System.lineSeparator());
			e.printStackTrace();
		}
	}

	public static ArrayList<AtencionCliente> getConectados() {
		return conectados;
	}

	public static Map<Integer, PaquetePersonaje> getPersonajes() {
		return personajes;
	}

	public static Conector getConector() {
		return conexionDB;
	}
}