package dominio;

/**
 * Un tipo de raza que hereda las caracteristicas de Casta.
 *
 */
public class Guerrero extends Casta {

  public Guerrero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Guerrero";
  }

  /**
   * Constructor por defecto de guerrero
   */
  public Guerrero() {
    super();
    this.nombreCasta = "Guerrero";

    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Ataque Doble";
    habilidadesCasta[1] = "Aumentar Defensa";
    habilidadesCasta[2] = "Ignorar Defensa";
  }

  // Ataque Doble
  /*
   * (non-Javadoc)
   *
   * @see dominio.Casta#habilidad1(dominio.Personaje, dominio.Peleable) Devuelve
   * si el personaje que le pasamos tiene la habilidad pedida
   */
  @Override
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if (atacado.serAtacado(caster.ataque * 2) > 0) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int addFuerzaInicial() {
    return 5;
  }

  // Aumentar Defensa
  @Override
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      caster.setDefensa(caster.getDefensa() + caster.magia);
      return true;
    }
    return false;
  }

  // Ignorar Defensa
  @Override
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);

      if (atacado.esPersonaje()) {
        int defensa_original = atacado.getDefensa();
        atacado.setDefensa(0);
        if (atacado.serAtacado(caster.ataque) > 0) {
          atacado.setDefensa(defensa_original);
          return true;
        }
      }
      /*
       * if (atacado instanceof Personaje) { int defensa_original = ((Personaje)
       * atacado).getDefensa(); ((Personaje) atacado).setDefensa(0); if
       * (atacado.serAtacado(caster.ataque) > 0) { ((Personaje)
       * atacado).setDefensa(defensa_original); return true; } }
       */

    }
    return false;
  }
}
