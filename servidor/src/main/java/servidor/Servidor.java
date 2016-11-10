package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Servidor extends Thread {

	private static ArrayList<AtencionCliente> conectados = new ArrayList<>();
	private ServerSocket server;
	private final int puerto = 9999;
//	private final int puerto = 20001;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<AtencionCliente> getConectados() {
		return conectados;
	}

	public static void main(String[] args) {
		new Servidor().start();
	}

}
