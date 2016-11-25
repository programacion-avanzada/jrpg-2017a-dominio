package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Item;
import dominio.Orco;
import dominio.Personaje;
import entidades.Animacion;
import entidades.Entidad;
import interfaz.InterfazGrafica;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoBatalla extends Estado {

	private Mundo mundo;
	private Personaje personaje;
	private Personaje enemigo;
	private Entidad entidadPersonaje;
	private Entidad entidadEnemigo;
	private int[] posMouse;
	private PaquetePersonaje paquetePersonaje;
	private PaquetePersonaje paqueteEnemigo;
	private PaqueteAtacar paqueteAtacar;
	private PaqueteFinalizarBatalla paqueteFinalizarBatalla;
	private boolean miTurno;
	private boolean haySpellSeleccionada;

	private Gson gson = new Gson();

	private final int XSPELLS;
	private final int YSPELLS;
	private final int ANCHOSPELL = 42;
	private final int SEPARACION = 6;
	private BufferedImage miniaturaPersonaje;
	private BufferedImage miniaturaEnemigo;
	
	public EstadoBatalla(Juego juego, PaqueteBatalla paqueteBatalla) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundoBatalla.txt");
		miTurno = paqueteBatalla.isMiTurno();

		paquetePersonaje = juego.getEscuchaMensajes().getPersonajesConectados().get(paqueteBatalla.getId());
		paqueteEnemigo = juego.getEscuchaMensajes().getPersonajesConectados().get(paqueteBatalla.getIdEnemigo());

		entidadPersonaje = new Entidad(juego, mundo, 128, 128, paquetePersonaje.getNombre(), 0, 0, Recursos.personaje.get(paquetePersonaje.getRaza()), 150);
		entidadEnemigo = new Entidad(juego, mundo, 128, 128, paqueteEnemigo.getNombre(), 0, 0, Recursos.personaje.get(paqueteEnemigo.getRaza()), 150);

		crearPersonajes();

		entidadPersonaje.setX(-150);
		entidadPersonaje.setY(350);

		entidadEnemigo.setX(200);
		entidadEnemigo.setY(350);
		juego.getCamara().setxOffset(-350);
		juego.getCamara().setyOffset(150);

		XSPELLS = 3;
		YSPELLS = juego.getAlto() - 60;
		
		paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
		paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
		paqueteFinalizarBatalla.setIdEnemigo(enemigo.getIdPersonaje());
		
	}

	@Override
	public void actualizar() {
		haySpellSeleccionada = false;

		if (miTurno) {
			if (juego.getHandlerMouse().getNuevoRecorrido()) {
				posMouse = juego.getHandlerMouse().getPosMouse();

				if (posMouse[1] >= YSPELLS + 7 && posMouse[1] <= YSPELLS + 54) {

					if (posMouse[0] >= XSPELLS && posMouse[0] <= XSPELLS + ANCHOSPELL) {
						personaje.habilidadCasta1(enemigo);
						haySpellSeleccionada = true;
					}

					if (posMouse[0] >= XSPELLS + 2 * SEPARACION + ANCHOSPELL && posMouse[0] <= XSPELLS + 2 * (SEPARACION + ANCHOSPELL)) {
						personaje.habilidadCasta2(enemigo);
						haySpellSeleccionada = true;
					}

					if (posMouse[0] >= XSPELLS + 3 * SEPARACION + 2 * ANCHOSPELL && posMouse[0] <= XSPELLS + 3 * (SEPARACION + ANCHOSPELL)) {
						personaje.habilidadCasta3(enemigo);
						haySpellSeleccionada = true;
					}

					if (posMouse[0] >= XSPELLS + 4 * SEPARACION + 3 * ANCHOSPELL && posMouse[0] <= XSPELLS + 4 * (SEPARACION + ANCHOSPELL)) {
						haySpellSeleccionada = true;
					}

					if (posMouse[0] >= XSPELLS + 5 * SEPARACION + 4 * ANCHOSPELL && posMouse[0] <= XSPELLS + 5 * (SEPARACION + ANCHOSPELL)) {
						haySpellSeleccionada = true;
					}

					if (posMouse[0] >= XSPELLS + 6 * SEPARACION + 5 * ANCHOSPELL && posMouse[0] <= XSPELLS + 6 * (SEPARACION + ANCHOSPELL)) {
						haySpellSeleccionada = true;
					}
				}

				if (haySpellSeleccionada) {
					if (!enemigo.estaVivo()) {
						personaje.ganarExperiencia(enemigo.getNivel() * 40);
						finalizarBatalla();
						Estado.setEstado(juego.getEstadoJuego());
					} else {
						paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigo.getId(), enemigo.getSalud(), personaje.getEnergia());
						enviarAtaque(paqueteAtacar);
						miTurno = false;
					}
				}

				juego.getHandlerMouse().setNuevoRecorrido(false);
			}
		}
		
	}

	@Override
	public void graficar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		mundo.graficar(g);
		
		g.drawImage(Recursos.personaje.get(paquetePersonaje.getRaza()).get(3)[0], 0, 200, 256, 256, null);
		g.drawImage(Recursos.personaje.get(paqueteEnemigo.getRaza()).get(7)[0], 550, 100, 256, 256, null);
		
		if (miTurno) {
			g.drawImage(Recursos.barraSpells, 0, YSPELLS, 300, 60, null);
			g.drawImage(Recursos.habilidad1, XSPELLS, YSPELLS + 7, 40, 48, null);
			g.drawImage(Recursos.habilidad2, XSPELLS + 2 * SEPARACION + ANCHOSPELL, YSPELLS + 7, 40, 48, null);
			g.drawImage(Recursos.habilidad3, XSPELLS + 3 * SEPARACION + 2 * ANCHOSPELL, YSPELLS + 7, 40, 48, null);
		}
		
		g.setColor(Color.RED);
		g.drawString(paqueteEnemigo.getCasta(),(int) (200 - juego.getCamara().getxOffset() + entidadEnemigo.getxOffset() / 2), (int) (480 - juego.getCamara().getyOffset()));
		g.setColor(Color.GREEN);
		
		InterfazGrafica.dibujarEstadoDePersonaje(g, 25, 5, personaje, miniaturaPersonaje);
		InterfazGrafica.dibujarEstadoDePersonaje(g, 550, 5, enemigo, miniaturaEnemigo);
	}
	
	private void crearPersonajes() {
		String nombre = paquetePersonaje.getNombre();
		int salud = paquetePersonaje.getSaludTope();
		int energia = paquetePersonaje.getEnergiaTope();
		int fuerza = paquetePersonaje.getFuerza();
		int destreza = paquetePersonaje.getDestreza();
		int inteligencia = paquetePersonaje.getInteligencia();
		LinkedList<Item> itemsEquipados = new LinkedList<>();
		LinkedList<Item> itemsGuardados = new LinkedList<>();
		int experiencia = paquetePersonaje.getExperiencia();
		int nivel = paquetePersonaje.getNivel();
		int id = paquetePersonaje.getId();

		Casta casta = null;
		if (paquetePersonaje.getCasta().equals("Guerrero")) {
			casta = new Guerrero();
		} else if (paquetePersonaje.getCasta().equals("Hechicero")) {
			casta = new Hechicero();
		} else if (paquetePersonaje.getCasta().equals("Asesino")) {
			casta = new Asesino();
		}

		if (paquetePersonaje.getRaza().equals("Humano")) {
			personaje = new Humano(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaPersonaje = Recursos.humano.get(5)[0];
		} else if (paquetePersonaje.getRaza().equals("Orco")) {
			personaje = new Orco(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaPersonaje = Recursos.orco.get(5)[0];
		} else if (paquetePersonaje.getRaza().equals("Elfo")) {
			personaje = new Elfo(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaPersonaje = Recursos.elfo.get(5)[0];
		}

		nombre = paqueteEnemigo.getNombre();
		salud = paqueteEnemigo.getSaludTope();
		energia = paqueteEnemigo.getEnergiaTope();
		fuerza = paqueteEnemigo.getFuerza();
		destreza = paqueteEnemigo.getDestreza();
		inteligencia = paqueteEnemigo.getInteligencia();
		itemsEquipados = new LinkedList<>();
		itemsGuardados = new LinkedList<>();
		experiencia = paqueteEnemigo.getExperiencia();
		nivel = paqueteEnemigo.getNivel();
		id = paqueteEnemigo.getId();

		casta = null;
		if (paqueteEnemigo.getCasta().equals("Guerrero")) {
			casta = new Guerrero();
		} else if (paqueteEnemigo.getCasta().equals("Hechicero")) {
			casta = new Hechicero();
		} else if (paqueteEnemigo.getCasta().equals("Asesino")) {
			casta = new Asesino();
		}

		if (paqueteEnemigo.getRaza().equals("Humano")) {
			enemigo = new Humano(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaEnemigo = Recursos.humano.get(5)[0];
		} else if (paqueteEnemigo.getRaza().equals("Orco")) {
			enemigo = new Orco(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaEnemigo = Recursos.orco.get(5)[0];
		} else if (paqueteEnemigo.getRaza().equals("Elfo")) {
			enemigo = new Elfo(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados,
					itemsGuardados, experiencia, nivel, id);
			miniaturaEnemigo = Recursos.elfo.get(5)[0];
		}
	}

	public void enviarAtaque(PaqueteAtacar paqueteAtacar) {
		try {
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteAtacar));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			e.printStackTrace();
		}
	}

	private void finalizarBatalla() {
		try {
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteFinalizarBatalla));
			
			paquetePersonaje.setSaludTope(personaje.getSaludTope());
			paquetePersonaje.setEnergiaTope(paquetePersonaje.getEnergiaTope());
			paquetePersonaje.setNivel(personaje.getNivel());
			paquetePersonaje.setExperiencia(personaje.getExperiencia());
			paquetePersonaje.setDestreza(personaje.getDestreza());
			paquetePersonaje.setFuerza(personaje.getFuerza());
			paquetePersonaje.setInteligencia(personaje.getInteligencia());
			
			paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
			paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
			paqueteEnemigo.setNivel(enemigo.getNivel());
			paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
			paqueteEnemigo.setDestreza(enemigo.getDestreza());
			paqueteEnemigo.setFuerza(enemigo.getFuerza());
			paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
			
			paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
			paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);
			
			juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteEnemigo));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			e.printStackTrace();
		}
	}

	public PaquetePersonaje getPaquetePersonaje() {
		return paquetePersonaje;
	}

	public PaquetePersonaje getPaqueteEnemigo() {
		return paqueteEnemigo;
	}

	public void setMiTurno(boolean b) {
		miTurno = b;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public Personaje getEnemigo() {
		return enemigo;
	}
}
