package dominio;

public class NonPlayableCharacter implements Peleable{

	int salud;
	int fuerza;
	
	public void serAtacado(int daño){
		salud -= daño;
	}
	
	public void despuesDeTurno(){
		
	}
}
