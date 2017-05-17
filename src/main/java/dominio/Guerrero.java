package dominio;

/**
	La clase "Guerrero" es un tipo de casta (por ende, hereda
	de esta misma). Aqui se describen los metodos propios de
	esta clase.
*/
public class Guerrero extends Casta {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int CANTIDAD_DE_HABILIDADES = 3;
  private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;

  /** 
   * Constructor parametrizado
 */

  public Guerrero(final double probCrit, final double evasion, final double danoCrit) {
		super(probCrit, evasion, danoCrit);
		this.setNombreCasta("Guerrero");
	}

  /**
   *  Constructor por defecto
   */
	public Guerrero() {
		super();
		this.setNombreCasta("Guerrero");
		setHabilidadesCasta(new String[CANTIDAD_DE_HABILIDADES]);
		getHabilidadesCasta()[0] = "Ataque Doble";
		getHabilidadesCasta()[1] = "Aumentar Defensa";
		getHabilidadesCasta()[2] = "Ignorar Defensa";
	}

/**
	El metodo "habilidad1" representa la habilidad "Ataque
	Doble" que equivale a duplicar el ataque causado por el
	atacante, siempre y cuando el atacante disponga de la
	suficiente energia. 
*/
	// Ataque Doble
	public boolean habilidad1(final Personaje caster, final Peleable atacado) { 
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado.serAtacado(caster.ataque * 2) > 0) {
        return true;
      }
		}
		return false;
	}
	
	/** El metodo "habilidad2" es un metodo que provoca un aumento en la defensa*/
	public boolean habilidad2(final Personaje caster, final Peleable atacado) { 
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

/**
	El metodo "habilidad3" representa la habilidad "Ignorar
	Defensa" que equivale a que la defensa de la victima 
	se reduzca a 0 para ser atacado. Luego de recibir el
	ataque, se le devuelve la defensa original. 
*/
	// Ignorar Defensa
	public boolean habilidad3(final Personaje caster, final Peleable atacado) { 
		if (caster.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			caster.setEnergia(caster.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado instanceof Personaje) {
				int defensaOriginal = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensaOriginal);
					return true;
				}
			} 

		}
		return false;
	}
}
