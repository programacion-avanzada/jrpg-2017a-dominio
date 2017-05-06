package dominio;

import java.util.LinkedList;

/**  Esta clase es desarrollada para saber y establecer las alianzas entre los personajes */
public class Alianza {

  private final String nombre;
  private final LinkedList<Personaje> aliados;

  public Alianza(String nombre) {
    this.nombre = nombre;
    this.aliados = new LinkedList<Personaje>();
  }
  
  /** Este medoto devuelve el nombre de nuestra alianza actual*/
  public String getNombre() {
    return nombre;
  }
  
  /** Este medoto devuelve el listado de los personajes aliados en la alianza actual*/
  public LinkedList<Personaje> getAliados() {
    return aliados;
  }

  /** Este medoto devuelve el nombre de la alianza actual @David*/ 
  public String obtenerNombre() {
    return nombre;
  }

  /**
     * Método "eliminarPersonaje", elimina a un personaje que ya no es aliado
     */ 
  public void eliminarPersonaje(final Personaje pj) {
    aliados.remove(pj);
  }

  /**
     * Método "anadirPersonaje", anade a un personaje aliado.
     */ 
  public void anadirPersonaje(final Personaje pj) {
    aliados.add(pj);
  }
}
