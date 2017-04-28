package dominio;

import java.io.Serializable;

public abstract class Personaje extends MadreDeTodo implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	//protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	//protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	//protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;
	
	protected int experiencia;
	//protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}
	/**
	 * La clase Personaje es la cual posee todos los atributos de los personajes del juego, algunos
	 * serán completados por las clases hijo (Elfo,Humano,Orco) como por ejemplo el array habilidadesRaza[]
	 * dependiendo de qué instancia es el parámetro casta, se incrementará en 5 un atributo del personaje
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje y con ella el incremento que tendrá cierto atributo
	 * @param id Identificador del personaje
	 */
	public Personaje(String nombre, Casta casta, int id) {
		super(10,10,1,nombre);
		//this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		//nivel = 1;
		//fuerza = 10;
		inteligencia = 10;
		destreza = 10;
//		if (casta instanceof Guerrero)
//			fuerza += 5;
//		if (casta instanceof Hechicero)
//			inteligencia += 5;
//		if (casta instanceof Asesino)
//			destreza += 5;
		casta.recibirAtributo(this);

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}
	/**
	 * La clase Personaje es la cual posee todos los atributos de los personajes del juego, algunos serán 
	 * completados por las clases hijo (Elfo,Humano,Orco) como por ejemplo el array habilidadesRaza[]
	 * A diferencia del constructor de sólo 3 parámetros, éste recibe la mayoría de los atributos
	 * @param nombre Nombre del personaje
	 * @param salud Salud del personaje
	 * @param energia Energia del personaje
	 * @param fuerza Fuerza del Personaje
	 * @param destreza Destreza del personaje
	 * @param inteligencia Inteligencia del personaje
	 * @param casta Casta(Raza) del personaje 
	 * @param experiencia Experiencia del personaje
	 * @param nivel Nivel del personaje 
	 * @param idPersonaje Id del personaje
	 */
	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
		super(fuerza,destreza,nivel,nombre);
		//this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		//this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		//this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}

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

//	public int getFuerza() {
//		return fuerza;
//	}

//	public void setFuerza(int fuerza) {
//		this.fuerza = fuerza;
//	}

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

//	public int getNivel() {
//		return nivel;
//	}
//
//	public void setNivel(int nivel) {
//		this.nivel = nivel;
//	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

//	public int getDefensa() {
//		return defensa;
//	}
//
//	public void setDefensa(int defensa) {
//		this.defensa = defensa;
//	}

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
	 * Método que retorna un entero dependiendo del resultado de las comparaciones entre el Personaje llamador
	 * y el argumento que puede ser instancia de Personaje o de NPC (NonPlayableCharacter)
	 * La probabilidad de golpe critico depende de la casta del Personaje y de la destreza del mismo
	 * Si la probabilidad junto con la destreza es mayor o igual al número generado de manera aleatorea entonces
	 * se atacará con golpe crítico, de lo contrario sera atacado con el valor del atributo ataque
	 * Retornará 0 si la salud del Personaje llamador es 0 o si el atacado posee una salud menor a 0
	 * @param atacado Instancia de Persona o NPC la cual será atacada
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

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return energia > 10;
	}

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	public boolean estaVivo() {
		return salud > 0;
	}
	/**
	 * Método implementado de la Interface Peleable, retornará un valor entero dependiendo del 
	 * resultado de las comparaciones, si el número generado con la clase MyRandom es mayor a
	 * la probabilidad de evitar daño la cual depende de la casta del Personaje, entonces no podrá
	 * evitarse el ataque, se descontará el valor del argumento daño al atributo salud.
	 * Si el valor del atributo salud es menor al valor del argumento daño, se procederá a igualar el
	 * atributo salud a 0 y retornar el daño realziado (que será igual a la salud antes de que esté en 0 
	 * @param daño valor a descontarse del atributo salud
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

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;
	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

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

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

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

	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}
