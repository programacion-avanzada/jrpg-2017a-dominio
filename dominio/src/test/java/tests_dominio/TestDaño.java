package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;
import dominio.Orco;

public class Test_Daño {

	@Test
	public void test_AtaqueComunYLaSaludNoBajeDe0() 
	{
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		Assert.assertTrue(o.getSalud() == 100);
		if (h.atacar(o) != 0)
		{
			Assert.assertTrue(o.getSalud() == 0);
			h.atacar(o);
			Assert.assertTrue(o.getSalud() == 0);
			h.atacar(o);
			Assert.assertTrue(o.getSalud() == 0);
		} else
			Assert.assertTrue(o.getSalud() == 0);

	}

	@Test
	public void test_losMuertosNoAtacan() {
		Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		h.atacar(o);
		h.atacar(o);
		h.atacar(o);
		h.atacar(o);

		o.atacar(h);
		Assert.assertEquals(100, h.getSalud());
	}

}