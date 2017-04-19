package dominio;

/**
 * La clase Hechicero es una casta de Personaje, hereda de la clase Casta
 */

public class Hechicero extends Casta {
	/**
	 * Constructor de la Clase, llama al constructor de la clase padre (Casta)
	 * y luego inicializa la variable nombreCasta.
	 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion Probabilidad de que el personaje evite un golpe crítico
	 * @param daño_crit Valor por el cual será multiplicado el golpe básico
	 */
	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}
	
	/** 	 
	 * Constructor por defecto de la Clase, llama al constructor por defecto de la clase padre (Casta), 
	 * asigna nombreCasta y habilidadesCasta
	 */
	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	// Bola de Fuego
	/**
	 * **Bola de Fuego**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee.
	 * El ataque será existoso únicamente si el daño calculado en el método Personaje.calcularPuntosDeMagia() 
	 * multiplicado por 1.5 es mayor a 0.
	 * 
	 * @param caster Personaje atacante
	 * @param atacado Personaje atacado
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	// Curar Aliado
	/**
	 * **Curar Aliado**
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 
	 * energía mayor a 10 ya que estos se descuentan seguido de comprobar que los posee.
	 * La habilidad se lanzará exitosamente únicamente si el aliado es un Personaje
	 * 
	 * @param caster Personaje que lanza la habilidad
	 * @param atacado Personaje que recibe la Curación
	 */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	// Robar Energia y Salud
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
