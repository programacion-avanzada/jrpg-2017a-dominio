package mundo;

import recursos.Recursos;

public class TileRoca extends Tile {
	
	public TileRoca(int id) {
		super(Recursos.roca, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
