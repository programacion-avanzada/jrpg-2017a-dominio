package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Item;
import dominio.ItemDeCabeza;
import dominio.ItemDeManos;
import dominio.ItemDeTorso;
import dominio.NonPlayableCharacter;

public class Test_NPC {

	@Test
	public void test_Pelea()
	{
		NonPlayableCharacter npc = new NonPlayableCharacter(1,null,-1);
		Humano h = new Humano("Nico",100, 100, 1000, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		h.atacar(npc);
		Assert.assertFalse(npc.estaVivo());
	}
	
	@Test
	public void test_DropearItem()
	{
		Item[] it = new Item[3];
		it[0]= new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		it[1]= new ItemDeTorso(2, 10, "Cota de Malla", "Torso", 0, 20, 0, 0, 0, 10, 10, 10);
		it[2]= new ItemDeCabeza(3,10,"Randuim Shield","Manos",0,50,0,0,0,10,10,10);
		
		NonPlayableCharacter npc = new NonPlayableCharacter(1,it,-1);
		Assert.assertNotNull(npc.dropearItemAleatorio());
	}
	
	@Test
	public void test_OtorgarExp()
	{
		NonPlayableCharacter npc = new NonPlayableCharacter(1,null,-1);
		Assert.assertTrue(30==npc.otorgarExp());
	}
	
}
