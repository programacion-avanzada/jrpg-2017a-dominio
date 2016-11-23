package estados;

import java.awt.Graphics;

import juego.Juego;

public abstract class Estado {

	private static Estado estadoActual = null; 
	
	// Tipo de estados
	public static int estadoOffline = 0;
	public static int estadoJuego = 1;
	public static int estadoBatalla = 2;
 
	protected Juego juego;
	
	public Estado(Juego juego) {
		this.juego = juego;
	}
	
	public abstract void actualizar();
	
	public abstract void graficar(Graphics g);
	
	public static void setEstado(Estado estado) {
		estadoActual = estado;
	}
	
	public static Estado getEstado() {
		return estadoActual;
	}
}
