package dominio;

public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
	}

	public void habilidad1(Personaje caster, Peleable aliado) // cura la salud a
																// un aliado
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje)
				((Personaje) aliado).serCurado(caster.getInteligencia()); // la
																			// inteligencia
																			// es
																			// la
																			// "fuerza"
																			// de
																			// mis
																			// hechizos,
																			// hay
																			// que
																			// modificarlo
		}
	}

	public void habilidad2(Personaje caster, Peleable atacado) // lanza una bola
																// de fuego que
																// es mas fuerte
																// que su ataque
																// "basico"
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			atacado.serAtacado(caster.getInteligencia());
		}
	}

	public void habilidad3(Personaje caster, Peleable atacado) // roba energia
																// de los
																// enemigos
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje)
				((Personaje) atacado).serDesernegizado(caster.getInteligencia());
		}
	}

}
