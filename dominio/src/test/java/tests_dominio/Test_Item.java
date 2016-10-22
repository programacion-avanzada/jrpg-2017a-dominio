package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Item;
import dominio.ItemDeManos;

public class Test_Item {

	@Test
	public void test_equiparItem_desequiparItem()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.equiparItem(excalibur));
		Assert.assertNotNull(h.getEquipado(0));
		Assert.assertTrue(h.desequiparItem(excalibur));
		Assert.assertNull(h.getEquipado(0));
	}
	
}
