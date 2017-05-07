package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getSalud(), 105);
		Assert.assertEquals(h.getEnergia(), 105);
		Assert.assertEquals(h.getFuerza(), 15);
		Assert.assertEquals(h.getDestreza(), 10);
		Assert.assertEquals(h.getInteligencia(), 10);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(h2.getSalud(), 105);
		Assert.assertEquals(h2.getEnergia(), 105);
		Assert.assertEquals(h2.getFuerza(), 10);
		Assert.assertEquals(h2.getDestreza(), 10);
		Assert.assertEquals(h2.getInteligencia(), 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertEquals(h3.getSalud(), 105);
		Assert.assertEquals(h3.getEnergia(), 105);
		Assert.assertEquals(h3.getFuerza(), 10);
		Assert.assertEquals(h3.getDestreza(), 15);
		Assert.assertEquals(h3.getInteligencia(), 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(e.getSalud(), 100);
		Assert.assertEquals(e.getEnergia(), 110);
		Assert.assertEquals(e.getFuerza(), 15);
		Assert.assertEquals(e.getDestreza(), 10);
		Assert.assertEquals(e.getInteligencia(), 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(e2.getSalud(), 100);
		Assert.assertEquals(e2.getEnergia(), 110);
		Assert.assertEquals(e2.getFuerza(), 10);
		Assert.assertEquals(e2.getDestreza(), 10);
		Assert.assertEquals(e2.getInteligencia(), 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertEquals(e3.getSalud(), 100);
		Assert.assertEquals(e3.getEnergia(), 110);
		Assert.assertEquals(e3.getFuerza(), 10);
		Assert.assertEquals(e3.getDestreza(), 15);
		Assert.assertEquals(e3.getInteligencia(), 10);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(o.getSalud(), 110);
		Assert.assertEquals(o.getEnergia(), 100);
		Assert.assertEquals(o.getFuerza(), 15);
		Assert.assertEquals(o.getDestreza(), 10);
		Assert.assertEquals(o.getInteligencia(), 10);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(o2.getSalud(), 110);
		Assert.assertEquals(o2.getEnergia(), 100);
		Assert.assertEquals(o2.getFuerza(), 10);
		Assert.assertEquals(o2.getDestreza(), 10);
		Assert.assertEquals(o2.getInteligencia(), 15);

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertEquals(o3.getSalud(), 110);
		Assert.assertEquals(o3.getEnergia(), 100);
		Assert.assertEquals(o3.getFuerza(), 10);
		Assert.assertEquals(o3.getDestreza(), 15);
		Assert.assertEquals(o3.getInteligencia(), 10);
	}
	@Test
	public void testSettersGettersHabilidadesRaza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		String [] v = new String[2];
		v[0] = "Incentivar";
		v[1] = "Golpe Fatal";
		Assert.assertArrayEquals(v, h.getHabilidadesRaza());
	}
	@Test
	public void testSettersGettersNombreRaza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setNombreRaza("Prueba");
		Assert.assertEquals("Prueba", h.getNombreRaza());
	}
	@Test
	public void testSettersGettersNombre(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setNombre("Obama");
		Assert.assertEquals("Obama", h.getNombre());
	}
	@Test
	public void testSettersGettersMagia(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setMagia(69);
		Assert.assertEquals(69, h.getMagia());
	}
	@Test
	public void testSettersGettersCasta(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setCasta(new Hechicero());
		Assert.assertEquals("Hechicero", h.getCasta().getNombreCasta());
	}
	@Test
	public void testSettersGettersExperiencia(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setExperiencia(1000);
		Assert.assertEquals(1000, h.getExperiencia());
	}
	@Test
	public void testSettersGettersNivel(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setNivel(25);
		Assert.assertEquals(25, h.getNivel());
	}
	@Test
	public void testSettersGettersID(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setIdPersonaje(33);
		Assert.assertEquals(33, h.getIdPersonaje());
	}
	@Test
	public void testSettersGettersSaludTope(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setSaludTope(255);
		Assert.assertEquals(255, h.getSaludTope());
	}
	@Test
	public void testSettersGettersEnergiaTope(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergiaTope(255);
		Assert.assertEquals(255, h.getEnergiaTope());
	}
	@Test
	public void testSettersGettersHabilidadesCasta(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		String aux [] = h.getHabilidadesCasta();
		Assert.assertArrayEquals(aux,h.getHabilidadesCasta());
	}
	
	@Test
	public void testDsitancia(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(0,h.distanciaCon(h2),0.0001);	
	}
	@Test
	public void testPuedeAtacar(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergia(100);
		Assert.assertTrue(h.puedeAtacar());
	}
	@Test
	public void testNoPuedeAtacar(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergia(0);
		Assert.assertFalse(h.puedeAtacar());
	}
	@Test
	public void testRestablecerSalud(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setSalud(1);
		Assert.assertEquals(h.getSalud(), 1);		
		h.restablecerSalud();
		Assert.assertEquals(h.getSalud(), h.getSaludTope());
	}
	@Test
	public void testRestablecerEnergia(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergia(1);
		Assert.assertEquals(h.getEnergia(), 1);		
		h.restablecerEnergia();
		Assert.assertEquals(h.getEnergia(), h.getEnergiaTope());
	}
	@Test
	public void testSerAtacadoyEsquivar(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h2.setSalud(200);
		h2.getCasta().setProbabilidadEvitarDano(1);
		h.atacar(h2);
		Assert.assertEquals(200, h2.getSalud());
	}
	@Test
	public void testSerAtacadoyNoRecibirDaño(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h2.setSalud(200);
		h2.getCasta().setProbabilidadEvitarDano(0);
		h.setAtaque(0);
		h.atacar(h2);
		Assert.assertEquals(200, h2.getSalud());
	}
	@Test
	public void testSerAtacadoyRecibirDaño(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h2.setSalud(200);
		h2.getCasta().setProbabilidadEvitarDano(0);
		h.setAtaque(100);
		h.atacar(h2);
		Assert.assertEquals(125, h2.getSalud());
	}
	@Test
	public void testAtacar(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h.getCasta().setProbabilidadGolpeCritico(1);
		Assert.assertEquals(30, h.atacar(h2),0.0001);
		
	}
	@Test
	public void testSerRobadoSalud(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(100, h.serRobadoSalud(150));
	}
	@Test
	public void testSerDesenergizado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(100,h.serDesernegizado(150));
	}
	@Test
	public void testNoSerRobadoSalud(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(0, h.serRobadoSalud(0));
	}
	@Test
	public void testNoSerDesenergizado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(0,h.serDesernegizado(0));
	}
	@Test
	public void testSerEnergizado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergia(0);
		h.serEnergizado(2000);
		Assert.assertEquals(h.getEnergia(), h.getEnergiaTope());
	}
	@Test
	public void testCrearAlianza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.crearAlianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso", h.getClan().getNombre());
	}
	@Test
	public void testNoCrearAlianza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		Alianza  a = new Alianza("Los Otros");
		h.crearAlianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso", h.getClan().getNombre());
		h2.setClan(a);
		Assert.assertFalse(h.aliar(h2));
	}
	@Test
	public void testSalirAlianza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.crearAlianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso", h.getClan().getNombre());
		h.salirDeAlianza();
		Assert.assertNull(h.getClan());
	}
	@Test
	public void testNoSalirAlianza(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.salirDeAlianza();
		Assert.assertNull(h.getClan());
	}
	
	@Test
	public void testSettersGettersAtributosCasta(){
		Orco o = new Orco("Hernan", new Asesino(), 3);
		o.getCasta().setDanoCritico(2.5);
		Assert.assertEquals(o.getCasta().getDanoCritico(), 2.5,0.0001);
		o.getCasta().setProbabilidadEvitarDano(0.5);
		Assert.assertEquals(o.getCasta().getProbabilidadEvitarDano(),0.5,0.0001);
		o.getCasta().setProbabilidadGolpeCritico(0.7);
		Assert.assertEquals(o.getCasta().getProbabilidadGolpeCritico(),0.7,0.0001);
		
	}
}
