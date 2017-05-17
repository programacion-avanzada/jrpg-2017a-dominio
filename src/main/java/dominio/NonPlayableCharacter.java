package dominio;

/**
	La clase "NonPlayableCharacter" es la que se encarga de manejar
	todos los personajes generados por el juego y como estos se 
	relacionan con el personaje dentro del juego (Como por ejemplo,
	en una pelea o el manejo de la experiencia).
*/
public class NonPlayableCharacter extends Unidad implements Peleable {

	private static final int DIFICULTADO_ALEATORIA = -1;
	private static final int SEMILLA_RANDOM = 3;
	
	private static final int FUERZA_BASE_DIFICULTAD_0 = 10;
	private static final int MULTIPLICADOR_FUERZA_DIFICULTAD_0 = 3;
	private static final int SALUD_BASE_DIFICULTAD_0 = 30;
    private static final int MULTIPICADOR_SALUD_DIFICULTAD_0 = 15;
  
  private static final int FUERZA_BASE_DIFICULTAD_1 = 20;
  private static final int MULTIPLICADOR_FUERZA_DIFICULTAD_1 = 6;
  private static final int SALUD_BASE_DIFICULTAD_1 = 40;
  private static final int MULTIPICADOR_SALUD_DIFICULTAD_1 = 20;
  private static final int DEFENSA_BASE_DIFICULTAD_1 = 5;
  
  private static final int FUERZA_BASE_DIFICULTAD_2 = 30;
  private static final int MULTIPLICADOR_FUERZA_DIFICULTAD_2 = 10;
  private static final int SALUD_BASE_DIFICULTAD_2 = 50;
  private static final int MULTIPICADOR_SALUD_DIFICULTAD_2 = 25;
  private static final int DEFENSA_BASE_DIFICULTAD_2 = 4;
  private static final int MULTIPLICADOR_DEFENSA_DIFICULTAD_2 = 4;
  private static final int MULTIPLICADOR_EXPERIENCIA = 30;
  
  private static final double PORCENTAJE_CRITICO = 0.15;
  private static final double AUMENTO_DANO_CRITICO = 1.5;

  /** 
   * Constructor parametrizado
 */
	public NonPlayableCharacter(final String nombre, int nivel, final int dificultadNPC) {
		super(nombre,nivel);
		int dificultad;
		if (dificultadNPC == DIFICULTADO_ALEATORIA) {
      dificultad = MyRandom.nextInt(SEMILLA_RANDOM);
    } else {
      dificultad = dificultadNPC;
    }

		switch (dificultad) {
		case 0:
			this.setFuerza(FUERZA_BASE_DIFICULTAD_0 + (nivel - 1) * MULTIPLICADOR_FUERZA_DIFICULTAD_0);  // 30%
			this.setSalud(SALUD_BASE_DIFICULTAD_0 + (nivel - 1) * MULTIPICADOR_SALUD_DIFICULTAD_0);
			this.setDefensa(2 + (nivel - 1) * 1);
			break;
		case 1:
			this.setFuerza( FUERZA_BASE_DIFICULTAD_1 + (nivel - 1) * MULTIPLICADOR_FUERZA_DIFICULTAD_1);  // 50%
			this.setSalud( SALUD_BASE_DIFICULTAD_1 + (nivel - 1) * MULTIPICADOR_SALUD_DIFICULTAD_1);
			this.setDefensa( DEFENSA_BASE_DIFICULTAD_1 + (nivel - 1) * 2);
			break;
		case 2:
			this.setFuerza( FUERZA_BASE_DIFICULTAD_2 + (nivel - 1) * MULTIPLICADOR_FUERZA_DIFICULTAD_2); // 50%
			this.setSalud( SALUD_BASE_DIFICULTAD_2 + (nivel - 1) * MULTIPICADOR_SALUD_DIFICULTAD_2);
			this.setDefensa( DEFENSA_BASE_DIFICULTAD_2 + (nivel - 1) * MULTIPLICADOR_DEFENSA_DIFICULTAD_2);
			break;
    default:
      break;

		}
	}

  /** este metodo decide la experiencia repartida por cada NPC derrotado*/
	public int otorgarExp() {
		return this.getNivel() * MULTIPLICADOR_EXPERIENCIA;
	}
	
	/** Este metodo booleano verifica la salud del NPC para verificar si sigue vivo*/
	public boolean estaVivo() {
		return this.getSalud() > 0;
	}
	
/**
	El metodo "atacar" es la que se encargara de administrar el 
	ataque del NPC y de su probabilidad de golpe critico
	retornando el daño infligido. 
*/
	public int atacar(final Peleable atacado) {
		if (MyRandom.nextDouble() <= PORCENTAJE_CRITICO) {  // los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * AUMENTO_DANO_CRITICO));
		} else {
      return atacado.serAtacado(this.getAtaque());
    }
	}

/**
	El metodo "serAtacado" es la que se encargara de administrar el 
	ataque del NPC al personaje con respecto a su probabilidad
	de evasion y de la defensa del objetivo.
*/
	public int serAtacado(int dano) {
		if (MyRandom.nextDouble() >= 0.15) {
			dano -= this.getDefensa() / 2;
			if (dano > 0) {
				this.setSalud(this.getSalud() - dano);
				return dano;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	/** Metodo que realiza las acciones del NPC despues de su turno*/
	public void despuesDeTurno() { }

	/** Este medoto calcula la experiencia que gana el NPC*/
	public void ganarExperiencia(final int exp) { }

	/** Este metodo devuelve el ataque del NPC*/
	@Override
	public int getAtaque() {
		return this.getFuerza();
	}
	/** Este medoto sirve para modificar el ataque del NPC*/
	@Override
	public void setAtaque(final int ataque) {
		this.setFuerza(ataque);
	}
}
