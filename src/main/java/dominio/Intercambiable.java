package dominio;

import java.io.Serializable;

/**
 * Permite crear objeto con oferta y demanda
 * que pueden ser intercambiados
 */

public class Intercambiable implements Serializable {

	private Item oferta = null;
	private Item demanda = null;

	/**
	 * Constructor de la clase
	 */

	public Intercambiable() { }

	/**
	 * Permite determinar si dos intercambiables se pueden cambiar
	 * Luego los asigna a null para evitar que se puedan volver a cambiar
	 * @param i1 intercambiable 1
	 * @param i2 intercambiable 2
	 * @return true o false si se pueden cambiar
	 */

	public static boolean intercambiar(final Intercambiable i1, final Intercambiable i2) {
		if (i1.oferta == null || i2.oferta == null) {
			return false;
		}

		if (i1.demanda == null || i2.demanda == null) {
			return false;
		}

		if (i1.oferta.getId() != i2.demanda.getId() || i1.demanda.getId() != i2.oferta.getId()) {
			return false;
		}

		i1.oferta = null;
		i1.demanda = null;
		i2.oferta = null;
		i2.demanda = null;

		return true;
	}

	/**
	 * Asigna el item ofertado
	 * @param ofeta item ofertado
	 */

	public void setOferta(final Item oferta) {
		this.oferta = oferta;
	}

	/**
	 * Asigna el item demandado
	 * @param demanda item demandado
	 */

	public void setDemanda(final Item demanda) {
		this.demanda = demanda;
	}

	/**
	 * Devuleve el item demandado
	 * @return demanda
	 */

	public Item getDemanda() {
		return demanda;
	}

	/**
	 * Devuleve el item ofertado
	 * @return oferta
	 */

	public Item getOferta() {
		return oferta;
	}

}
