package recursos;

import java.awt.image.BufferedImage;

public class Recursos {

	private static int ANCHO; // Ancho del tile a obtener
	private static int ALTO; // Alto del tile a obtener
	
	// Inicio Personajes
	public static BufferedImage[] guerreroIzq;
	public static BufferedImage[] guerreroArribaIzq;
	public static BufferedImage[] guerreroArriba;
	public static BufferedImage[] guerreroArribaDer;
	public static BufferedImage[] guerreroDer;
	public static BufferedImage[] guerreroAbajoDer;
	public static BufferedImage[] guerreroAbajo;
	public static BufferedImage[] guerreroAbajoIzq;
	
	public static BufferedImage[] ogroIzq;
	public static BufferedImage[] ogroArribaIzq;
	public static BufferedImage[] ogroArriba;
	public static BufferedImage[] ogroArribaDer;
	public static BufferedImage[] ogroDer;
	public static BufferedImage[] ogroAbajoDer;
	public static BufferedImage[] ogroAbajo;
	public static BufferedImage[] ogroAbajoIzq;
	// Fin Personajes
	
	// Entorno
	public static BufferedImage cesped;
	public static BufferedImage fuego;
	// Fin Entorno
	
	// Cargo todos los recursos una sola vez para no tener que hacerlo en cada actualizacion
	
	public static void cargar() {
		
		ANCHO = 256;
		ALTO = 256;
		// Inicio Guerrero
		SpriteSheet guerrero = new SpriteSheet(CargadorImagen.cargarImagen("/Guerrero.png"));
		
		guerreroIzq = new BufferedImage[4];
		guerreroArribaIzq = new BufferedImage[4];
		guerreroArriba = new BufferedImage[4];
		guerreroArribaDer = new BufferedImage[4];
		guerreroDer = new BufferedImage[4];
		guerreroAbajoDer = new BufferedImage[4];
		guerreroAbajo = new BufferedImage[4];
		guerreroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			guerreroIzq[i] = guerrero.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaIzq[i] = guerrero.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArriba[i] = guerrero.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaDer[i] = guerrero.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroDer[i] = guerrero.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoDer[i] = guerrero.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajo[i] = guerrero.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoIzq[i] = guerrero.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		// Fin Guerrero
		
		// Inicio Ogro
		SpriteSheet ogro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));
		
		ogroIzq = new BufferedImage[4];
		ogroArribaIzq = new BufferedImage[4];
		ogroArriba = new BufferedImage[4];
		ogroArribaDer = new BufferedImage[4];
		ogroDer = new BufferedImage[4];
		ogroAbajoDer = new BufferedImage[4];
		ogroAbajo = new BufferedImage[4];
		ogroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			ogroIzq[i] = ogro.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaIzq[i] = ogro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArriba[i] = ogro.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaDer[i] = ogro.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroDer[i] = ogro.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoDer[i] = ogro.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajo[i] = ogro.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoIzq[i] = ogro.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		// Fin Ogro
		
		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		fuego = CargadorImagen.cargarImagen("/Fuego.png");
		// Fin Entor
	}
}
