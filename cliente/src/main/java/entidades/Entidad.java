package entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteMovimiento;
import mundo.Grafo;
import mundo.Mundo;
import mundo.Nodo;
import recursos.Recursos;
import entidades.Animacion;
import estados.Estado;

public class Entidad {

	Juego juego;

	// Tamaño de la entidad
	private int ancho;
	private int alto;

	// Posiciones
	private float x;
	private float y;
	private float dx;
	private float dy;
	private float xInicio;
	private float yInicio;
	private float xFinal;
	private float yFinal;
	private int xOffset;
	private int yOffset;
	private int drawX;
	private int drawY;
	private int posMouse[];
	private int[] tile;

	// Calculo de movimiento
	private float difX;
	private float difY;
	private float relacion;

	// Posicion final
	private float auxX;
	private float auxY;

	// Movimiento Actual
	private static final int horizontalDer = 4;
	private static final int horizontalIzq = 0;
	private static final int verticalSup = 2;
	private static final int verticalInf = 6;
	private static final int diagonalInfIzq = 7;
	private static final int diagonalInfDer = 5;
	private static final int diagonalSupDer = 3;
	private static final int diagonalSupIzq = 1;
	private int movimientoHacia = 6;
	private boolean enMovimiento;

	// Animaciones
	private LinkedList<BufferedImage[]> animaciones;
	private final Animacion moverIzq;
	private final Animacion moverArribaIzq;
	private final Animacion moverArriba;
	private final Animacion moverArribaDer;
	private final Animacion moverDer;
	private final Animacion moverAbajoDer;
	private final Animacion moverAbajo;
	private final Animacion moverAbajoIzq;

	private final Gson gson = new Gson();
	private int intervaloEnvio = 0;

	// pila de movimiento
	private PilaDeTiles pilaMovimiento;
	private int[] tileActual;
	private int[] tileFinal;
	private int[] tileMoverme;

	private Mundo mundo;
	private int[] tilePersonajes;
	private int idEnemigo;

	public Entidad(Juego juego, Mundo mundo, int ancho, int alto, float spawnX, float spawnY,
			LinkedList<BufferedImage[]> animaciones, int velAnimacion) {
		this.juego = juego;
		this.ancho = ancho;
		this.alto = alto;
		this.mundo = mundo;
		xOffset = ancho / 2;
		yOffset = alto / 2;
		x = (int) (spawnX / 64) * 64;
		y = (int) (spawnY / 32) * 32;

		this.animaciones = animaciones;

		moverIzq = new Animacion(velAnimacion, animaciones.get(0));
		moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
		moverArriba = new Animacion(velAnimacion, animaciones.get(2));
		moverArribaDer = new Animacion(velAnimacion, animaciones.get(3));
		moverDer = new Animacion(velAnimacion, animaciones.get(4));
		moverAbajoDer = new Animacion(velAnimacion, animaciones.get(5));
		moverAbajo = new Animacion(velAnimacion, animaciones.get(6));
		moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(7));
		
		// Informo mi posicion actual
		juego.getUbicacionPersonaje().setPosX(x);
		juego.getUbicacionPersonaje().setPosY(y);
		juego.getUbicacionPersonaje().setDireccion(getDireccion());
		juego.getUbicacionPersonaje().setFrame(getFrame());
	}

	public void actualizar() {
		
		
		if (enMovimiento) {
			moverIzq.actualizar();
			moverArribaIzq.actualizar();
			moverArriba.actualizar();
			moverArribaDer.actualizar();
			moverDer.actualizar();
			moverAbajoDer.actualizar();
			moverAbajo.actualizar();
			moverAbajoIzq.actualizar();
		} else {
			moverIzq.reset();
			moverArribaIzq.reset();
			moverArriba.reset();
			moverArribaDer.reset();
			moverDer.reset();
			moverAbajoDer.reset();
			moverAbajo.reset();
			moverAbajoIzq.reset();
		}

		getEntrada();
		mover();
		
		juego.getCamara().Centrar(this);
	}

	public void getEntrada() {

		posMouse = juego.getHandlerMouse().getPosMouse();

		if (juego.getHandlerMouse().getNuevoRecorrido()) {

			tileMoverme = Mundo.mouseATile(posMouse[0] + juego.getCamara().getxOffset() - xOffset, posMouse[1] + juego.getCamara().getyOffset() - yOffset);

			juego.getHandlerMouse().setNuevoRecorrido(false);

			pilaMovimiento = null;
			
			if (juego.getEstadoJuego().getHaySolicitud()) {
				
				if (posMouse[0] >= 200 && posMouse[0] < 400 && posMouse[1] >= 0 && posMouse[1] <= 25) {
					
					PaqueteBatalla pBatalla = new PaqueteBatalla();
					
					pBatalla.setId(juego.getPersonaje().getId());
					pBatalla.setIdEnemigo(idEnemigo);
					
					juego.getEstadoJuego().setHaySolicitud(false);
					
					try {
						juego.getCliente().getSalida().writeObject(gson.toJson(pBatalla));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			} else {
				
				Iterator<Integer> it = juego.getEscuchaMensajes().getUbicacionPersonajes().keySet().iterator();
				int key;
				PaqueteMovimiento actual;
				while (it.hasNext()) {
					key = (int) it.next();
					actual = juego.getEscuchaMensajes().getUbicacionPersonajes().get(key);
					tilePersonajes = Mundo.mouseATile(actual.getPosX(), actual.getPosY());
					if (actual.getIdPersonaje() != juego.getPersonaje().getId() && 
							juego.getEscuchaMensajes().getPersonajesConectados().get(actual.getIdPersonaje()).getEstado() == Estado.estadoJuego) {
						if (tileMoverme[0] == tilePersonajes[0] && tileMoverme[1] == tilePersonajes[1]) {
							juego.getEstadoJuego().setHaySolicitud(true);
							idEnemigo = actual.getIdPersonaje();
						}
					}
				}
			}

		}

		if (!enMovimiento && tileMoverme != null) {

			enMovimiento = false;

			xInicio = x;
			yInicio = y;

			tileActual = Mundo.mouseATile(x, y);

			if (tileMoverme[0] < 0 || tileMoverme[1] < 0 || tileMoverme[0] >= mundo.obtenerAncho()|| tileMoverme[1] >= mundo.obtenerAlto()) {
				enMovimiento = false;
				juego.getHandlerMouse().setNuevoRecorrido(false);
				pilaMovimiento = null;
				tileMoverme = null;
				return;
			}

			if (tileMoverme[0] == tileActual[0] && tileMoverme[1] == tileActual[1] || mundo.getTile(tileMoverme[0], tileMoverme[1]).esSolido()) {
				tileMoverme = null;
				enMovimiento = false;
				juego.getHandlerMouse().setNuevoRecorrido(false);
				pilaMovimiento = null;
				return;
			}

			if (pilaMovimiento == null)
				pilaMovimiento = caminoMasCorto(tileActual[0], tileActual[1], tileMoverme[0], tileMoverme[1]);

			// Me muevo al primero de la pila
			NodoDePila nodoActualTile = pilaMovimiento.pop();

			if (nodoActualTile == null) {
				enMovimiento = false;
				juego.getHandlerMouse().setNuevoRecorrido(false);
				pilaMovimiento = null;
				tileMoverme = null;
				return;
			}

			tileFinal = new int[2];
			tileFinal[0] = nodoActualTile.obtenerX();
			tileFinal[1] = nodoActualTile.obtenerY();

			xFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[0];
			yFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[1];

			if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] - 1)
				movimientoHacia = verticalSup;

			if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] + 1)
				movimientoHacia = verticalInf;

			if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1] + 1)
				movimientoHacia = horizontalIzq;

			if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1] - 1)
				movimientoHacia = horizontalDer;

			if (tileFinal[0] == tileActual[0] - 1 && tileFinal[1] == tileActual[1])
				movimientoHacia = diagonalSupIzq;

			if (tileFinal[0] == tileActual[0] + 1 && tileFinal[1] == tileActual[1])
				movimientoHacia = diagonalInfDer;

			if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] - 1)
				movimientoHacia = diagonalSupDer;

			if (tileFinal[0] == tileActual[0] && tileFinal[1] == tileActual[1] + 1)
				movimientoHacia = diagonalInfIzq;

			enMovimiento = true;
		}
	}

	public void mover() {

		dx = 0;
		dy = 0;

		double paso = 1;

		if (enMovimiento && !(x == xFinal && y == yFinal - 32)) {
			if (movimientoHacia == verticalSup)
				dy -= paso;
			else if (movimientoHacia == verticalInf)
				dy += paso;
			else if (movimientoHacia == horizontalDer)
				dx += paso;
			else if (movimientoHacia == horizontalIzq)
				dx -= paso;
			else if (movimientoHacia == diagonalInfDer) {
				dx += paso;
				dy += paso / 2;
			} else if (movimientoHacia == diagonalInfIzq) {
				dx -= paso;
				dy += paso / 2;
			} else if (movimientoHacia == diagonalSupDer) {
				dx += paso;
				dy -= paso / 2;
			} else if (movimientoHacia == diagonalSupIzq) {
				dx -= paso;
				dy -= paso / 2;
			}
			
			x += dx;
			y += dy;
			
			// Le envio la posicion
			if (intervaloEnvio == 2) {
				enviarPosicion();
				intervaloEnvio = 0;
			}
			intervaloEnvio++;

			if (x == xFinal && y == yFinal - 32) {
				enMovimiento = false;
			}
		}
	}

	public void graficar(Graphics g) {
		drawX = (int) (x - juego.getCamara().getxOffset());
		drawY = (int) (y - juego.getCamara().getyOffset());
		g.drawImage(getFrameAnimacionActual(), drawX, drawY, ancho, alto, null);
		g.setColor(Color.WHITE);
		//g.drawString("<LosCacheFC>", drawX, drawY);
		//g.drawString(juego.getPersonaje().getNombre(), drawX + 10, drawY - 12);
		Pantalla.centerString(g, new java.awt.Rectangle(drawX + 32, drawY-20, 0, 10), juego.getPersonaje().getNombre());
	}
	

	private BufferedImage getFrameAnimacionActual() {
		if (movimientoHacia == horizontalIzq) {
			return moverIzq.getFrameActual();
		} else if (movimientoHacia == horizontalDer) {
			return moverDer.getFrameActual();
		} else if (movimientoHacia == verticalSup) {
			return moverArriba.getFrameActual();
		} else if (movimientoHacia == verticalInf) {
			return moverAbajo.getFrameActual();
		} else if (movimientoHacia == diagonalInfIzq) {
			return moverAbajoIzq.getFrameActual();
		} else if (movimientoHacia == diagonalInfDer) {
			return moverAbajoDer.getFrameActual();
		} else if (movimientoHacia == diagonalSupIzq) {
			return moverArribaIzq.getFrameActual();
		} else if (movimientoHacia == diagonalSupDer) {
			return moverArribaDer.getFrameActual();
		}

		return Recursos.ogro.get(6)[0];
	}

	private int getDireccion() {
		return movimientoHacia;
	}

	private int getFrame() {
		if (movimientoHacia == horizontalIzq) {
			return moverIzq.getFrame();
		} else if (movimientoHacia == horizontalDer) {
			return moverDer.getFrame();
		} else if (movimientoHacia == verticalSup) {
			return moverArriba.getFrame();
		} else if (movimientoHacia == verticalInf) {
			return moverAbajo.getFrame();
		} else if (movimientoHacia == diagonalInfIzq) {
			return moverAbajoIzq.getFrame();
		} else if (movimientoHacia == diagonalInfDer) {
			return moverAbajoDer.getFrame();
		} else if (movimientoHacia == diagonalSupIzq) {
			return moverArribaIzq.getFrame();
		} else if (movimientoHacia == diagonalSupDer) {
			return moverArribaDer.getFrame();
		}

		return 0;
	}

	private void enviarPosicion() {
		juego.getUbicacionPersonaje().setPosX(x);
		juego.getUbicacionPersonaje().setPosY(y);
		juego.getUbicacionPersonaje().setDireccion(getDireccion());
		juego.getUbicacionPersonaje().setFrame(getFrame());
		try {
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			e.printStackTrace();
		}
	}

	private PilaDeTiles caminoMasCorto(int xInicial, int yInicial, int xFinal, int yFinal) {
		Grafo grafoLibres = mundo.obtenerGrafoDeTilesNoSolidos();
		// Transformo las coordenadas iniciales y finales en indices
		int nodoInicial = (yInicial - grafoLibres.obtenerNodos()[0].obtenerY()) * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal()) 
							+ xInicial - grafoLibres.obtenerNodos()[0].obtenerX();
		
		int nodoFinal = (yFinal - grafoLibres.obtenerNodos()[0].obtenerY()) * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal())
							+ xFinal - grafoLibres.obtenerNodos()[0].obtenerX();

		// Hago todo
		double[] vecCostos = new double[grafoLibres.obtenerCantidadDeNodosTotal()];
		int[] vecPredecesores = new int[grafoLibres.obtenerCantidadDeNodosTotal()];
		boolean[] conjSolucion = new boolean[grafoLibres.obtenerCantidadDeNodosTotal()];
		int cantSolucion = 0;
		// Lleno la matriz de costos de numeros grandes
		for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
			vecCostos[i] = Double.MAX_VALUE;
		}
		// Adyacentes al nodo inicial
		conjSolucion[nodoInicial] = true;
		cantSolucion++;
		vecCostos[nodoInicial] = 0;
		Nodo[] adyacentes = grafoLibres.obtenerNodos()[nodoInicial].obtenerNodosAdyacentes();
		for (int i = 0; i < grafoLibres.obtenerNodos()[nodoInicial].obtenerCantidadDeAdyacentes(); i++) {
			if (estanEnDiagonal(grafoLibres.obtenerNodos()[nodoInicial], grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()]))
				vecCostos[adyacentes[i].obtenerIndice()] = 1.5;
			else
				vecCostos[adyacentes[i].obtenerIndice()] = 1;
			vecPredecesores[adyacentes[i].obtenerIndice()] = nodoInicial;
		}
		// Aplico Dijkstra
		while (cantSolucion < grafoLibres.obtenerCantidadDeNodosTotal()) {
			// Elijo W perteneciente al conjunto restante tal que el costo de W
			// sea minimo
			double minimo = Double.MAX_VALUE;
			int indiceMinimo = 0;
			Nodo nodoW = null;
			for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
				if (!conjSolucion[i] && vecCostos[i] < minimo) {
					nodoW = grafoLibres.obtenerNodos()[i];
					minimo = vecCostos[i];
					indiceMinimo = i;
				}
			}
			// Pongo a W en el conj solucion
			conjSolucion[indiceMinimo] = true;
			cantSolucion++;
			// Por cada nodo I adyacente a W del conj restante
			// Le sumo 1 al costo de ir hasta W y luego ir hasta su adyacente
			adyacentes = grafoLibres.obtenerNodos()[indiceMinimo].obtenerNodosAdyacentes();
			for (int i = 0; i < grafoLibres.obtenerNodos()[indiceMinimo].obtenerCantidadDeAdyacentes(); i++) {
				double valorASumar = 1;
				if (estanEnDiagonal(grafoLibres.obtenerNodos()[indiceMinimo],
						grafoLibres.obtenerNodos()[adyacentes[i].obtenerIndice()]))
					valorASumar = 1.5;
				if (vecCostos[indiceMinimo] + valorASumar < vecCostos[adyacentes[i].obtenerIndice()]) {
					vecCostos[adyacentes[i].obtenerIndice()] = vecCostos[indiceMinimo] + valorASumar;
					vecPredecesores[adyacentes[i].obtenerIndice()] = indiceMinimo;
				}
			}
		}
		// Creo el vector de nodos hasta donde quiere llegar
		PilaDeTiles camino = new PilaDeTiles();
		while (nodoFinal != nodoInicial) {
			camino.push(new NodoDePila(grafoLibres.obtenerNodos()[nodoFinal].obtenerX(), grafoLibres.obtenerNodos()[nodoFinal].obtenerY()));
			nodoFinal = vecPredecesores[nodoFinal];
		}
		
		return camino;
	}

	private boolean estanEnDiagonal(Nodo nodoUno, Nodo nodoDos) {
		if (nodoUno.obtenerX() == nodoDos.obtenerX() || nodoUno.obtenerY() == nodoDos.obtenerY())
			return false;
		return true;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getxOffset() {
		return xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}
}
