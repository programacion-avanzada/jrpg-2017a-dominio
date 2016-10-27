package juego;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Juego implements Runnable {

	private Pantalla pantalla;
	private final String NOMBRE;
	private final int ANCHO;
	private final int  ALTO;
	
	private Thread hilo;
	private boolean corriendo;
	
	private BufferStrategy bs; // Estrategia para graficar mediante buffers (Primero se "grafica" en el/los buffer/s y finalmente en el canvas)
	private Graphics g;	
	
	public Juego(final String nombre, final int ancho, final int alto) {
		this.NOMBRE = nombre;
		this.ALTO = alto;
		this.ANCHO = ancho;
	}

	public void iniciar() { // Carga lo necesario para iniciar el juego
		pantalla = new Pantalla(NOMBRE, ANCHO, ALTO);
	}
	
	private void actualizar() { // Actualiza los objetos y sus posiciones

	}
	
	private void graficar() { // Grafica los objetos y sus posiciones
		bs = pantalla.getCanvas().getBufferStrategy();
		if(bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
			pantalla.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g
		
		g.clearRect(0, 0, ANCHO, ALTO); // Limpiamos la pantalla
		
		// Graficado de imagenes
		

		
		// Fin de graficado de imagenes
		
		bs.show(); // Hace visible el próximo buffer disponible
		g.dispose();
	}
	
	@Override
	public void run() { // Hilo principal del juego
		iniciar();
		
		while(corriendo) {
			
		}
		
		stop();
	}
	
	public synchronized void start() { // Inicia el juego
		if(corriendo) return;
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
	}
	
	public synchronized void stop() { // Detiene el juego
		if(!corriendo) return;
		try {
			corriendo = false;
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getAncho() {
		return ANCHO;
	}
	
	public int getAlto() {
		return ALTO;
	}
}
