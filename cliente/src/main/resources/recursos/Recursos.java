package recursos;

import java.awt.image.BufferedImage;

public class Recursos {

	private int ANCHO = 32; // Ancho del tile a obtener
	private int ALTO = 32; // Alto del tile a obtener
	
	public static BufferedImage prueba;
	
	// Cargo todos los recursos una sola vez para no tener que hacerlo en cada actualizacion
	public static void cargar() {
		prueba = CargadorImagen.cargarImagen("/Tree3.png");
	}
}
