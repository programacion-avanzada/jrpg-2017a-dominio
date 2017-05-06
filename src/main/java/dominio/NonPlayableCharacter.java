package dominio;

/**
 * Clase que posee los atributos y funciones del NonPlayableCharacter.
 *
 */
public class NonPlayableCharacter extends Character {

  private int fuerza;

  private static final int dificultadAleatoria = -1;

  /**
   * @param nombre
   * @param nivel
   * @param dificultadNPC
   */
  public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
    this.nombre = nombre;
    this.nivel = nivel;
    int dificultad;
    if (dificultadNPC == dificultadAleatoria) {
      dificultad = MyRandom.nextInt(3);
    } else {
      dificultad = dificultadNPC;
    }
    if (dificultad == 0) {
      this.fuerza = 10 + ((nivel - 1) * 3);// 30%
      this.salud = 30 + ((nivel - 1) * 15);
      this.defensa = 2 + ((nivel - 1) * 1);
    }

    if (dificultad == 1) {
      this.fuerza = 20 + ((nivel - 1) * 6);// 50%
      this.salud = 40 + ((nivel - 1) * 20);
      this.defensa = 5 + ((nivel - 1) * 2);
    }

    if (dificultad == 2) {
      this.fuerza = 30 + ((nivel - 1) * 10);// 50%
      this.salud = 50 + ((nivel - 1) * 25);
      this.defensa = 4 + ((nivel - 1) * 4);
    }
    /*
     * switch (dificultad) { case 0: this.fuerza = 10 + ((nivel - 1) * 3);// 30%
     * this.salud = 30 + ((nivel - 1) * 15); this.defensa = 2 + ((nivel - 1) *
     * 1); break; case 1: this.fuerza = 20 + ((nivel - 1) * 6);// 50% this.salud
     * = 40 + ((nivel - 1) * 20); this.defensa = 5 + ((nivel - 1) * 2); break;
     * case 2: this.fuerza = 30 + ((nivel - 1) * 10);// 50% this.salud = 50 +
     * ((nivel - 1) * 25); this.defensa = 4 + ((nivel - 1) * 4); break; }
     *
     */
  }

  @Override
  public boolean esPersonaje() {
    return false;
  }

  @Override
  public int otorgarExp() {
    return this.nivel * 30;
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#getSalud()
   */
  @Override
  public int getSalud() {
    return salud;
  }

  /**
   * @param salud
   */
  public void setSalud(int salud) {
    this.salud = salud;
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#atacar(dominio.Peleable)
   */
  @Override
  public int atacar(Peleable atacado) {

    if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
      return atacado.serAtacado((int) (this.getAtaque() * 1.5));
    } else {
      return atacado.serAtacado(this.getAtaque());
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#serAtacado(int)
   */
  @Override
  public int serAtacado(int daño) {
    if (MyRandom.nextDouble() >= 0.15) {
      daño -= this.getDefensa() / 2;
      if (daño > 0) {
        salud -= daño;
        return daño;
      }
      return 0;// no le hace daño ya que la defensa fue mayor
    }
    return 0;// esquivo el golpe
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#getAtaque()
   */
  @Override
  public int getAtaque() {
    return fuerza;
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#setAtaque(int)
   */
  @Override
  public void setAtaque(int ataque) {
    this.fuerza = ataque;
  }

}
