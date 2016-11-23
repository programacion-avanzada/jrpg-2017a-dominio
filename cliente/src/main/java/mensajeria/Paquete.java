package mensajeria;

import java.io.Serializable;

public class Paquete implements Serializable, Cloneable {
	
	public static String msjExito = "1";
	public static String msjFracaso = "0";
	
	private String mensaje;
	private String ip;
	private int comando;

	public Paquete() {
		
	}
	
	public Paquete(String mensaje, String nick, String ip, int comando) {
		this.mensaje = mensaje;
		this.ip = ip;
		this.comando = comando;
	}
	
	public Paquete(String mensaje, int comando) {
		this.mensaje = mensaje;
		this.comando = comando;
	}

	public Paquete(int comando) {
		this.comando = comando;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setComando(int comando) {
		this.comando = comando;
	}

	public String getMensaje() {
		return mensaje;
	}


	public String getIp() {
		return ip;
	}

	public int getComando() {
		return comando;
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}
