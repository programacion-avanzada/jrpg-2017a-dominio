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

	public String getNombre_usuario() {
		return nombreUsuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombreUsuario = nombre_usuario;
	}

	public String getPassword_usuario() {
		return password;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password = password_usuario;
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
