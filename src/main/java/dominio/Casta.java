package dominio;

import java.io.Serializable;

/**
 * La clase Casta posee una serie de atributos relacionados a la defensa y el
 * ataque del personaje y también a sus habilidades.
 * Define 3 métodos de habilidad abstractos.
 */

public abstract class Casta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1494790491018757796L;
	protected static final int INCREMENTO_POR_TIPO = 5;
	protected static final int ENERGIA_MINIMA = 10;

	private static final int CANTIDAD_HABILIDADES = 3;
	private static final double PROBABILIDAD_POR_DEFECTO = 0.2;
	private static final double DANO_CRITICO_POR_DEFECTO = 1.5;

	private double probabilidadGolpeCritico;
	protected double probabilidadEvitarDano;
	private double danoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * Constructor de una casta con sus valores por defecto
	 * @param nombreCasta nombre de la casta
	 * @param habilidad1 habilidad1
	 * @param habilidad2 habilidad2
	 * @param habilidad3 habilidad3
	 */

	public Casta(final String nombreCasta, final String habilidad1,
		final String habilidad2, final String habilidad3) {

		this.probabilidadGolpeCritico = PROBABILIDAD_POR_DEFECTO;
		this.probabilidadEvitarDano = PROBABILIDAD_POR_DEFECTO;
		this.danoCritico = DANO_CRITICO_POR_DEFECTO;

		this.nombreCasta = nombreCasta;

		habilidadesCasta = new String[CANTIDAD_HABILIDADES];
		habilidadesCasta[0] = habilidad1;
		habilidadesCasta[1] = habilidad2;
		habilidadesCasta[2] = habilidad3;
	}

	/**
	 * Constructor de una casta con valores por parámetro.
	 * @param nombreCasta nombre de la casta
	 * @param probCrit probabilidad de golpe critico.
	 * @param evasion probabilidad de evitar dano.
	 * @param danoCrit dano critico.
	 */

	public Casta(final String nombreCasta, final double probCrit, final double evasion, final double danoCrit) {
		this.nombreCasta = nombreCasta;

		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDano = evasion;
		this.danoCritico = danoCrit;
	}

	/**
	 * Habilidad 1 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad1 o no.
	 */

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Habilidad 2 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad2 o no.
	 */

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Habilidad 3 será sobreescrita en las clases que hereden de esta.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso si se puede utilizar la habilidad2 o no.
	 */

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * getInteligencia sera reemplazada en los hijos segun corresponda.
	 * @return 0
	 */

	public int getInteligencia() {
		return 0;
	}

	/**
	 * getFuerza sera reemplazada en los hijos segun corresponda.
	 * @return 0
	 */

	public int getFuerza() {
		return 0;
	}

	/**
	 * getDestreza sera reemplazada en los hijos segun corresponda.
	 * @return 0
	 */

	public int getDestreza() {
		return 0;
	}



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
	 * @return la probabilidad del evitar dano
	 */

	public double getProbabilidadEvitarDano() {
		return probabilidadEvitarDano;
	}

	/**
	 * Asigna la probabilidad de evitar dano
	 * @param probabilidadEvitarDano a asignar
	 */

	public void setProbabilidadEvitarDano(final double probabilidadEvitarDano) {
		this.probabilidadEvitarDano = probabilidadEvitarDano;
	}

	/**
	 * @return el dano critico
	 */

	public double getDanoCritico() {
		return danoCritico;
	}

	/**
	 * Asigna el dano critico
	 * @param danoCritico a asignar
	 */

	public void setDanoCritico(final double danoCritico) {
		this.danoCritico = danoCritico;
	}
}
