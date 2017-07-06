package dominio;

import java.io.Serializable;

/**
 * Clase de items pertencientes al inventario del personaje
 */

public class Item implements Serializable {

	private static final long serialVersionUID = 936650374906569457L;

	private final int id;

	private String nombre;

	private int ataque;
	private int defensa;
	private int magia;
	private int salud;
	private int energia;

	/**
	 * Constructor de la clase
	 * @param id id
	 * @param nombre nombre
	 * @param ataque ataque
	 * @param defensa defensa
	 * @param magia magia
	 * @param salud salud
	 * @param energia energia
	 */

	public Item(final int id, final String nombre, final int ataque,
		final int defensa, final int magia, final int salud,
		final int energia) {

		this.id = id;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.magia = magia;
		this.salud = salud;
		this.energia = energia;
	}

	/**
	 * Devuleve el id
	 * @return id
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * Devuleve el nombre
	 * @return nombre
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuleve el ataque
	 * @return ataque
	 */

	public int getAtaque() {
		return this.ataque;
	}

	/**
	 * Devuleve la defensa
	 * @return defensa
	 */

	public int getDefensa() {
		return this.defensa;
	}

	/**
	 * Devuleve la magia
	 * @return magia
	 */

	public int getMagia() {
		return this.magia;
	}

	/**
	 * Devuleve la salud
	 * @return salud
	 */

	public int getSalud() {
		return this.salud;
	}

	/**
	 * Devuleve la energia
	 * @return energia
	 */

	public int getEnergia() {
		return this.energia;
	}
}
