package tests_dominio;
import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_Atributos {

	@Test
	public void test_IncrementarFuerza(){
		
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getAtaque()==22);
		h.AsignarPuntosSkills(10, 0, 0);
		Assert.assertTrue(h.getAtaque()>22);
		

	}
	
	@Test
	public void test_IncrementarDestreza(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		
		Assert.assertTrue(h.getDefensa()==10);
		h.AsignarPuntosSkills(0, 10, 0);
		Assert.assertTrue(h.getDefensa()>10);
}
	
	@Test
	public void test_IncrementarInteligencia(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getMagia()==15);
		h.AsignarPuntosSkills(0, 0, 10);
		Assert.assertTrue(h.getMagia()>15);
	}
	
}
