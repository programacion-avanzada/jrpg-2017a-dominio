package mundo;

import recursos.Recursos;

public class TileFuego extends Tile {
	
	public TileFuego(int id) {
		super(Recursos.fuego, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
