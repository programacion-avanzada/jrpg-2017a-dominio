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
  public void testNPC() {
    int dificultadNPC = 0;
    if (dificultadNPC == 0) {
      NonPlayableCharacter a = new NonPlayableCharacter("C", 23, dificultadNPC);
      Assert.assertTrue(a.getFuerza() == (10 + ((23 - 1) * 3)));
      Assert.assertTrue(a.getSalud() == (30 + ((23 - 1) * 15)));
      Assert.assertTrue(a.getDefensa() == (2 + ((23 - 1) * 1)));

    }

    dificultadNPC = 1;
    if (dificultadNPC == 1) {
      NonPlayableCharacter b = new NonPlayableCharacter("A", 23, dificultadNPC);
      Assert.assertTrue(b.getFuerza() == (20 + ((23 - 1) * 6)));
      Assert.assertTrue(b.getSalud() == (40 + ((23 - 1) * 20)));
      Assert.assertTrue(b.getDefensa() == (5 + ((23 - 1) * 2)));
    }

    dificultadNPC = 2;
    if (dificultadNPC == 2) {
      NonPlayableCharacter c = new NonPlayableCharacter("B", 23, dificultadNPC);
      Assert.assertTrue(c.getFuerza() == (30 + ((23 - 1) * 10)));
      Assert.assertTrue(c.getSalud() == (50 + ((23 - 1) * 25)));
      Assert.assertTrue(c.getDefensa() == (4 + ((23 - 1) * 4)));
    }
    NonPlayableCharacter d = new NonPlayableCharacter("A", 23, dificultadNPC);
    d.setFuerza(66);
    Assert.assertTrue(d.getFuerza() == 66);

    d.setNombre("asda");
    Assert.assertTrue(d.getNombre().equals("asda"));

    d.setNivel(66);
    Assert.assertTrue(d.getNivel() == 66);

    d.setDefensa(66);
    Assert.assertTrue(d.getDefensa() == 66);

    d.setSalud(66);
    Assert.assertTrue(d.getSalud() == 66);

  }
}
