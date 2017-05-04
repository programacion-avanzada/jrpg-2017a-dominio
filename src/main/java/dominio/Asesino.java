package dominio;

/**
 * Un tipo de raza que hereda las caracteristicas de Casta.
 *
 */
public class Asesino extends Casta {

  public Asesino(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Asesino";
  }

  /**
   * Constructor por defecto
   */
  public Asesino() {
    super();
    this.nombreCasta = "Asesino";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }

  // Golpe Crítico
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
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
        return true;
      }
    }
    return false;
  }

  // Aumentar Evasion

  @Override
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      if ((this.getProbabilidadEvitarDaño() + 0.15) < 0.5) {
        this.probabilidadEvitarDaño += 0.15;
      } else {
        this.probabilidadEvitarDaño = 0.5;
      }
      return true;
    }
    return false;
  }

  // Robar
  @Override
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    return false;
  }
}
