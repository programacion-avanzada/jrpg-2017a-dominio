package tests_dominio;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import dominio.Alianza;
import dominio.Humano;
import dominio.Hechicero;
import dominio.Personaje;

public class TestAlianza {

	@Test
	public void testManipularAlianza(){
		Alianza alianza = new Alianza("el clan");
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue("el clan" == alianza.obtenerNombre());

    alianza.añadirPersonaje(h);
    Assert.assertTrue(h == alianza.getAliados().getFirst());

    alianza.eliminarPersonaje(h);
    Assert.assertTrue(0 == alianza.getAliados().size());
	}

  @Test
  public void testSetAliados(){
		Alianza alianza = new Alianza("el clan");
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    LinkedList ll = new LinkedList<Personaje>();

    ll.add(h);
    alianza.setAliados(ll);
    Assert.assertTrue(ll == alianza.getAliados());
	}

}
