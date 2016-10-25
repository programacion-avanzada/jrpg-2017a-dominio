package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Batallon {
	
	LinkedList <Peleable> equipo;
	String alianza;
	
	
	
	
	
	
	
	
	public LinkedList <Peleable> getAliados() {
		return equipo;
	}

	public void setAliados(LinkedList <Peleable> aliados) {
		this.equipo = aliados;
	}

	public String getAlianza() {
		return alianza;
	}

	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}

	public int cantidad_luchadores()
	{
		return equipo.size();
	}
	
	
	
	
}
