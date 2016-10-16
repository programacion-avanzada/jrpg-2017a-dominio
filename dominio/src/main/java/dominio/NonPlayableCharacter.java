package dominio;

public class NonPlayableCharacter implements Peleable{

	public int salud;
	public int fuerza;
	public int defensa;
	public Item[] items_dropeables;
	
	
	
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int serAtacado(int daño){
		salud -= daño;
		return daño;
	}
	
	public void despuesDeTurno(){
		
	}
}
