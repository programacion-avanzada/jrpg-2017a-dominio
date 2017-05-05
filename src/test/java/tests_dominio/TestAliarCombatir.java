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
		if(	h.atacar(h2)!=0)
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
	public void testGettersYSetters() {
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		Humano h3 = new Humano("Maxi",new Guerrero(),1);
		Humano h4 = new Humano("Dimas",new Guerrero(),1);
		
		Alianza a1= new Alianza("Los CacheFC");
		
		LinkedList<Personaje> aliados = new LinkedList<Personaje>();
		LinkedList<Personaje> aliados2 = new LinkedList<Personaje>();
		
		aliados.add(h);
		aliados.add(h2);
		aliados2.add(h3);
		aliados2.add(h4);
		
		
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		
		Assert.assertNotNull(aliados);
		Assert.assertTrue(a1.getAliados().get(0) == aliados.get(0));
		Assert.assertTrue(a1.getAliados().get(1) == aliados.get(1));
		
		Assert.assertNull(h3.getClan());
		Assert.assertNull(h4.getClan());
		Assert.assertNotNull(aliados2);
		a1.setAliados(aliados2);
		h3.setClan(a1);
		h4.setClan(a1);
	}
	
	@Test
	public void testObtenerNombre() {
		Alianza a1 = new Alianza("The Bitles");
		String nombre = "The Bitles";
		
		Assert.assertNotNull(a1.obtenerNombre());
		Assert.assertNotNull(nombre);
		
		Assert.assertTrue(a1.obtenerNombre() == nombre);
		Assert.assertFalse(a1.obtenerNombre() != nombre);
	}
	
	@Test
	public void testEliminarPersonaje() {
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		
		Alianza a1= new Alianza("Los CacheFC");
		
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h2 == a1.getAliados().get(1));
		a1.eliminarPersonaje(h2);
		a1.eliminarPersonaje(h);
		Assert.assertTrue(a1.getAliados().isEmpty());
	}
	
}
