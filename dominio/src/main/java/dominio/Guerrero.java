package dominio;

public class Guerrero extends Casta{

	public Guerrero(double crit,double evasion)
	{
		this.probabilidadGolpeCritico=crit;
		this.probabilidadEvitarDaño=evasion;
	}
	
	public int golpeDoble(Personaje caster, Peleable atacado) //pega el doble de fuerte que un ataque normal
	{
		return 0;
	}
	
	public int aumentarDefensa(Personaje caster) //aumenta la defensa propia
	{
		return 0;
	}
	
	public int ignoraDefensa(Personaje caster, Peleable atacado) //ataca e ignora la defensa del oponente
	{
		return 0;
	}
	
}
