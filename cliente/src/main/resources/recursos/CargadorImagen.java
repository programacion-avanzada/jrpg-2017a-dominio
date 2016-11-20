package recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import juego.Juego;

public class CargadorImagen {

	public static BufferedImage cargarImagen(String path) {
		try {
			return  ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el archivo " + path);
			e.printStackTrace();
		}

		return null;
	}
}
