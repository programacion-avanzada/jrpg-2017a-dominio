
package dominio;

public abstract class MadreDeTodo {


	private int fuerza;
	private int defensa;
	private int nivel;
	private String nombre;

	public MadreDeTodo(final int fuerza, final int defensa, final int nivel, final String nombre) {
		this.fuerza = fuerza;
		this.defensa = defensa;
		this.nivel = nivel;
		this.nombre = nombre;
	}



	public final int getFuerza() {
		return fuerza;
	}

	public final void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	public final int getDefensa() {
		return defensa;
	}

	public final void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	public final int getNivel() {
		return nivel;
	}

	public final void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
}
