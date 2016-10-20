package dominio;

import java.util.LinkedList;

public class Humano extends Personaje {

	public Humano(String casta){
		super(casta);
	}
	
	
	
	public Humano(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje, int defensa) {
		super(salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje,defensa);
		
	}



	public void incentivar(Batallon aliados){
		
	}
	
	public void golpeFatal(Peleable atacado){
		if(this.getEnergia()>10)
		{
			atacado.serAtacado(atacado.getSalud()/2);
			this.setEnergia(this.getEnergia()/2);
		}
		
		
	}
	
	
}
