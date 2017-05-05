package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Personaje;

public class TestAlianza {

  @Test
  public void testAlianza() {
    LinkedList<Elfo> aliados = new LinkedList<Elfo>();
    aliados.add(new Elfo("elfito", new Guerrero(1, 2, 3), 34));
    Alianza a = new Alianza("miAlianza");
    Assert.assertNotNull(a.getAliados());
  }

  @Test
  public void testGetNombreNoNull() {
    LinkedList<Personaje> aliados = new LinkedList<Personaje>();
    aliados.add(new Elfo("elfito", new Guerrero(1, 2, 3), 34));
    Alianza a = new Alianza("miAlianza");
    Assert.assertTrue(a.obtenerNombre().equals("miAlianza"));
    // Assert.assertNotNull(a.getAliados());
  }

  @Test
  public void testGetNombreIsNull() {
    LinkedList<Personaje> aliados = new LinkedList<Personaje>();
    aliados.add(new Elfo("elfito", new Guerrero(1, 2, 3), 34));
    Alianza a = new Alianza(null);
    Assert.assertNull(a.obtenerNombre());
    // Assert.assertNotNull(a.getAliados());
  }

  @Test
  public void testSetAlianza() {
    LinkedList<Personaje> aliados = new LinkedList<Personaje>();
    aliados.add(new Elfo("elfito", new Guerrero(1, 2, 3), 34));
    Alianza a = new Alianza("miAlianza");
    a.setAliados(aliados);
    Assert.assertNotNull(a.getAliados());
  }

  // Para el caso positivo y negativo el Coverage test no incrementa.
  @Test
  public void testSetAlianzaNull() {
    Alianza a = new Alianza("miAlianza");
    a.setAliados(null);
    Assert.assertNull(a.getAliados());
  }

}
