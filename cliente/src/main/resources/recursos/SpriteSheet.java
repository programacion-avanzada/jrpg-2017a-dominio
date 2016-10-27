package recursos;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sprite;
	
	public SpriteSheet(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public BufferedImage getTile(int x, int y, int ancho, int alto) {
		return sprite.getSubimage(x, y, ancho, alto);
	}
}