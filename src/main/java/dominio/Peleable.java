package dominio;

/**
 * Clase Peleable Esta clase contiene la definicion de los metodos y funciones
 * que van a utilizar la clase Personaje y NonPlayableCharacter Son las
 * funciones principales.
 *
 */
public interface Peleable {
  public int serAtacado(int daño);

  public int getSalud();

  public void despuesDeTurno();

  public int atacar(Peleable atacado);

  public int otorgarExp();

  public int getAtaque();

  public void setAtaque(int ataque);

  public boolean estaVivo();

  public String getNombre();
}
