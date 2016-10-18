package dominio;

public interface Peleable {
	public int serAtacado(int daño);
	public int getSalud();
	public void despuesDeTurno();
	public void atacar(Peleable atacado);
}
