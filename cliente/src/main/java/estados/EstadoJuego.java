package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Entidad;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;
	private boolean haySolicitud;
	private final Gson gson = new Gson();

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt");
		personaje = new Entidad(juego, mundo, 64, 64, juego.getPersonaje().getNombre(), 0, 0, Recursos.ogro, 150);

		try {
			// Le envio al servidor que me conecte al mapa y mi posicion
			juego.getPersonaje().setComando(Comando.CONEXION);
			juego.getPersonaje().setEstado(Estado.estadoJuego);
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
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
		if(haySolicitud) {
			g.drawImage(Recursos.botonMenu, 200, 0, 200, 25, null);
			g.drawImage(Recursos.botonMenu, 430, 0, 200, 25, null);
			g.setColor(Color.WHITE);
			g.drawString("Batallar", 280, 15);
			g.drawString("Cancelar", 505, 15);
		}
	}

	public void graficarPersonajes(Graphics g) {
		if(juego.getEscuchaMensajes().getUbicacionPersonajes() != null){
			Iterator<Integer> it = juego.getEscuchaMensajes().getUbicacionPersonajes().keySet().iterator();
			int key;
			PaqueteMovimiento actual;
			g.setFont(new Font("Book Antiqua", 0, 15));
			while (it.hasNext()) {
				key = (int) it.next();
				actual = juego.getEscuchaMensajes().getUbicacionPersonajes().get(key);
				if (actual.getIdPersonaje() != juego.getPersonaje().getId() && juego.getEscuchaMensajes().getPersonajesConectados().get(actual.getIdPersonaje()).getEstado() == Estado.estadoJuego) {
					Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32), (int) (actual.getPosY() - juego.getCamara().getyOffset() - 20 ), 0, 10), juego.getEscuchaMensajes().getPersonajesConectados().get(actual.getIdPersonaje()).getNombre());
					g.drawImage(Recursos.ogro.get(actual.getDireccion())[actual.getFrame()], (int) (actual.getPosX() - juego.getCamara().getxOffset() ), (int) (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
				}
			}
		}
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
	
	private String getMundo() {
		int mundo = juego.getPersonaje().getMapa();

		if (mundo == 1) {
			return "Aubenor";
		} else if (mundo == 2) {
			return "Aris";
		} else if (mundo == 3) {
			return "Eodrim";
		}

		return null;
	}
	
	public void setHaySolicitud(boolean b) {
		haySolicitud = b;
	}
	
	public boolean getHaySolicitud() {
		return haySolicitud;
	}
}