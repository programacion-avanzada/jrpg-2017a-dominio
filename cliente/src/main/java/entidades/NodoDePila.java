package entidades;

public class NodoDePila {

	private int x;
	private int y;
	private NodoDePila ptrSiguiente;
	
	public NodoDePila(int x, int y){
		this.x = x;
		this.y = y;
		ptrSiguiente = null;
	}
	
	public NodoDePila obtenerSiguiente(){
		return ptrSiguiente;
	}
	
	public void establecerSiguiente(NodoDePila nodo){
		ptrSiguiente = nodo;
	}
	
	public int obtenerX(){
		return x;
	}
	
	public int obtenerY(){
		return y;
	}

}
