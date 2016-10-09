package dominio;

public class Asesino extends Casta {

	public Asesino(double prob_crit,double evasion,double daño_crit)
	{
		super(prob_crit,evasion,daño_crit);
	}
	
	
	public void golpeCritico(Personaje caster, Peleable atacado)// ataca con un golpe mas poderoso de lo normal, hay que ver el porcentaje
	{
		atacado.serAtacado((int)(caster.getFuerza()*caster.getCasta().getDañoCritico()));
	}
	
	public void perspicacia()// aumenta su probabilidadEvitarDaño, hasta un maximo posible
	{
		if(this.getProbabilidadEvitarDaño()>0.5)
		this.probabilidadEvitarDaño+=0.15;// hay que ponerle un tope
	}
	
	public boolean robar(Personaje caster, Peleable atacado)//roba un item, aunque tiene una probabilidad de exito
	{
		return true;
	}
}
