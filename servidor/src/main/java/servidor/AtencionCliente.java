package servidor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.*;
import dominio.*;

public class AtencionCliente extends Thread {

	private final Socket socket;
	private final ObjectInputStream entrada;
	private final ObjectOutputStream salida;
	private String salaCliente;
	private PaquetePersonaje personaje;
	private PaqueteDePersonajes pdp;
	private final Gson gson = new Gson();

	public AtencionCliente(String ip, Socket socket, ObjectInputStream entrada, ObjectOutputStream salida) {
		this.socket = socket;
		this.entrada = entrada;
		this.salida = salida;
	}

	public void run() {
		try {

			Paquete paquete;
			Paquete paqueteSv = new Paquete(null, null);
			Conector con;
			Semaphore semaforo = new Semaphore(0);
			Personaje p1 = new Humano(); // auxiliar para la BD
			Usuario u1 = new Usuario();

			String cadenaLeida = (String) entrada.readObject();
			

			while (!((paquete = gson.fromJson(cadenaLeida, Paquete.class)).getComando().equals("desconectar"))){
				switch (paquete.getComando()) {
				case "registrar":

					con = new Conector();
					con.connect();
					paqueteSv.setComando("estadoRegistro");
					u1 = (Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class);

					if (con.registrarUsuario(u1)) {
						{

							paqueteSv.setMensaje("1");
							salida.writeObject(gson.toJson(paqueteSv));
							con.mostrarUsuarios();
						}
					} else {
						paqueteSv.setMensaje("0");
						salida.writeObject(false);
					}
					con.close();
					break;

				case "creacionPersonaje":
					Personaje per;
					con = new Conector();
					con.connect();
					per = (Personaje) entrada.readObject();
					con.registrarPersonaje(per, u1);
					salida.writeObject((int) per.getIdPersonaje());
					break;

				case "iniciarSesion":
					con = new Conector();
					con.connect();
					paqueteSv.setComando("estadoInicioSesion");
					if (con.loguearUsuario((Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class))) {
						paqueteSv.setMensaje("1");
						salida.writeObject(gson.toJson(paqueteSv));
						PaquetePersonaje pp = con
								.getPersonaje((Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class));
						salida.writeObject(gson.toJson(pp));
					} else {
						paqueteSv.setMensaje("0");
						salida.writeObject(gson.toJson(paqueteSv));
					}
					con.close();
					break;

				case "salir":
					paqueteSv.setComando("salir");
					paqueteSv.setMensaje(null);
					salida.writeObject(gson.toJson(paqueteSv));
					break;

				case "cerrar":
					paqueteSv.setComando("cerrar");
					paqueteSv.setMensaje(null);
					salida.writeObject(gson.toJson(paqueteSv));
					break;

				case "conectado":
					personaje = (PaquetePersonaje) (gson.fromJson(cadenaLeida, PaquetePersonaje.class)).clone();

					Servidor.getPersonajes().put(personaje.getIdPersonaje(), (PaquetePersonaje) personaje.clone());

					for (AtencionCliente conectado : Servidor.getConectados()) {
						pdp = new PaqueteDePersonajes(Servidor.getPersonajes());
						pdp.setComando("conectado");
						conectado.salida.writeObject(gson.toJson(pdp));
					}
					break;

				case "movimiento":
					personaje = (PaquetePersonaje) (gson.fromJson((String) cadenaLeida, PaquetePersonaje.class));
					System.out.println(personaje.getIp()  + " recibi movimiento ");
							//.clone();
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosX(personaje.getPosX());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosY(personaje.getPosY());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setDireccion(personaje.getDireccion());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setFrame(personaje.getFrame());

					for (AtencionCliente conectado : Servidor.getConectados()) {
						PaquetePersonaje pj = (PaquetePersonaje)Servidor.getPersonajes().get(personaje.getIdPersonaje()).clone();
						pj.setComando("movimiento");
						System.out.println("Al cliente: " + conectado.getId() + " le envio " + gson.toJson(pdp));
						conectado.salida.writeObject(gson.toJson(pdp));
					}
					break;

				case "mostrarMapas":
					System.out.println("MAPA ELEGIDO: " + paquete.getMensaje());
					break;
					
					
				}
				cadenaLeida = (String) entrada.readObject();
			}

			entrada.close();
			salida.close();
			socket.close();

			Servidor.getPersonajes().remove(personaje.getIdPersonaje());
			Servidor.getConectados().remove(this);

			for (AtencionCliente conectado : Servidor.getConectados()) {
				pdp = new PaqueteDePersonajes(Servidor.getPersonajes());
				pdp.setComando("conectado");
				conectado.salida.writeObject(gson.toJson(pdp));
			}

			System.out.println(paquete.getIp() + " se ha desconectado.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

