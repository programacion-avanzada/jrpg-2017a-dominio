package dominio;

/**
 * La clase NonPlayableCharacter implementa la interface Peleable que Define
 * una lista de métodos a ser implementados.
 * Define los atributos de salud, fuerza, defensa, nombre y nivel.
 */

public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	private static final int dificultadAleatoria = -1;

	/**
	 * Constructor de la clase. Asigna atributos de fuerza, salud y defensa basados en la dificultad.
	 * @param nombre
	 * @param nivel
	 * @param dificultadNPC dificultadNonPlayableCharacter
	 */

	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;// 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;// 50%
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
	 * @return fuerza
	 */

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * @param fuerza
	 */

	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * @return nombre
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return nivel
	 */

	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel
	 */

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return verdadero o falso si tiene salud
	 */

	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * @return defensa
	 */

	public int getDefensa() {
		return defensa;
	}

	/**
	 * @param defensa
	 */

	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * @return salud
	 */

	public int getSalud() {
		return salud;
	}

	/**
	 * @param salud
	 */

	public void setSalud(final int salud) {
		this.salud = salud;
	}

	/**
	 * "atacar" obtiene el ataque de este objeto e invoca al método serAtacado
	 * del "atacado" recibido como parametro.
	 * @param atacado
	 * @return daño ocasionado al atacar
	 */

	public int atacar(final Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}

	/**
	 * "serAtacado" devuelve 0 si no es dañado o si esquivo el golpe o
	 * el valor del daño ocasionado por el ataque.
	 * @param daño
	 * @return daño ocasionado al atacar.
	 */

	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
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
	 * @param ataque
	 */

	@Override
	public void setAtaque(final int ataque) {
		this.fuerza = ataque;
	}
}
