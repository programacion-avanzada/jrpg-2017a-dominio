package dominio;

import java.util.ArrayList;

public class Alianza {

	String nombre;
	ArrayList<Personaje> aliados;
	
	public Alianza(String nombre){
		this.nombre=nombre;
	}
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
