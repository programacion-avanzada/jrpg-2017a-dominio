package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.*;

public class TestAtaqueCritico {

private ArrayList<Item> l;
	
	@Before
	public void initialize(){
		l = new ArrayList<Item>();
	}
	
	@Test
	public void testgolpeCrit(){
		Humano h = new Humano("Nicolas",new Guerrero(),1,l);
		Assert.assertEquals(h.getAtaque()*1.5, h.golpeCritico(), 1);
	}
}
