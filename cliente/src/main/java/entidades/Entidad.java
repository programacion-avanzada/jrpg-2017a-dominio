package entidades;

import java.awt.Graphics;

import juego.Juego;
import recursos.Recursos;

public class Entidad {

	Juego juego;

	private double x;
	private double y;
	private double xInicio;
	private double yInicio;
	private double xFinal;
	private double yFinal;
	private int posMouse[];

	private double difX;
	private double difY;
	private double relacion;

	private int auxX;
	private int auxY;

	private boolean enMovimiento;

	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;

	public Entidad(Juego juego) {
		this.juego = juego;
		x = 100;
		y = 100;
	}

	public void actualizar() {
		getEntrada();
		mover();
	}

	public void graficar(Graphics g) {
		g.drawImage(Recursos.prueba, (int) x, (int) y, 32, 32, null);
	}

	public void getEntrada() {

		posMouse = juego.getHandlerMouse().getPosMouse();

		if (juego.getHandlerMouse().getNuevoRecorrido()) {
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			x = Math.round(x);
			y = Math.round(y);
			xInicio = x;
			yInicio = y;

			xFinal = posMouse[0];
			yFinal = posMouse[1];

			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}

			System.out.println("Inicio: " + xInicio + " " + yInicio);
			System.out.println("Final: " + xFinal + " " + yFinal);

			if (difX < 32 && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < 32 && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			juego.getHandlerMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		}
	}

	public void mover() {

		if (enMovimiento && (x != xFinal || y != yFinal)) {

			if (vertical) {
				if (yFinal > y) {
					y++;
				} else {
					y--;
				}
			}

			if (horizontal) {
				if (xFinal > x) {
					x++;
				} else {
					x--;
				}
			}

			if (diagonalInfDer) {
				x += relacion;
				y++;
			} else if (diagonalInfIzq) {
				x -= relacion;
				y++;
			} else if (diagonalSupDer) {
				x += relacion;
				y--;
			} else if (diagonalSupIzq) {
				x -= relacion;
				y--;
			}

			auxX = (int) Math.round(x);
			auxY = (int) Math.round(y);

			if (horizontal || vertical) {
				if (auxX == xFinal) {
					horizontal = false;
				}

				if (auxY == yFinal) {
					vertical = false;
				}
			}

			if (auxX == xFinal && auxY == yFinal) {
				diagonalInfIzq = false;
				diagonalInfDer = false;
				diagonalSupIzq = false;
				diagonalSupDer = false;
				enMovimiento = false;
			}
		}
	}
}
