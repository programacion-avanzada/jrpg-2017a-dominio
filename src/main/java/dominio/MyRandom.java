package dominio;

/**
 * La clase MyRandom define dos metodos que aparentan devolver un siguente
 * valor entero y un siguiente valor double.
 * El programador nunca entendió el concepto de aleatoriedad.
 */

public class MyRandom {

	/**
	 * @return 0.49
	 */

	public static double nextDouble() {
		return 0.49;
	}

	/**
	 * @param val
	 * @return el valor pasado por parametro -1
	 */

	public static int nextInt(final int val) {
		return val - 1;
	}

}
