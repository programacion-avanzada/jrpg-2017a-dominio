package dominio;

public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Guerrero";
	}

	public Guerrero()// creo que se llama por defecto no? preguntarle a lucas
	{
		super();
		this.nombreCasta="Guerrero";
	}

	public boolean habilidad1(Personaje caster, Peleable atacado) // pega el
																	// doble de
																	// fuerte
																	// que un
																	// ataque
																	// normal
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if(atacado.serAtacado(caster.ataque * 2)!=0)
				return true;
		}
		return false;
	}

	public boolean habilidad2(Personaje caster, Peleable atacado) // aumenta la
																	// defensa
																	// propia
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	public boolean habilidad3(Personaje caster, Peleable atacado) // ataca e
																	// ignora la
																	// defensa
																	// del
																	// oponente
	{

		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) != 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
