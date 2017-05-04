package dominio;

/**
 * Es uno de los tipos de persona, herendando asi sus atributos y
 * funcionalidades.
 *
 */
public class Humano extends Personaje {

  public Humano(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    saludTope += 5;
    energiaTope += 5;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Humano";
  }

  /**
   * @param nombre
   * @param salud
   * @param energia
   * @param fuerza
   * @param destreza
   * @param inteligencia
   * @param casta
   * @param experiencia
   * @param nivel
   * @param idPersonaje
   */
  public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
    nombreRaza = "Humano";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Incentivar";
    habilidadesRaza[1] = "Golpe Fatal";
  }

  // Incentivar
  /*
   * (non-Javadoc)
   *
   * @see dominio.Personaje#habilidadRaza1(dominio.Peleable) Devuele si el
   * personaje en cuestion tiene o no la habilidad requerida
   */
  @Override
  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      atacado.setAtaque(atacado.getAtaque() + this.getMagia());
      return true;
    }
    return false;
  }

  // Golpe Fatal
  @Override
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
        this.setEnergia(this.getEnergia() / 2);
        return true;
      }
    }
    this.setEnergia(this.getEnergia() - 10);
    return false;
  }
}
