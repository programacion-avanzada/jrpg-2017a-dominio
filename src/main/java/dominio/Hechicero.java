package dominio;

/**
 * Un tipo de raza que hereda las caracteristicas de Casta.
 *
 */
public class Hechicero extends Casta {

  public Hechicero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Hechicero";
  }

  /**
   * Constructor por defecto de Hechicero
   */
  public Hechicero() {
    super();
    this.nombreCasta = "Hechicero";
    habilidadesCasta = new String[3];
    habilidadesCasta[0] = "Bola de Fuego";
    habilidadesCasta[1] = "Curar Aliado";
    habilidadesCasta[2] = "Robar Energia y Salud";
  }

  // Bola de Fuego
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
      if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0) {
        return true;
      }
    }
    return false;
  }

  // Curar Aliado
  @Override
  public boolean habilidad2(Personaje caster, Peleable aliado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);
      // es personaje esta sobreescrito en Personaje y NPC. cada uno devolvera V
      // & F respectivamente
      if (aliado.esPersonaje()) {
        ((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
        return true;
      }
    }
    return false;
  }

  // Robar Energia y Salud
  @Override
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > 10) {
      caster.setEnergia(caster.getEnergia() - 10);

      if (atacado.esPersonaje()) {
        int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
        int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
        caster.serEnergizado(energia_robada);
        caster.serCurado(salud_robada);
        return true;
      }
      /*
       * if (atacado instanceof Personaje) { int energia_robada = ((Personaje)
       * atacado).serDesernegizado(caster.calcularPuntosDeMagia()); int
       * salud_robada = ((Personaje)
       * atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
       * caster.serEnergizado(energia_robada); caster.serCurado(salud_robada);
       * return true; }
       */

    }
    return false;
  }

  @Override
  /**
   * addInteligenciaInicial().
   *
   * @return Devuelve el numero a sumar al valor base
   */
  public int addInteligenciaInicial() {
    return 5;
  }

}
