package dominio;

import java.util.LinkedList;
import java.util.Random;

public class BatallonNPC {

	LinkedList <NonPlayableCharacter> equipo;
	
	public BatallonNPC(int nivel, Item[] it)//de npcs
	{
		Random rnd = new Random();
		int cant_npc=rnd.nextInt(3)+3;
		for(int i=0;i<cant_npc;i++)
		{
			this.equipo.add(new NonPlayableCharacter(nivel,it,-1));
		}
	}

	public void accion()
	{
		
	}
	
}
