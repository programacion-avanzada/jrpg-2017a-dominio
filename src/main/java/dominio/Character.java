package dominio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * La clase Character contiene los atributos y metodos compartidos de Personaje
 * y NonPlayableCharacter.
 */

public abstract class Character implements Peleable {

	private static final int SOLTAR = -1;
	private static final int EQUIPAR = 1;
	
	public static final String ATRIBUTO_NOMBRE = "nombre";
	public static final String ATRIBUTO_SALUD = "salud";
	public static final String ATRIBUTO_DEFENSA = "defensa";
	public static final String ATRIBUTO_FUERZA = "fuerza";
	public static final String ATRIBUTO_NIVEL = "nivel";

	private String nombre;
	protected int salud;
	protected int defensa;
	protected int fuerza;
	protected int nivel;
	protected ArrayList<Item> inventario;

	protected int ultimaDefensa;

	protected RandomGenerator aleatorizador;


	/**
	 * Contructor de un Character
	 *
	 * @param nombre
	 *            nombre del character
	 */

	public Character(final String nombre, final int nivel, ArrayList<Item> inventario) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.aleatorizador = new MyRandom();
		this.inventario = inventario;
	}

	/**
	 * @param randomGenerator
	 *            randomGenerator a asignar
	 */

	public void setRandomGenerator(final MyRandomStub randomGenerator) {
		this.aleatorizador = randomGenerator;
	}

	/**
	 * @return nombre del personaje
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            del personaje
	 */

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return salud
	 */

	public int getSalud() {
		return salud;
	}

	/**
	 * @return defensa
	 */

	public int getDefensa() {
		return defensa;
	}

	/**
	 * @return fuerza
	 */

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * @return nivel
	 */

	public int getNivel() {
		return nivel;
	}

	/**
	 * Checker para ver si el personaje vive o no.
	 *
	 * @return verdadero o falso si salud es mayor a cero o no.
	 */

	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * Anular defensa guarda la defensa y la asigna a 0
	 */

	public void anularDefensa() {
		this.ultimaDefensa = this.defensa;
		this.defensa = 0;
	}

	/**
	 * Reestablecer defensa pone de nuevo en defensa el valor almacenado en
	 * anularDefensa.
	 */

	public void reestablecerDefensa() {
		this.defensa = this.ultimaDefensa;
	}

	/**
	 * @param aumento
	 *            de defensa a incrementar
	 */

	public void aumentarDefensa(final int aumento) {
		this.defensa += aumento;
	}

	/**
	 * Actualiza el Character recibiendo un HashMap
	 *
	 * @param mapa
	 *            con los datos del Character
	 */

	public void update(final HashMap<String, Object> mapa) {
		this.nombre = (String) mapa.get(ATRIBUTO_NOMBRE);
		this.salud = (Integer) mapa.get(ATRIBUTO_SALUD);
		this.defensa = (Integer) mapa.get(ATRIBUTO_DEFENSA);
		this.fuerza = (Integer) mapa.get(ATRIBUTO_FUERZA);
		this.nivel = (Integer) mapa.get(ATRIBUTO_NIVEL);
	}

	/**
	 * Crea un HashMap con los datos del Character
	 *
	 * @return mapa de datos
	 */

	public HashMap<String, Object> all() {
		HashMap<String, Object> mapa = new HashMap<>();
		mapa.put(ATRIBUTO_SALUD, this.salud);
		mapa.put(ATRIBUTO_FUERZA, this.fuerza);
		mapa.put(ATRIBUTO_DEFENSA, this.defensa);
		mapa.put(ATRIBUTO_NOMBRE, this.nombre);
		mapa.put(ATRIBUTO_NIVEL, this.nivel);
		return mapa;
	}
}
