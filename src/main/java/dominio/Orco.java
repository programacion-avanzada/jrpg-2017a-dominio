package dominio;

public class Orco extends Personaje {
	/**
	 * La clase Orco hereda de la clase Personaje, completa ciertos atributos que estaban declarados en
	 * la clase Personaje, como por ejemplo habilidadesRaza[]
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * @param id Identificador del personaje
	 */
	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		this.completarHabilidad();
		//habilidadesRaza = new String[2];

	}
	/**
	 * La clase Orco hereda de la clase Personaje, completa ciertos atributos que estaban declarados en
	 * la clase Personaje, como por ejemplo habilidadesRaza[]
	 * Recibe la mayoría de los atributos
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
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		this.completarHabilidad();
	}

	// Golpe Defensa
	/**
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, 
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() tiene como argumento el doble del valor del atributo defensa del llamador
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el 
	 * método serAtacado()
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}

	// Mordisco de Vida
	/**
	 * Retorna un booleano dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster) posea 10 o
	 * más del atributo energia ya que estos se descuentan seguido de comprobar que los posee, 
	 * de lo contrario el ataque no será posible y se retornará false
	 * El método serAtacado() tiene como argumento el valor del atributo fuerza del llamador
	 * luego el llamador se cura con el daño causado al atacado
	 * @param atacado Instancia de Personaje o de NPC, dependiendo de cual sea, será como responda el 
	 * método serAtacado()
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
	@Override
	public void completarHabilidad() {
		nombreRaza = "Orco";
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
		
	}
}
