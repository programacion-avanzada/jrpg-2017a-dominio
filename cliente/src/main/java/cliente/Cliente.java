package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.*;
import frames.*;




public class Cliente extends Thread {
	private Socket cliente;
	private String miIp;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Semaphore semaforo;
	private String nick;
	private String sala;
	private final Gson gson = new Gson();

	public Cliente(String ip, int puerto) throws UnknownHostException, IOException {
		cliente = new Socket(ip, puerto);
		miIp = cliente.getInetAddress().getHostAddress();
		salida = new ObjectOutputStream(cliente.getOutputStream());
		entrada = new ObjectInputStream(cliente.getInputStream());
		semaforo = new Semaphore(0);

	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public static <T> String conversor(Object obj, Class<T> clazz)//////////////////////////////////////////////////////////////
	{
		Gson gson = new Gson();
		return gson.toJson(obj, clazz);
	}

	public static <T> Object desconversor(String obj, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(obj, clazz);
	}

	

	public void run() {

		try {
			Usuario u1;
			FrameInicial fr1;
			boolean opcion = false;
			Personaje p1 = new Humano(); // auxiliar para la BD
			
			while (opcion == false) {
				Semaphore sem = new Semaphore(0);
				u1 = new Usuario(null, null, -1);
				fr1 = new FrameInicial(u1, sem);
				fr1.setVisible(true);
				sem.acquire();
				Paquete paquete = new Paquete();
		
				paquete.setMensaje(Cliente.conversor(u1, u1.getClass()));
				
				switch(u1.getAccion()){
				case "registro":paquete.setComando("registrar");
				break;
				case "inicioSesion":paquete.setComando("iniciarSesion");
				break;
				case "salir":paquete.setComando("salir");
				break;
				case "cerrar":paquete.setComando("cerrar");
				break;
				}

				salida.writeObject(gson.toJson(paquete));

				paquete = gson.fromJson((String) entrada.readObject(), Paquete.class);
				switch (paquete.getComando()) {
				case "estadoRegistro":
					if (paquete.getMensaje().equals("1")) {
						//PersonajeUser pjUser = new PersonajeUser();
						Personaje per = new Humano("nico",new Asesino(),-1);
						//CrearPersonaje cp = new CrearPersonaje(pjUser,sem);
						CrearPersonaje cp = new CrearPersonaje(per,sem);
						cp.setVisible(true);
						sem.acquire();
						paquete.setComando("creacionPersonaje");
					//	paquete.setMensaje(gson.toJson(pjUser));
					//	salida.writeObject(gson.toJson(paquete));
						
						salida.writeObject(gson.toJson(paquete));
						
						salida.writeObject(per);
						JOptionPane.showMessageDialog(null, "Registro exitoso");
						
						opcion = true;
					} else {
						if (paquete.getMensaje().equals("0"))
							JOptionPane.showMessageDialog(null, "No se pudo registrar");
						// crucecita
						opcion = false;
					}
					break;

				case "estadoInicioSesion":
					if (paquete.getMensaje().equals("1")) {
						JOptionPane.showMessageDialog(null, "Se pudo loguear");
						
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
					
				case "cerrar": opcion = false;
					break;
				}

			}
			Semaphore sem = new Semaphore(0);
			Paquete paquete = new Paquete(null, "mostrarMapas");
			ElegirMapa em = new ElegirMapa (paquete,sem);
			em.setVisible(true);
			sem.acquire();
			salida.writeObject(gson.toJson(paquete));
			
			paquete.setComando("desconectar");
			paquete.setIp(this.miIp);
			salida.writeObject(gson.toJson(paquete));

			System.out.println("SE TERMINO");
			cliente.close();
		} catch (IOException e) {
			System.out.println("Excepcion!");
			e.printStackTrace();
		} catch (InterruptedException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws UnknownHostException, IOException {
		Cliente cliente = new Cliente("localhost", 9999);
		// Cliente cliente = new Cliente("186.19.155.14", 9999);

		cliente.start();
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

}
