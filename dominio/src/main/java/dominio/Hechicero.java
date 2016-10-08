package dominio;

public class Hechicero extends Casta{
	
	public Hechicero(double crit,double evasion)
	{
		this.probabilidadGolpeCritico=crit;
		this.probabilidadEvitarDaño=evasion;
	}
	
	public int curar(Personaje caster, Personaje aliado) //cura la salud a un aliado
	{
		return 0;
	}
	
	public int bolaDeFuego(Personaje caster, Peleable atacado) //lanza una bola de fuego que es mas fuerte que su ataque "basico"
	{
		return 0;
	}
	
	public int quitarEnergia(Personaje caster, Personaje atacado) //roba energia de los enemigos
	{
		return 0;
	}

}
