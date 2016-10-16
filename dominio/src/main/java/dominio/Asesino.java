package dominio;

public class Asesino extends Casta {

	public Asesino(double prob_crit,double evasion,double daño_crit)
	{
		super(prob_crit,evasion,daño_crit);
	}
	
	
	public void habilidad1 (Personaje caster, Peleable atacado)// ataca con un golpe mas poderoso de lo normal, hay que ver el porcentaje
	{if(caster.getEnergia()>10)
	{
	caster.setEnergia(caster.getEnergia()-10);
		atacado.serAtacado((int)(caster.getFuerza()*caster.getCasta().getDañoCritico()));
	}
	}
	
	public void habilidad2(Personaje caster, Peleable atacado)// aumenta su probabilidadEvitarDaño, hasta un maximo posible
	{
		if(caster.getEnergia()>10)
		{
		caster.setEnergia(caster.getEnergia()-10);
		if(this.getProbabilidadEvitarDaño()>0.5)
		this.probabilidadEvitarDaño+=0.15;// hay que ponerle un tope
		}
	}
	
	public void habilidad3(Personaje caster, Peleable atacado)//roba un item, aunque tiene una probabilidad de exito
	{
		if(caster.getEnergia()>10)
		{
		caster.setEnergia(caster.getEnergia()-10);
		}
	}
}
