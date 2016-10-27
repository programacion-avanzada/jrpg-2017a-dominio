package tests_dominio;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_Enemigos_y_Experiencia {

	@Test
	public void test_PjvsNPC(){
		
	Humano h = new Humano("Nicolas",new Guerrero(),1);
	NonPlayableCharacter npc = new NonPlayableCharacter("Gigante",1,null,0);
	Personaje.cargar_tabla_nivel();
	Assert.assertTrue(h.getExperiencia()==0);
	while(npc.estaVivo())
		h.atacar(npc);
	h.ganarExperiencia(npc.otorgarExp());
	Assert.assertTrue(h.getExperiencia()==30);
	
	}
	
	@Test
	public void test_MasFuerte_MasExperiencia(){
		
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante",1,null,0);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante",2,null,0);
		
		
		Assert.assertTrue(npc.otorgarExp()<npc2.otorgarExp());
	
	}
	
	@Test
	public void test_PjvsPj(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),2);
		Personaje.cargar_tabla_nivel();
		Assert.assertTrue(h.getExperiencia()==0);
		Assert.assertTrue(h2.getExperiencia()==0);
		while(h2.estaVivo())
			h.atacar(h2);
		
		h.ganarExperiencia(h2.otorgarExp());
		Assert.assertTrue(h.getExperiencia()==40);
		Assert.assertTrue(h2.getExperiencia()==0);
		
	}
}
