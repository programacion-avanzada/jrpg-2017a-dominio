package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;

public class TestAliarCombatir {

	@Test
	public void testCrearAlianza(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		
		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}
	
	@Test
	public void testDañar(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Asesino(),1);
		
		Assert.assertTrue(h2.getSalud()==105);
		if(h.atacar(h2)!=0)
			Assert.assertTrue(h2.getSalud()<105);
		else
			Assert.assertTrue(h2.getSalud()==105);
	}
	
	@Test
	public void testAliar(){
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
	
	@Test
	public void testDesaliar(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		Alianza a1= new Alianza("Los CacheFC");
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h.getClan()==h2.getClan());
		h.salirDeAlianza();
		Assert.assertTrue(h.getClan()==null);
	}
	
	@Test
	public void testAlianzaNombre(){
		Alianza a = new Alianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso",a.obtenerNombre());
		
	}
	
	@Test
	public void testSetGetAliados(){
		Alianza a = new Alianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso",a.obtenerNombre());
		Humano h = new Humano("Chistoso", new Hechicero(),69);
		h.setClan(a);
		Humano h2 = new Humano("Chistoso2", new Hechicero(),69);
		h.setClan(a);
		LinkedList <Personaje> aliados = a.getAliados();
		Assert.assertEquals(aliados, a.getAliados());
		Assert.assertEquals("Algo Gracioso", a.getNombre());
	}
	
}
