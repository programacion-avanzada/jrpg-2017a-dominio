package dominio;

import java.util.LinkedList;

/**
 * La clase Alianza representa el vinculo entre una lista personajes
 * la cual tiene un nombre como atributo. Se pueden agregar y eliminar personajes
 * de las alianzas.
 */

public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public String obtenerNombre(){
		return nombre;
	}

	/**
	 * eliminarPersonaje elimina un personaje de la lista que representa a los aliados.
	 */

	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}

	/**
	 * añadirPersonaje agrega un personaje a la lista que representa a los aliados.
	 */

	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
