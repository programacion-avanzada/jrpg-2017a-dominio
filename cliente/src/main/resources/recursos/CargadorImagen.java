package recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CargadorImagen {

	public static BufferedImage cargarImagen(String path) {
		try {
			return ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
