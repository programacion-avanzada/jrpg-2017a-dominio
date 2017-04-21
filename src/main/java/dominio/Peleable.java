package dominio;

/**
 * Esta interface define los metodos requeridos por las clases que
 * representen entidades que pueden pelear entre sí.
 * La implementan la clase Personaje y NonPlayableCharacter.
 */

public interface Peleable {
	public int serAtacado(int daño);
	public int getSalud();
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
