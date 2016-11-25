package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

public class MenuEnemigo {

	private static final int anchoPersonaje = 128;
	
	private int x;
	private int y;
	private PaquetePersonaje personaje;
	private static final BufferedImage menu = Recursos.menuEnemigo;

	public MenuEnemigo(int x, int y, PaquetePersonaje personaje){
		this.x = x;
		this.y = y;
		this.personaje = personaje;
	}
	
	public void graficar(Graphics g){
		
		// dibujo el menu
		g.drawImage(menu, x, y, null);
		
		// dibujo el personaje
		g.drawImage(Recursos.personaje.get(personaje.getRaza()).get(6)[0], x + menu.getWidth() / 2  - anchoPersonaje / 2, y + 70, 128, 128, null);
		
		// muestro el nombre
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", 1, 20));
		Pantalla.centerString(g, new Rectangle(x, y + 15, menu.getWidth(), 0), personaje.getNombre());
		
		// muestro los nombres de los atributos
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), personaje.getRaza());
		g.drawString("Casta: ", x + 30, y + 260);
		g.drawString("Nivel: ", x + 30, y + 290);
		g.drawString("Experiencia: ", x + 30, y + 320);
		
		// muestro los atributos
		g.setFont(new Font("Book Antiqua", 0, 20));
		g.drawString(personaje.getCasta(), x + 100, y + 260);
		g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
		g.drawString(personaje.getExperiencia() + " / " + Personaje.tablaDeNiveles[personaje.getNivel() + 1], x + 150, y + 320);
		
		// muestro los botones
		g.drawImage(Recursos.botonMenu, x + 50, y + 380, 200, 25, null);
		g.setColor(Color.WHITE);
		Pantalla.centerString(g, new Rectangle(x + 50, y + 380, 200, 25), "Batallar");
		
	}
	
	public boolean clickEnBatallar(int mouseX, int mouseY){
		if(mouseX >= x + 50 && mouseX <= x + 250 && mouseY >= y + 380 && mouseY <= y + 405)
			return true;
		return false;
	}
	
	public boolean clickEnCerrar(int mouseX, int mouseY){
		if(mouseX >= x + menu.getWidth() - 24 && mouseX <= x + menu.getWidth() + 4 && mouseY >= y + 12 && mouseY <= y + 36)
			return true;
		return false;
	}
	
	public boolean clickEnMenu(int mouseX, int mouseY){
		if(mouseX >= x && mouseX <= x + menu.getWidth() && mouseY >= y  && mouseY <= y + menu.getHeight())
			return true;
		return false;
	}
}
