package dominio;

/**
 * La clase Humano representa una raza (tipo) de personaje.
 * Tiene 2 habilidades de raza que son incentivar y el golpe fatal.
 */

public class Humano extends Personaje {

	private static final int ENERGIA_MINIMA = 2;
	private static final int INCREMENTO_TOPE = 5;

	/**
	 * Permite crear un humano con atributos por defecto.
	 * @param nombre del humano
	 * @param casta casta
	 * @param id de personaje
	 */

	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, "Humano", "Incentivar", "Golpe Fatal");
		saludTope += INCREMENTO_TOPE;
		energiaTope += INCREMENTO_TOPE;
		salud = saludTope;
		energia = energiaTope;
	}

	/**
	 * Permite crear un humano con atributos pasados por parametro.
	 * @param nombre nombre
	 * @param salud salud
	 * @param energia energia
	 * @param fuerza fuerza
	 * @param destreza destreza
	 * @param inteligencia inteligencia
	 * @param casta casta
	 * @param experiencia experiencia
	 * @param nivel nive;
	 * @param idPersonaje idPersonaje
	 */

	public Humano(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia,
			final Casta casta, final int experiencia, final int nivel,
			final int idPersonaje) {

		super(
			nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia,
			nivel, idPersonaje, "Humano", "Incentivar", "Golpe Fatal"
		);
	}

	/**
	 * Incentivar
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado attacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Golpe Fatal
	 * habilidadRaza2 sobrescribe el metodo de la clase padre.
	 * @param atacado atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			if (atacado.serAtacado(atacado.getSalud() / ENERGIA_MINIMA) > 0) {
				this.setEnergia(this.getEnergia() / ENERGIA_MINIMA);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
		return false;
	}
}
