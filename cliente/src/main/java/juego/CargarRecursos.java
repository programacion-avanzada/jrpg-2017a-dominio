package juego;

import cliente.Cliente;
import mensajeria.Comando;
import recursos.Recursos;

public class CargarRecursos extends Thread {

	private Cliente cliente;
	
	public CargarRecursos(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public void run() {
		synchronized (cliente) {
			Recursos.cargar(cliente.getMenuCarga());
			
			cliente.setAccion(Comando.SALIR);
			cliente.notify();
		}
	}

}
