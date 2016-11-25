package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import recursos.Recursos;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile cesped = new Tile(Recursos.cesped, 0, false);
	public static Tile greenTree = new Tile(Recursos.greenTree, 1, true, 64, 70);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
	
	protected BufferedImage textura;
	protected final int id;
	
	private boolean esSolido;
	
	
	protected int ancho;
	protected int alto;
	
	
	public Tile(BufferedImage textura, int id, boolean esSolido) {
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.esSolido = esSolido;
	}
	
	public Tile(BufferedImage textura, int id, boolean esSolido, int ancho, int alto){
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.ancho = ancho;
		this.alto = alto;
		this.esSolido = esSolido;
	}
	
	public void actualizar() {
		
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	 public void graficar(Graphics g, int x, int y , int width, int height){
	    g.drawImage(textura, x, y, width, height, null);
	 }
	 
	
	public boolean esSolido() {
		return esSolido;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAncho() {
		  return ancho; 
	}
		  
	public int getAlto() {
		return alto;	 
	}
		 
}
