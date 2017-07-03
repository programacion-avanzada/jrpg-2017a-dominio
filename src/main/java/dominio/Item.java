package dominio;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 936650374906569457L;

	private final int id;

	private String nombre;

	private int ataque;
	private int defensa;
	private int magia;
	private int salud;
	private int energia;
	
	public Item(final int _id, final String _nombre, final int _ataque, final int _defensa, final int _magia, final int _salud, final int _energia) {
		this.id = _id;
		this.nombre = _nombre;
		this.ataque = _ataque;
		this.defensa = _defensa;
		this.magia = _magia;
		this.salud = _salud;
		this.energia = _energia;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
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

	public int getEnergia() {
		return this.energia;
	}
}
