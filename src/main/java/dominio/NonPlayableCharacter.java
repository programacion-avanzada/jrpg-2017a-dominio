package dominio;

/**
 * La clase NonPlayableCharacter implementa la interface Peleable que Define
 * una lista de métodos a ser implementados.
 * Define los atributos de salud, fuerza, defensa, nombre y nivel.
 */

public class NonPlayableCharacter extends Character implements Peleable {

	private static final double PORCENTAJE_GOLPE_CRITICO = 0.15;
	private static final int dificultadAleatoria = -1;

	/**
	 * Constructor de la clase. Asigna atributos de fuerza, salud y defensa basados en la dificultad.
	 * @param nombre nombre
	 * @param nivel nivel
	 * @param dificultadNPC dificultadNonPlayableCharacter
	 */

	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		super(nombre);

		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria) {
			dificultad = this.aleatorizador.nextInt(3);
		} else {
			dificultad = dificultadNPC;
		}

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}

	/**
	 * Otorga experiencia al personaje multiplicando su nivel.
	 * @return 30 veces el nivel actual.
	 */

	public int otorgarExp() {
		return this.nivel * 30;
	}

	/**
	 * "atacar" obtiene el ataque de este objeto e invoca al método serAtacado
	 * del "atacado" recibido como parametro.
	 * @param atacado atacado
	 * @return dano ocasionado al atacar
	 */

	public int atacar(final Peleable atacado) {
		if (this.aleatorizador.nextDouble() <= 0.15) {
			return atacado.serAtacado((int) (this.getAtaque() * PORCENTAJE_GOLPE_CRITICO));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	/**
	 * "serAtacado" devuelve 0 si no es dañado o si esquivo el golpe o
	 * el valor del dano ocasionado por el ataque.
	 * @param dano dano
	 * @return dano ocasionado al atacar.
	 */

	public int serAtacado(int dano) {
		if (this.aleatorizador.nextDouble() >= PORCENTAJE_GOLPE_CRITICO) {
			dano -= this.getDefensa() / 2;
			if (dano > 0) {
				salud -= dano;
				return dano;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * to do
	 */

	public void despuesDeTurno() { }

	/**
	 * to do
	 * @param exp experiencia
	 */

	public void ganarExperiencia(final int exp) { }

	/**
	 * Sobreescribe el getter de "ataque" de la clase padre
	 * para usar el atributo "fuerza" de este objeto.
	 * @return fuerza
	 */

	@Override
	public int getAtaque() {
		return fuerza;
	}

	/**
	 * Sobreescribe el setter de "ataque" de la clase padre
	 * para usar el atributo "fuerza" de este objeto.
	 * @param ataque ataque
	 */

	@Override
	public void setAtaque(final int ataque) {
		this.fuerza = ataque;
	}

	/**
	 * @param salud no se utiliza
	 */

	public void serCurado(final int salud) {}

	/**
	 * @param dano no utilizado
	 * @return 0
	 */

	public int serDesenergizado(final int dano) {
		return 0;
	}

	/**
	 * @param dano no utilizado
	 * @return 0
	 */

	public int serRobadoSalud(final int dano) {
		return 0;
	}

}
