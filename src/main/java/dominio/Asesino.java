package dominio;

/**
Esta clase es creada con el fin de poder crear un tipo de raza para el personaje en
el entorno del juego, en este caso Asesino.--
*/
public class Asesino extends Casta {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private static final int CANTIDAD_DE_HABILIDADES = 3;
  private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
  private static final double AUMENTO_EVASION_HABILIDAD = 0.15;
  private static final double TOPE_AUMENTO_EVASION = 0.5;
 
  //constructores
  /** 
   * Constructor parametrizado
 */
  public Asesino(final double probCrit, final double evasion, final double danoCrit) {
super(probCrit, evasion, danoCrit);
    this.setNombreCasta("Asesino");
  }

  /**
   *  Constructor por defecto
   */
  public Asesino() {
super();
    this.setNombreCasta("Asesino");
    setHabilidadesCasta(new String[CANTIDAD_DE_HABILIDADES]);
    getHabilidadesCasta()[0] = "Golpe Critico";
    getHabilidadesCasta()[1] = "Aumentar Evasion";
    getHabilidadesCasta()[2] = "Robar";
  }

  /**
  *El metodo "habilidad1" es el que calcula el dano por golpe critico
  *segun la casta del personaje
  */
  public boolean habilidad1(final Personaje caster, final Peleable atacado) {
    if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
      caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanoCritico())) > 0) {
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
      if (this.getProbabilidadEvitarDano() + AUMENTO_EVASION_HABILIDAD < TOPE_AUMENTO_EVASION) {
        this.setProbabilidadEvitarDano(this.getProbabilidadEvitarDano() + AUMENTO_EVASION_HABILIDAD);
      } else {
        this.setProbabilidadEvitarDano(TOPE_AUMENTO_EVASION);
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
