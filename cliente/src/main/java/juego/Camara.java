package juego;

import entidades.Entidad;

public class Camara {

	private Juego juego;
	private float yOffset;
	private float xOffset;

	public Camara(Juego juego, float xOffset, float yOffset) {
		this.juego = juego;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void Centrar(Entidad e) {
		xOffset = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
		yOffset = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
	}
	
	public void mover(float dx, float dy) {
		xOffset += dx;
		yOffset += dy;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
}
