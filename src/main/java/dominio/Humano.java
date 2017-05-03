package dominio;

/**
 * La clase Humano representa una raza (tipo) de personaje.
 * Tiene 2 habilidades de raza que son incentivar y el golpe fatal.
 */

public class Humano extends Personaje {

	private static final int ENERGIA_MINIMA = 2;

	/**
	 * Permite crear un humano con atributos por defecto.
	 * @param nombre del humano
	 * @param casta
	 * @param id de personaje
	 */

	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	/**
	 * Permite crear un humano con atributos pasados por parametro.
	 * @param nombre
	 * @param salud
	 * @param energia
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta
	 * @param experiencia
	 * @param nivel
	 * @param idPersonaje
	 */

	public Humano(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[CANTIDAD_HABILIDADES];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	// Incentivar
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * habilidadRaza2 sobrescribe el metodo de la clase padre.
	 * @param atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	// Golpe Fatal
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
