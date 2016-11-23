package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import estados.Estado;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteDeMovimientos;
import mensajeria.PaqueteDePersonajes;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

public class EscuchaMensajes extends Thread {

	private Cliente cliente;
	private ObjectInputStream entrada;
	private final Gson gson = new Gson();
	
	private PaqueteBatalla paqueteBatalla;
	
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<Integer, PaquetePersonaje> personajesConectados;

	public EscuchaMensajes(Cliente cliente) {
		this.cliente = cliente;
		entrada = cliente.getEntrada();
	}

	public void run() {

		try {

			Paquete paquete;
			PaqueteMovimiento personaje;
			personajesConectados = new HashMap<>();
			ubicacionPersonajes = new HashMap<>();

			while (true) {
				
				String objetoLeido = (String)entrada.readObject();
				
				//System.out.println(objetoLeido);

				paquete = gson.fromJson(objetoLeido , Paquete.class);
				
				switch (paquete.getComando()) {
	
				case Comando.CONEXION:
					personajesConectados = (Map<Integer, PaquetePersonaje>) gson.fromJson(objetoLeido, PaqueteDePersonajes.class).getPersonajes();
					break;

				case Comando.MOVIMIENTO:
					ubicacionPersonajes = (Map<Integer, PaqueteMovimiento>) gson.fromJson(objetoLeido, PaqueteDeMovimientos.class).getPersonajes();
					break;
					
				case Comando.BATALLA:
					paqueteBatalla = gson.fromJson(objetoLeido, PaqueteBatalla.class);
					cliente.getPaquetePersonaje().setEstado(Estado.estadoBatalla);
					Estado.setEstado(cliente.getJuego().getEstadoBatalla());
					break;
					
				}
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			//System.exit(1);
			e.printStackTrace();
		}
	}

	public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
		return ubicacionPersonajes;
	}
	
	public Map<Integer, PaquetePersonaje> getPersonajesConectados(){
		return personajesConectados;
	}
}