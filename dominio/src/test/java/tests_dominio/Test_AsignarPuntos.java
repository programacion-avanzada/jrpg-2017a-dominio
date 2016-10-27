package tests_dominio;


import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_AsignarPuntos {

	@Test
	public void test_AumentarSalud_tope(){
		Personaje.cargar_tabla_nivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getSalud_tope()==55);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getSalud_tope()==80);
		
	}
	
	@Test
	public void test_AumentarEnergia_tope(){
		Personaje.cargar_tabla_nivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getEnergia_tope()==55);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getEnergia_tope()==75);
		
	}
	
	@Test
	public void test_MasDe200Puntos(){
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
