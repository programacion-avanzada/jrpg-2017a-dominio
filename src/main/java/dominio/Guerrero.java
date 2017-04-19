package dominio;

/**
 * La clase Guerrero es una casta de Personaje, hereda de la clase Casta
 */

public class Guerrero extends Casta {
	/**
	 * Constructor de la Clase, llama al constructor de la clase padre (Casta)
	 * y luego inicializa la variable nombreCasta.
	 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion Probabilidad de que el personaje evite un golpe crítico
	 * @param daño_crit Valor por el cual será multiplicado el golpe básico
	 */
	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}
	
	/** 	 
	 * Constructor por defecto de la Clase, llama al constructor por defecto de la clase padre (Casta), 
	 * asigna nombreCasta y habilidadesCasta
	 */
	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	// Ataque Doble
	/**
	 * **Ataque Doble**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false
	 * En caso de resultar exitoso, el atacante(caster) efectuará el doble de daño
	 * 
	 * @param caster Personaje atacante
	 * @param atacado Personaje o de NPC (NonPlayableCharacter) atacado
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	// Aumentar Defensa
	/**
	 * **Aumentar Defensa**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * no será posible lanzar la habilidad y se retornará false
	 * 
	 * @param caster Personaje que lanza la habilidad, en este caso un aumento en 
	 * las caracteristicas del caster en este caso incrementa el atributo defensa
	 * @param atacado No aplica para esta habilidad
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	// Ignorar Defensa
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
