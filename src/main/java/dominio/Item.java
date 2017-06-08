package dominio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Item implements Serializable {

	private final int ID;

	private String nombre;
	private String flavorText;

	private int fuerza;
	private int salud;
	private int defensa;

	private int ataque;
	private int magia;
	private int inteligencia;
	private int destreza;
	private int energia;
	
	@SuppressWarnings("unused")
	private BufferedImage icono;

	public Item(int id, String name, String text, int fuerza, int salud, int defensa, int ataque, int magia,
			int inteligencia, int destreza, int energia, String path) {

		this.ID = id;
		this.nombre = name;
		this.flavorText = text;
		this.fuerza = fuerza;
		this.salud = salud;
		this.defensa = defensa;
		this.ataque = ataque;
		this.magia = magia;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
		this.energia = energia;
		try {
			this.icono = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("item_icon_error: No se pudo leer archivo de imagen");
		}
	}

	public int getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getSalud() {
		return salud;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getMagia() {
		return magia;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getDestreza() {
		return destreza;
	}

	public int getEnergia() {
		return energia;
	}

}
