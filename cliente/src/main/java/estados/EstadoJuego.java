package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;

import cliente.Paquete;
import cliente.PaquetePersonaje;
import entidades.Entidad;
import juego.Juego;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;
	private final Gson gson = new Gson();

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundo2.txt");
		personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.ogro, 150);

		try {
			juego.getPersonaje().setComando("conectado");
			//System.out.println("Estado de Juego : " + gson.toJson(juego.getPersonaje()));
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		Iterator it = juego.getEscuchaMensajes().getPersonajes().keySet().iterator();
		int key;
		PaquetePersonaje p;
		while (it.hasNext()) {
			key = (int) it.next();
			p = juego.getEscuchaMensajes().getPersonajes().get(key);
			if (p.getIdPersonaje() != juego.getPersonaje().getIdPersonaje()) {
				g.drawImage(Recursos.ogro.get(p.getDireccion())[p.getFrame()], (int) (p.getPosX() - juego.getCamara().getxOffset() ), (int) (p.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
			}
		}
		
		g.drawImage(Recursos.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
	}

	public Entidad getPersonaje() {
		return personaje;
	}
}