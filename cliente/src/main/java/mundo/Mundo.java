package mundo;

import java.awt.Graphics;

import juego.Juego;

public class Mundo {
	private Juego juego;
	private int ancho;
	private int alto;
	private int spawnX;
	private int spawnY;
	private int xOffset = 300;
	private int yOffset = 50;

	private int[][] tiles;

	public Mundo(Juego juego, String path) {
		this.juego = juego;
		cargarMundo("recursos/mundo1.txt");
	}

	public void actualizar() {

	}

	public void graficar(Graphics g) {
		float[] iso = new float[2];
		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				iso = dosDaIso(x, y);
				getTile(x, y).graficar(g, (int) (iso[0] + xOffset - juego.getCamara().getxOffset()),
										  (int) (iso[1] + yOffset - juego.getCamara().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.cesped;
		}
		return t;
	}

	private void cargarMundo(String path) {
		String archivo = Utilitarias.archivoAString(path);
		String[] tokens = archivo.split("\\s+");
		ancho = Utilitarias.parseInt(tokens[0]);
		alto = Utilitarias.parseInt(tokens[1]);
		spawnX = Utilitarias.parseInt(tokens[2]);
		spawnY = Utilitarias.parseInt(tokens[3]);

		tiles = new int[ancho][alto];

		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				tiles[x][y] = Utilitarias.parseInt(tokens[(x + y * ancho + 4)]);
			}
		}
	}

	public static float[] isoA2D(float x, float y) {
		float[] dosD = new float[2];

		dosD[0] = (x / (Tile.ANCHO / 2) + y / (Tile.ALTO / 2)) / 2;
		dosD[1] = (y / (Tile.ALTO / 2) - (x / (Tile.ANCHO / 2))) / 2;
		
		return dosD;
	}
	
	public static float[] dosDaIso(float x, float y) {
		float[] iso = new float[2];
		
		iso[0] = (x - y) * (Tile.ANCHO / 2);
		iso[1] = (x + y) * (Tile.ALTO / 2);
		
		return iso;
	}
	
	public static float[] mouseAIso(float x, float y) {
		float iso[] = new float[2];
		
		iso[0] = (float) Math.floor((y / Tile.ALTO) + (x / Tile.ANCHO));
		iso[1] = (float) Math.floor((-x / Tile.ANCHO) + (y / Tile.ALTO));
	
		return iso;
	}
}
