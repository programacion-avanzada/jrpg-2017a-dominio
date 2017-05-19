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
	 * @param dano_crit dano crítico
	 */

	public Hechicero(final double prob_crit, final double evasion, final double dano_crit) {
		super("Hechicero", prob_crit, evasion, dano_crit);
	}

	/**
	 * Permite crear un nuevo Hechicero con sus habilidades por defecto.
	 */

	public Hechicero() {
		super("Hechicero", "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud");
	}

	/**
	 * getIncrementoInteligencia los hechizeros se inicializan con mas inteligencia
	 * @return INCREMENTO_POR_TIPO
	 */

	public int getIncrementoInteligencia(){
		return INCREMENTO_POR_TIPO;
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
			caster.usarHabilidad(ENERGIA_MINIMA);
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
			caster.usarHabilidad(ENERGIA_MINIMA);
			aliado.serCurado(caster.calcularPuntosDeMagia());
			return true;
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
			caster.usarHabilidad(ENERGIA_MINIMA);
			int puntosDeMagia = caster.calcularPuntosDeMagia();
			int energiaRobada = atacado.serDesenergizado(puntosDeMagia);
			int saludRobada = atacado.serRobadoSalud(puntosDeMagia / 2);
			caster.serEnergizado(energiaRobada);
			caster.serCurado(saludRobada);
			return true;
		}
		return false;
	}

}
