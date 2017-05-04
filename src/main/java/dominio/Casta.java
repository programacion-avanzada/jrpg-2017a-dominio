package dominio;

import java.io.Serializable;

/**
  La clase "Casta" es la que se encargara de administrar las 
  los atributos basicos en todas las castas (como ser la
  "probablidadGolpeCritico") del juego asi como tambien los
  metodos que comparten. 
*/
public abstract class Casta implements Serializable {
  protected double probabilidadGolpeCritico;
  protected double probabilidadEvitarDaño;
  protected double dañoCritico;
  protected String nombreCasta;

  protected String[] habilidadesCasta;

  /** Constructor parametrizado*/
  
  public Casta() {
  this.probabilidadGolpeCritico = 0.2;
  this.probabilidadEvitarDaño = 0.2;
  this.dañoCritico = 1.5;
  }

  /** Constructor parametrizado*/
  
  public Casta(double prob_crit, double evasion, double daño_crit) {
  this.probabilidadGolpeCritico = prob_crit;
  this.probabilidadEvitarDaño = evasion;
  this.dañoCritico = daño_crit;
  }

  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  public abstract boolean habilidad2(Personaje caster, Peleable atacado);

  public abstract boolean habilidad3(Personaje caster, Peleable atacado);

  /** Este metodo devuelve el nombre de la casta */
  public String getNombreCasta() {
    return this.nombreCasta;
  }
  /** Este metodo devuelve la descripción de las habilidades que posee la casta*/

  public String[] getHabilidadesCasta() {
    return habilidadesCasta;
  }
  /** Este metodo devuelve la probabilidad que tiene la casta actual de golpecritico */

  public double getProbabilidadGolpeCritico() {
    return probabilidadGolpeCritico;
  }
  /** Este metodo establece la probabilidad de golpe critico */

  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }
  /** Este metodo devuelve la probabilidad de evitar daño de la casta actual */

  public double getProbabilidadEvitarDaño() {
    return probabilidadEvitarDaño;
  }
  /** Este metodo establece la probabilidad de evitar daño de la casta actual */

  public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDaño = probabilidadEvitarDaño;
  }
  /** Este metodo devuelve el valor del daño critico de la casta actual */

  public double getDañoCritico() {
    return dañoCritico;
  }
  /** Este metodo establece la probabilidad de daño critico  de la casta actual*/

  public void setDañoCritico(double dañoCritico) {
    this.dañoCritico = dañoCritico;
  }
}
