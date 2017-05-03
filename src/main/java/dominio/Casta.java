package dominio;

import java.io.Serializable;

/**
 * La clase Casta posee una serie de atributos relacionados a la defensa y el
 * ataque del personaje y también a sus habilidades.
 * Define 3 métodos de habilidad abstractos.
 */

public abstract class Casta implements Serializable {

	protected static final int TAMAÑO_CASTA = 3;
	protected static final int ENERGIA_MAXIMA = 10;
	private static final double PROBABILIDAD_POR_DEFECTO = 0.2;
	private static final double DAÑO_CRITICO_POR_DEFECTO = 1.5;

	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * Constructor de una casta con sus valores por defecto
	 */

	public Casta() {
		this.probabilidadGolpeCritico = PROBABILIDAD_POR_DEFECTO;
		this.probabilidadEvitarDaño = PROBABILIDAD_POR_DEFECTO;
		this.dañoCritico = DAÑO_CRITICO_POR_DEFECTO;
	}

	/**
	 * Constructor de una casta con valores por parámetro.
	 * @param prob_crit probabilidad de golpe critico.
	 * @param evasion probabilidad de evitar daño.
	 * @param daño_crit daño critico.
	 */

	public Casta(final double prob_crit, final double evasion, final double daño_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = daño_crit;
	}

	/**
	 * Habilidad 1, 2 y 3 serán sobreescritas en las clases que hereden de esta.
	 */

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * @return el nombre de la casta
	 */

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	/**
	 * @return las habilidades de la casta
	 */

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	/**
	 * @return la probabilidad del golpe crítico
	 */

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Asigna la probabilidad de golpe critico
	 * @param probabilidadGolpeCritico a asignar
	 */

	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * @return la probabilidad del evitar daño
	 */

	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}

	/**
	 * Asigna la probabilidad de evitar daño
	 * @param probabilidadEvitarDaño a asignar
	 */

	public void setProbabilidadEvitarDaño(final double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}

	/**
	 * @return el daño critico
	 */

	public double getDañoCritico() {
		return dañoCritico;
	}

	/**
	 * Asigna el daño critico
	 * @param dañoCritico a asignar
	 */

	public void setDañoCritico(final double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
