package dominio;
import java.util.Random;

public class NonPlayableCharacter implements Peleable{

	private int salud;
	private  int fuerza;
	private int defensa;
	private Item[] items_dropeables;
	private int nivel;
	
	public boolean estaVivo() {
		return salud > 0;
	}
	
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void atacar(Peleable atacado)
	{
		Random rnd = new Random();
		if(rnd.nextDouble()<=0.15)//los NPC tienen 15% de golpes criticos
			{
			System.out.println("GOLPE CRITICO NPC!");
			atacado.serAtacado((int) (this.getFuerza()*1.5));//pego daño critico
			}
		else
	atacado.serAtacado(this.getFuerza());
	}
	
	public int serAtacado(int daño){
		 Random rnd = new Random();
			if(rnd.nextDouble()>=0.15)
			{
			daño -= this.getDefensa()/2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
			}
			System.out.println("GOLPE EVADIDO NPC!");
			return 0;//esquivo el golpe
	}
	
	public void despuesDeTurno(){
		
	}
	
	public Item dropearItemAleatorio()
	{
		Random rnd =new Random();
		int aux=(int) (rnd.nextDouble()*10);
			while(aux>items_dropeables.length-1)
				aux=(int) (rnd.nextDouble()*10);
			
		int	nivel_item=(int) (rnd.nextDouble()*100);
			while((this.nivel-5)>nivel_item || (this.nivel+5)<nivel_item)///aca hago que dropee un item dependiendo del nivel del NPC
				nivel_item=(int) (rnd.nextDouble()*100);
		return modificarItem(items_dropeables[aux],nivel_item);
	}
	
	public Item modificarItem(Item i, int nivel_item)///La modificacion depende directamente del nivel(nivel 5 = bono_daño+5,etc)
	{
		i.setNivel(nivel_item);
		if(i.getBono_daño()!=0)
			i.setBono_daño(i.getBono_daño()+nivel_item);
		if(i.getBono_defensa()!=0)
			i.setBono_defensa(i.getBono_defensa()+nivel_item);
		if(i.getBono_magia()!=0)
			i.setBono_magia(i.getBono_magia()+nivel_item);
		if(i.getBono_salud()!=0)
			i.setBono_salud(i.getBono_salud()+nivel_item);
		if(i.getBono_energia()!=0)
			i.setBono_daño(i.getBono_energia()+nivel_item);
		return i;
	}
	
	public Item serRobado()
	{
		return this.items_dropeables[0];
	}
}
