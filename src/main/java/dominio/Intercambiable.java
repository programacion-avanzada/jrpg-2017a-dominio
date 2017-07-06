package dominio;

import java.io.Serializable;

public class Intercambiable implements Serializable {
	
	private Item oferta = null;
	private Item demanda = null;
	
	public Intercambiable() {
		
	}
	
	public static boolean sonIntercambiables(final Intercambiable i1, final Intercambiable i2) {
		if(i1.oferta == null || i2.oferta == null) {
			return false;
		}
		
		if(i1.demanda == null || i2.demanda == null) {
			return false;
		}
		
		if(i1.oferta.getId() != i2.demanda.getId() || i1.demanda.getId() != i2.oferta.getId()) {
			return false;
		}
		
		return true;
	}
	
	public void setOferta(Item oferta) {
		this.oferta = oferta;
	}
	
	public void setDemanda(Item demanda) {
		this.demanda = demanda;
	}

	public Item getDemanda() {
		return demanda;
	}

	public Item getOferta() {
		return oferta;
	}
	
}
