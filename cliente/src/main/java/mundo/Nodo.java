package mundo;

public class Nodo {
	
	private int x;
	private int y;
	private int indice;
	private int cantidadDeAdyacentes;
	private Nodo [] nodosAdyacentes;
	
	public Nodo(int indice, int x, int y){
		this.x = x;
		this.y = y;
		this.indice = indice;
		cantidadDeAdyacentes = 0;
		nodosAdyacentes = new Nodo[8];
	}
	
	public int obtenerX(){
		return x;
	}
	
	public int obtenerY(){
		return y;
	}
	
	public int obtenerIndice(){
		return indice;
	}
	
	public Nodo [] obtenerNodosAdyacentes(){
		return nodosAdyacentes;
	}
	
	public void agregarAdyacente(Nodo nodo){
		nodosAdyacentes[cantidadDeAdyacentes++] = nodo; 
	}
	
	public int obtenerCantidadDeAdyacentes(){
		return cantidadDeAdyacentes;
	}
}
