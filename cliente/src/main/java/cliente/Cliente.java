package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.*;
import frames.*;
import juego.Juego;

public class Cliente extends Thread {
	private Socket socket;
	private String miIp;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Semaphore semaforo;
	private String sala;
	private final Gson gson = new Gson();

	public Cliente(String ip, int puerto) {
		try {
			socket = new Socket(ip, puerto);
			miIp = socket.getInetAddress().getHostAddress();
			entrada = new ObjectInputStream(socket.getInputStream());
			salida = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo al iniciar la aplicación. Revise la conexión con el servidor.");
			System.exit(1);
			e.printStackTrace();
		}
		
		semaforo = new Semaphore(0);
	}

	public void run() {

		try {
			Usuario u1;
			FrameInicial fr1;
			boolean opcion = false;
			Personaje per = new Humano();
			PaquetePersonaje pp = null;

			while (!opcion) {
				Semaphore sem = new Semaphore(0);
				u1 = new Usuario(null, null, -1);
				fr1 = new FrameInicial(u1, sem);
				fr1.setVisible(true);
				sem.acquire();
				Paquete paquete = new Paquete();

				paquete.setMensaje(Cliente.conversor(u1, u1.getClass()));

				switch (u1.getAccion()) {
				
				case "registro":
					paquete.setComando("registrar");
					break;
				case "inicioSesion":
					paquete.setComando("iniciarSesion");
					break;
				case "salir":
					paquete.setComando("salir");
					break;
				case "cerrar":
					paquete.setComando("cerrar");
					break;
				}

				salida.writeObject(gson.toJson(paquete));

				paquete = gson.fromJson((String) entrada.readObject(), Paquete.class);
				
				switch (paquete.getComando()) {
				
				case "estadoRegistro":
					if (paquete.getMensaje().equals("1")) {

						per = new Humano("nico", new Asesino(), -1);
						CrearPersonaje cp = new CrearPersonaje(per, sem);
						cp.setVisible(true);
						sem.acquire();
						paquete.setComando("creacionPersonaje");

						salida.writeObject(gson.toJson(paquete));
						salida.writeObject(per);
						JOptionPane.showMessageDialog(null, "Registro exitoso.");
						per.setIdPersonaje((int) entrada.readObject());
						opcion = true;

						pp = new PaquetePersonaje(per.getIdPersonaje(), per.getNombreRaza(), 0, 0, 0);
					} else {
						if (paquete.getMensaje().equals("0"))
							JOptionPane.showMessageDialog(null, "No se pudo registrar.");
						opcion = false;
					}
					break;

				case "estadoInicioSesion":
					if (paquete.getMensaje().equals("1")) {
						JOptionPane.showMessageDialog(null, "Se pudo loguear");
						pp = gson.fromJson((String) entrada.readObject(), PaquetePersonaje.class);
						opcion = true;
					} else {
						if (paquete.getMensaje().equals("0"))
							JOptionPane.showMessageDialog(null, "No se pudo loguear");

						opcion = false;
					}
					break;

				case "salir":
					opcion = true;
					break;

				case "cerrar":
					opcion = false;
					break;
				}

			}

			Semaphore sem = new Semaphore(0);
			Paquete paquete = new Paquete(null, "mostrarMapas");
			ElegirMapa em = new ElegirMapa(paquete, sem);
			em.setVisible(true);
			sem.acquire();
			pp.setMundo(Integer.parseInt(paquete.getMensaje()));
			paquete.setIp(miIp);
			salida.writeObject(gson.toJson(paquete));

			Juego wome = new Juego("World Of the Middle Earth", 800, 600, this, pp);
			wome.start();

		} catch (IOException | InterruptedException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor durante el inicio de sesión.");
			System.exit(1);
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws UnknownHostException, IOException {
		Cliente cliente = new Cliente("localhost", 9999);
		cliente.start();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getMiIp() {
		return miIp;
	}

	public void setMiIp(String miIp) {
		this.miIp = miIp;
	}

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public void liberarSemaforo() {
		semaforo.release();
	}

	public static <T> String conversor(Object obj, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.toJson(obj, clazz);
	}

	public static <T> Object desconversor(String obj, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(obj, clazz);
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

}
