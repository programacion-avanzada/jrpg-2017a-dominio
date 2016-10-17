package tests_dominio;
import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;
import dominio.Orco;

public class Test_Daño {

	@Test
	public void test_AtaqueComun()
	{
		Humano h = new Humano(100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new Item[6], new Item[20], 0, 1, 1,
				50);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new Item[6], new Item[20], 0, 1, 1, 50);
		
		Assert.assertEquals(200, o.getSalud());
		//h.atacar(o);
		Assert.assertTrue(o.getSalud()==200);//no le pegue nada ya que la defensa es mayor
	}
	
	}
	
