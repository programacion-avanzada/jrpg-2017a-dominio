package dominio;

public abstract class Unidad {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	
	
	
	
	
	/** Este metodo sirve para modificar la fuerza del NPC*/
	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}
	
	/** Este metodo devuelve la fuerza del NPC*/
	public int getFuerza() {
		return fuerza;
	}
	
	 /** Este metodo devuelve el nombre del NPC*/
	public String getNombre() {
		return nombre;
	}

	/** Este metodo sirve para modificar el nombre del NPC*/
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/** Este metodo devuelve el nivel del NPC*/
	public int getNivel() {
		return nivel;
	}

	/** Este metodo sirve para modificar el nivel del NPC*/
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}
	
	/** El siguiente metodo establece el nivel de salud del personaje */
	 public int getSalud() {
	   return salud;
	 }
	  
	 /** El siguiente metodo establece el nivel de salud del personaje */
	 public void setSalud(final int salud) {
	   this.salud = salud;
	 }
	 /** Este metodo devuelve la defensa del NPC*/
	 public int getDefensa() {
		return defensa;
	 }
    
	 /** Este medoto sirve para modificar la defensa del NPC*/
	 public void setDefensa(final int defensa) {
			this.defensa = defensa;
	 }
	 
	 public Unidad(int salud, String nombre, int fuerza, int nivel){
		 
		 this.salud = salud;
		 this.nombre = nombre;
		 this.fuerza = fuerza;
		 this.nivel = nivel;
	 }
	 
	 public Unidad(String nombre){
		 
		 this.nombre = nombre;
	 }
	 
	 public Unidad(String nombre, int nivel){
		 
		 this.nombre = nombre;
		 this.nivel = nivel;
	 }
	 
	 
	 /** este metodo decide la experiencia repartida por cada NPC derrotado*/
		public abstract int otorgarExp();
		
		/** Este metodo booleano verifica la salud del NPC para verificar si sigue vivo*/
		public abstract boolean estaVivo();
		
	/**
		El metodo "atacar" es la que se encargara de administrar el 
		ataque del NPC y de su probabilidad de golpe critico
		retornando el daño infligido. 
	*/
		public abstract int atacar(final Peleable atacado);
		/** Metodo que realiza las acciones del NPC despues de su turno*/
		public abstract void despuesDeTurno();
		
		


}
