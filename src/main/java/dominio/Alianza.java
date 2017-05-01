
package dominio;

import java.util.LinkedList;

public class Alianza {

	private final String nombre;
	private LinkedList<Personaje> aliados;
	/**La clase Alianza tiene como función agrupar a los jugadores.
	 * mediante una LinkedList de Personajes
	 * @param nombre Nombre que se le dará a la alianza
	 */

	public Alianza(final String nombre){
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public final LinkedList<Personaje> getAliados(){
		return aliados;
	}

	/**Método void que referencia al atributo aliados con el argumento del método.
	 * De haber una lista aliados preexistente, está será sobreescrita por la nueva.
	 * @param aliados LinkedList que sobreescribirá a la actual
	 */

	public final void setAliados(final LinkedList<Personaje> aliados){
		this.aliados = aliados;
	}

	public final String obtenerNombre(){
		return nombre;
	}

	public final void eliminarPersonaje(final Personaje pj){
		aliados.remove(pj);
	}

	/**Método void que agrega un nuevo Personaje a la LinkedList aliados utilizando el método.
	 * add() de la LinkedList
	 * @param pj Personaje a agregarse a la lista de aliados
	 */
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
