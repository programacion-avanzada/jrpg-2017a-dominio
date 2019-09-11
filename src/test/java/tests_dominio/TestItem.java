package tests_dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Item;

public class TestItem {

	Item item;
	
	@Before
	public void initialize(){
		item = new Item(1, "Item 1", 10, 20, 30, 40, 50);
	}

	@Test
	public void testGetters() {
		Assert.assertTrue(item.getId() == 1);
		Assert.assertTrue(item.getNombre() == "Item 1");
		Assert.assertTrue(item.getAtaque() == 10);
		Assert.assertTrue(item.getDefensa() == 20);
		Assert.assertTrue(item.getMagia() == 30);
		Assert.assertTrue(item.getSalud() == 40);
		Assert.assertTrue(item.getEnergia() == 50);
	}

}
