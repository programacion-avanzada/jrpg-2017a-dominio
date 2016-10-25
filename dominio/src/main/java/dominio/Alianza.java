package dominio;


import java.util.LinkedList;

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
	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
