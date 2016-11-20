package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.google.gson.Gson;

import juego.Juego;
import recursos.Recursos;

public class EscuchaMensajes extends Thread {

	private Cliente cliente;
	private ObjectInputStream entrada;
	private final Gson gson = new Gson();
	private Map<Integer, PaquetePersonaje> personajes;

	public EscuchaMensajes(Cliente cliente) {
		this.cliente = cliente;
		entrada = cliente.getEntrada();
	}

	public void run() {

		try {

			Paquete paquete;
			PaquetePersonaje personaje;
			personajes = new HashMap<>();

			while (true) {
				
				String objetoLeido = (String)entrada.readObject();

				paquete = gson.fromJson(objetoLeido , Paquete.class);
				
				switch (paquete.getComando()) {

				case "conectado":
					personajes = (Map<Integer, PaquetePersonaje>) gson.fromJson( objetoLeido, PaqueteDePersonajes.class).getPersonajes();
					break;

				case "movimiento":
					personaje = (PaquetePersonaje) gson.fromJson( objetoLeido , Paquete.class);
					personajes.get(personaje.getIdPersonaje()).setPosX(personaje.getPosX());
					personajes.get(personaje.getIdPersonaje()).setPosY(personaje.getPosY());
					personajes.get(personaje.getIdPersonaje()).setDireccion(personaje.getDireccion());
					personajes.get(personaje.getIdPersonaje()).setDireccion(personaje.getDireccion());
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			System.exit(1);
			e.printStackTrace();
		}
	}

	public Map<Integer, PaquetePersonaje> getPersonajes() {
		return personajes;
	}
}