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
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia()); 
																			
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
			atacado.serAtacado((int) (caster.calcularPuntosDeMagia()*1.5));
		}
	}

	public void habilidad3(Personaje caster, Peleable atacado) // roba energia y salud
																// de los
																// enemigos 
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje)
				{
				int energia_robada=((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada=((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia()/2);//divido por 2 sino es muy fruta
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				System.out.println("Energia robada: "+energia_robada);
				System.out.println("Salud robada: "+salud_robada);
				}
				
		}
	}

}
