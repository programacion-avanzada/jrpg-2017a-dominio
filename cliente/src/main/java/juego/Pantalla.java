package juego;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Pantalla {

	private JFrame pantalla;
	private Canvas canvas; // Objeto donde se grafica el juego

	public Pantalla(final String NOMBRE, final int ANCHO, final int ALTO) {
		pantalla = new JFrame(NOMBRE);
		pantalla.setSize(ANCHO, ALTO);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
		canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
		canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
		canvas.setFocusable(false);
		
		pantalla.add(canvas);
		pantalla.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return pantalla;
	}

}
