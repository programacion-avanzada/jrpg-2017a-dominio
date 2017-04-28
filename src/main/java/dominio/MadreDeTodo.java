package dominio;

public abstract class MadreDeTodo {
	
	//protected int salud;
	protected int fuerza;
	protected int defensa;
	protected int nivel;
	protected String nombre;
	
	public MadreDeTodo(int fuerza, int defensa, int nivel, String nombre) {
		
		this.fuerza = fuerza;
		this.defensa = defensa;
		this.nivel = nivel;
		this.nombre = nombre;
	}



	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
//	public int getSalud() {
//		return salud;
//	}
//
//
//
//	public void setSalud(int salud) {
//		this.salud = salud;
//	}
	
	
	
}
