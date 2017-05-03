package dominio;

/**
 * La clase Asesino hereda de Casta e implementa los metodos abstractos de su clase
 * padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son el golpe critico, aumentar la evasion y robar.
 */

public class Asesino extends Casta {

	private static final int TAMAÑO_CASTA = 3;

	/**
	 * Constructor de asesinos con parámetros.
	 * @param prob_crit es la probabilidad de golpe critico
	 * @param evasion
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
		habilidadesCasta = new String[TAMAÑO_CASTA];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster es el personaje a traves del cual se obtiene el daño a realizar.
	 * @param atacado es el objecto que será atacado.
	 * @return verdadero o falso para la utilización del golpe critico
	 * dependiendo del caster y el atacado.
	 */

	// Golpe Crítico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @return verdadero o falso para la utilización de aumentar evasion
	 * dependiendo del caster y el atacado.
	 */

	// Aumentar Evasion
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad3 de la clase padre.
	 * Devuelve siempre falso para la acción de robar.
	 */

	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
