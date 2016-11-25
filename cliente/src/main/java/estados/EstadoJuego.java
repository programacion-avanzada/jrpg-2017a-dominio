package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Elfo;
import dominio.Humano;
import dominio.Orco;
import dominio.Personaje;
import entidades.Entidad;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoJuego extends Estado {

	private Entidad entidadPersonaje;
	private PaquetePersonaje paquetePersonaje;
	private Mundo mundo;
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<Integer, PaquetePersonaje> personajesConectados;
	private boolean haySolicitud;
	
	private final Gson gson = new Gson();
	
	private final int ANCHOBARRA = 122;
	private final int ALTOSALUD = 14;
	private final int ALTOENERGIA = 14; 
	private final int ALTOEXPERIENCIA = 6; 
	private final int ALTOMINIATURA = 64;
	private final int ANCHOMINIATURA = 64;
	private BufferedImage miniaturaPersonaje;
	private int drawBarra;

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt");
		entidadPersonaje = new Entidad(juego, mundo, 64, 64, juego.getPersonaje().getNombre(), 0, 0, Recursos.personaje.get(juego.getPersonaje().getRaza()), 150);
		paquetePersonaje = juego.getPersonaje();
		
		if (paquetePersonaje.getRaza().equals("Humano")) {
			miniaturaPersonaje = Recursos.humano.get(5)[0];
		} else if (paquetePersonaje.getRaza().equals("Orco")) {
			miniaturaPersonaje = Recursos.orco.get(5)[0];
		} else if (paquetePersonaje.getRaza().equals("Elfo")) {
			miniaturaPersonaje = Recursos.elfo.get(5)[0];
		}
		
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
		entidadPersonaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		entidadPersonaje.graficar(g);
		graficarPersonajes(g);
		g.drawImage(Recursos.marco, 0, 0, juego.getAncho(), juego.getAlto(), null);
		graficarEstadoPersonaje(g);
		if(haySolicitud) {
			g.drawImage(Recursos.botonMenu, 200, 0, 200, 25, null);
			g.drawImage(Recursos.botonMenu, 430, 0, 200, 25, null);
			g.setColor(Color.WHITE);
			g.drawString("Batallar", 280, 15);
			g.drawString("Cancelar", 505, 15);
		}
	}

	public void graficarPersonajes(Graphics g) {
		
		if(juego.getEscuchaMensajes().getPersonajesConectados() != null){
			personajesConectados = new HashMap(juego.getEscuchaMensajes().getPersonajesConectados());
			ubicacionPersonajes = new HashMap(juego.getEscuchaMensajes().getUbicacionPersonajes());
			Iterator<Integer> it = personajesConectados.keySet().iterator();
			int key;
			PaqueteMovimiento actual;
			g.setFont(new Font("Book Antiqua", 0, 15));
			while (it.hasNext()) {
				key = (int) it.next();
				actual = ubicacionPersonajes.get(key);
				if (actual != null && actual.getIdPersonaje() != juego.getPersonaje().getId() && personajesConectados.get(actual.getIdPersonaje()).getEstado() == Estado.estadoJuego) {
						Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32), (int) (actual.getPosY() - juego.getCamara().getyOffset() - 20 ), 0, 10), personajesConectados.get(actual.getIdPersonaje()).getNombre());
						g.drawImage(Recursos.personaje.get(personajesConectados.get(actual.getIdPersonaje()).getRaza()).get(actual.getDireccion())[actual.getFrame()], (int) (actual.getPosX() - juego.getCamara().getxOffset() ), (int) (actual.getPosY() - juego.getCamara().getyOffset()), 64, 64, null);
				}
			}
		}
	}
	
	private void graficarEstadoPersonaje(Graphics g) {
		g.drawImage(Recursos.estadoPersonaje, 0, 0, null);

		g.drawImage(miniaturaPersonaje, 5, 5, ANCHOMINIATURA, ALTOMINIATURA, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud, 78, 23, ANCHOBARRA, ALTOSALUD, null);
		g.drawString(String.valueOf(paquetePersonaje.getSaludTope()) + " / " + String.valueOf(paquetePersonaje.getSaludTope()), 132, 33);

		g.drawImage(Recursos.barraEnergia, 78, 41, ANCHOBARRA, ALTOENERGIA, null);
		g.drawString(String.valueOf(paquetePersonaje.getEnergiaTope()) + " / " + String.valueOf(paquetePersonaje.getEnergiaTope()), 132, 53);

		if(paquetePersonaje.getExperiencia() == Personaje.tablaDeNiveles[paquetePersonaje.getNivel() + 1]) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (paquetePersonaje.getExperiencia() * ANCHOBARRA) / Personaje.tablaDeNiveles[paquetePersonaje.getNivel() + 1];
		}
		
		g.setFont(new Font("Tahoma", Font.PLAIN, 8));
		g.drawImage(Recursos.barraExperiencia, 77, 62, drawBarra, ALTOEXPERIENCIA, null);
		g.drawString(String.valueOf(paquetePersonaje.getExperiencia()) + " / " + String.valueOf(Personaje.tablaDeNiveles[paquetePersonaje.getNivel() + 1]), 132, 68);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(paquetePersonaje.getNivel()), 55, 68);
	}
	
	public Entidad getPersonaje() {
		return entidadPersonaje;
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
	
	public void actualizarPersonaje() {
		paquetePersonaje = juego.getPersonaje();
	}
}