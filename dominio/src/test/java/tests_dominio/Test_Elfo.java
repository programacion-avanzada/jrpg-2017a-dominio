package tests_dominio;

import org.junit.Test;


import dominio.Elfo;
import dominio.Humano;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import dominio.Asesino;
import dominio.Item;




public class Test_Elfo {

	@Test
	public void test_golpeLevel()
	{
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);

		Assert.assertTrue(h.getSalud()==100);
		e.golpeLevel(h);
		Assert.assertTrue(h.getSalud()<100);
		
	}
	
	@Test
	public void test_ataqueBosque()
	{
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(h.getSalud()==100);
		e.ataqueBosque(h);
		Assert.assertTrue(h.getSalud()<100);
		
	}
	
}
