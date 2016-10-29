package dominio;

import java.util.LinkedList;
import java.util.Random;

public class BatallonNPC {

	LinkedList <NonPlayableCharacter> equipo;
	
	public BatallonNPC(String nombre_npc,int nivel, Item[] it,int cant)//de npcs
	{
		equipo= new LinkedList <NonPlayableCharacter>();
		int cant_npc;
		if(cant==-1)
		{
		Random rnd = new Random();
		 cant_npc=rnd.nextInt(3)+3;
		}
		else
			cant_npc=cant;
		for(int i=0;i<cant_npc;i++)
		{
			this.equipo.add(new NonPlayableCharacter(nombre_npc+(i+1),nivel,it,-1));
		}
	}

	

	public LinkedList<NonPlayableCharacter> getEquipo() {
		return equipo;
	}

	public void setEquipo(LinkedList<NonPlayableCharacter> equipo) {
		this.equipo = equipo;
	}
	
	
}
