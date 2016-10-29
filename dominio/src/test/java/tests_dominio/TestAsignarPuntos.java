package tests_dominio;


import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class TestAsignarPuntos {

	@Test
	public void testAumentarSalud_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getSaludTope()==55);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getSaludTope()==80);
		}
	
	@Test
	public void testAumentarEnergia_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getEnergiaTope()==55);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getEnergiaTope()==75);
		
	}
	
	@Test
	public void testMasDe200Puntos(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		h.setFuerza(199);
		h.setDestreza(199);
		h.setInteligencia(199);
		h.AsignarPuntosSkills(2, 2, 2);
		Assert.assertTrue(h.getFuerza()==199);
		Assert.assertTrue(h.getDestreza()==199);
		Assert.assertTrue(h.getInteligencia()==199);
	}
	
}
