package dominio;

/**
Esta clase es creada con el fin de poder crear un tipo de raza para el personaje en
el entorno del juego, en este caso Asesino.--
*/
public class Asesino extends Casta {

  //constructores
  /** 
   * Constructor parametrizado
 */
  public Asesino(double probCrit, double evasion, double dañoCrit) {
super(probCrit, evasion, dañoCrit);
    this.nombreCasta = "Asesino";
  }

  /** Constructor por defecto*/
  
  public Asesino() {
super();
    this.nombreCasta = "Asesino";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }

  /**
  *El metodo "habilidad1" es el que calcula el daño por golpe critico
  *segun la casta del personaje
  */

  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
        return true;
      }
    }
    return false;
  }

  /** 
  * El metodo "habilidad2" es el que aumenta la evasion segun 
  *la casta del personaje
  */

  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5) {
        this.probabilidadEvitarDaño += 0.15;
      } else {
        this.probabilidadEvitarDaño = 0.5;
      }
      return true;
    }
    return false;
  }

  // Robar
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    return false;
  }
}
