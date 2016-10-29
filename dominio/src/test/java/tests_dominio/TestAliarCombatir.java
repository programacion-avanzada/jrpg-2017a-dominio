package tests_dominio;
import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_Aliar_y_Combatir {

	@Test
	public void test_CrearAlianza(){
		
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);

		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}
	
	@Test
	public void test_Dañar(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Asesino(),1);
		Assert.assertTrue(h2.getSalud()==55);
		if(	h.atacar(h2)!=0)
			Assert.assertTrue(h2.getSalud()<55);
		else
			Assert.assertTrue(h2.getSalud()==55);
	}
	
	@Test
	public void test_Aliar()
	{
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		Alianza a1= new Alianza("Los CacheFC");
		
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h.getClan()==h2.getClan());

	}
	
}
