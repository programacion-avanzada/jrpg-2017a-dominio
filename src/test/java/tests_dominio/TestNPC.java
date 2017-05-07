package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.NonPlayableCharacter;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertEquals(30, npc.otorgarExp());
	}
	
	@Test
	public void testDificultad0(){
		NonPlayableCharacter npcEasy = new NonPlayableCharacter("Goblin",2,0);
		Assert.assertEquals(npcEasy.getFuerza(), 13);
		Assert.assertEquals(npcEasy.getSalud(), 45);
		Assert.assertEquals(npcEasy.getDefensa(), 3);
	}
	@Test
	public void testDificultad1(){
		NonPlayableCharacter npcNormal = new NonPlayableCharacter("Goblin",2,1);
		Assert.assertEquals(npcNormal.getFuerza(), 26);
		Assert.assertEquals(npcNormal.getSalud(), 60);
		Assert.assertEquals(npcNormal.getDefensa(), 7);
	}
	@Test
	public void testDificultad2(){
		NonPlayableCharacter npcHard = new NonPlayableCharacter("Goblin",2,2);
		Assert.assertEquals(npcHard.getFuerza(), 40);
		Assert.assertEquals(npcHard.getSalud(), 75);
		Assert.assertEquals(npcHard.getDefensa(), 8);
	}
	@Test
	public void testGetterSetterAtaque(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setAtaque(10);
		Assert.assertEquals(10, npc.getAtaque());
	}
	@Test
	public void testGetterSetterDefensa(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setDefensa(10);
		Assert.assertEquals(10, npc.getDefensa());
	}
	@Test
	public void testGetterSetterFuerza(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setFuerza(10);
		Assert.assertEquals(10, npc.getFuerza());
	}
	@Test
	public void testGetterSetterNivel(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setNivel(15);
		Assert.assertEquals(npc.getNivel(), 15);
	}
	@Test
	public void testGetterSetterNombre(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setNombre("Prueba");
		Assert.assertEquals(npc.getNombre(), "Prueba");
	}
	@Test
	public void testGetterSetterSalud(){
		NonPlayableCharacter npc = new NonPlayableCharacter("Goblin",1,1);
		npc.setSalud(100);
		Assert.assertEquals(npc.getSalud(), 100);
	}
	
	@Test
	public void testSerAtacadoyDañado(){
		NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin",1,1);
		goblin.setSalud(100);
		Assert.assertEquals(100, goblin.getSalud());
		goblin.setDefensa(0);
		Assert.assertEquals(0, goblin.getDefensa());
		goblin.serAtacado(80);
		Assert.assertEquals(20, goblin.getSalud());
	}
	@Test
	public void testSerAtacadoyMorir(){
		NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin",1,1);
		goblin.setSalud(100);
		Assert.assertEquals(100, goblin.getSalud());
		goblin.setDefensa(0);
		Assert.assertEquals(0, goblin.getDefensa());
		goblin.serAtacado(100);
		Assert.assertEquals(0, goblin.getSalud());
		Assert.assertFalse(goblin.estaVivo());
	}
	@Test
	public void testSerAtacadoyNoDañado(){
		NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin",1,1);
		goblin.setSalud(100);
		Assert.assertEquals(100, goblin.getSalud());
		goblin.setDefensa(0);
		Assert.assertEquals(0, goblin.getDefensa());
		goblin.serAtacado(0);
		Assert.assertEquals(100, goblin.getSalud());
	}
	
	@Test
	public void testSerAtacadoyEsquivar(){}
	
	@Test
	public void testAtacarSinCritico(){}
	
	@Test
	public void testAtacarCritico(){
		NonPlayableCharacter goblin = new NonPlayableCharacter("Goblin",1,1);
		NonPlayableCharacter ogro = new NonPlayableCharacter("Ogro",1,1);
		goblin.setSalud(100);
		ogro.setAtaque(50);
		ogro.atacar(goblin);
		Assert.assertEquals(goblin.getSalud(),52);
	}
}
