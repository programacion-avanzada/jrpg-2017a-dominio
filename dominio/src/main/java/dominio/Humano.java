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



	public void habilidadRaza1(Peleable atacado){//incentivar
		if(this.getEnergia()>10)
		{
			this.setEnergia(this.getEnergia()-10);
			atacado.setAtaque(atacado.getAtaque()+this.getMagia());
		}
	}
	
	public void habilidadRaza2(Peleable atacado){//golpefatal
		if(this.getEnergia()>10)
		{
			atacado.serAtacado(atacado.getSalud()/2);
			this.setEnergia(this.getEnergia()/2);
		}
		
		
	}
	
	
}
