package dominio;

public class Personaje implements Peleable{
	
	int salud;
	int energia;
	int fuerza;
	int destreza;
	int inteligencia;
	Casta casta;
	Item [] itemsEquipados;
	Item [] itemsGuardados;
	int experiencia;
	int nivel;
	int idPersonaje;
	
	public Personaje(String casta){
		
	}
	
	public void atacar(Peleable atacado){
	
	}
	
	public void despuesDeTurno(){
		
	}
	
	public boolean puedeAtacar(){
		return true;
	}
	
	public int calcularPuntosDeAtaque(){
		return 0;
	}
	
	public int calcularPuntosDeDefensa(){
		return 0;
	}
	
	public boolean estaVivo(){
		return salud > 0;
	}
	
	public void serAtacado(int daño){
		salud -= daño;
	}
	
	public void serCurado(){
		salud = 100;
	}
	
	public void serEnergizado(){
		energia = 100;
	}
	
	public void desequiparItem(int item){
		
	}
	
	public void dropearItem(int  item){
		
	}
	public void salirDeAlianza(){
		
	}
	
	public void aliarme(Personaje aliado){
		
	}
	
	public void subirNivel(){
		
	}
	
	public void ganarExperiencia(int exp){
		experiencia += exp;
	}

}
