package dominio;

/**
 * La clase Asesino es una casta de Personaje, hereda de la clase Casta
 */

public class Asesino extends Casta {
	/**
	 * 
	 * Constructor de la Clase, llama al constructor de la clase padre (Casta)
	 * y luego inicializa la variable nombreCasta
	 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion Probabilidad de que el personaje evite un golpe crítico
	 * @param daño_crit Valor por el cual será multiplicado el golpe básico
	 */

	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Asesino";
	}
	
	/** 	 
	 * Constructor por defecto de la Clase, llama al constructor por defecto de la clase padre (Casta), 
	 * asigna nombreCasta y habilidadesCasta
	 */
	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

	// Golpe Crítico
	/**
	 * **Golpe Crítico**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false
	 * De ser posible el ataque, se llama al método serAtacado() del argumento atacado el cual actuará de
	 * cierta manera dependiendo de que clase sea el argumento atacado
	 * 
	 * @param caster Personaje atacante
	 * @param atacado Personaje o de NPC (NonPlayableCharacter)  atacado
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	/**
	 * **Aumentar Evasion**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * no será posible lanzar la habilidad y se retornará false
	 * 
	 * @param caster Personaje que lanza la habilidad, en este caso un aumento en 
	 * las caracteristicas del caster en este caso incrementa el atributo probabilidadEvitarDaño
	 * @param atacado No aplica para esta habilidad
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
