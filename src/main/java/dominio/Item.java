package dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable{
	
	private final int ID;
	
	private String nombre;
	private String flavorText;
	
	private int fuerza;
	private int salud;
	private int defensa;
	
	private int ataque;
	
	private int magia;
	private int inteligencia;
	private int destreza;
	private int energia;
	
	
	public Item(int id, String name, String text, int fuerza, int salud, int defensa, int ataque,
			int magia, int inteligencia, int destreza, int energia) {
		
		this.ID = id;
		this.nombre = name;
		this.flavorText = text;
		this.fuerza = fuerza;
		this.salud = salud;
		this.defensa = defensa;
		this.ataque = ataque;
		this.magia = magia;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
		this.energia = energia;
	}
	
	public int getID() {
		return ID;
	}


	public String getNombre() {
		return nombre;
	}


	public String getFlavorText() {
		return flavorText;
	}


	public int getFuerza() {
		return fuerza;
	}


	public int getSalud() {
		return salud;
	}


	public int getDefensa() {
		return defensa;
	}


	public int getAtaque() {
		return ataque;
	}


	public int getMagia() {
		return magia;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public int getDestreza() {
		return destreza;
	}


	public int getEnergia() {
		return energia;
	}

}
