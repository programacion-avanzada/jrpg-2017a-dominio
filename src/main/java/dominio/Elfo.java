
package dominio;

public class Elfo extends Personaje {

	private static final int ENERGIAMINIMA = 10;
	private static final int MULTIPLICADORNIVEL = 10;
	private static final int BONUSENERGIA = 10;

	/** La clase Elfo hereda de la clase Personaje.
	 * Completa ciertos atributos que estaban declarados en
	 * la clase Personaje, como por ejemplo habilidadesRaza[]
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * @param id Identificador del personaje
	 */
	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
	}
	/** La clase Elfo hereda de la clase Personaje.
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
	public Elfo(final String nombre, final int salud, final int energia, final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel,
			final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
	}


	/**Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() posee como argumento la suma de la fuerza del atacante y
	 * el nivel del mismo multiplicado por 10
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado()
	 * @return retorna si se ejecutó correctamente la habilidad
	 */
	@Override
	public final boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * MULTIPLICADORNIVEL) > 0) {
				return true;
			}
		}
		return false;
	}



	/** Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() posee como argumento un entero representando 1 o 0, dependiendo si el
	 * atributo magia del llamador, es mayor a 0
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado()
	 * @return retorna si se ejecutó correctamente la habilidad
	 */
	@Override
	public final boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((this.getMagia())) > 0) {
				return true;
			}
		}
		return false;
	}
	/**Retorna un vector de string con los nombres de las habilidades de la raza.
	 * @return Retorna nombres de las habilidades propias de la raza.
	 */
	@Override
	public final String[] getHabilidadesRaza() {
		return new String[] {"Golpe Level","Ataque Bosque"};
	}
	/**Retorna un entero con el bonificador de salud de la raza.
	 * @return Retorna 0 para esta raza.
	 */
	@Override
	public final int getSaludBonus() {
		return 0;
	}
	/**Retorna un entero con el bonificador de energia de la raza.
	 * @return Retorna la energia extra para esta raza.
	 */
	@Override
	public final int getEnergiaBonus() {
		return BONUSENERGIA;
	}
	/**Retorna una string con el nombre de la raza.
	 * @return Retorna el nombre de la raza.
	 */
	@Override
	public final String getNombreRaza() {
		return "Elfo";
	}
}
