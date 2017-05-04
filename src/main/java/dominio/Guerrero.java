package dominio;

/**
 * La clase Guerrero hereda de Casta e implementa los metodos abstractos de su clase
 * padre, habilidad 1, 2 y 3. Es un tipo especifico de Casta.
 * Tambien define sus habilidades que son el ataque doble, aumentar la defensa
 * e ignorar la defensa.
 */

public class Guerrero extends Casta {

	private static final int INCREMENTO_ATAQUE = 2;

	/**
	 * Permite crear un nuevo Guerrero con con valores por parámetro.
	 * @param prob_crit es la probabilidad de golpe critico
	 * @param evasion evasion
	 * @param daño_crit es el daño crítico
	 */

	public Guerrero(final double prob_crit, final double evasion, final double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	/**
	 * Permite crear un nuevo Guerrero con sus habilidades por defecto.
	 */

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[CANTIDAD_HABILIDADES];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización del ataque doble
	 * dependiendo del caster y el atacado.
	 */

	// Ataque Doble
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado.serAtacado(caster.ataque * INCREMENTO_ATAQUE) > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de aumentar defensa
	 * dependiendo del caster y el atacado.
	 */

	// Aumentar Defensa
	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	/**
	 * Sobreescribe la habilidad3 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de aumentar defensa
	 * dependiendo del caster y el atacado.
	 */

	// Ignorar Defensa
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}
		}
		return false;
	}
}
