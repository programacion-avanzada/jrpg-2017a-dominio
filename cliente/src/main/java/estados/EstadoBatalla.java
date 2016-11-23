package estados;

import java.awt.Graphics;

import juego.Juego;

public class EstadoBatalla extends Estado{

	public EstadoBatalla(Juego juego) {
		super(juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void graficar(Graphics g) {
		// TODO Auto-generated method stub
		g.fill3DRect(0, 0, juego.getAncho(), juego.getAlto(), false);
	}

}
