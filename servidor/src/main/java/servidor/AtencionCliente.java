package servidor;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
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
			String mensaje;
			Conector con;
			Semaphore semaforo = new Semaphore(0);
			Personaje p1 = new Humano(); // auxiliar para la BD
			Usuario u1 = new Usuario();
			
			while (!((paquete = gson.fromJson((String) entrada.readObject(), Paquete.class)).getComando()
					.equals("desconectar")))
				switch (paquete.getComando()) {
				case "registrar":
				
					con = new Conector();
					con.connect();
					paqueteSv.setComando("estadoRegistro");
					u1 = (Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class);
					
					if (con.registrarUsuario(u1)){
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
										//PersonajeUser pjUser = new PersonajeUser();
										Personaje per;
										con = new Conector();
										con.connect();
									//	pjUser = (PersonajeUser) Cliente.desconversor(paquete.getMensaje(), PersonajeUser.class);
									//	con.registrarPersonaje(pjUser,u1);
										per = (Personaje) entrada.readObject();
										con.registrarPersonaje(per,u1);
									//	System.out.println(per.getNombre()+" "+per.getIdPersonaje());
										break;
				case "iniciarSesion":
					con = new Conector();
					con.connect();
					paqueteSv.setComando("estadoInicioSesion");
					if (con.loguearUsuario((Usuario) Cliente.desconversor(paquete.getMensaje(), Usuario.class))) {
						paqueteSv.setMensaje("1");
						salida.writeObject(gson.toJson(paqueteSv));
					//	con.mostrarUsuarios();
					} else {
						paqueteSv.setMensaje("0");
						salida.writeObject(gson.toJson(paqueteSv));
					}
					con.close();
					break;

				case "salir":paqueteSv.setComando("salir");
							paqueteSv.setMensaje(null);
							salida.writeObject(gson.toJson(paqueteSv));
							break;
				
				case "cerrar":paqueteSv.setComando("cerrar");
				paqueteSv.setMensaje(null);
				salida.writeObject(gson.toJson(paqueteSv));
				break;
							
				case "conectado":
					for (AtencionCliente conectado : Servidor.getConectados()) {
						if (paquete.getSala().equals(conectado.salaCliente))
							conectado.salida.writeObject(gson.toJson(paquete));
					}
					break;

				case "mensaje":
					for (AtencionCliente conectado : Servidor.getConectados()) {
						if (paquete.getSala().equals(conectado.salaCliente) && !conectado.equals(this))
							conectado.salida.writeObject(gson.toJson(paquete));
					}
					break;
					
				case "mostrarMapas":
					System.out.println("MAPA ELEGIDO: "+paquete.getMensaje());
					break;
				}

			entrada.close();
			salida.close();
			socket.close();

		
			Servidor.getConectados().remove(this);

			System.out.println(paquete.getIp() + " se ha desconectado.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
