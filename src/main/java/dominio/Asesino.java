package dominio;

public class Asesino extends Casta {

/** La clase Asesino es una casta de Personaje, hereda de la clase Casta
 * posee dos constructores, el constructor por defecto, llama al constructor por defecto
 * de la clase
 * padre (Casta), luego inicializa la variable nombreCasta y crea un array de String de tamaño 3
 * El otro constructor, llama al constructor de la clase padre (Casta)
 * pasándole los argumentos recibidos
 * por el constructor hijo y luego inicializa la variable nombreCasta
 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
 * @param evasion Probabilidad de que el personaje evite un golpe crítico
 * @param daño_crit Valor por el cual será multiplicado el golpe básico
 */

public Asesino(double prob_crit, double evasion, double daño_crit) {
	super(prob_crit, evasion, daño_crit);

}

	public Asesino() {
		super();

	}

	// Golpe Crítico
	/**
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false
	 * De ser posible el ataque, se llama al método serAtacado() del argumento atacado el cual actuará de
	 * cierta manera dependiendo de que clase sea el argumento atacado
	 *
	 * @param caster Personaje atacante
	 * @param atacado puede recibir como argumento una instancia de Personaje o de NPC (NonPlayableCharacter)
	 * ya que ambas implementan la interface Peleable
	 */
	@Override
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	/**
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false
	 * @param caster Personaje que realiza el ataque, en este caso no es un ataque si no un aumento en
	 * las caracteristicas del caster en este caso incrementa el atributo probabilidadEvitarDaño
	 * @param atacado no cumple función alguna dentro de este método
	 */
	@Override
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.aumentarEvitarDaño(0.15);
			else
				this.setProbabilidadEvitarDaño(0.5);;
			return true;
		}
		return false;
	}

	// Robar
	@Override
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}

	@Override
	public int recibirDestrezaBonus() {
		return 5;
	}

	@Override
	public int recibirFuerzaBonus() {

		return 0;
	}

	@Override
	public int recibirInteligenciaBonus() {
				return 0;
	}

	@Override
	public String getNombreCasta() {
		return "Asesino";
	}

	@Override
	public String[] getHabilidadesCasta() {
		return new String[] {"Golpe Critico","Aumentar Evasion","Robar"};
	}

}
