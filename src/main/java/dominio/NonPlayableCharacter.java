package dominio;

import java.util.ArrayList;

/**
 * La clase NonPlayableCharacter implementa la interface Peleable que Define una
 * lista de métodos a ser implementados. Define los atributos de salud, fuerza,
 * defensa, nombre y nivel.
 */

public class NonPlayableCharacter extends Character {

	private static final double PORCENTAJE_GOLPE_CRITICO = 0.15;
	private static final int DIFICULTAD_ALEATORIA = -1;

	/**
	 * Constructor de la clase. Asigna atributos de fuerza, salud y defensa
	 * basados en la dificultad.
	 *
	 * @param nombre
	 *            nombre
	 * @param nivel
	 *            nivel
	 * @param dificultadNPC
	 *            dificultadNonPlayableCharacter
	 * @param inventario
	 *            inventario
	 */

	public NonPlayableCharacter(final String nombre, final int nivel,
		final int dificultadNPC, final ArrayList<Item> inventario) {

		super(nombre, nivel, inventario);

		int dificultad;
		if (dificultadNPC == DIFICULTAD_ALEATORIA) {
			dificultad = this.aleatorizador.nextInt(3);
		} else {
			dificultad = dificultadNPC;
		}

		switch (dificultad) {
		case 0:
			this.fuerza = calcularAtributo(10, 3);
			this.salud = calcularAtributo(30, 15);
			this.defensa = calcularAtributo(2, 1);
			break;
		case 1:
			this.fuerza = calcularAtributo(20, 6);
			this.salud = calcularAtributo(40, 20);
			this.defensa = calcularAtributo(5, 2);
			break;
		case 2:
			this.fuerza = calcularAtributo(30, 10);
			this.salud = calcularAtributo(50, 25);
			this.defensa = calcularAtributo(4, 4);
			break;
		default:
			break;
		}
	}

	/**
	 * Calcula el atributo fuerza salud o defensa al inicializar el NPC
	 * @param a
	 *            es un valor numerico
	 * @param b
	 *            es un valor numerico
	 * @return una funcion lineal con el nivel
	 */

	private int calcularAtributo(final int a, final int b) {
		return a + (nivel - 1) * b;
	}

	/**
	 * Otorga experiencia al personaje multiplicando su nivel.
	 *
	 * @return 30 veces el nivel actual.
	 */

	public int otorgarExp() {
		return this.nivel * 30;
	}

	/**
	 * "atacar" obtiene el ataque de este objeto e invoca al método serAtacado
	 * del "atacado" recibido como parametro.
	 *
	 * @param atacado
	 *            atacado
	 * @return dano ocasionado al atacar
	 */

	public int atacar(final Peleable atacado) {
		darBonus();

		int danio;

		if (this.aleatorizador.nextDouble() <= 0.15) {
			danio = atacado.serAtacado((int) (this.getAtaque() * PORCENTAJE_GOLPE_CRITICO));
		} else {
			danio = atacado.serAtacado(this.getAtaque());
		}

		sacarBonus();

		return danio;
	}

	/**
	 * "serAtacado" devuelve 0 si no es dañado o si esquivo el golpe o el valor
	 * del dano ocasionado por el ataque.
	 *
	 * @param dano
	 *            dano
	 * @return dano ocasionado al atacar.
	 */

	public int serAtacado(final int dano) {
		darBonus();
		int danio = 0;

		if (this.aleatorizador.nextDouble() >= PORCENTAJE_GOLPE_CRITICO) {
			danio = dano - (this.getDefensa() / 2);
			if (danio > 0) {
				salud -= danio;
			} else {
				danio = 0;
			}
		} else {
			danio = 0;
		}

		sacarBonus();

		return danio;
	}

	/**
	 * to do
	 */

	public void despuesDeTurno() {
	}

	/**
	 * to do
	 *
	 * @param exp
	 *            experiencia
	 */

	public void ganarExperiencia(final int exp) {
	}

	/**
	 * Sobreescribe el getter de "ataque" de la clase padre para usar el
	 * atributo "fuerza" de este objeto.
	 *
	 * @return fuerza
	 */

	@Override
	public int getAtaque() {
		return fuerza;
	}

	/**
	 * Sobreescribe el setter de "ataque" de la clase padre para usar el
	 * atributo "fuerza" de este objeto.
	 *
	 * @param ataque
	 *            ataque
	 */

	@Override
	public void setAtaque(final int ataque) {
		this.fuerza = ataque;
	}

	/**
	 * @param salud
	 *            no se utiliza
	 */

	public void serCurado(final int salud) {
	}

	/**
	 * @param dano
	 *            no utilizado
	 * @return 0
	 */

	public int serDesenergizado(final int dano) {
		return 0;
	}

	/**
	 * @param dano
	 *            no utilizado
	 * @return 0
	 */

	public int serRobadoSalud(final int dano) {
		return 0;
	}

}
