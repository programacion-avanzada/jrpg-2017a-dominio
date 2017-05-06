package dominio;

/**
	La clase "Hechicero" hereda de la clase Casta, con esta clase se podran crear y administrar personajes "hechiceros" con sus atributos y metodos. 
*/
public class Hechicero extends Casta {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int CANTIDAD_DE_HABILIDADES = 3;
  private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
  private static final double MULTIPLICADOR_HABILIDAD_1 = 1.5;

  
  /** 
   * Constructor parametrizado
 */
  public Hechicero(final double probCrit, final double evasion, final double dano_crit) {
		super(probCrit, evasion, dano_crit);
		this.setNombreCasta("Hechicero");
		}

  /**
   *  Constructor por defecto
  */
	public Hechicero() {
		super();
		this.setNombreCasta("Hechicero");
		setHabilidadesCasta(new String[CANTIDAD_DE_HABILIDADES]);
		getHabilidadesCasta()[0] = "Bola de Fuego";
		getHabilidadesCasta()[1] = "Curar Aliado";
		getHabilidadesCasta()[2] = "Robar Energia y Salud";
	}

	// Bola de Fuego
/** "habilidad 1 es un metodo de ataque, se debe tener una energia mayor a 10 para poder ejecutarlo
 *  y realiza un ataque igual a 3/2 de los puntos de magia*/
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * MULTIPLICADOR_HABILIDAD_1)) > 0) {
        return true;
      }
		}
		return false;
	}

	// Curar Aliado
	/**
	Con este metodo "habilidad2" el personaje "hechicero" tiene la capacidad de curar a un aliado, para poder hacerlo su energia
	*debe ser mayor a 10.
*/	
	public boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}
    /** El siguiente metodo se encargar de robar energia y salud al personaje atacado */
	// Robar Energia y Salud
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
	  
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado instanceof Personaje) {
				int energiaRobada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}
}
