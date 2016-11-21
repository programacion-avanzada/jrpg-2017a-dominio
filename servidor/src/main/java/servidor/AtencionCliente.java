package servidor;

import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;

import cliente.*;
import dominio.*;

public class AtencionCliente extends Thread {

	private final Socket socket;
	private final ObjectInputStream entrada;
	private final ObjectOutputStream salida;
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
			Usuario u1 = new Usuario();

			String cadenaLeida = (String) entrada.readObject();
			

			while (!((paquete = gson.fromJson(cadenaLeida, Paquete.class)).getComando().equals("desconectar"))){
				switch (paquete.getComando()) {
				
				case "registrar":
					paqueteSv.setComando("estadoRegistro");
					u1 = (Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class);

					if (Servidor.getConector().registrarUsuario(u1)) {
							paqueteSv.setMensaje("1");
							salida.writeObject(gson.toJson(paqueteSv));
					} else {
						paqueteSv.setMensaje("0");
						salida.writeObject(false);
					}
					break;

				case "creacionPersonaje":
					Personaje per;
					per = (Personaje) entrada.readObject();
					Servidor.getConector().registrarPersonaje(per, u1);
					salida.writeObject((int) per.getIdPersonaje());
					break;

				case "iniciarSesion":
					paqueteSv.setComando("estadoInicioSesion");
					if (Servidor.getConector().loguearUsuario((Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class))) {
						paqueteSv.setMensaje("1");
						salida.writeObject(gson.toJson(paqueteSv));
						PaquetePersonaje pp = Servidor.getConector()
								.getPersonaje((Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class));
						salida.writeObject(gson.toJson(pp));
					} else {
						paqueteSv.setMensaje("0");
						salida.writeObject(gson.toJson(paqueteSv));
					}
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
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosX(personaje.getPosX());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setPosY(personaje.getPosY());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setDireccion(personaje.getDireccion());
					Servidor.getPersonajes().get(personaje.getIdPersonaje()).setFrame(personaje.getFrame());
					
					for (AtencionCliente conectado : Servidor.getConectados()) {
						PaquetePersonaje pj = (PaquetePersonaje)Servidor.getPersonajes().get(personaje.getIdPersonaje()).clone();
						pj.setComando("movimiento");
						conectado.salida.writeObject(gson.toJson(pdp));
					}
					break;

				case "mostrarMapas":
					Servidor.log.append(paquete.getIp() + " ha elegido el mapa " + paquete.getMensaje() + System.lineSeparator());
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

			Servidor.log.append(paquete.getIp() + " se ha desconectado." + System.lineSeparator());

		} catch (IOException | ClassNotFoundException e) {
			Servidor.log.append("Error de conexion: " + e.getMessage() + System.lineSeparator());
			e.printStackTrace();
		} 
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public ObjectInputStream getEntrada() {
		return entrada;
	}
	
	public ObjectOutputStream getSalida() {
		return salida;
	}
}

