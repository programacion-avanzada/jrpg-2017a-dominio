package cliente;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Map;

import dominio.Mapa;

public class PaqueteDePersonajes extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaquetePersonaje> personajes;

	public PaqueteDePersonajes(){

	}
	
	public PaqueteDePersonajes(Map<Integer, PaquetePersonaje> personajes){
		this.personajes = personajes;
	}
	
	public Map<Integer, PaquetePersonaje> getPersonajes(){
		return personajes;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}