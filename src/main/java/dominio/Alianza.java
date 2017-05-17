package dominio;

import java.util.LinkedList;

/**
 * La clase Alianza representa el vinculo entre una lista personajes
 * la cual tiene un nombre como atributo. Se pueden agregar y eliminar personajes
 * de las alianzas.
 */

public class Alianza {

	private String nombre;
	private LinkedList<Personaje> aliados;

	/**
	 * Constructor de la clase.
	 * @param nombre de la alianza
	 */

	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * @return aliados
	 */

	public LinkedList<Personaje> getAliados() {
		return copiarLista(this.aliados);
	}

	/**
	 * Devulve el nombre de la alianza
	 * @return nombre del asesino
	 */

	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Elimina un personaje de la lista que representa a los aliados.
	 * @param pj es el personaje a eliminar
	 */

	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Agrega un personaje a la lista que representa a los aliados.
	 * @param pj es el personaje a añadir
	 */

	public void añadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}

	private static LinkedList<Personaje> copiarLista(LinkedList<Personaje> lista) {
		LinkedList<Personaje> copia = new LinkedList<Personaje>();
		for(int i = 0 ; i < lista.size() ; i++) {
			copia.add(lista.get(i));
		}
		return copia;
	}
	
}
