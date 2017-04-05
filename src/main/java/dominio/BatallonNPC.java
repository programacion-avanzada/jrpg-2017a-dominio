package dominio;

import java.util.LinkedList;
import java.util.Random;

public class BatallonNPC {

	LinkedList <NonPlayableCharacter> equipo;
	private static final int cantidadAleatoria = -1;
	
	public BatallonNPC(String nombreNPC,int nivel, Item[] itemsParaDropear,int cantidad){
		equipo= new LinkedList <NonPlayableCharacter>();
		int cantidadNPC;
		if(cantidad==cantidadAleatoria){
		Random rnd = new Random();
		cantidadNPC=rnd.nextInt(3)+3;
		}
		else
			cantidadNPC=cantidad;
		for(int i=0;i<cantidadNPC;i++){
			this.equipo.add(new NonPlayableCharacter(nombreNPC+(i+1),nivel,itemsParaDropear,-1));
		}
	}
	
	public LinkedList<NonPlayableCharacter> getEquipo() {
		return equipo;
	}

	public void setEquipo(LinkedList<NonPlayableCharacter> equipo) {
		this.equipo = equipo;
	}
}
