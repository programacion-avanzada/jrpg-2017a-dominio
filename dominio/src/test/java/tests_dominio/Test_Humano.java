package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class Test_Humano {

	@Test
	public void test_incentivar()
	{
		Humano h = new Humano("Nico",100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		
		Assert.assertTrue(e.getAtaque()==25);
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque()==55);
	}
	
	@Test
	public void test_golpeFatal()
	{
		Humano h = new Humano("Nico",100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		
		Assert.assertTrue(h.getEnergia()==100);
		Assert.assertTrue(e.getSalud()==100);
		h.habilidadRaza2(e);
		Assert.assertTrue(e.getSalud()==70);
		Assert.assertTrue(h.getEnergia()==50);
	}
	
}
