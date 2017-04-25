package dominio;

/**
	La clase "Elfo" es un tipo de Personaje (por ende, hereda
	de esta misma). Aqui se describen los metodos y atributos
	propios de esta clase.
	a
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
	El metodo "habilidadRaza1" correspondiente a la habilidad
	"Golpe Level" se ocupa de aplicar el daño basico mas 10 
	por el nivel del personaje.
*/
	// Golpe Level
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
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
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
        return true;
      }
		}
		return false;
	}
}
