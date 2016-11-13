package cliente;

import dominio.Mapa;

public class PaquetePersonaje {

	private int idPersonaje;
	private String nombreRaza;
	private int mundo;
	private int posX;
	private int posY;
	
	
	
	public PaquetePersonaje(int idPersonaje, String nombreRaza, int mundo, int posX, int posY) {
		this.idPersonaje = idPersonaje;
		this.nombreRaza = nombreRaza;
		this.mundo = mundo;
		this.posX = posX;
		this.posY = posY;
	}
	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getNombreRaza() {
		return nombreRaza;
	}
	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}
	public int getMundo() {
		return mundo;
	}
	public void setMundo(int mundo) {
		this.mundo = mundo;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
}
