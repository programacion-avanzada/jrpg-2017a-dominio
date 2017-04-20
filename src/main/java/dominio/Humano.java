package dominio;

/**
 * La clase Humano hereda de la clase Personaje, completa ciertos atributos que estaban declarados en
 * la clase Personaje, como por ejemplo habilidadesRaza[]
 *
 */

public class Humano extends Personaje {
	/**
	 * Constructor de la Clase, heredando del constructor de Personaje y asignando ciertos atributos
	 * característicos de la raza
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * @param id Identificador del personaje
	 */
	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}
	/**
	 * Constructor de la Clase, heredando del constructor de Personaje,
	 * recibiendo la mayoría de los atributos
	 * @param nombre Nombre del personaje
	 * @param salud Salud del personaje
	 * @param energia Energia del personaje
	 * @param fuerza Fuerza del Personaje
	 * @param destreza Destreza del personaje
	 * @param inteligencia Inteligencia del personaje
	 * @param casta Casta(Raza) del personaje 
	 * @param experiencia Experiencia del personaje
	 * @param nivel Nivel del personaje 
	 * @param idPersonaje Id del personaje
	 */
	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	// Incentivar
	/**
	 * *Incentivar*
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, 
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() tiene como argumento la suma del valor del atributo ataque 
	 * y magia del llamador.
	 * @param atacado Personaje o de NPC
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	// Golpe Fatal
	/**
	 * *Golpe Fatal
	 * Retorna un booleano dependiendo del éxito del ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, 
	 * de lo contrario el ataque no será posible y se retornará false
	 * El ataque será exitoso únicamente si serAtacado() devuelve un valor mayor a 0, recibiendo
	 * como parámetro la mitad del valor de la salud del atacado. Como consecuencia, el valor del 
	 * atributo energia del llamador será reducido a la mitad.
	 * 
	 * @param atacado Personaje o de NPC
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
		
}
