package dominio;

/**
 * Es uno de los tipos de persona, herendando asi sus atributos y
 * funcionalidades.
 *
 */
public class Orco extends Personaje {

  /**
   * @param nombre
   * @param casta
   * @param id
   */
  public Orco(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    saludTope += 10;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Orco";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Defensa";
    habilidadesRaza[1] = "Mordisco de Vida";
  }

  public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
    nombreRaza = "Orco";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Defensa";
    habilidadesRaza[1] = "Mordisco de Vida";
  }

  // Golpe Defensa
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
      if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
        return true;
      }
    }
    return false;
  }

  // Mordisco de Vida
  @Override
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      int danioCausado = atacado.serAtacado(this.getFuerza());
      if (danioCausado > 0) {
        this.serCurado(danioCausado);
        return true;
      }
    }
    return false;
  }
}
