package estados;

import java.awt.Color;
import java.awt.Graphics;

import entidades.Entidad;
import juego.Juego;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundo2.txt");
	    personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.ogro, 150);
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		personaje.graficar(g);
		g.drawImage(Recursos.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
