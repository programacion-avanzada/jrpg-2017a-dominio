package dominio;

import java.util.LinkedList;

/**
 *  La clase Alianza tiene como función agrupar a los jugadores
 *  mediante una LinkedList de Personajes
 *
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;
	/**
	 * Constructor de la Clase que genera una lista vacía de personajes y
	 * asigna el nombre a la Alianza
	 * 
	 * @param nombre Nombre que se le dará a la alianza
	 */
	
	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}
	/**
	 * Método void que referencia al atributo aliados con el argumento del método.
	 * De haber una lista aliados preexistente, está será sobreescrita por la nueva.
	 * @param aliados LinkedList que sobreescribirá a la actual
	 */
	
	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public String obtenerNombre(){
		return nombre;
	}
	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	/**
	 * Método void que agrega un nuevo Personaje a la LinkedList aliados utilizando el método
	 * add() de la LinkedList
	 * @param pj Personaje a agregarse a la lista de aliados
	 */
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
