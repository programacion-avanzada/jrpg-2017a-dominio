package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilitarias {

	public static String archivoAString(String path) {
		StringBuilder builder = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String linea;

			while ((linea = br.readLine()) != null) {
				builder.append(linea + System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static int parseInt(String numero) {
		try {
			return Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
