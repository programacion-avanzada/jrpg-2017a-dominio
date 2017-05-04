package dominio;

/**
	La clase "Guerrero" es un tipo de casta (por ende, hereda
	de esta misma). Aqui se describen los metodos propios de
	esta clase.
*/
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

/**
	El metodo "habilidad1" representa la habilidad "Ataque
	Doble" que equivale a duplicar el ataque causado por el
	atacante, siempre y cuando el atacante disponga de la
	suficiente energia. 
*/
	// Ataque Doble
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0) {
        return true;
      }
		}
		return false;
	}
	
	
	/** El metodo "habilidad2" es un metodo que provoca un aumento en la defensa*/
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

/**
	El metodo "habilidad3" representa la habilidad "Ignorar
	Defensa" que equivale a que la defensa de la victima 
	se reduzca a 0 para ser atacado. Luego de recibir el
	ataque, se le devuelve la defensa original. 
*/
	// Ignorar Defensa
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			} 

		}
		return false;
	}
}
