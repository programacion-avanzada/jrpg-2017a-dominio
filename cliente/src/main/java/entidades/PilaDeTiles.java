package entidades;

public class PilaDeTiles {
	
	NodoDePila ptrPila;
	
	public PilaDeTiles(){
		ptrPila = null;
	}
	
	public void push(NodoDePila nodo){
		nodo.establecerSiguiente(ptrPila);
		ptrPila = nodo;
	}
	
	public NodoDePila pop(){
		NodoDePila tope = ptrPila;
		if(tope == null){
			return null;
		}
		ptrPila = ptrPila.obtenerSiguiente();
		return tope;
	}
	
	public boolean estaVacia(){
		return ptrPila == null;
	}

}
