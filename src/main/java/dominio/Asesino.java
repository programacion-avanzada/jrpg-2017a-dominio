package dominio;

/**
 * La clase Asesino hereda de Casta e implementa los metodos abstractos de su clase
 * padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son el golpe critico, aumentar la evasion y robar.
 */

public class Asesino extends Casta {

	private static final int ENERGIA_MINIMA = 3;
	private static final double INCREMENTO_EVITAR_DAÑO = 0.15;
	private static final double MAX_PROBABILIDAD_EVITAR_DAÑO = 0.5;

	/**
	 * Constructor de asesinos con parámetros.
	 * @param prob_crit es la probabilidad de golpe critico
	 * @param evasion evasion
	 * @param daño_crit es el daño crítico
	 */

	public Asesino(final double prob_crit, final double evasion, final double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Asesino";
	}

	/**
	 * Constructor de asesinos por defecto. Asigna el nombre y las habilidades
	 * de esta casta.
	 */

	public Asesino() {
		super();
		this.nombreCasta = "Asesino";
		habilidadesCasta = new String[CANTIDAD_HABILIDADES];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster es el personaje a traves del cual se obtiene el daño y al que se
	 * le decrementa la energía.
	 * @param atacado es el objecto que será atacado.
	 * @return verdadero o falso para la utilización del golpe critico
	 * dependiendo del caster y el atacado.
	 */

	// Golpe Crítico
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
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

	// Aumentar Evasion
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (this.getProbabilidadEvitarDaño() + INCREMENTO_EVITAR_DAÑO < MAX_PROBABILIDAD_EVITAR_DAÑO) {
				this.probabilidadEvitarDaño += INCREMENTO_EVITAR_DAÑO;
			} else {
				this.probabilidadEvitarDaño = MAX_PROBABILIDAD_EVITAR_DAÑO;
			}
			return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad3 de la clase padre.
	 * @param caster no es utilizado
	 * @param atacado no es utilizado
	 * @return siempre falso.
	 */

	// Robar
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}
}
