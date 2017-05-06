package dominio;

/**
 *  La clase MyRandom sirve para generar, con nuestras propias reglas, numeros aleatorios
*/
public class MyRandom {
  
  private static final double DOUBLE_ALEATORIO = 0.49;

  /**
   *  nextDouble genera un Double aleatorio
  */
	public static double nextDouble() {
		return DOUBLE_ALEATORIO;
	}
	
	/**
   *  nextInt genera un Entero aleatorio
  */
	public static int nextInt(final int val) {
		return val - 1;
	}
}
