package mundo;

public class Grafo {
	
	private int cantidadDeNodos;
	private int cantidadDeNodosTotal;
	private Nodo [] nodos;
	
	public Grafo(int cantidadDeNodosTotal){
		cantidadDeNodos = 0;
		nodos = new Nodo[cantidadDeNodosTotal];
		this.cantidadDeNodosTotal = cantidadDeNodosTotal;
	}
	
	public void agregarNodo(Nodo nodo){
		nodos [cantidadDeNodos++] = nodo;
	}
	
	public void agregarAdyacentes(Nodo nodoUno, Nodo nodoDos){
		nodoUno.agregarAdyacente(nodoDos);
	}
	
	public Nodo [] obtenerNodos(){
		return nodos;
	}
	
	public int obtenerCantidadDeNodos(){
		return cantidadDeNodos;
	}
	
	public int obtenerCantidadDeNodosTotal(){
		return cantidadDeNodosTotal;
	}

}
