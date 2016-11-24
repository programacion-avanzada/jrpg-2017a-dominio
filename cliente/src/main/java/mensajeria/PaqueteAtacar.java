package mensajeria;

import java.io.Serializable;

public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int nuevaSalud;
	private int nuevaEnergia;
	
	public PaqueteAtacar(int id, int idEnemigo, int nuevaSalud, int nuevaEnergia) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		this.nuevaSalud = nuevaSalud;
		this.nuevaEnergia = nuevaEnergia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}

	public int getNuevaSalud() {
		return nuevaSalud;
	}

	public void setNuevaSalud(int nuevaSalud) {
		this.nuevaSalud = nuevaSalud;
	}

	public int getNuevaEnergia() {
		return nuevaEnergia;
	}

	public void setNuevaEnergia(int nuevaEnergia) {
		this.nuevaEnergia = nuevaEnergia;
	}
}
