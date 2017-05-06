package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.NonPlayableCharacter;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertTrue(30 == npc.otorgarExp());
	}
	
	@Test
	public void testDificultad(){
		NonPlayableCharacter npcNormal = new NonPlayableCharacter("Goblin",1,1);
		Assert.assertTrue(npcNormal.getFuerza()==20);
		Assert.assertTrue(npcNormal.getSalud()==40);
		Assert.assertTrue(npcNormal.getDefensa()==5);
	}
	@Test
	public void testSettersGetters(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setAtaque(10);
		Assert.assertEquals(10, npc.getAtaque());
		npc.setDefensa(10);
		Assert.assertEquals(10, npc.getDefensa());
		npc.setFuerza(10);
		Assert.assertEquals(10, npc.getDefensa());
		npc.setNivel(15);
		Assert.assertEquals(npc.getNivel(), 15);
		npc.setNombre("Prueba");
		Assert.assertEquals(npc.getNombre(), "Prueba");
		npc.setSalud(100);
		Assert.assertEquals(npc.getSalud(), 100);
	}
	
	@Test
	public void testSerAtacado(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Ogro",2,1);
		npc.setDefensa(200);
		npc2.setAtaque(2000);
		npc.serAtacado(10);
		Assert.assertEquals(40, npc.getSalud());
		npc2.atacar(npc);
		Assert.assertTrue(npc.getSalud()<=0);
		Assert.assertFalse(npc.estaVivo());
		npc.setAtaque(10);
		npc2.setDefensa(0);
		npc2.setSalud(150);
		int aux = npc.atacar(npc2);
		if(aux==0){
			Assert.assertEquals(150,npc2.getSalud());
		}
	}
}
