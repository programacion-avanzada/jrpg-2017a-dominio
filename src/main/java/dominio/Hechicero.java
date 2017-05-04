package dominio;

/**
 * La clase Hechicero hereda de Casta e implementa los metodos abstractos
 * de su clase padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son la bola de fuego, curar al aliado
 * y aumentar la defensa.
 */

public class Hechicero extends Casta {

	private static final double INCREMENTO_MAGIA = 1.5;

	/**
	 * Permite crear un nuevo Hechicero con valores por parámetro.
	 * @param prob_crit probabilidad critica
	 * @param evasion evasion
	 * @param daño_crit daño crítico
	 */

	public Hechicero(final double prob_crit, final double evasion, final double daño_crit) {
		super("Hechicero", prob_crit, evasion, daño_crit);
	}

	/**
	 * Permite crear un nuevo Hechicero con sus habilidades por defecto.
	 */

	public Hechicero() {
		super("Hechicero", "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud");
	}

	/**
	 * Bola de Fuego
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de la bola de fuego
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * INCREMENTO_MAGIA)) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Curar Aliado
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la acción de curar aliado
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Robar Energia y Salud
	 * Sobreescribe la habilidad3 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de la robar energia y
	 * salud dependiendo del caster y el atacado.
	 */

	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado instanceof Personaje) {
				int puntosDeMagia = caster.calcularPuntosDeMagia();
				int energiaRobada = ((Personaje) atacado).serDesernegizado(puntosDeMagia);
				int saludRobada = ((Personaje) atacado).serRobadoSalud(puntosDeMagia / 2);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}

	/**
	 * @param personaje sobre el cual se incrementa la inteligencia
	 */

	public void incrementarAtributoAlCrear(final Personaje personaje) {
		personaje.setInteligencia(personaje.getInteligencia() + INCREMENTO_POR_TIPO);
	}

}
