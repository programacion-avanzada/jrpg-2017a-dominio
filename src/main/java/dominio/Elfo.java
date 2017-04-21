package dominio;

/**
 * La clase Elfo representa una raza (tipo) de personaje.
 * Tiene 2 habilidades que son el Golpe Level y Ataque Bosque.
 */

public class Elfo extends Personaje {

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
	 * Permite create un elfo con atributos pasados por parametro.
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
