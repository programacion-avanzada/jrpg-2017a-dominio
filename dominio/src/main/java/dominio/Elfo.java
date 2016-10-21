package dominio;

import java.util.LinkedList;

public class Elfo extends Personaje{
	
	public Elfo(String casta){
		super(casta);
	}
	
	
	
	public Elfo(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, LinkedList<Item> itemsEquipados,
			LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje,int defensa) {
		super(salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje,defensa);
		// TODO Auto-generated constructor stub
	}



	public void golpeLevel(Peleable atacado){
		if(this.getEnergia()>10)
		{atacado.serAtacado(this.getFuerza()+this.getNivel()*10);
		this.setEnergia(this.getEnergia()-10);}
	}
	
	public void ataqueBosque(Peleable atacado){
		if(this.getEnergia()>10)
		{
			atacado.serAtacado( (int) (this.calcularPuntosDeMagia()));
			this.setEnergia(this.getEnergia()-10);
		}
	}

}
