package dominio;

import java.io.Serializable;

/**
 * La clase Personaje contiene los atributos de cada jugador.
 * Entre ellos se destacan los de ataque y defensa, salud, posicion,
 * nivel y nombre. Ademas posee una casta y una raza, ambas conteniendo
 * una serie de habilidades especiales.
 * Además implementa la interfaz Peleable por lo que debe implementar sus métodos.
 */

public abstract class Personaje implements Peleable, Serializable {

	protected static final int ENERGIA_MAXIMA = 10;

	/**
	 * Attributos de la clase.
	 */

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	/**
	 * Getters para las habilidades de casta y raza.
	 */

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * Inicialización de la tabla de nieveles del juego.
	 */

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	/**
	 * Constructor de la clase con valores por defecto.
	 * Recibe el nombre, la casta y el id de personaje.
	 */

	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	/**
	 * Constructor de la clase con valores pasados por parámetro.
	 * Los atributos defensa ataque y magia son calculados.
	 */

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Getters y setters para los atributos
	 */

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * "atacar" obtiene el ataque de este objeto e invoca al método serAtacado
	 * del "atacado" recibido como parametro.
	 */

	public int atacar(Peleable atacado) {
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/**
	 * Calculo del valor del golpe critico basado en el ataque y el daño de
	 * la casta.
	 */

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}

	/**
	 * Verifica que el personaje pueda atacar.
	 */

	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * Calculo de los puntos de ataque del personaje.
	 * Función lineal de la fuerza.
	 */

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	/**
	 * Calculo de los puntos de defensa.
	 * La parte entera del atributo destreza.
	 */

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * Calculo de los puntos de magia.
	 * Función lineal de la inteligencia.
	 */

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	/**
	 * Carga la salud del personaje hasta el tope.
	 */

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	/**
	 * Carga la energia del personaje hasta el tope.
	 */

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/**
	 * Recalcula el ataque, la defensa y la magia del personaje.
	 */

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/**
	 * Checker para ver si el personaje vive o no.
	 */

	public boolean estaVivo() {
		return salud > 0;
	}

	/**
	 * Aplica un daño sobre la salud. Devuelve 0 si no es dañado o
	 * el valor del daño ocasionado por el ataque.
	 */

	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
				}
				return daño;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Aplica un daño a la salud y devuelve la cantidad del
	 * mismo que se ha inflingido.
	 */

	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((salud - daño) >= 0)
			salud -= daño;
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	/**
	 * Aplica daño a la energia y devuelve la cantidad del
	 * mismo que se ha inflingido.
	 */

	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

	/**
	 * Aumenta la salud del personaje.
	 */

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}

	/**
	 * Aumenta la energia del personaje.
	 */

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	/**
	 * Crea una nueva alianza entre personajes y agregar
	 * al objeto como el primer integrante.
	 */

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	/**
	 * Elimina al personaje del clan al que pertenece.
	 */

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * Convierte a un personaje recibido por parámetro en el aliado de
	 * este personaje. Crea una nueva alianza si no existe.
	 */

	public boolean aliar(Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			return false;
	}

	/**
	 * Aumenta fuerza, destreza e inteligencia siempre que el total
	 * sea menor a 200.
	 */

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	/**
	 * Aumenta el nivel del personaje y recalcula sus atributos.
	 */

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/**
	 * Aumenta la experiencia del personaje y lo sube de nivel
	 * llegado el caso.
	 */

	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/**
	 * Aumenta el nivel del personaje 40 veces.
	 */

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Calcula la distancia con otro personaje.
	 */

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/**
	 * Invoca al metodo habilidad 1 de la casta.
	 */

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**
	 * Invoca al metodo habilidad 2 de la casta.
	 */

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/**
	 * Invoca al metodo habilidad 3 de la casta.
	 */

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**
	 * Metodos que serán implementados en las clases que hereden de esta.
	 */

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}
