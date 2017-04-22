package dominio;

/**
	La clase "Humano" es un tipo de Personaje (por ende, 
	hereda de esta misma). Aqui se describen los metodos y 
	atributos propios de esta clase.
*/
public class Humano extends Personaje {

	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}
	
/**
	El metodo "habilidadRaza1" correspondiente a la habilidad
	"Incentivar" se ocupa de aumentar el ataque del objetivo
	en la cantidad de magia del personaje.
*/
	// Incentivar
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

/**
	El metodo "habilidadRaza2" correspondiente a la habilidad
	"Golpe Fatal" se ocupa de aplicar la mitad de la vida 
	actual de la victima como daño a la misma.
*/
	// Golpe Fatal
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
