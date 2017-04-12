package dominio;
/**
 * 
 * Interface implementada en las clases Personaje y NPC
 * Dependiendo qué clase las esté implementando será como responderán
 *
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
