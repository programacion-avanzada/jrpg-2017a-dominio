package dominio;

/**
 * La clase Elfo representa una raza (tipo) de personaje.
 * Tiene 2 habilidades que son el Golpe Level y Ataque Bosque.
 */

public class Elfo extends Personaje {

	/**
	 * Constructor de un elfo con valores por defecto.
	 * El nombre, casta y id de personaje son requeridos en ambos constructores.
	 * Asigna el nombre y las habilidades de la raza.
	 */

	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * Constructor de un elfo con valores por parámetro.
	 * Asigna los atributos del metodo de la clase padre pasando los mismos
	 * atributos recibidos. Asigna el nombre y las habilidades de la raza.
	 */

	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * habilidadRaza1 sobrescribe el metodo de la clase padre, recibe un
	 * objeto atacado y dependiendo de este y de sí mismo devuelve verdadero
	 * o falso según corresponda.
	 */

	// Golpe Level
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0)
				return true;
		}
		return false;
	}

	/**
	 * habilidadRaza2 sobrescribe el metodo de la clase padre, recibe un
	 * objeto atacado y dependiendo de este y de sí mismo devuelve verdadero
	 * o falso según corresponda.
	 */

	// Ataque Bosque
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0)
				return true;
		}
		return false;
	}
}
