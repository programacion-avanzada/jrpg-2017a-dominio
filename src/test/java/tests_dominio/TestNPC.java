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
    NonPlayableCharacter a = new NonPlayableCharacter("C", 23, dificultadNPC);
    Assert.assertTrue(a.getFuerza() == (10 + ((23 - 1) * 3)));

    dificultadNPC = 1;
    NonPlayableCharacter b = new NonPlayableCharacter("A", 23, dificultadNPC);
    Assert.assertTrue(b.getFuerza() == (20 + ((23 - 1) * 6)));

    dificultadNPC = 2;
    NonPlayableCharacter c = new NonPlayableCharacter("B", 23, dificultadNPC);
    Assert.assertTrue(c.getFuerza() == (30 + ((23 - 1) * 10)));
  }
}
