package dominio;

import java.util.LinkedList;
/**  Esta clase es desarrollada para saber saber y establecer las alianzas entre los personajes */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	public String obtenerNombre(){
		return nombre;
	}
	
	/**
     * Método "eliminarPersonaje", elimina a un personaje que ya no es aliado
     */	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	/**
     * Método "añadirPersonaje", añade a un personaje aliado.
     */	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
