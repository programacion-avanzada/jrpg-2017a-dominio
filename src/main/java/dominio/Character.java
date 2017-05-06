package dominio;

public class Character implements Peleable {
  protected int fuerza;
  protected String nombre;
  protected int nivel;
  protected int defensa;
  protected int salud;

  public Character() {

  }

  /**
   * @param exp
   */
  public boolean ganarExperiencia(int exp) {
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#despuesDeTurno()
   */
  @Override
  public void despuesDeTurno() {
  }

  @Override
  public boolean estaVivo() {
    return salud > 0;
  }

  /**
   * @return devuelve la fuerza
   */
  public int getFuerza() {
    return fuerza;
  }

  /**
   * @param fuerza
   */
  public void setFuerza(int fuerza) {
    this.fuerza = fuerza;
  }

  /*
   * (non-Javadoc)
   *
   * @see dominio.Peleable#getNombre() Devuelve el nombre del personaje
   * solicitado
   */
  @Override
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return devuelve el nivel del personaje
   */
  public int getNivel() {
    return nivel;
  }

  /**
   * @param nivel
   */
  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  /**
   * @return devuelve la defensa del personaje
   */
  @Override
  public int getDefensa() {
    return defensa;
  }

  /**
   * @param defensa
   */
  @Override
  public void setDefensa(int defensa) {
    this.defensa = defensa;
  }

  @Override
  public int serAtacado(int daño) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getSalud() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int atacar(Peleable atacado) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int otorgarExp() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getAtaque() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAtaque(int ataque) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean esPersonaje() {
    // TODO Auto-generated method stub
    return false;
  }

}
