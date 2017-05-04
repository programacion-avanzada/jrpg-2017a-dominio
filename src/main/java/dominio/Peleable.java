
package dominio;

/** Interface implementada en las clases Personaje y NPC.
 * Dependiendo qué clase las esté implementando será como responderán
 *
 */
public interface Peleable {
	int serAtacado(int daño);

	int getSalud();

	int getMagia();

	void despuesDeTurno();

	int atacar(Peleable atacado);

	int otorgarExp();

	int getAtaque();

	void setAtaque(int ataque);

	boolean estaVivo();

	String getNombre();
}
