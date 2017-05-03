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
	 * @param evasion
	 * @param daño_crit daño crítico
	 */

	public Hechicero(final double prob_crit, final double evasion, final double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * Permite crear un nuevo Hechicero con sus habilidades por defecto.
	 */

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[CANTIDAD_HABILIDADES];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster
	 * @param atacado
	 * @return verdadero o falso para la utilización de la bola de fuego
	 * dependiendo del caster y el atacado.
	 */

	// Bola de Fuego
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
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster
	 * @param atacado
	 * @return verdadero o falso para la acción de curar aliado
	 * dependiendo del caster y el atacado.
	 */

	// Curar Aliado
	public boolean habilidad2(Personaje caster, Peleable aliado) {
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
	 * Sobreescribe la habilidad3 de la clase padre.
	 * @param caster
	 * @param atacado
	 * @return verdadero o falso para la utilización de la robar energia y
	 * salud dependiendo del caster y el atacado.
	 */

	// Robar Energia y Salud
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
