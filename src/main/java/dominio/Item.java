package dominio;

import java.io.Serializable;

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
	
	

}
