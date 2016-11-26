package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

public class MenuInfoPersonaje {

	private static final int anchoPersonaje = 128;
	private static final BufferedImage menu = Recursos.menuEnemigo;
	public static final int menuBatallar = 0;
	public static final int menuInformacion = 1;
	public static final int menuSubirNivel = 2;
	public static final int menuGanarBatalla = 3;
	public static final int menuPerderBatalla = 4;
	private static final String [] leyendaBoton = {"Batallar", "Volver", "Aceptar", "Aceptar", "Aceptar"};
	
	private int x;
	private int y;
	private PaquetePersonaje personaje;

	public MenuInfoPersonaje(int x, int y, PaquetePersonaje personaje){
		this.x = x;
		this.y = y;
		this.personaje = personaje;
	}
	
	public void graficar(Graphics g, int tipoMenu){
		
		// dibujo el menu
		g.drawImage(menu, x, y, null);
		
		// dibujo el personaje
		g.drawImage(Recursos.personaje.get(personaje.getRaza()).get(6)[0], x + menu.getWidth() / 2  - anchoPersonaje / 2, y + 70, 128, 128, null);
		
		// muestro el nombre
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", 1, 20));
		Pantalla.centerString(g, new Rectangle(x, y + 15, menu.getWidth(), 0), personaje.getNombre());
		
		// Grafico la leyenda segun el tipo de menu
		switch(tipoMenu){
		case menuBatallar:
			graficarMenuInformacion(g);
			break;
		case menuInformacion:
			graficarMenuInformacion(g);
			break;
		case menuSubirNivel:
			graficarMenuSubirNivel(g);
			break;
		case menuGanarBatalla:
			graficarMenuGanarBatalla(g);
			break;
		case menuPerderBatalla:
			graficarMenuPerderBatalla(g);
			break;
		}
		
		
		// muestro los botones
		g.setFont(new Font("Book Antiqua", 1, 20));
		g.drawImage(Recursos.botonMenu, x + 50, y + 380, 200, 25, null);
		g.setColor(Color.WHITE);
		Pantalla.centerString(g, new Rectangle(x + 50, y + 380, 200, 25), leyendaBoton[tipoMenu]);
	}
	
	private void graficarMenuPerderBatalla(Graphics g) {
		
		// Informo que perdio la batalla
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), "¡Has sido derrotado!");
		
		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 250, menu.getWidth(), 0), "¡No te rindas! Sigue luchando");
		Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0), "contra los demás personajes");
		Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0), "para aumentar tu nivel y");
		Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0), "mejorar tus atributos.");
	}

	private void graficarMenuGanarBatalla(Graphics g) {
		
		// Informo que gano la batalla
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), "¡Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + 230, menu.getWidth(), 0), "a tu enemigo!");
		
		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0), "¡Felicitaciones! Has derrotado");
		Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0), "a tu oponente, sigue así");
		Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0), "para lograr subir de nivel");
		Pantalla.centerString(g, new Rectangle(x, y + 330, menu.getWidth(), 0), "y mejorar tus atributos.");
	}

	private void graficarMenuSubirNivel(Graphics g) {
		
		// Informo que subio de nivel
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), "¡Has subido de nivel!");
		
		g.setFont(new Font("Book Antiqua", 0, 18));
		Pantalla.centerString(g, new Rectangle(x, y + 240, menu.getWidth(), 0), "¡Felicitaciones!");
		Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0), "Nuevo Nivel");
		g.setFont(new Font("Book Antiqua", 1, 62));
		Pantalla.centerString(g, new Rectangle(x, y + 325, menu.getWidth(), 0), String.valueOf(personaje.getNivel()));
		
	}

	public void graficarMenuInformacion(Graphics g){
		
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
		
	}
	
	public boolean clickEnBoton(int mouseX, int mouseY){
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
