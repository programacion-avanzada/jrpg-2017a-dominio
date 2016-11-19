package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import cliente.PaquetePersonaje;



public class Servidor extends Thread {

	private static ArrayList<AtencionCliente> conectados = new ArrayList<>();
	private static Map<Integer, PaquetePersonaje> personajes = new HashMap<>();
	private ServerSocket server;
	private final int puerto = 9999;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	
	
	public void run() {
		try {

			System.out.println("Iniciando el servidor...");
			server = new ServerSocket(puerto);
			System.out.println("Servidor esperando conexiones...");
			String ipRemota;

			while (true) {
				Socket cliente = server.accept();
				ipRemota = cliente.getInetAddress().getHostAddress();
				System.out.println(ipRemota + " se ha conectado");

				ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				AtencionCliente atencion = new AtencionCliente(ipRemota, cliente, entrada, salida);
				atencion.start();
				conectados.add(atencion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<AtencionCliente> getConectados() {
		return conectados;
	}
	
	public static Map<Integer, PaquetePersonaje> getPersonajes() {
		return personajes;
	}

	public static void main(String[] args) {
		new Servidor().start();
	}

}