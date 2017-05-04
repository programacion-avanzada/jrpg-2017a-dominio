
package dominio;

public class Asesino extends Casta {
	private static final int ENERGIAMINIMA = 10;
	private static final int BONUSDESTREZA = 5;
	private static final double AUMENTARPROBEVITAR = 0.15;
	private static final double PROBEVITARDAÑO = 0.5;


/** La clase Asesino es una casta de Personaje, hereda de la clase Casta
 * posee dos constructores.
 * El otro constructor, llama al constructor de la clase padre (Casta)
 * pasándole los argumentos recibidos
 * por el constructor hijo y luego inicializa la variable nombreCasta
 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
 * @param evasion Probabilidad de que el personaje evite un golpe crítico
 * @param daño_crit Valor por el cual será multiplicado el golpe básico
 */

public Asesino(final double prob_crit, final double evasion, final double daño_crit) {
	super(prob_crit, evasion, daño_crit);
}
	/** El constructor por defecto, llama al constructor por defecto de la clase
	 * padre (Casta), inicializando probabilidadGolpeCritico, probabilidadEvitarDaño, dañoCritico,
	 * con valores predeterminados.
	 */
	public Asesino() {
		super();
	}


	/**Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * De ser posible el ataque, se llama al método serAtacado() del argumento atacado el cual actuará de
	 * cierta manera dependiendo de que clase sea el argumento atacado
	 *
	 * @param caster Personaje atacante
	 * @param atacado puede recibir como argumento una instancia de Personaje o de NPC (NonPlayableCharacter)
	 * ya que ambas implementan la interface Peleable
	 * @return retorna si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta().getDañoCritico())) > 0) {
				return true;
			}
		}
		return false;
	}


	/** Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible y se retornará false
	 * @param caster Personaje que realiza el ataque, en este caso no es un ataque si no un aumento en
	 * las caracteristicas del caster en este caso incrementa el atributo probabilidadEvitarDaño
	 * @param atacado no cumple función alguna dentro de este método
	 * @return retorna si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > ENERGIAMINIMA) {
			caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
			if (this.getProbabilidadEvitarDaño() + AUMENTARPROBEVITAR < 0.5){
				this.aumentarEvitarDaño(AUMENTARPROBEVITAR);
			}
			else {
				this.setProbabilidadEvitarDaño(PROBEVITARDAÑO);
			}
			return true;
		}
		return false;
	}

	/** Not implemented yet.
	 * @param caster Personaje que realiza el ataque.
	 * @param atacado .
	 * @return Retorna falso.
	 */
	@Override
	public final boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}
	/** Retorna un entero que otorga el bonus de destreza perteneciente a esta casta.
	 * @return Retorna la destreza extra de la casta.
	 */
	@Override
	public final int recibirDestrezaBonus() {
		return BONUSDESTREZA;
	}
	/** Retorna un entero que otorga el bonus de fuerza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirFuerzaBonus() {
		return 0;
	}
	/** Retorna un entero que otorga el bonus de inteligencia perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirInteligenciaBonus() {
		return 0;
	}
	/**Retorna una string con el nombre de la casta.
	 * @return Retorna el nombre de la casta.
	 */
	@Override
	public final String getNombreCasta() {
		return "Asesino";
	}
	/**Retorna un vector de string con los nombres de las habilidades de la casta.
	 * @return Retorna nombres de las habilidades propias de la casta.
	 */
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Golpe Critico","Aumentar Evasion","Robar"};
	}

}
