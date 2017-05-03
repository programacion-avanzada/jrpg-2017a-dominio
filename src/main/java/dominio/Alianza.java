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
	 * @param nombre
	 */

	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * Devuelve la lista de aliados
	 * @return aliados
	 */

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	/**
	 * Asigna la lista de aliados
	 */

	public void setAliados(final LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	/**
	 * Devulve el nombre de la alianza
	 * @return nombre
	 */

	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Elimina un personaje de la lista que representa a los aliados.
	 */

	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Agrega un personaje a la lista que representa a los aliados.
	 */

	public void añadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
