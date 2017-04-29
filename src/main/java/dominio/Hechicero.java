package dominio;

public class Hechicero extends Casta {
	/**
	 * La clase Hechicero es una casta de Personaje, hereda de la clase Casta
	 * posee dos constructores, el constructor por defecto, llama al constructor por defecto de la clase 
	 * padre (Casta), luego inicializa la variable nombreCasta y crea un array de String de tamaño 3
	 * El otro constructor, llama al constructor de la clase padre (Casta), pasándole los argumentos recibidos
	 * por el constructor hijo y luego inicializa la variable nombreCasta
	 * @param prob_crit Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion Probabilidad de que el personaje evite un golpe crítico
	 * @param daño_crit Valor por el cual será multiplicado el golpe básico
	 */
	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		//this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
//		this.nombreCasta = "Hechicero";
//		habilidadesCasta = new String[3];
//		habilidadesCasta[0] = "Bola de Fuego";
//		habilidadesCasta[1] = "Curar Aliado";
//		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	// Bola de Fuego
	/**
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false.
	 * El parámetro caster a su vez llama al método calcularPuntosDeMagia() 
	 * el cual luego se multiplica por 1.5 
	 * @param caster Personaje que realiza la habilidad
	 * @param atacado puede ser una instancia de Persona o NPC dependiendo de la misma, 
	 * variará lo que retornará serAtacado()
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
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, de lo contrario
	 * el ataque no será posible y se retornará false.
	 * Para que éste método tenga posibilidad de retornar true, aliado debe ser de la instancia Personaje
	 * @param caster Personaje que realiza la habilidad
	 * @param aliado atacado puede ser una instancia de Persona o NPC dependiendo de la misma podrá o no
	 * retornar true el método.
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

	@Override
	public int recibirInteligenciaBonus() {
		return 5;
		
	}

	@Override
	public int recibirDestrezaBonus() {
		
		return 0;
	}

	@Override
	public int recibirFuerzaBonus() {
		
		return 0;
	}

	@Override
	public String getNombreCasta() {
		
		return "Hechiero";
	}

	@Override
	public String[] getHabilidadesCasta() {
		
		return new String[] {"Bola de Fuego","Curar Aliado","Robar Energia y Salud"};
	}
}
