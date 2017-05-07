package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandom;
import dominio.Orco;

public class TestDaño {

	@Test
	public void testAtaqueComunYLaSaludNoBajeDe0() {
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);

		Assert.assertEquals(o.getSalud(), 100);
		if (h.atacar(o) != 0) {
			Assert.assertEquals(o.getSalud(), 0);
			h.atacar(o);
			Assert.assertEquals(o.getSalud(), 0);
			h.atacar(o);
			Assert.assertEquals(o.getSalud(), 0);
		} else
			Assert.assertEquals(o.getSalud(), 0);
	}

	@Test
	public void testLosMuertosNoAtacan() {
		Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);

		h.atacar(o);
		h.atacar(o);
		h.atacar(o);
		h.atacar(o);

		o.atacar(h);
		Assert.assertEquals(100, h.getSalud());
	}
	@Test
	public void testNextIntRandom(){
		MyRandom r = new MyRandom();
		int aux= 1;
		Assert.assertEquals(0, r.nextInt(aux));
	}
	@Test
	public void testNextDoubleRandom(){
		MyRandom r = new MyRandom();
		Assert.assertEquals(0.49, r.nextDouble(),0.001);
	}
}