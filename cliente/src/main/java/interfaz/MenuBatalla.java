package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import dominio.Personaje;
import juego.Pantalla;
import recursos.Recursos;

public class MenuBatalla {
	
	private static final int x = 100; 
	private static final int y = 380;
	private static final int anchoBoton = 40;
	private static final int [][] botones = { { x + 48, y + 72 } , { x + 48, y + 146 } , { x + 221 , y + 72 } , { x + 221 , y + 146 } , { x + 394 , y + 72 } , { x + 394 , y + 146 } };
	private boolean habilitado;
	private Personaje personaje;
	
	public MenuBatalla(boolean habilitado, Personaje personaje){
		this.habilitado = habilitado;
		this.personaje = personaje;
	}
	
	public void graficar(Graphics g){
		
		if(habilitado)
			g.drawImage(Recursos.menuBatalla, x, y, null);
		else
			g.drawImage(Recursos.menuBatallaDeshabilitado, x, y, null);
		
		// Dibujo los boones
		g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[0]), botones[0][0], botones[0][1], anchoBoton, anchoBoton, null);
		g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[1]), botones[1][0], botones[1][1], anchoBoton, anchoBoton, null);
		g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[0]), botones[2][0], botones[2][1], anchoBoton, anchoBoton, null);
		g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[1]), botones[3][0], botones[3][1], anchoBoton, anchoBoton, null);
		g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesCasta()[2]), botones[4][0], botones[4][1], anchoBoton, anchoBoton, null);
		g.drawImage(Recursos.habilidades.get("Ser Energizado"), botones[5][0], botones[5][1], anchoBoton, anchoBoton, null);
		
		// Dibujo las leyendas
		g.setFont(new Font("Book Antiqua", 1, 14));
		g.drawString(personaje.getHabilidadesRaza()[0], x + 95, y + 94);
		g.drawString(personaje.getHabilidadesRaza()[1], x + 95, y + 168);
		g.drawString(personaje.getHabilidadesCasta()[0], x + 268, y + 94);
		g.drawString(personaje.getHabilidadesCasta()[1], x + 268, y + 168);
		g.drawString(personaje.getHabilidadesCasta()[2], x + 442, y + 94);
		g.drawString("Ser energizado", x + 442, y + 168);
		
		// Dibujo el turno de quien es
		g.setColor(Color.WHITE);
		if(habilitado)
			Pantalla.centerString(g, new Rectangle(x, y + 5, Recursos.menuBatalla.getWidth(), 20), "Mi Turno");
		else
			Pantalla.centerString(g, new Rectangle(x, y + 5, Recursos.menuBatalla.getWidth(), 20), "Turno Rival");
		
	}

	public int getBotonClickeado(int mouseX, int mouseY){
		if(!habilitado)
			return 0;
		for(int i=0; i<botones.length; i++){
			if(mouseX >= botones[i][0] && mouseX <= botones[i][0] + anchoBoton 
					&& mouseY >= botones[i][1] && mouseY <= botones[i][1] + anchoBoton)
				return i + 1;
		}
		return 0;
	}
	
	public boolean clickEnMenu(int mouseX, int mouseY){
		if(mouseX >= x && mouseX <= x + Recursos.menuBatalla.getWidth() && mouseY >= y && mouseY <= y + Recursos.menuBatalla.getHeight())
			return habilitado;
		return false;
	}
	
	public void setHabilitado(boolean b){
		habilitado = b;
	}
}
