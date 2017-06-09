package dominio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Item implements Serializable {

	private final int id;

	private String nombre;
	private BufferedImage icono;

	private int ataque;
	private int defensa;
	private int magia;
	private int salud;
	private int fuerza;

	public Item() {
		this.id = 0;

		try {
			this.icono = ImageIO.read(new File("recursos//inventario_ranura_vacia.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Item(final int id, final String nombre, final String icono, final int ataque, final int defensa, final int magia, final int salud, final int fuerza) {

		this.id = id;
		this.nombre = nombre;

		try {
			this.icono = ImageIO.read(new File("recursos//" + icono));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.ataque = ataque;
		this.defensa = defensa;
		this.magia = magia;
		this.salud = salud;
		this.fuerza = fuerza;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public BufferedImage getIcono() {
		return this.icono;
	}

	public int getAtaque() {
		return this.ataque;
	}

	public int getDefensa() {
		return this.defensa;
	}

	public int getMagia() {
		return this.magia;
	}

	public int getSalud() {
		return this.salud;
	}

	public int getFuerza() {
		return this.fuerza;
	}
}
