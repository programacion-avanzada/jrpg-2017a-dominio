package dominio;

import java.util.Random;

public class Asesino extends Casta {

	private double prob_robar = 0.2;/// y tambien va a depender de la destreza

	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
	}

	public void habilidad1(Personaje caster, Peleable atacado)// ataca con un
																// golpe mas
																// poderoso de
																// lo normal,
																// hay que ver
																// el porcentaje
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico()));
		}
	}

	public void habilidad2(Personaje caster, Peleable atacado)// aumenta su
																// probabilidadEvitarDaño,
																// hasta un
																// maximo
																// posible
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;// hay que ponerle un tope(en este caso 0.5)
			else
				this.probabilidadEvitarDaño = 0.5;
		}
	}

	public void habilidad3(Personaje caster, Peleable atacado)// roba un item,
																// aunque tiene
																// una
																// probabilidad
																// de exito
	{

		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			Random rnd = new Random();

			if ((rnd.nextDouble() <= this.prob_robar + caster.getDestreza() / 1000)
					&& caster.itemsGuardados.size() <= 20) {
				caster.itemsGuardados.add(atacado.serRobado());
				System.out.println("Se pudo robar!");
			}
			else
			System.out.println("No se pudo robar!");

		}
	}
}
