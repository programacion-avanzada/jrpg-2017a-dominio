package dominio;

/**
 * Es uno de los tipos de persona, herendando asi sus atributos y
 * funcionalidades.
 *
 */
public class Elfo extends Personaje {

  /**
   * @param nombre
   * @param casta
   * @param id
   */
  public Elfo(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    energiaTope += 10;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Elfo";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Level";
    habilidadesRaza[1] = "Ataque Bosque";
  }

  public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
    nombreRaza = "Elfo";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Level";
    habilidadesRaza[1] = "Ataque Bosque";
  }

  // Golpe Level
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
      if (atacado.serAtacado(this.getFuerza() + (this.getNivel() * 10)) > 0) {
        return true;
      }
    }
    return false;
  }

  // Ataque Bosque
  @Override
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado((this.magia)) > 0) {
        return true;
      }
    }
    return false;
  }
}
