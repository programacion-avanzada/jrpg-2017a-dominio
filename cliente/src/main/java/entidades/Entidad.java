package entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.Juego;
import recursos.Recursos;
import entidades.Animacion;

public class Entidad {

	Juego juego;
	
	// Tamaño de la entidad
	private int tamAncho;
	private int tamAlto;
	
	// Posiciones
	private double x;
	private double y;
	private double xInicio;
	private double yInicio;
	private double xFinal;
	private double yFinal;
	private int posMouse[];

	// Calculo de movimiento
	private double difX;
	private double difY;
	private double relacion;
	
	// Posicion final
	private int auxX;
	private int auxY;

	// Movimiento Actual
	private boolean enMovimiento;
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;

	
	// Animaciones
	private final Animacion moverIzq;
	private final Animacion moverArribaIzq;
	private final Animacion moverArriba;
	private final Animacion moverArribaDer;
	private final Animacion moverDer;
	private final Animacion moverAbajoDer;
	private final Animacion moverAbajo;
	private final Animacion moverAbajoIzq;
	
	public Entidad(Juego juego, int tamAncho, int tamAlto) {
		this.juego = juego;
		x = 100;
		y = 100;
		this.tamAncho = tamAncho;
		this.tamAlto = tamAlto;
		
		moverIzq = new Animacion(200, Recursos.guerreroIzq); 
		moverArribaIzq = new Animacion(200, Recursos.guerreroArribaIzq);
		moverArriba = new Animacion(200, Recursos.guerreroArriba);
		moverArribaDer = new Animacion(200, Recursos.guerreroArribaDer);
		moverDer = new Animacion(200, Recursos.guerreroDer);
		moverAbajoDer = new Animacion(200, Recursos.guerreroAbajoDer);
		moverAbajo = new Animacion(200, Recursos.guerreroAbajo);
		moverAbajoIzq = new Animacion(200, Recursos.guerreroAbajoIzq);
	}

	public void actualizar() {
		moverIzq.actualizar();
		moverArribaIzq.actualizar();
		moverArriba.actualizar();
		moverArribaDer.actualizar();
		moverDer.actualizar();
		moverAbajoDer.actualizar();
		moverAbajo.actualizar();
		moverAbajoIzq.actualizar();
		getEntrada();
		mover();
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
			
			if (difX < tamAncho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < tamAncho && xInicio != xFinal) {
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
	
	public void graficar(Graphics g) {
		g.drawImage(getFrameAnimacionActual(), (int) x, (int) y, tamAncho, tamAlto, null);
	}
	
	private BufferedImage getFrameAnimacionActual() {
		if(horizontal && x > xFinal) {
			return moverIzq.getFrameActual();
		} else if(horizontal && x < xFinal) {
			return moverDer.getFrameActual();
		} else if(vertical && y > yFinal) {
			return moverArriba.getFrameActual();
		} else if(vertical && y < yFinal) {
			return moverAbajo.getFrameActual();
		} else if(diagonalInfIzq) {
			return moverAbajoIzq.getFrameActual();
		} else if(diagonalInfDer) {
			return moverAbajoDer.getFrameActual();
		} else if(diagonalSupIzq) {
			return moverArribaIzq.getFrameActual();
		} else if(diagonalSupDer) {
			return moverArribaDer.getFrameActual();
		}
		
		return Recursos.guerreroAbajo[0];
	}
}
