package estados;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

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
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje()));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor al ingresar al mundo.");
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
		graficarPersonajes(g);
		g.drawImage(Recursos.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
	}

	public void graficarPersonajes(Graphics g) {
		Iterator<Integer> it = juego.getEscuchaMensajes().getPersonajes().keySet().iterator();
		int key;
		PaquetePersonaje actual;
		while (it.hasNext()) {
			key = (int) it.next();
			actual = juego.getEscuchaMensajes().getPersonajes().get(key);
			if (actual.getIdPersonaje() != juego.getPersonaje().getIdPersonaje()) {
				g.drawImage(Recursos.ogro.get(actual.getDireccion())[actual.getFrame()], (int) (actual.getPosX() - juego.getCamara().getxOffset() ), (int) (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
			}
		}
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}