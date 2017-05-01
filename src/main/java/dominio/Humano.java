
package dominio;

public class Humano extends Personaje {
	private static final int ENERGIAMINIMA = 10;
	private static final int DIVISORSALUD = 2;
	private static final int DIVISORENERGIA = 2;
	private static final int BONUSENERGIA = 5;
	private static final int BONUSSALUD = 5;

	/**La clase Humano hereda de la clase Personaje.
	 * Completa ciertos atributos que estaban declarados en la clase Personaje,
	 * como por ejemplo habilidadesRaza[]
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * @param id Identificador del personaje
	 */
	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);

		//POR QUE ACA NO COMPLETA EL ARRAY??
	}
	/** La clase Humano hereda de la clase Personaje.
	 * Completa ciertos atributos que estaban declarados en
	 * la clase Personaje, como por ejemplo habilidadesRaza[]
	 * Recibe la mayoría de los atributos
	 * @param nombre Nombre del personaje
	 * @param salud Salud del personaje
	 * @param energia Energia del personaje
	 * @param fuerza Fuerza del Personaje
	 * @param destreza Destreza del personaje
	 * @param inteligencia Inteligencia del personaje
	 * @param casta Casta(Raza) del personaje
	 * @param experiencia Experiencia del personaje
	 * @param nivel Nivel del personaje
	 * @param idPersonaje Id del personaje
	 */
	public Humano(final String nombre, final int salud, final int energia, final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
	}


	/** Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() tiene como argumento la suma del valor del atributo ataque
	 * y magia del llamador.
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado()
	 */
	@Override
	public final boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}


	/** Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() recibe como parámetro la mitad del valor de la salud del atacado,
	 * si el valor retornado es mayor a 0, el valor del atributo energia del llamador será
	 * reducido a la mitad.
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado()
	 */
	@Override
	public final boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			if (atacado.serAtacado(atacado.getSalud() / DIVISORSALUD) > 0) {
				this.setEnergia(this.getEnergia() / DIVISORENERGIA);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
		return false;
	}

	@Override
	public final String[] getHabilidadesRaza() {
		return new String[] {"Incentivar","Golpe Fatal"};
	}
	@Override
	public final int getSaludBonus() {
		return BONUSSALUD;
	}
	@Override
	public final int getEnergiaBonus() {
		return BONUSENERGIA;
	}
	@Override
	public final String getNombreRaza() {
		return "Humano";
	}

}
