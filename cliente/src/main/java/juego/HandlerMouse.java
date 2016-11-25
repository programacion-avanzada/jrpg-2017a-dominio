package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HandlerMouse implements MouseListener {
	
	private int x;
	private int y;
	private int posMouse[];
	private int posMouseRecorrido[];
	private boolean nuevoRecorrido;
	private boolean nuevoClick;
	
	
	public HandlerMouse() {
		posMouse = new int[2];
		posMouseRecorrido = new int[2];
	}
	
	public void actualizar() {
		//posMouse[0] = x;
		//posMouse[1] = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//x = e.getX();
		//y = e.getY();
		if(e.getButton() == MouseEvent.BUTTON1) {
			posMouse[0] = e.getX();
			posMouse[1] = e.getY();
			nuevoClick = true;
		} else if(e.getButton() == MouseEvent.BUTTON3) {
			posMouseRecorrido[0] = e.getX();
			posMouseRecorrido[1] = e.getY();
			nuevoRecorrido = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	public int[] getPosMouse() {
		return posMouse;
	}
	
	public int[] getPosMouseRecorrido() {
		return posMouseRecorrido;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
	}
	
	public void setNuevoRecorrido(boolean b) {
		nuevoRecorrido = b;
	}

	public boolean getNuevoClick() {
		return nuevoClick;
	}
	
	public void setNuevoClick(boolean b) {
		nuevoClick = b;
	}
}
