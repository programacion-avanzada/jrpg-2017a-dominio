package dominio;

import java.util.LinkedList;

public class Humano extends Personaje {

	public Humano(String nombre,Casta casta,int id)
	{
		super(nombre,casta,id);
		saludTope+=5;
		energiaTope+=5;
		salud=saludTope;
		energia=energiaTope;
		nombreRaza="Humano";
	}
	
	public Humano() {
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
		
	}
	
	public Humano(String nombre,int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje) {
		super(nombre,salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje);
		nombreRaza="Humano";
		
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}



	public boolean habilidadRaza1(Peleable atacado){//incentivar
		if(this.getEnergia()>10){
			this.setEnergia(this.getEnergia()-10);
			atacado.setAtaque(atacado.getAtaque()+this.getMagia());
			return true;
		}
		return false;
	}
	
	public boolean habilidadRaza2(Peleable atacado){//golpefatal
		if(this.getEnergia()>10){
			if(atacado.serAtacado(atacado.getSalud()/2)!=0){
				this.setEnergia(this.getEnergia()/2);
				return true;
				}
		}
		this.setEnergia(this.getEnergia()-10);
		return false;
		}
	
	
}
