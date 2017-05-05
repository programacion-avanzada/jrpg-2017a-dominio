package dominio;

import java.io.Serializable;

/**
 * Es la clase que une a los tipos de razas (asesino, guerrero, hechicero), con
 * sus metodos correspondientes a utilizar.
 *
 */
public abstract class Casta implements Serializable {
  protected double probabilidadGolpeCritico;
  protected double probabilidadEvitarDaño;
  protected double dañoCritico;
  protected String nombreCasta;

  protected String[] habilidadesCasta;

  /**
   * Constructor por defecto
   */
  public Casta() {
    this.probabilidadGolpeCritico = 0.2;
    this.probabilidadEvitarDaño = 0.2;
    this.dañoCritico = 1.5;
  }

  /**
   * @param prob_crit
   * @param evasion
   * @param daño_crit
   */
  public Casta(double prob_crit, double evasion, double daño_crit) {
    this.probabilidadGolpeCritico = prob_crit;
    this.probabilidadEvitarDaño = evasion;
    this.dañoCritico = daño_crit;
  }

  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  public abstract boolean habilidad2(Personaje caster, Peleable atacado);

  public abstract boolean habilidad3(Personaje caster, Peleable atacado);

  /**
   * @return Devuelve el nombre de la Casta pedido
   */
  public String getNombreCasta() {
    return this.nombreCasta;
  }

  /**
   * @return Devuelve las habilidades que posee dicha casta, en formato String[]
   */
  /**
   * @return devuelve todas las habilidades de la casta
   */
  public String[] getHabilidadesCasta() {
    return habilidadesCasta;
  }

  /**
   * @return devuelve la probabilidad de golpe critico
   */
  public double getProbabilidadGolpeCritico() {
    return probabilidadGolpeCritico;
  }

  /**
   * @param probabilidadGolpeCritico
   */
  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }

  /**
   * @return devuelve la probabilidad de Evitar Daño
   */
  public double getProbabilidadEvitarDaño() {
    return probabilidadEvitarDaño;
  }

  /**
   * @param probabilidadEvitarDaño
   */
  public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDaño = probabilidadEvitarDaño;
  }

  /**
   * @return devuelve el daño critico
   */
  public double getDañoCritico() {
    return dañoCritico;
  }

  /**
   * @param dañoCritico
   */
  public void setDañoCritico(double dañoCritico) {
    this.dañoCritico = dañoCritico;
  }
}
