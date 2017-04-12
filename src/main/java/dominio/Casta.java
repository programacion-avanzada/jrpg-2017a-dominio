package dominio;

import java.io.Serializable;

public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;
	/**
	 * Clase abstracta de la cual heredarán las clases Asesion,Guerrero,Hechicero
	 * Posee dos contructores, el contructor por defecto (no recibe argumentos) pondrá los atributos
	 * con sus respectivos valores por defecto.
	 * El otro constructor (el cual recibe argumentos) asignará a cada atributo el valor correspondiente
	 * que será el que se reciba por argumento.
	 * @param probabilidadGolpeCritico Probabilidad de que el personaje realice un golpe crítico
	 * @param probabilidadEvitarDaño Probabilidad de que el personaje evite un golpe crítico
	 * @param dañoCritico Valor por el cual será multiplicado el golpe básico
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	public Casta(double prob_crit, double evasion, double daño_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = daño_crit;
	}

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);
	
	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @param caster Personaje atacante.
	 * @param atacado Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}
	/**
	 * Método void que sobreescribe el atributo probabilidadGolpeCritico con el valor que se ingresa por 
	 * parámetro.
	 * @param probabilidadGolpeCritico
	 */
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
