package dominio;

import java.util.LinkedList;

public class Elfo extends Personaje{
	
	public Elfo(String casta){
		super(casta);
	}
	
	
	
	public Elfo(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, LinkedList<Item> itemsEquipados,
			LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje) {
		super(salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje);
		// TODO Auto-generated constructor stub
	}



	public void habilidadRaza1(Peleable atacado){ //golpelevel
		if(this.getEnergia()>10)
		{atacado.serAtacado(this.getFuerza()+this.getNivel()*10);//no importan los items, solo la fuerza y el level
		this.setEnergia(this.getEnergia()-10);}
	}
	
	public void habilidadRaza2(Peleable atacado){ //ataquebosque
		if(this.getEnergia()>10)
		{
			atacado.serAtacado( (int) (this.magia));
			this.setEnergia(this.getEnergia()-10);
		}
	}

}
