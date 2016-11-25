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
	 
	
	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	private static BufferedImage[] orcoIzq;
	private static BufferedImage[] orcoArribaIzq;
	private static BufferedImage[] orcoArriba;
	private static BufferedImage[] orcoArribaDer;
	private static BufferedImage[] orcoDer;
	private static BufferedImage[] orcoAbajoDer;
	private static BufferedImage[] orcoAbajo;
	private static BufferedImage[] orcoAbajoIzq; 
	
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
	public static BufferedImage menuEnemigo;
	// Fin Entorno
	
	// Batalla
	public static BufferedImage barraSpells;
	public static BufferedImage estadoPersonaje;
	public static BufferedImage barraSalud;
	public static BufferedImage barraEnergia;
	public static BufferedImage barraExperiencia;
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
		
		orcoIzq = new BufferedImage[4];
		orcoArribaIzq = new BufferedImage[4];
		orcoArriba = new BufferedImage[4];
		orcoArribaDer = new BufferedImage[4];
		orcoDer = new BufferedImage[4];
		orcoAbajoDer = new BufferedImage[4];
		orcoAbajo = new BufferedImage[4];
		orcoAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			orcoIzq[i] = spriteOgro.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoArribaIzq[i] = spriteOgro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoArriba[i] = spriteOgro.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoArribaDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoAbajoDer[i] = spriteOgro.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoAbajo[i] = spriteOgro.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		orco.add(orcoIzq);
		orco.add(orcoArribaIzq);
		orco.add(orcoArriba);
		orco.add(orcoArribaDer);
		orco.add(orcoDer);
		orco.add(orcoAbajoDer);
		orco.add(orcoAbajo);
		orco.add(orcoAbajoIzq);
		
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
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);
		
		
		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		roca = CargadorImagen.cargarImagen("/rock.png");
		background = CargadorImagen.cargarImagen("/background.jpg");
		marco = CargadorImagen.cargarImagen("/marco.png");
		botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		menuEnemigo = CargadorImagen.cargarImagen("/MenuEnemigo.png");
		// Fin Entorno
		
		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
		barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
		barraEnergia = CargadorImagen.cargarImagen("/BarraDeEnergia.png");
		barraExperiencia = CargadorImagen.cargarImagen("/BarraDeExperiencia.png");
		habilidad1 = CargadorImagen.cargarImagen("/habilidad1.png");
		habilidad2 = CargadorImagen.cargarImagen("/habilidad2.png");
		habilidad3 = CargadorImagen.cargarImagen("/habilidad3.png");
		// Fin Batalla
	}
}
