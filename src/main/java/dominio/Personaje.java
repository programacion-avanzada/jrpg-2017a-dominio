
package dominio;

import java.io.Serializable;

public abstract class Personaje extends MadreDeTodo implements Peleable, Serializable {

	private int salud;
	private int energia;
	private static final int CANTHABILIDADESCASTA =3;
	private static final int CANTHABILIDADESRAZA =2;
	private static final int CANTIDADNIVELES = 101;
	private static final int CONSTANTENIVEL = 50;
	private static final int FUERZAINICIAL = 10;
	private static final int DEFENSAINICIAL = 10;
	private static final int NIVELINICIAL = 1;
	private static final int SALUDTOPEINICIAL = 100;
	private static final int ENERGIATOPEINICIAL = 100;
	private static final int FUERZAMAXIMA = 200;
	private static final int DEFENSAMAXIMA = 200;
	private static final int INTELIGENCIAMAXIMA = 200;
	private static final int NIVELMAXIMO = 100;
	private static final int SALUDTOPESUBIRN = 25;
	private static final int ENERGIATOPESUBIRN = 20;
	private static final double MULTIPLICADORFZA = 1.5;
	private static final double MULTIPLICADORMGA = 1.5;
	private static final int MULTIPLICADOREXP = 40;
	private static final int ENERGIAMINIMA = 10;
	private static final int DIVISORDEDESTREZA = 1000;

	private int ataque;
	private int magia;


	private String nombreRaza;

	private int saludTope;
	private int energiaTope;


	private int destreza;
	private int inteligencia;
	private Casta casta;

	private int x;
	private int y;

	private int experiencia;


	private int idPersonaje;

	private Alianza clan = null;
	private static int tablaDeNiveles[];

	private String[] habilidadesRaza = new String[CANTHABILIDADESRAZA];
	private String[] habilidadesCasta = new String[CANTHABILIDADESCASTA];
	private String nombreCasta;


	public final String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[CANTIDADNIVELES];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++){
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + CONSTANTENIVEL;
		}
	}
	/** La clase Personaje es la cual posee todos los atributos de los personajes del juego.
	 * Algunos serán completados por las clases hijo (Elfo,Humano,Orco)
	 * como por ejemplo el array habilidadesRaza[] dependiendo de qué instancia es el parámetro casta,
	 * se incrementará en 5 un atributo del personaje
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje y con ella el incremento que tendrá cierto atributo
	 * @param id Identificador del personaje
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		super(FUERZAINICIAL, DEFENSAINICIAL, NIVELINICIAL, nombre);


		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;;
		inteligencia = 10;
		destreza = 10;
		destreza+= casta.recibirDestrezaBonus();
		this.aumentarFuerza(casta.recibirFuerzaBonus());
		inteligencia+= casta.recibirInteligenciaBonus();
		nombreRaza= getNombreRaza();
		nombreCasta= casta.getNombreCasta();
		habilidadesRaza = getHabilidadesRaza();
		habilidadesCasta = casta.getHabilidadesCasta();
		x = 0;
		y = 0;
		saludTope = SALUDTOPEINICIAL + getSaludBonus();
		energiaTope = ENERGIATOPEINICIAL + getEnergiaBonus();
		salud = saludTope;
		energia = energiaTope;
		ataque = this.calcularPuntosDeAtaque();
		this.setDefensa(this.calcularPuntosDeDefensa());
		magia = this.calcularPuntosDeMagia();

	}
	/** La clase Personaje es la cual posee todos los atributos de los personajes del juego.
	 * Algunos serán completados por las clases hijo (Elfo,Humano,Orco) como por ejemplo:
	 * El array habilidadesRaza[], a diferencia del constructor de sólo 3 parámetros,
	 * éste recibe la mayoría de los atributos.
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
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel,
			final int idPersonaje) {
		super(fuerza,destreza,nivel,nombre);

		this.salud = salud;
		this.energia = energia;

		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;


		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.setDefensa(this.calcularPuntosDeDefensa());
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}



	public final void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}



	@Override
	public final int getAtaque() {
		return ataque;
	}

	@Override
	public final void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	@Override
	public final int getMagia() {
		return magia;
	}

	public final void setMagia(final int magia) {
		this.magia = magia;
	}

	public final Alianza getClan() {
		return clan;
	}

	public final void setClan(final Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}

	@Override
	public final int getSalud() {
		return salud;
	}

	public final void setSalud(final int salud) {
		this.salud = salud;
	}

	public final int getEnergia() {
		return energia;
	}

	public final void setEnergia(final int energia) {
		this.energia = energia;
	}



	public final int getDestreza() {
		return destreza;
	}

	public final void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	public final int getInteligencia() {
		return inteligencia;
	}

	public final void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public final Casta getCasta() {
		return casta;
	}

	public final void setCasta(Casta casta) {
		this.casta = casta;
	}

	public final int getExperiencia() {
		return experiencia;
	}

	public final void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}


	public final int getIdPersonaje() {
		return idPersonaje;
	}

	public final void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}



	public final int getSaludTope() {
		return saludTope;
	}

	public final void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public final int getEnergiaTope() {
		return energiaTope;
	}

	public final void setEnergiaTope(int energiaTope) {
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
	 * @return Retorna si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final int atacar(final Peleable atacado) {
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / DIVISORDEDESTREZA) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	public final int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	@Override
	public void despuesDeTurno() {

	}

	public final boolean puedeAtacar() {
		return energia > ENERGIAMINIMA;
	}

	public final int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * MULTIPLICADORFZA);
	}

	public final int calcularPuntosDeDefensa() {
		return (this.getDestreza());
	}

	public final int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORMGA);
	}

	public final void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public final void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public final void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.setDefensa(this.calcularPuntosDeDefensa());
		this.magia = this.calcularPuntosDeMagia();
	}

	@Override
	public final boolean estaVivo() {
		return salud > 0;
	}
	/** Método implementado de la Interface Peleable.
	 * Retornará un valor entero dependiendo del resultado de las comparaciones,
	 * si el número generado con la clase MyRandom es mayor a la probabilidad de evitar daño,
     * La cual depende de la casta del Personaje, entonces no podrá
	 * evitarse el ataque, se descontará el valor del argumento daño al atributo salud.
	 * Si el valor del atributo salud es menor al valor del argumento daño, se procederá a igualar el
	 * atributo salud a 0 y retornar el daño realziado
	 * (que será igual a la salud antes de que esté en 0)
	 * @param daño valor a descontarse del atributo salud
	 * @return Retorna si el Personaje peude ser atacado.
	 */
	@Override
	public final int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.getDefensa();
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

	public final int serRobadoSalud(int daño) {
		daño -= this.getDefensa();
		if (daño <= 0){
			return 0;
		}
		if ((salud - daño) >= 0){
			salud -= daño;
		}
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	public final int serDesernegizado(int daño) {
		daño -= this.getDefensa();
		if (daño <= 0){
			return 0;
		}
		if ((energia - daño) >= 0){
			energia -= daño;
		}
		else {
			daño = energia;
			energia = 0;
		}
		return daño;
	}

	public final void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope){
			this.salud += salud;
		}
		else{
			this.salud = this.saludTope;
		}
	}

	public final void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope){
			this.energia += energia;
		}
		else{
			this.energia = this.energiaTope;
		}
	}

	public final void crearAlianza(final String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	public final void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public final boolean aliar(final Personaje nuevo_aliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else{
			return false;
		}
	}

	public final void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.getFuerza() + fuerza <= FUERZAMAXIMA){
			this.aumentarFuerza(fuerza);;
		}
		if (this.destreza + destreza <= DEFENSAMAXIMA){
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= INTELIGENCIAMAXIMA){
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	public final void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.getNivel() == NIVELMAXIMO) {
			return;
		}
		while (this.getNivel() != NIVELMAXIMO
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.getNivel() + 1];
			this.aumentarNivel();
			this.modificarAtributos();
			this.saludTope += SALUDTOPESUBIRN;
			this.energiaTope += ENERGIATOPESUBIRN;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public final boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	@Override
	public final int otorgarExp() {
		return this.getNivel() * MULTIPLICADOREXP;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public final double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public final boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public final boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public final boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
	public abstract String[] getHabilidadesRaza();
	public abstract int getSaludBonus();
	public abstract int getEnergiaBonus();
	public abstract String getNombreRaza();

}

