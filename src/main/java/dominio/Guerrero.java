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
	 * @param probCrit es la probabilidad de golpe critico
	 * @param evasion evasion
	 * @param danoCrit es el dano crítico
	 */

	public Guerrero(final double probCrit, final double evasion, final double danoCrit) {
		super("Guerrero", probCrit, evasion, danoCrit);
	}

	/**
	 * Permite crear un nuevo Guerrero con sus habilidades por defecto.
	 */

	public Guerrero() {
		super("Guerrero", "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa");
	}

	/**
	 * getIncrementoFuerza los guerreros se inicializan con mas fuerza
	 * @return INCREMENTO_POR_TIPO
	 */

	public int getIncrementoFuerza() {
		return INCREMENTO_POR_TIPO;
	}

	/**
	 * Ataque Doble
	 * Sobreescribe la habilidad1 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización del ataque doble
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.usarHabilidad(ENERGIA_MINIMA);

			if (atacado.serAtacado(caster.ataque * INCREMENTO_ATAQUE) > 0) {
				return true;
			}
		}
		return false;
	}



	/**
	 * Aumentar Defensa
	 * Sobreescribe la habilidad2 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de aumentar defensa
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.usarHabilidad(ENERGIA_MINIMA);
			caster.aumentarDefensa(caster.magia);
			return true;
		}
		return false;
	}

	/**
	 * Ignorar Defensa
	 * Sobreescribe la habilidad3 de la clase padre.
	 * @param caster caster
	 * @param atacado atacado
	 * @return verdadero o falso para la utilización de aumentar defensa
	 * dependiendo del caster y el atacado.
	 */

	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIA_MINIMA) {
			caster.usarHabilidad(ENERGIA_MINIMA);
			atacado.anularDefensa();
			if (atacado.serAtacado(caster.ataque) > 0) {
				atacado.reestablecerDefensa();
				return true;
			}
		}
		return false;
	}

}
