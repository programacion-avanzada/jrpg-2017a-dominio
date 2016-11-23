package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import cliente.Cliente;
import estados.Estado;
import mensajeria.Comando;
import mensajeria.PaqueteDePersonajes;

public class AtencionConexiones extends Thread {
	
	private final Gson gson = new Gson();

	public AtencionConexiones() {
		
	}

	public void run() {

		synchronized(this){
			try {
	
				while (true) {
			
					// Espero a que se conecte alguien
					wait();
					
					// Le reenvio la conexion a todos
					for (EscuchaCliente conectado : Servidor.getClientesConectados()) {
						
						if(conectado.getPaquetePersonaje().getEstado() != Estado.estadoOffline){
							
							PaqueteDePersonajes pdp = (PaqueteDePersonajes) new PaqueteDePersonajes(Servidor.getPersonajesConectados()).clone();
							pdp.setComando(Comando.CONEXION);
							conectado.getSalida().writeObject(gson.toJson(pdp));	
							
							
						}
						
						
					}
					
				}
				
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}