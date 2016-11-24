package recursos;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Recursos {

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener
	
	// Inicio Personajes
	public static LinkedList<BufferedImage[]> guerrero = new LinkedList<>();
	private static BufferedImage[] guerreroIzq;
	private static BufferedImage[] guerreroArribaIzq; 
	private static BufferedImage[] guerreroArriba;
	private static BufferedImage[] guerreroArribaDer;
	private static BufferedImage[] guerreroDer;
	private static BufferedImage[] guerreroAbajoDer;
	private static BufferedImage[] guerreroAbajo;
	private static BufferedImage[] guerreroAbajoIzq;
	 
	
	public static LinkedList<BufferedImage[]> ogro = new LinkedList<>();
	private static BufferedImage[] ogroIzq;
	private static BufferedImage[] ogroArribaIzq;
	private static BufferedImage[] ogroArriba;
	private static BufferedImage[] ogroArribaDer;
	private static BufferedImage[] ogroDer;
	private static BufferedImage[] ogroAbajoDer;
	private static BufferedImage[] ogroAbajo;
	private static BufferedImage[] ogroAbajoIzq; 
	// Fin Personajes
	
	// Entorno
	public static BufferedImage cesped;
	public static BufferedImage roca;
	public static BufferedImage background;
	public static BufferedImage marco;
	public static BufferedImage botonMenu;
	// Fin Entorno
	
	// Batalla
	public static BufferedImage barraSpells;
	public static BufferedImage habilidad1;
	public static BufferedImage habilidad2;
	public static BufferedImage habilidad3;
	// Fin Batalla
	
	// Se cargan todos los recursos del juego una sola vez al inicio
	
	public static void cargar() {
		
		ANCHO = 256;
		ALTO = 256;
		// Inicio Guerrero
		SpriteSheet spriteGuerrero = new SpriteSheet(CargadorImagen.cargarImagen("/Guerrero.png"));
		
		guerreroIzq = new BufferedImage[4];
		guerreroArribaIzq = new BufferedImage[4];
		guerreroArriba = new BufferedImage[4];
		guerreroArribaDer = new BufferedImage[4];
		guerreroDer = new BufferedImage[4];
		guerreroAbajoDer = new BufferedImage[4];
		guerreroAbajo = new BufferedImage[4];
		guerreroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			guerreroIzq[i] = spriteGuerrero.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaIzq[i] = spriteGuerrero.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArriba[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaDer[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroDer[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoDer[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajo[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoIzq[i] = spriteGuerrero.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		 guerrero.add(guerreroIzq);
		 guerrero.add(guerreroArribaIzq);
		 guerrero.add(guerreroArriba);
		 guerrero.add(guerreroArribaDer);
		 guerrero.add(guerreroDer);
		 guerrero.add(guerreroAbajoDer);
		 guerrero.add(guerreroAbajo);
		 guerrero.add(guerreroAbajoIzq);
		 // Fin Guerrero
		
		// Inicio Ogro
		SpriteSheet spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));
		
		ogroIzq = new BufferedImage[4];
		ogroArribaIzq = new BufferedImage[4];
		ogroArriba = new BufferedImage[4];
		ogroArribaDer = new BufferedImage[4];
		ogroDer = new BufferedImage[4];
		ogroAbajoDer = new BufferedImage[4];
		ogroAbajo = new BufferedImage[4];
		ogroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			ogroIzq[i] = spriteOgro.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaIzq[i] = spriteOgro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArriba[i] = spriteOgro.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajo[i] = spriteOgro.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoIzq[i] = spriteOgro.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		ogro.add(ogroIzq);
		ogro.add(ogroArribaIzq);
		ogro.add(ogroArriba);
		ogro.add(ogroArribaDer);
		ogro.add(ogroDer);
		ogro.add(ogroAbajoDer);
		ogro.add(ogroAbajo);
		ogro.add(ogroAbajoIzq);
		
		// Fin Ogro
		
		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		roca = CargadorImagen.cargarImagen("/rock.png");
		background = CargadorImagen.cargarImagen("/background.jpg");
		marco = CargadorImagen.cargarImagen("/marco.png");
		botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		// Fin Entorno
		
		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		habilidad1 = CargadorImagen.cargarImagen("/habilidad1.png");
		habilidad2 = CargadorImagen.cargarImagen("/habilidad2.png");
		habilidad3 = CargadorImagen.cargarImagen("/habilidad3.png");
		// Fin Batalla
	}
}
