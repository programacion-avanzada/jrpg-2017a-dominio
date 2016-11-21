package cliente;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String nombreUsuario;
	private String password;
	private int opcion;
	private int idPj;
	private String accion;

	public Usuario(String nombreUsuario, String password, int idPj) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.opcion = -1;
		this.idPj = idPj;
	}

	public Usuario() {
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdPj() {
		return idPj;
	}

	public void setIdPj(int idPj) {
		this.idPj = idPj;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
