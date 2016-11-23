package mensajeria;

import java.io.Serializable;

public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

	private int idPj;
	private String username;
	private String password;
	private boolean inicioSesion;
	
	public PaqueteUsuario(){
		
	}

	public PaqueteUsuario(int pj, String user, String pw){
		idPj = pj;
		username = user;
		password = pw;
		inicioSesion = false;
	}
	
	public int getIdPj() {
		return idPj;
	}

	public void setIdPj(int idPj) {
		this.idPj = idPj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
	
	
}
