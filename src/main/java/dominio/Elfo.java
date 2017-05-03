package dominio;

/**
 * La clase Elfo representa una raza (tipo) de personaje.
 * Tiene 2 habilidades que son el Golpe Level y Ataque Bosque.
 */

public class Elfo extends Personaje {

	private static final int INCREMENTO_NIVEL = 10;

	/**
	 * Constructor de un elfo con valores por defecto.
	 * Asigna el nombre y las habilidades de la raza.
	 * @param nombre del personaje
	 * @param casta del personaje
	 * @param id del personaje
	 */

	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		energiaTope += ENERGIA_MINIMA;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * Constructor de un elfo con valores por parámetro.
	 * Asigna los atributos del metodo de la clase padre pasando los mismos
	 * atributos recibidos. Asigna el nombre y las habilidades de la raza.
	 * @param nombre del elfo
	 * @param salud del personaje
	 * @param energia del personaje
	 * @param fuerza del personaje
	 * @param destreza del personaje
	 * @param inteligencia del personaje
	 * @param casta del personaje
	 * @param experiencia del personaje
	 * @param nivel del personaje
	 * @param idPersonaje del personaje
	 */

	public Elfo(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia,
			final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[CANTIDAD_HABILIDADES];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * habilidadRaza1 sobrescribe el metodo de la clase padre
	 * @param atacado atacado
	 * @return verdadero o falso dependiendo de una cuenta entre si mismo y
	 * el objecto atacado.
	 */

	// Golpe Level
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * INCREMENTO_NIVEL) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * habilidadRaza2 sobrescribe el metodo de la clase padre
	 * @param atacado atacado
	 * @return verdadero o falso dependiendo de una cuenta entre si mismo y
	 * el objecto atacado.
	 */

	// Ataque Bosque
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
				return true;
			}
		}
		return false;
	}
}
