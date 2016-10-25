package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class Test_Hechicero {
	
	@Test
	public void test_curar()
	{
		Humano h = new Humano(100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		
		Assert.assertTrue(e.getSalud()==100);
		h.atacar(e);
		Assert.assertTrue(e.getSalud()==65);
		h.habilidadCasta2(e);
		Assert.assertTrue(e.getSalud()==95);

	}
	
	@Test
	public void test_bolaDeFuego()
	{
		Humano h = new Humano(100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		
		Assert.assertTrue(e.getSalud()==100);
		h.habilidadCasta1(e);
		Assert.assertTrue(e.getSalud()==75);

	}
	
	@Test
	public void test_robarEnergia_y_Salud()
	{
		Humano h = new Humano(100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
	
		Assert.assertTrue(e.getSalud()==100);
		h.setSalud(50);
		h.setEnergia(50);
		h.habilidadCasta3(e);
	
		Assert.assertTrue(e.getSalud()==95);
		Assert.assertTrue(h.getEnergia()==70);
		Assert.assertTrue(h.getSalud()==55);
		
	}
}
