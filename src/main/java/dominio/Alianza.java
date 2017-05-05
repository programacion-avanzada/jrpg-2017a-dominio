package dominio;

import java.util.LinkedList;

/**
 * Alianza es la clase que une todos los personajes junto con sus aliados en una
 * lista en comun.
 *
 */
public class Alianza {

  String nombre;
  LinkedList<Personaje> aliados;

  /**
   * @param Constructor parametrizado
   */
  public Alianza(String nombre) {
    this.nombre = nombre;
    this.aliados = new LinkedList<Personaje>();
  }

  /**
   * Devuelve una lista de personajes donde estan todos los aliados.
   */
  public LinkedList<Personaje> getAliados() {
    return aliados;
  }

  /**
   * @param aliados
   *          Permite guardar la lista de aliados que le pase en la Alianza
   */
  public void setAliados(LinkedList<Personaje> aliados) {
    this.aliados = aliados;
  }

  /**
   * @return devuelve el nombre
   */
  public String obtenerNombre() {
    return nombre;
  }

  /**
   * @param Elimina un personaje de la alianza
   */
  public void eliminarPersonaje(Personaje pj) {
    aliados.remove(pj);
  }

  /**
   * @param Agrega un personaje a la alianza
   */
  public void aņadirPersonaje(Personaje pj) {
    aliados.add(pj);
  }
}
