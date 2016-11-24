package recursos;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Recursos {

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener
	
	// Inicio Personajes
	// Hash de imagenes para los personajes (humano, ogro, elfo)
	public static Map<String, LinkedList<BufferedImage[]> > personaje = new HashMap<>();
	
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	private static BufferedImage[] humanoIzq;
	private static BufferedImage[] humanoArribaIzq; 
	private static BufferedImage[] humanoArriba;
	private static BufferedImage[] humanoArribaDer;
	private static BufferedImage[] humanoDer;
	private static BufferedImage[] humanoAbajoDer;
	private static BufferedImage[] humanoAbajo;
	private static BufferedImage[] humanoAbajoIzq;
	 
	
	public static LinkedList<BufferedImage[]> ogro = new LinkedList<>();
	private static BufferedImage[] ogroIzq;
	private static BufferedImage[] ogroArribaIzq;
	private static BufferedImage[] ogroArriba;
	private static BufferedImage[] ogroArribaDer;
	private static BufferedImage[] ogroDer;
	private static BufferedImage[] ogroAbajoDer;
	private static BufferedImage[] ogroAbajo;
	private static BufferedImage[] ogroAbajoIzq; 
	
	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	private static BufferedImage[] elfoIzq;
	private static BufferedImage[] elfoArribaIzq;
	private static BufferedImage[] elfoArriba;
	private static BufferedImage[] elfoArribaDer;
	private static BufferedImage[] elfoDer;
	private static BufferedImage[] elfoAbajoDer;
	private static BufferedImage[] elfoAbajo;
	private static BufferedImage[] elfoAbajoIzq; 
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
		
		// Inicio humano
		SpriteSheet spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));
		
		humanoIzq = new BufferedImage[4];
		humanoArribaIzq = new BufferedImage[4];
		humanoArriba = new BufferedImage[4];
		humanoArribaDer = new BufferedImage[4];
		humanoDer = new BufferedImage[4];
		humanoAbajoDer = new BufferedImage[4];
		humanoAbajo = new BufferedImage[4];
		humanoAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			humanoIzq[i] = spriteHumano.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoArribaIzq[i] = spriteHumano.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoArriba[i] = spriteHumano.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoArribaDer[i] = spriteHumano.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoDer[i] = spriteHumano.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoAbajoDer[i] = spriteHumano.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoAbajo[i] = spriteHumano.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		 humano.add(humanoIzq);
		 humano.add(humanoArribaIzq);
		 humano.add(humanoArriba);
		 humano.add(humanoArribaDer);
		 humano.add(humanoDer);
		 humano.add(humanoAbajoDer);
		 humano.add(humanoAbajo);
		 humano.add(humanoAbajoIzq);
		 // Fin humano
		
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
		
		// Inicio Elfo
		SpriteSheet spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/Elfo.png"));
		
		elfoIzq = new BufferedImage[4];
		elfoArribaIzq = new BufferedImage[4];
		elfoArriba = new BufferedImage[4];
		elfoArribaDer = new BufferedImage[4];
		elfoDer = new BufferedImage[4];
		elfoAbajoDer = new BufferedImage[4];
		elfoAbajo = new BufferedImage[4];
		elfoAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			elfoIzq[i] = spriteElfo.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArribaIzq[i] = spriteElfo.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArriba[i] = spriteElfo.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);
		
		// Fin Ogro
		
		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", ogro);
		personaje.put("Elfo", elfo);
		
		
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
