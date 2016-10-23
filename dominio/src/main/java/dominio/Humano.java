package dominio;

import java.util.LinkedList;

public class Humano extends Personaje {

	public Humano(String casta){
		super(casta);
	}
	
	
	
	public Humano(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje) {
		super(salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje);
		
	}



	public void incentivar(Personaje aliado){
		if(this.getEnergia()>10)
		{
			this.setEnergia(this.getEnergia()-10);
			aliado.setAtaque(aliado.getAtaque()+this.getMagia());
		}
	}
	
	public void golpeFatal(Peleable atacado){
		if(this.getEnergia()>10)
		{
			atacado.serAtacado(atacado.getSalud()/2);
			this.setEnergia(this.getEnergia()/2);
		}
		
		
	}
	
	
}
