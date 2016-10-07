package dominio;

public abstract class Item {

	private String nombre;
	
	public Item(String nombre)
	{
		this.nombre=nombre;
	}
	
	public abstract double obtenerModificadorFuerza();
	public abstract double obtenerModificadorDestreza();
	public abstract double obtenerModificadorInteligencia();
}
