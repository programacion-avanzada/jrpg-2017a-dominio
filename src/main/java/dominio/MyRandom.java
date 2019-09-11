package dominio;

import java.util.Random;

/**
 * La clase MyRandom devuelve lo mismo que Random
 */

public class MyRandom extends RandomGenerator {

	private static final double NEXT_DOUBLE = 0.49;

	/**
	 * @return Random.nextDouble
	 */

	public double nextDouble() {
		Random r = new Random();
		return r.nextDouble();
	}

	/**
	 * @param val val
	 * @return Random.nextInt
	 */

	public int nextInt(final int val) {
		Random r = new Random();
		return r.nextInt(val);
	}

}
