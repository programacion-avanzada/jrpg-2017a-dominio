package dominio;

/**
 * Esta interface define los metodos requeridos por las clases que
 * representen entidades que pueden pelear entre sí.
 * La implementan la clase Personaje y NonPlayableCharacter.
 */

public interface Peleable {

	/**
	 * Ser Atacado
	 * @param daño realizado
	 * @return daño realizado efectivamente
	 */
	int serAtacado(int daño);

	/**
	 * Get Salud
	 * @return salud
	 */
	int getSalud();

	/**
	 * Despues De Turno
	 */
	void despuesDeTurno();

	/**
	 * Atacar
	 * @param atacado objeto atacado
	 * @return si puede atacar o no
	 */
	int atacar(Peleable atacado);

	/**
	 * Otorgar Experiencia
	 * @return nueva experiencia
	 */
	int otorgarExp();


	/**
	 * Ataque
	 * @return puntos de ataque
	 */
	int getAtaque();


	/**
	 * Set Ataque
	 * @param ataque ataque
	 */
	void setAtaque(int ataque);

	/**
	 * Esta Vivo ?
	 * @return si esta vivo o no
	 */
	boolean estaVivo();

	/**
	 * Get Nombre
	 * @return nombre del objeto
	 */
	String getNombre();

	/**
	 * Aumenta la salud del personaje.
	 * @param salud salud del personaje
	 */

	void serCurado(int salud);

	/**
	 * @param defensa defensa
	 */

	/**
	 * Aplica daño a la energia y devuelve la cantidad del
	 * mismo que se ha inflingido.
	 * @param daño daño
	 * @return daño que se ha inflingido.
	 */

	int serDesenergizado(int daño);

	/**
	 * Aplica un daño a la salud y devuelve la cantidad del
	 * mismo que se ha inflingido.
	 * @param daño daño
	 * @return daño que se ha inflingido.
	 */

	int serRobadoSalud(int daño);

	/**
	 * Anula la defensa hasta ser reestablecida
	 */

	void anularDefensa();

	/**
	 * Reestablece la defensa
	 */

	void reestablecerDefensa();
}
