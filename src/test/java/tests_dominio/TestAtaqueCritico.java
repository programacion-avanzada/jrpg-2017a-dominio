package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestAtaqueCritico {

	@Test
	public void testgolpeCrit(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertEquals(h.getAtaque()*1.5, h.golpeCritico(), 1);
	}
}
