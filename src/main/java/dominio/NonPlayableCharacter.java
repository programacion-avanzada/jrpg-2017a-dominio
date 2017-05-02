
package dominio;

public class NonPlayableCharacter extends MadreDeTodo implements Peleable {

	private int salud;

	private static final int DIFICULTADALEATORIA = -1;
	private static final int DIF1F = 10;
	private static final int DIF1S = 30;
	private static final int DIF1D = 2;
	private static final int DIF1MF = 3;
	private static final int DIF1MS = 15;
	private static final int DIF1MD = 1;

	private static final int DIF2F = 20;
	private static final int DIF2S = 40;
	private static final int DIF2D = 5;
	private static final int DIF2MF = 6;
	private static final int DIF2MS = 20;
	private static final int DIF2MD = 2;

	private static final int DIF3F = 30;
	private static final int DIF3S = 50;
	private static final int DIF3D = 4;
	private static final int DIF3MF = 10;
	private static final int DIF3MS = 25;
	private static final int DIF3MD = 4;

	private static final int MULTIPLICADOREXPNPC = 30;
	private static final double MULTIPLICADORFUERZA = 1.5;
	private static final double NUMEROPARASERATACADO = 0.15;
	private static final double NUMEROPARAATACAR = 0.15;
	private static final int DIVISORDEDEFENSA = 2;

	/** La clase NonPlayableCharacter representa a los NPC del juego.
	 * Dependiendo de la dificultad que se pasa por parámetro al constructor,
	 * aumentará o disminuirá el valor de los atributos fuerza salud y defensa.
	 * @param nombre Nombre que se le otorga al NPC
	 * @param nivel Nivel (entero) que se le otorga al NPC
	 * @param dificultadNPC valor entero que consecuentemente produce una variación en los atributos.
	 */
	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		super(0, 0, nivel, nombre);

		int dificultad;
		if (dificultadNPC == DIFICULTADALEATORIA) {
			dificultad = MyRandom.nextInt(3); 
		}
		else {
			dificultad = dificultadNPC;
		}

		switch (dificultad) {
		case 0:
			this.setFuerza(DIF1F + (nivel - 1) * DIF1MF);
			this.salud = DIF1S + (nivel - 1) * DIF1MS;
			this.setDefensa(DIF1D + (nivel - 1) * DIF1MD);
			break;
		case 1:
			this.setFuerza(DIF2F + (nivel - 1) * DIF2MF);
			this.salud = DIF2S + (nivel - 1) * DIF2MS;
			this.setDefensa(DIF2D + (nivel - 1) * DIF2MD);
			break;
    	case 2:
			this.setFuerza(DIF3F + (nivel - 1) * DIF3MF);
			this.salud = DIF3S + (nivel - 1) * DIF3MS;
			this.setDefensa(DIF3D + (nivel - 1) * DIF3MD);
			break;
		default:
			break;
		}
	}

	/** Retorna un entero.
	 * Rrepresentando la cantidad de experiencia que debe sumarse al Personaje que
	 * produjo la disminución de la salud del NPC a 0
	 * La experiencia será 30 veces el valor del atributo nivel
	 */
	@Override
	public final int otorgarExp() {
		return this.getNivel() * MULTIPLICADOREXPNPC;
	}



	@Override
	public final boolean estaVivo() {
		return salud > 0;
	}



	@Override
	public final int getSalud() {
		return salud;
	}

	public final void setSalud(int salud) {
		this.salud = salud;
	}

	@Override
	public final int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= NUMEROPARAATACAR) {
			return atacado.serAtacado((int) (this.getAtaque() * MULTIPLICADORFUERZA));
		} else{
			return atacado.serAtacado(this.getAtaque());
		}
	}

	/** Método que retorna 0 o un valor positivo.
	 * Ei el número generado por MyRandom.nextDouble() es mayor a 0.15,
	 * se procede a disminuir el daño por la mitad del atributo defensa si después de la
	 * reducción de daño, este sigue siendo mayor a 0,
	 *  se procede a restar el valor del daño al atributo
	 * salud.
	 * @param daño valor a ser descontado del atributo salud.
	 * @return Retorna 0 si el ataque no fue realizado con exito
	 */
	@Override
	public final int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= NUMEROPARASERATACADO) {
			daño -= this.getDefensa() / DIVISORDEDEFENSA;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;
		}
		return 0;
	}

	@Override
	public void despuesDeTurno() { }

	public void ganarExperiencia(final int exp) {

	}

	@Override
	public final int getAtaque() {
		return this.getFuerza();
	}

	@Override
	public final void setAtaque(final int ataque) {
		this.setFuerza(ataque);
	}

	@Override
	public final int getMagia() {

		return 0;
	}
}


