package tests_dominio;

import org.junit.Before;
import org.junit.Test;

import dominio.Intercambiable;
import dominio.Item;
import org.junit.Assert;

public class TestIntercambiable {

  Intercambiable intercambiable1;
  Intercambiable intercambiable2;

  Item item1;
  Item item2;

	@Before
	public void initialize(){
        intercambiable1 = new Intercambiable();
        intercambiable2 = new Intercambiable();
    
        item1 = new Item(1, "Item 1", 0, 0, 0, 0, 0);
        item2 = new Item(2, "Item 2", 0, 0, 0, 0, 0);
	}

	@Test
	public void testSonIntercambiables() {
        intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        intercambiable2.setOferta(item2);
        intercambiable2.setDemanda(item1);
        
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == true);
    }

	@Test
	public void testNoSonIntercambiablesOferta() {
        intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        intercambiable2.setOferta(item2);
        intercambiable2.setDemanda(item2);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testNoSonIntercambiablesDemanda() {
		intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        intercambiable2.setOferta(item1);
        intercambiable2.setDemanda(item1);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testNoSonIntercambiablesOferta1Null() {
        intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        intercambiable2.setDemanda(item1);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testNoSonIntercambiablesDemanda1Null() {
        intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        intercambiable2.setOferta(item2);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testNoSonIntercambiablesOferta2Null() {
        intercambiable2.setOferta(item1);
        intercambiable2.setDemanda(item2);
        intercambiable1.setDemanda(item1);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testNoSonIntercambiablesDemanda2Null() {
        intercambiable2.setOferta(item1);
        intercambiable2.setDemanda(item2);
        intercambiable1.setOferta(item2);
    
        boolean resultado = Intercambiable.intercambiar(intercambiable1, intercambiable2);
        Assert.assertTrue(resultado == false);
    }
	
	@Test
	public void testGetters() {
		intercambiable1.setOferta(item1);
        intercambiable1.setDemanda(item2);
        
        Assert.assertTrue(intercambiable1.getOferta() == item1);
        Assert.assertTrue(intercambiable1.getDemanda() == item2);
    }
}
