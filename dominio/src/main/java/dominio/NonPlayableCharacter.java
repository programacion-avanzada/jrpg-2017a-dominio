package dominio;
import java.util.Random;

public class NonPlayableCharacter implements Peleable{

	private int salud;
	private  int fuerza;
	private int defensa;
	private String nombre;
	private Item[] items_dropeables;
	private int nivel;
	private int x;
	private int y;
	
	public NonPlayableCharacter(String nombre,int nivel,Item[] items_dropeables,int dif){
		this.nombre=nombre;
		this.nivel=nivel;
		this.items_dropeables=items_dropeables;
		Random rnd = new Random();
		int dificultad ;
		if(dif==-1)
			dificultad = rnd.nextInt(3);
		else
			dificultad=dif;
		
		switch(dificultad)
		{
		case 0: this.fuerza=10+(nivel-1)*3;//30%
				this.salud=30+(nivel-1)*15;
				this.defensa=2+(nivel-1)*1;
				break;
		case 1:	this.fuerza=20+(nivel-1)*6;//50%
				this.salud=40+(nivel-1)*20;
				this.defensa=5+(nivel-1)*2;
				break;
		case 2:	this.fuerza=30+(nivel-1)*10;//50%
				this.salud=50+(nivel-1)*25;
				this.defensa=4+(nivel-1)*4;
				break;		
				
		}
		System.out.println("Fuerza: "+this.fuerza+" Salud: "+this.salud+" Defensa: "+this.defensa);
	}
	
	/*public NonPlayableCharacter(int nivel,Item[] items_dropeables)
	{
		this.nivel=nivel;
		this.items_dropeables=items_dropeables;
		Random rnd = new Random();
		int dificultad = rnd.nextInt(3);//hago que los atrib sean al azar,y dependientes del lvl
		if(dificultad==0)
			this.salud=this.nivel*100;
		if(dificultad==1)
			this.salud=this.nivel*150;
		if(dificultad==2)
			this.salud=this.nivel*200;
		
		dificultad = rnd.nextInt(3);
		if(dificultad==0)
			this.fuerza=this.nivel*100;
		if(dificultad==1)
			this.fuerza=this.nivel*150;
		if(dificultad==2)
			this.fuerza=this.nivel*200;	
		
		dificultad = rnd.nextInt(3);
		if(dificultad==0)
			this.defensa=this.nivel*100;
		if(dificultad==1)
			this.defensa=this.nivel*150;
		if(dificultad==2)
			this.defensa=this.nivel*200;	
		System.out.println("Fuerza: "+this.fuerza+" Defensa: "+this.defensa+" Salud: "+this.salud);
	}*/
	
	
	
	public int otorgarExp()
	{
		return this.nivel*30; // dsp se cambia
	}
	
	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public void atacar(Peleable atacado)
	{
		Random rnd = new Random();
		if(rnd.nextDouble()<=0.15)//los NPC tienen 15% de golpes criticos
			{
			System.out.println("GOLPE CRITICO NPC!");
			atacado.serAtacado((int) (this.getAtaque()*1.5));//pego daño critico
			}
		else
	atacado.serAtacado(this.getAtaque());
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
		if(items_dropeables!=null)
			{while(aux>items_dropeables.length-1)
				aux=(int) (rnd.nextDouble()*10);
			
		int	nivel_item=(int) (rnd.nextDouble()*100);
			while((this.nivel-5)>nivel_item || (this.nivel+5)<nivel_item)///aca hago que dropee un item dependiendo del nivel del NPC
				nivel_item=(int) (rnd.nextDouble()*100);
		return modificarItem(items_dropeables[aux],nivel_item);
			}
		return null;
	}
	
	public Item modificarItem(Item a, int nivel_item)///La modificacion depende directamente del nivel(nivel 5 = bono_daño+5,etc)
	{
		Item i = a.clone();
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
		Random rnd = new Random();
		return this.items_dropeables[rnd.nextInt(this.items_dropeables.length)].clone();
	}
	
	public void ganarExperiencia(int exp)
	{
		
	}

	@Override
	public int getAtaque() {
		return fuerza;
	
	}

	@Override
	public void setAtaque(int ataque) {
		this.fuerza=ataque;
		
	}
	
	
}
