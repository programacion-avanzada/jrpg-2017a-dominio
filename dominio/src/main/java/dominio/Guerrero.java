package dominio;

public class Guerrero extends Casta{

	public Guerrero(double prob_crit,double evasion,double daño_crit)
	{
		super(prob_crit,evasion,daño_crit);
	}
	
	public void golpeDoble(Personaje caster, Peleable atacado) //pega el doble de fuerte que un ataque normal
	{
		atacado.serAtacado(caster.calcularPuntosDeAtaque()*2);
		
	}
	
	public void aumentarDefensa(Personaje caster) //aumenta la defensa propia
	{
		caster.setDefensa(caster.getDefensa()+10);
	}
	
	public void ignoraDefensa(Personaje caster, Peleable atacado) //ataca e ignora la defensa del oponente
	{
		if(atacado instanceof Personaje)
		{
			int defensa_original =((Personaje) atacado).getDefensa();
			((Personaje) atacado).setDefensa(0);
			atacado.serAtacado(caster.fuerza);
			((Personaje) atacado).setDefensa(defensa_original);
		}
	}
	
}
