package dominio;

import java.io.Serializable;

/**
 * La clase Casta posee una serie de atributos relacionados a la defensa y el
 * ataque del personaje y también a sus habilidades.
 * Define 3 métodos de habilidad abstractos.
 */

public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * Constructor de una casta con sus valores por defecto
	 */

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	/**
	 * Constructor de una casta con valores por parámetro.
	 * Recibe una probabilidad, evasion y daño.
	 */

	public Casta(double prob_crit, double evasion, double daño_crit) {
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
	 * Getters y setters para los diferentes atributos de la clase.
	 */

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}

	public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}

	public double getDañoCritico() {
		return dañoCritico;
	}

	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
