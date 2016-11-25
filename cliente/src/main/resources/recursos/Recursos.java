package recursos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import frames.MenuCarga;

public class Recursos {

	private static int ELEMENTOS = 59;
	private static int ANCHOBARRA = 345;

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener

	// Inicio Personajes
	// Hash de imagenes para los personajes (humano, ogro, elfo)
	public static Map<String, LinkedList<BufferedImage[]>> personaje = new HashMap<>();

	private static SpriteSheet spriteHumano;
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	private static BufferedImage[] humanoIzq;
	private static BufferedImage[] humanoArribaIzq;
	private static BufferedImage[] humanoArriba;
	private static BufferedImage[] humanoArribaDer;
	private static BufferedImage[] humanoDer;
	private static BufferedImage[] humanoAbajoDer;
	private static BufferedImage[] humanoAbajo;
	private static BufferedImage[] humanoAbajoIzq;

	private static SpriteSheet spriteOgro;
	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	private static BufferedImage[] orcoIzq;
	private static BufferedImage[] orcoArribaIzq;
	private static BufferedImage[] orcoArriba;
	private static BufferedImage[] orcoArribaDer;
	private static BufferedImage[] orcoDer;
	private static BufferedImage[] orcoAbajoDer;
	private static BufferedImage[] orcoAbajo;
	private static BufferedImage[] orcoAbajoIzq;

	private static SpriteSheet spriteElfo;
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
	public static BufferedImage greenTree;
	// Fin Entorno

	// Batalla
	public static BufferedImage barraSpells;
	public static BufferedImage estadoPersonaje;
	public static BufferedImage barraSalud;
	public static BufferedImage barraEnergia;
	public static BufferedImage barraExperiencia;
	public static BufferedImage menuBatalla;
	public static BufferedImage menuBatallaDeshabilitado;
	
	public static Map<String, BufferedImage> habilidades = new HashMap<>();
	// Fin Batalla
	

	// Se cargan todos los recursos del juego una sola vez al inicio

	public static void cargar(MenuCarga menuCarga) {
		
		int elementosCargados = 0;
		
		ANCHO = 256;
		ALTO = 256;

		// Inicio humano
		spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		humanoIzq = new BufferedImage[4];
		humanoArribaIzq = new BufferedImage[4];
		humanoArriba = new BufferedImage[4];
		humanoArribaDer = new BufferedImage[4];
		humanoDer = new BufferedImage[4];
		humanoAbajoDer = new BufferedImage[4];
		humanoAbajo = new BufferedImage[4];
		humanoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			humanoIzq[i] = spriteHumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < 4; i++) {
			humanoArribaIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			humanoArriba[i] = spriteHumano.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < 4; i++) {
			humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < 4; i++) {
			humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < 4; i++) {
			humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
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
		spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		orcoIzq = new BufferedImage[4];
		orcoArribaIzq = new BufferedImage[4];
		orcoArriba = new BufferedImage[4];
		orcoArribaDer = new BufferedImage[4];
		orcoDer = new BufferedImage[4];
		orcoAbajoDer = new BufferedImage[4];
		orcoAbajo = new BufferedImage[4];
		orcoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			orcoIzq[i] = spriteOgro.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoArribaIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoArriba[i] = spriteOgro.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoArribaDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoAbajoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoAbajo[i] = spriteOgro.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
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
		spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/Elfo.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		elfoIzq = new BufferedImage[4];
		elfoArribaIzq = new BufferedImage[4];
		elfoArriba = new BufferedImage[4];
		elfoArribaDer = new BufferedImage[4];
		elfoDer = new BufferedImage[4];
		elfoAbajoDer = new BufferedImage[4];
		elfoAbajo = new BufferedImage[4];
		elfoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < 4; i++) {
			elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		for (int i = 0; i < 4; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);

		// Fin Elfo

		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);

		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		roca = CargadorImagen.cargarImagen("/rock.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		background = CargadorImagen.cargarImagen("/background.jpg");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		marco = CargadorImagen.cargarImagen("/marco.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		menuEnemigo = CargadorImagen.cargarImagen("/MenuEnemigo.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		SpriteSheet trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));  
		greenTree = trees.getTile(0, 0, 42, 50);
		// Fin Entorno

		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraEnergia = CargadorImagen.cargarImagen("/BarraDeEnergia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraExperiencia = CargadorImagen.cargarImagen("/BarraDeExperiencia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Level", CargadorImagen.cargarImagen("/Golpe Level.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ataque Bosque", CargadorImagen.cargarImagen("/Ataque Bosque.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Defensa", CargadorImagen.cargarImagen("/Golpe Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Mordisco de Vida", CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Incentivar", CargadorImagen.cargarImagen("/Incentivar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Fatal", CargadorImagen.cargarImagen("/Golpe Fatal.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ataque Doble", CargadorImagen.cargarImagen("/Ataque Doble.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Aumentar Defensa", CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ignorar Defensa", CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Bola de Fuego", CargadorImagen.cargarImagen("/Bola de Fuego.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Curar Aliado", CargadorImagen.cargarImagen("/Curar Aliado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Robar Energía y Salud", CargadorImagen.cargarImagen("/Robar Energia y Salud.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Crítico", CargadorImagen.cargarImagen("/Golpe Critico.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Aumentar Evasión", CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ser Energizado", CargadorImagen.cargarImagen("/Ser Energizado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		menuBatalla = CargadorImagen.cargarImagen("/MenuBatalla.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		menuBatallaDeshabilitado = CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// Fin Batalla
	}

	private static void actualizarBarraDeCarga(int elementosCargados, MenuCarga menuCarga) {
		menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
	}
}
