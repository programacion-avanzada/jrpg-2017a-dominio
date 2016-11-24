package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class TestBatallonNPC {

	@Test
	public void testBatallonNPC(){
	
		
		Item[] item = new Item[3];
		item[0]= new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		item[1] = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		item[2] = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, null, -1);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Enano", 1, null, -1);
		LinkedList<NonPlayableCharacter> eq = new LinkedList<NonPlayableCharacter>();
		eq.add(npc);
		eq.add(npc2);
		
		
		BatallonNPC b2= new BatallonNPC("Lobo",100,item,3);
		BatallonNPC b1= new BatallonNPC("Lobo",100,item,-1);
		Assert.assertEquals(b2.getEquipo().size(),3);
		Assert.assertTrue(b1.getEquipo().size()>=3);
		
		b1.setEquipo(eq);
		Assert.assertEquals(b1.getEquipo(), eq);
	}
}
