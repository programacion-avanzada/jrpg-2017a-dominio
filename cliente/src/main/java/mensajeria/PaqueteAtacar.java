package mensajeria;

import java.io.Serializable;

public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	int id;
	int idEnemigo;
	int nuevaSalud;
	
	public PaqueteAtacar(int id, int idEnemigo, int nuevaSalud) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		this.nuevaSalud = nuevaSalud;
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
}
