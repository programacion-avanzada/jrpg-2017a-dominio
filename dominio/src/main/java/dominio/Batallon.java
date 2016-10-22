package dominio;

import java.util.Iterator;
import java.util.LinkedList;

public class Batallon {
	
	LinkedList <Peleable> equipo;
	String alianza;
	
	
	public Batallon(LinkedList <Peleable> aliados)
	{
		this.equipo=aliados;
	}
	
	public LinkedList <Peleable> armarBatallonPjs(Personaje p)
	{
		
		LinkedList <Peleable> batallon_amigo = new LinkedList();
		Iterator <Personaje> it = p.getClan().getAliados().iterator(); 
		while(it.hasNext())
		{
			if(it.next().distanciaCon(p)<=10)
				batallon_amigo.add(it.next());
		}
		return batallon_amigo;
	}
	
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
	
	public void establecerEstrategia(){
		
	}
}
