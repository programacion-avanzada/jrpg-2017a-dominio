package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoJuego;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

public class Juego implements Runnable {
	
	private Pantalla pantalla;
	private final String NOMBRE;
	private final int ANCHO;
	private final int ALTO;

	private Thread hilo;
	private boolean corriendo;

	private BufferStrategy bs; // Estrategia para graficar mediante buffers (Primero se "grafica" en el/los buffer/s y finalmente en el canvas)
	private Graphics g;

	// Estados
	private Estado estadoJuego;
	private Estado estadoBatalla;

	// HandlerMouse
	private HandlerMouse handlerMouse;
	
	// Camara
	private Camara camara;

	// Conexion
	private Cliente cliente;
	private EscuchaMensajes escuchaMensajes;
	private PaquetePersonaje paquetePersonaje;
	private PaqueteMovimiento ubicacionPersonaje;
	

	public Juego(final String nombre, final int ancho, final int alto, Cliente cliente, PaquetePersonaje pp) {
		this.NOMBRE = nombre;
		this.ALTO = alto;
		this.ANCHO = ancho;
		this.cliente = cliente;
		this.paquetePersonaje = pp;
		
		// Inicializo la ubicacion del personaje 
		ubicacionPersonaje = new PaqueteMovimiento();
		ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
		ubicacionPersonaje.setFrame(0);
		ubicacionPersonaje.setDireccion(6);
		
		// Creo el escucha de mensajes
		escuchaMensajes = new EscuchaMensajes(this);
		escuchaMensajes.start();
		
		handlerMouse = new HandlerMouse();
	}

	public void iniciar() { // Carga lo necesario para iniciar el juego
		pantalla = new Pantalla(NOMBRE, ANCHO, ALTO, cliente);

		pantalla.getCanvas().addMouseListener(handlerMouse);

		Recursos.cargar();

		camara = new Camara(this, 0, 0);
		
		estadoJuego = new EstadoJuego(this);
		
		Estado.setEstado(estadoJuego);
		
		Personaje.cargarTablaNivel();
	}

	private void actualizar() { // Actualiza los objetos y sus posiciones
		handlerMouse.actualizar();

		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}

	private void graficar() { // Grafica los objetos y sus posiciones
		bs = pantalla.getCanvas().getBufferStrategy();
		if (bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
			pantalla.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

		g.clearRect(0, 0, ANCHO, ALTO); // Limpiamos la pantalla

		// Graficado de imagenes
		g.setFont(new Font("Book Antiqua",1,15));
	
		if (Estado.getEstado() != null) {
			Estado.getEstado().graficar(g);
		}

		// Fin de graficado de imagenes

		bs.show(); // Hace visible el próximo buffer disponible
		g.dispose();
	}

	@Override
	public void run() { // Hilo principal del juego
		iniciar();

		int fps = 60; // Cantidad de actualizaciones por segundo que se desean
		double tiempoPorActualizacion = 1000000000 / fps; // Cantidad de nanosegundos en FPS deseados
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; // Timer para mostrar fps cada un segundo
		int actualizaciones = 0; // Cantidad de actualizaciones que se realizan realmente

		while (corriendo) {
			ahora = System.nanoTime();
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; // Calculo  para determinar cuando realizar la actualizacion y el graficado
			timer += ahora - ultimoTiempo; // Sumo el tiempo transcurrido hasta que se acumule 1 segundo y mostrar los FPS
			ultimoTiempo = ahora; // Para las proximas corridas del bucle

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}

			if (timer >= 1000000000) { // Si paso 1 segundo muestro los FPS
				pantalla.getFrame().setTitle(NOMBRE + " | " + "FPS: " + fps);
				actualizaciones = 0;
				timer = 0;
			}
		}

		stop();
	}

	public synchronized void start() { // Inicia el juego
		if (corriendo)
			return;
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
	}

	public synchronized void stop() { // Detiene el juego
		if (!corriendo)
			return;
		try {
			corriendo = false;
			hilo.join();
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Fallo al intentar detener el juego.");
			e.printStackTrace();
		}
	}

	public int getAncho() {
		return ANCHO;
	}

	public int getAlto() {
		return ALTO;
	}

	public HandlerMouse getHandlerMouse() {
		return handlerMouse;
	}
	
	public Camara getCamara() {
		return camara;
	}
	
	public EstadoJuego getEstadoJuego() {
		return (EstadoJuego) estadoJuego;
	}
	
	public EstadoBatalla getEstadoBatalla(){
		return (EstadoBatalla) estadoBatalla;
	}
	
	public void setEstadoBatalla(EstadoBatalla estadoBatalla){
		this.estadoBatalla = estadoBatalla;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public EscuchaMensajes getEscuchaMensajes() {
		return escuchaMensajes;
	}
	
	public PaquetePersonaje getPersonaje() {
		return paquetePersonaje;
	}
	
	public PaqueteMovimiento getUbicacionPersonaje(){
		return ubicacionPersonaje;
	}
	
	public void setPersonaje(PaquetePersonaje paquetePersonaje) {
		this.paquetePersonaje = paquetePersonaje;
	}
}
