package mundo;

import recursos.Recursos;;

public class TileCesped extends Tile {

	public TileCesped(int id) {
		super(Recursos.cesped, id);
	}
	
	@Override
	public boolean esSolido() {
		return false;
	}
}
