package dominio;

/**
Esta clase es creada con el fin de poder crear un tipo de raza para el personaje en
el entorno del juego, en este caso Asesino.--
*/
public class Asesino extends Casta {

  static final int CANTIDAD_DE_HABILIDADES = 3;
  static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
  static final double AUMENTO_EVASION_HABILIDAD = 0.15;
  static final double TOPE_AUMENTO_EVASION = 0.5;

  private static final long serialVersionUID = 1L;

  //constructores
  /** 
   * Constructor parametrizado
 */
  public Asesino(final double probCrit, final double evasion, final double dañoCrit) {
super(probCrit, evasion, dañoCrit);
    this.nombreCasta = "Asesino";
  }

  /**
   *  Constructor por defecto
   */
  
  public Asesino() {
super();
    this.nombreCasta = "Asesino";
    habilidadesCasta = new String[CANTIDAD_DE_HABILIDADES];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }

  /**
  *El metodo "habilidad1" es el que calcula el daño por golpe critico
  *segun la casta del personaje
  */
  public boolean habilidad1(final Personaje caster, final Peleable atacado) {
    if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
      caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
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

  public boolean habilidad2(final Personaje caster, final Peleable atacado) {
    if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
      caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
      if (this.getProbabilidadEvitarDaño() + AUMENTO_EVASION_HABILIDAD < TOPE_AUMENTO_EVASION) {
        this.probabilidadEvitarDaño += AUMENTO_EVASION_HABILIDAD;
      } else {
        this.probabilidadEvitarDaño = TOPE_AUMENTO_EVASION;
      }
      return true;
    }
    return false;
  }

  // Robar
  public boolean habilidad3(final Personaje caster, final Peleable atacado) {
    return false;
  }
}
