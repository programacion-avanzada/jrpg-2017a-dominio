package dominio;

/**
 * La clase Orco representa una raza (tipo) de personaje.
 * Tiene 2 habilidades de raza que son el golpe defensa y el mordisco de vida.
 */

public class Orco extends Personaje {

	private static final int INCREMENTO_DEFENSA = 2;

	/**
	 * Permite crear un orco con atributos por defecto.
	 * @param nombre del orco
	 * @param casta casta
	 * @param id del personaje
	 */

	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id, "Orco", "Golpe Defensa", "Mordisco de Vida");
		saludTope += INCREMENTO_TOPE;
		salud = saludTope;
		energia = energiaTope;
	}

	/**
	 * Permite crear un orco con atributos pasados por parámetro.
	 * @param nombre del orco
	 * @param salud del orco
	 * @param energia del orco
	 * @param fuerza del orco
	 * @param destreza del orco
	 * @param inteligencia del orco
	 * @param casta del orco
	 * @param experiencia del orco
	 * @param nivel del orco
	 * @param idPersonaje del orco
	 */

	public Orco(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia,
			final Casta casta, final int experiencia, final int nivel,
			final int idPersonaje) {

		super(
			nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia,
			nivel, idPersonaje, "Orco", "Golpe Defensa", "Mordisco de Vida"
		);
	}

	/**
	 * Golpe Defensa
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado(this.getDefensa() * INCREMENTO_DEFENSA) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Mordisco de Vida
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
}