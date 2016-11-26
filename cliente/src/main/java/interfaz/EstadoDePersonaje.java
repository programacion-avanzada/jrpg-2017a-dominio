package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

public class EstadoDePersonaje {
	
	private static final int ANCHOBARRA = 122;
	private static final int ALTOSALUD = 14;
	private static final int ALTOENERGIA = 14; 
	private static final int ALTOEXPERIENCIA = 6; 
	private static final int ALTOMINIATURA = 64;
	private static final int ANCHOMINIATURA = 64;
	
	public static void dibujarEstadoDePersonaje(Graphics g, int x, int y, Personaje personaje, BufferedImage miniaturaPersonaje){
		
		int drawBarra = 0;
		
		g.drawImage(Recursos.estadoPersonaje, x, y, null);

		g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);
		
		if(personaje.getSalud() == personaje.getSaludTope()) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (personaje.getSalud() * ANCHOBARRA) / personaje.getSaludTope();
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud,  x + 80, y + 26, drawBarra, ALTOSALUD, null);
		g.drawString(String.valueOf(personaje.getSalud()) + " / " + String.valueOf(personaje.getSaludTope()), x + 132, y + 37);
		
		if(personaje.getEnergia() == personaje.getEnergiaTope()) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (personaje.getEnergia() * ANCHOBARRA) / personaje.getEnergiaTope();
		}
		
		g.drawImage(Recursos.barraEnergia, x + 80, y + 42, drawBarra, ALTOENERGIA, null);
		g.drawString(String.valueOf(personaje.getEnergia()) + " / " + String.valueOf(personaje.getEnergiaTope()), x + 132, y + 52);

		if(personaje.getExperiencia() == Personaje.tablaDeNiveles[personaje.getNivel() + 1]) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje.tablaDeNiveles[personaje.getNivel() + 1];
		}
		
		g.setFont(new Font("Tahoma", Font.PLAIN, 8));
		g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra, ALTOEXPERIENCIA, null);
		g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String.valueOf(Personaje.tablaDeNiveles[personaje.getNivel() + 1]), x + 132, y + 70);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);
	
		
	}
	
	public static void dibujarEstadoDePersonaje(Graphics g, int x, int y, PaquetePersonaje personaje, BufferedImage miniaturaPersonaje){
		
		int drawBarra = 0;
		
		g.drawImage(Recursos.estadoPersonaje, x, y, null);

		g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud, x + 80, y + 26, ANCHOBARRA, ALTOSALUD, null);
		g.drawString(String.valueOf(personaje.getSaludTope()) + " / " + String.valueOf(personaje.getSaludTope()), x + 132, y + 37);

		g.drawImage(Recursos.barraEnergia, x + 80, y + 42, ANCHOBARRA, ALTOENERGIA, null);
		g.drawString(String.valueOf(personaje.getEnergiaTope()) + " / " + String.valueOf(personaje.getEnergiaTope()), x + 132, y + 52);

		if(personaje.getExperiencia() == Personaje.tablaDeNiveles[personaje.getNivel() + 1]) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (personaje.getExperiencia() * ANCHOBARRA) / Personaje.tablaDeNiveles[personaje.getNivel() + 1];
		}
		
		g.setFont(new Font("Tahoma", Font.PLAIN, 8));
		g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra, ALTOEXPERIENCIA, null);
		g.drawString(String.valueOf(personaje.getExperiencia()) + " / " + String.valueOf(Personaje.tablaDeNiveles[personaje.getNivel() + 1]), x + 132, y + 70);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);
	}
}
