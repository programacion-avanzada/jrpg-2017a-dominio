package cliente;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import dominio.Mapa;

public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	private int idPersonaje;
	private String nombreRaza;
	private int mundo;
	private float posX;
	private float posY;
	private int direccion;
	private int frame;

	public PaquetePersonaje() {

	}

	public PaquetePersonaje(int idPersonaje, String nombreRaza, int mundo, float posX, float posY) {
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

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}

