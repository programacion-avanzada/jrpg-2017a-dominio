package dominio;

/**
	La clase "Elfo" es un tipo de Personaje (por ende, hereda
	de esta misma). Aqui se describen los metodos y atributos
	propios de esta clase.
	a
*/
public class Elfo extends Personaje {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int AUMENTO_ENERGIA_TOPE_POR_RAZA = 10;
  private static final int MULTIPLICADOR_HABILIDAD_1 = 10;
  private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
  protected final static String habilidades [] = new String[]{"Golpe Level","Ataque Bosque"};
  /** 
   * Constructor parametrizado para Casta Guerrero
 */
  public Elfo(final String nombre, final Guerrero guerrero, final int id) {
		super(nombre, guerrero, id,0, AUMENTO_ENERGIA_TOPE_POR_RAZA,"Elfo",habilidades);
	}
  /** 
   * Constructor parametrizado para Casta Hechicero
 */
  public Elfo(final String nombre, final Hechicero hechicero, final int id) {
		super(nombre, hechicero, id,0, AUMENTO_ENERGIA_TOPE_POR_RAZA,"Elfo",habilidades);
	}
  /** 
   * Constructor parametrizado para Casta Asesino
 */
  public Elfo(final String nombre, final Asesino asesino, final int id) {
		super(nombre, asesino, id,0, AUMENTO_ENERGIA_TOPE_POR_RAZA,"Elfo",habilidades);
	}
  
  /** 
   * Constructor parametrizado en donde se pasan los states de la raza
 */
	public Elfo(final String nombre, final int salud, final int energia, final int fuerza,
	    final int destreza, final int inteligencia, final Casta casta, final int experiencia,
	    final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje,"Elfo",habilidades);
	}

/**
	El metodo "habilidadRaza1" correspondiente a la habilidad
	"Golpe Level" se ocupa de aplicar el daño basico mas 10 
	por el nivel del personaje.
*/
	// Golpe Level
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			this.setEnergia(this.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * MULTIPLICADOR_HABILIDAD_1) > 0) {
        return true;
      }
		}
		return false;
	}

/**
	El metodo "habilidadRaza2" correspondiente a la habilidad
	"Ataque Bosque" se ocupa de aplicar daño en funcion a la 
	cantidad de magia del personaje.
*/
	// Ataque Bosque
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			this.setEnergia(this.getEnergia() - COSTE_DE_ENERGIA_HABILIDADES);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
        return true;
      }
		}
		return false;
	}
}
