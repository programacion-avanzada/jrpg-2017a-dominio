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
	 * @param casta
	 * @param id del personaje
	 */

	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[CANTIDAD_HABILIDADES];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * Permite crear un orco con atributos pasados por parámetro.
	 * @param nombre del orco
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

	public Orco(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia,
			final Casta casta, final int experiencia, final int nivel,
			final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[CANTIDAD_HABILIDADES];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	// Golpe Defensa
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIA_MINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado(this.getDefensa() * INCREMENTO_DEFENSA) > 0)
				return true;
		}
		return false;
	}

	/**
	 * habilidadRaza1 sobrescribe el metodo de la clase padre.
	 * @param atacado
	 * @return verdadero o falso dependiendo del objeto atacado y de sí mismo.
	 */

	// Mordisco de Vida
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
