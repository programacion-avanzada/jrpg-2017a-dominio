package dominio;

/**
 * La clase Asesino hereda de Casta e implementa los metodos abstractos de su clase
 * padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son el golpe critico, aumentar la evasion y robar.
 */

public class Asesino extends Casta {

	private static final int ENERGIA_MINIMA = 3;
	private static final double INCREMENTO_EVITAR_DANO = 0.15;
	private static final double MAX_PROBABILIDAD_EVITAR_DANO = 0.5;

	/**
	 * Constructor de asesinos con parámetros.
	 * @param probCrit es la probabilidad de golpe critico
	 * @param evasion evasion
	 * @param danoCrit es el dano crítico
	 */

	public Asesino(final double probCrit, final double evasion, final double danoCrit) {
		super("Asesino", probCrit, evasion, danoCrit);
	}

	/**
	 * Constructor de asesinos por defecto. Asigna el nombre y las habilidades
	 * de esta casta.
	 */

	public Asesino() {
		super("Asesino", "Golpe Critico", "Aumentar Evasion", "Robar");
	}

	/**
	 * getDestreza los asesinos se inicializan con mas destreza
	 * @return INCREMENTO_POR_TIPO
	 */

	public int getDestreza() {
		return INCREMENTO_POR_TIPO;
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster es el personaje a traves del cual se obtiene el dano y al que se
	 * le decrementa la energía.
	 * @param atacado es el objecto que será atacado.
	 * @return verdadero o falso para la utilización del golpe critico
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.usarHabilidad(ENERGIA_MINIMA);

			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDanoCritico())) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster es el personaje al cual se le decrementa la energía.
	 * @param atacado no es utilizado en este metodo
	 * @return verdadero o falso para la utilización de aumentar evasion
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.usarHabilidad(ENERGIA_MINIMA);

			if (this.getProbabilidadEvitarDano() + INCREMENTO_EVITAR_DANO < MAX_PROBABILIDAD_EVITAR_DANO) {
				this.probabilidadEvitarDano += INCREMENTO_EVITAR_DANO;
			} else {
				this.probabilidadEvitarDano = MAX_PROBABILIDAD_EVITAR_DANO;
			}
			return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad3 (robar) de la clase padre.
	 * @param caster no es utilizado
	 * @param atacado no es utilizado
	 * @return siempre falso.
	 */

	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}

}
