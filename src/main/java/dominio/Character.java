package dominio;



/**
 * La clase Character contiene los atributos y metodos compartidos de
 * Personaje y NonPlayableCharacter.
 */

public abstract class Character {

  private String nombre;

  /**
   * Contructor de un Character
   * @param nombre nombre del character
   */

  public Character(final String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return nombre del personaje
   */

  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre del personaje
   */

  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }

}
