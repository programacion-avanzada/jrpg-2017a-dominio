package estados;

import java.awt.Color;
import java.awt.Graphics;

import entidades.Entidad;
import juego.Juego;
import mundo.Mundo;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;

	public EstadoJuego(Juego juego) {
		super(juego);
		personaje = new Entidad(juego, 64, 64, 332, 44);
		mundo = new Mundo(juego, "recursos/mundo1.txt");
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fill3DRect(0, 0, juego.getAncho(), juego.getAlto(), false);
		mundo.graficar(g);
		personaje.graficar(g);
	}

}
