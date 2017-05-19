package dominio;



/**
 * La clase Character contiene los atributos y metodos compartidos de
 * Personaje y NonPlayableCharacter.
 */

public abstract class Character {

  private String nombre;

  protected int salud;
  protected int defensa;
  protected int fuerza;
  protected int nivel;

  public RandomGenerator aleatorizador;

  /**
   * Contructor de un Character
   * @param nombre nombre del character
   */

  public Character(final String nombre) {
    this.nombre = nombre;
    this.aleatorizador = new MyRandom();
  }

  /**
   * @param nombre del personaje
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
   * @param nombre del personaje
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
	 * @param defensa defensa
	 */

	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

  /**
	 * @return fuerza
	 */

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * @param fuerza fuerza a adicionar
	 */

	public void aumentarFuerza(final int fuerza) {
		this.fuerza += fuerza;
	}

  /**
	 * @return nivel
	 */

	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel nivel
	 */

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

  /**
	 * Checker para ver si el personaje vive o no.
	 * @return verdadero o falso si salud es mayor a cero o no.
	 */

	public boolean estaVivo() {
		return salud > 0;
	}

}
