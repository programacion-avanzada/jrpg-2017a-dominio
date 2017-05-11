package dominio;

/**
	La clase "Orco" es un tipo de Personaje (por ende, hereda
	de esta misma). Aqui se describen los metodos y atributos
	propios de esta clase.
*/
public class Orco extends Personaje {
	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int AUMENTO_SALUD_TOPE_POR_RAZA = 10;
  private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
  protected final static String habilidades [] = new String[]{"Golpe Defensa","Mordisco de Vida"};
  /** 
   * Constructor parametrizado para la casta Guerrero
 */
  public Orco(final String nombre, final Guerrero guerrero, final int id) {
		super(nombre, guerrero, id, AUMENTO_SALUD_TOPE_POR_RAZA,0,"Orco",habilidades);
	}
  /** 
   * Constructor parametrizado para la casta Hechicero
 */
  public Orco(final String nombre, final Hechicero hechicero, final int id) {
		super(nombre, hechicero, id, AUMENTO_SALUD_TOPE_POR_RAZA,0,"Orco",habilidades);
	}
  /** 
   * Constructor parametrizado para la casta Asesino
 */
  public Orco(final String nombre, final Asesino asesino, final int id) {
		super(nombre, asesino, id,
				AUMENTO_SALUD_TOPE_POR_RAZA,0,"Orco",habilidades);
	}

  /** 
   * Constructor parametrizado en donde se pasan los states de la raza
 */
	public Orco(final String nombre, final int salud, final int energia, final int fuerza,
	    final int destreza, final int inteligencia, final Casta casta, final int experiencia,
	    final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,
				"Orco",habilidades);
	}

/**
	El metodo "habilidadRaza1" correspondiente a la habilidad
	"Golpe Defensa" se ocupa de aplicar el doble de la defensa
	del atacante como daño.
*/
	// Golpe Defensa
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			this.setEnergia(this.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
        return true;
      }
		}
		return false;
	}

/**
	El metodo "habilidadRaza2" correspondiente a la habilidad
	"Mordisco de Vida" se ocupa de aplicar daño en funcion a la 
	cantidad de fuerza del personaje. Si este daño se aplica
	el atacante se cura la misma cantidad de daño causado.
*/
	// Mordisco de Vida
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			this.setEnergia(this.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			int danoCausado = atacado.serAtacado(this.getFuerza());
			if (danoCausado > 0) {
				this.serCurado(danoCausado);
				return true;
			}
		}
		return false;
	}
}


