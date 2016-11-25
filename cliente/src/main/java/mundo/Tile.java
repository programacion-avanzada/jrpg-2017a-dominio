package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile cesped = new TileCesped(0);
	public static Tile cespedSolido = new TileCespedSolido(1);
	public static Tile roca = new TileRoca(2);
	public static Tile greenTree = new TileGreenTree(3, 42, 70);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
	
	protected BufferedImage textura;
	protected final int id;
	
	protected int anchoObst;
	protected int altoObst;
	
	
	public Tile(BufferedImage textura, int id) {
		this.textura = textura;
		this.id = id;
		
		tiles[id] = this;
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
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAncho() {
		  return anchoObst; 
	}
		  
	public int getAlto() {
		return altoObst;	 
	}
		 
}
