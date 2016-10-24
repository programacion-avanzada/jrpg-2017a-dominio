package dominio;

import java.util.LinkedList;

public class Batalla {

	private Batallon batallonUno;
	private Batallon batallonDos;
	private	int experiencia1=0;
	private int experiencia2=0;
	private LinkedList <Item> items1;
	private LinkedList <Item> items2;
	
	public Batalla(Batallon b1, Batallon b2){
		batallonUno = b1;
		batallonDos = b2;
	}
	
	public void batallar(){
		batallonUno.establecerEstrategia();
		batallonDos.establecerEstrategia();
		while(batallonUno.equipo.size()>0 && batallonDos.equipo.size()>0)
		{
			batallonUno.accion();
			batallonDos.accion();
		}
		
		//if(batallonUno.equipo.size()>0)
			//batallonUno.despuesDeBatallar(this.experiencia1, items1);
		//else
			//batallonUno.despuesDeBatallar(this.experiencia2, items2);
	}
	
	
}
