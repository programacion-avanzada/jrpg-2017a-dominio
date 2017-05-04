
package dominio;

import java.io.Serializable;

public abstract class Personaje extends MadreDeTodo implements Peleable, Serializable {

	private int salud;
	private int energia;
	private static final int CANTHABILIDADESCASTA = 3;
	private static final int CANTHABILIDADESRAZA = 2;
	private static final int CANTIDADNIVELES = 101;
	private static final int CONSTANTENIVEL = 50;
	private static final int FUERZAINICIAL = 10;
	private static final int DESTREZAINICIAL = 10;
	private static final int INTELIGENCIANICIAL = 10;
	private static final int DEFENSAINICIAL = 10;
	private static final int EXPERIENCIAINICIAL = 0;
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
	private static final int POSXI = 0;
	private static final int POSYI = 0;

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
	private static int[] tablaDeNiveles;

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
		for (int i = 2; i < CANTIDADNIVELES; i++) {
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
		experiencia = EXPERIENCIAINICIAL;
		inteligencia = INTELIGENCIANICIAL;
		destreza = DESTREZAINICIAL;
		destreza += casta.recibirDestrezaBonus();
		this.aumentarFuerza(casta.recibirFuerzaBonus());
		inteligencia += casta.recibirInteligenciaBonus();
		nombreRaza = getNombreRaza();
		nombreCasta = casta.getNombreCasta();
		habilidadesRaza = getHabilidadesRaza();
		habilidadesCasta = casta.getHabilidadesCasta();
		x = POSXI;
		y = POSYI;
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
		super(fuerza, destreza, nivel, nombre); 

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




	/**Retorna un entero con el ataque del personaje. 
	 * @return Ataque del personaje.
	 */

	@Override
	public final int getAtaque() {
		return ataque;
	}
	/**Metodo void que sobreescribe el atributo de ataque
	 * con el parametro enviado.
	 * @param Ataque nuevo valor del ataque del peronaje.
	 */

	@Override
	public final void setAtaque(final int ataque) {
		this.ataque = ataque;
	}
	
	/**Retorna un enetro con la magia del personaje.
	 * @return Magia del personaje.
	 */

	@Override
	public final int getMagia() {
		return magia;
	}
	
	/**Metodo void que sobreescribe el atributo de magia
	 * con el parámatero.
	 * @param Nuevo valor de magia del personaje.
	 */
	public final void setMagia(final int magia) {
		this.magia = magia;
	}
	/**Retorna un String con la alianza del personaje
	 * @return Alianza del personaje.
	 */
	public final Alianza getClan() {
		return clan;
	}
	/**Metodo void que sobreescribe el atributo clan y
	 * añade al personaje llamador al clan enviado 
	 * como parámetro.
	 * @param Alianza nueva del personaje.
	 */
	public final void setClan(final Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}
	/**Retorna entero con la salud del personaje
	 * @return Salud del personaje
	 */
	@Override
	public final int getSalud() {
		return salud;
	}
	/**Metodo void que sobreescribe el atributo de la 
	 * salud actual del personaje.
	 * @param Nueva salud actual del personaje
	 */
	public final void setSalud(final int salud) {
		this.salud = salud;
	}
	/**Retorna entero con la energia del personaje
	 * @return Energia del personaje
	 */
	public final int getEnergia() {
		return energia;
	}
	/** Metodo void que sobreescribe la energia con el
	 * parametro enviado.
	 * @param Nueva energia del personaje.
	 */
	public final void setEnergia(final int energia) {
		this.energia = energia;
	}


	/**Retorna un entero con la destreza del personaje
	 * @return Destreza del personaje
	 */
	public final int getDestreza() {
		return destreza;
	}
	/** Metodo void que sobreescribe la destreza del 
	 * personaje con el parametro enviado
	 * @param Nueva destreza del personaje
	 */

	public final void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	/** Retorna un entero con la inteligencia del personaje
	 * @return Inteligencia del personaje
	 */
	public final int getInteligencia() {
		return inteligencia;
	}
	/** Metodo void que sobreescribe la inteligencia del 
	 * personaje con el parametro enviado
	 * @param Nueva inteligencia del personaje
	 */
	public final void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}
	/**Retorna una Casta con la casta del personaje
	 * @return Casta del personaje
	 */
	public final Casta getCasta() {
		return casta;
	}
	/**Metodo void que sobreescribe la Casta del personaje
	 * @param Nueva Casta del personaje
	 */
	public final void setCasta(final Casta casta) {
		this.casta = casta;
	}
	/**Retorna un entero con la experiencia del personaje
	 * 
	 * @return Experiencia del personaje
	 */
	public final int getExperiencia() {
		return experiencia;
	}
	/**Metodo void que sobreescribe la experiencia del 
	 * personaje con el parametro enviado.
	 * @param Nueva experiencia del personaje
	 */
	public final void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}
	/** Retorna un entero con el Id del personaje
	 * @return Identificacion del personaje
	 */
	public final int getIdPersonaje() {
		return idPersonaje;
	}
	/** Metodo void que sobreescribe el Id del personaje
	 * con el paramatro enviado.
	 * @param Nuevo Id del personaje
	 */
	public final void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	/**Retorna un entero con el maximo de salud que tiene 
	 * el personaje
	 * @return saludTope del personaje
	 */
	public final int getSaludTope() {
		return saludTope;
	}
	/**Metodo void que sobreescribe la salud maxima que
	 * puede tener el personaje con el parametro enviado.
	 * @param Nueva saludTope, salud maxima del personaje
	 */
	public final void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}
	/**Retorna un entero con la energia Maxima que puede
	 * tener el personaje.
	 * @return Energia maxima del personaje.
	 * */
	public final int getEnergiaTope() {
		return energiaTope;
	}
	/** Metodo void que sobreescribe la enegria maxima
	 * que el personaje puede terner con el parametro
	 * enviado.
	 * @param Nueva energia maxima del personaje
	 */
	public final void setEnergiaTope(final int energiaTope) {
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
		if (salud == 0) {
			return 0;
		}
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / DIVISORDEDESTREZA) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	/** Metodo que retorna un entero que depende a que casta pertenece el
	 * personaje y que ataque poseaa. El daño critico se obtiene de la clase
	 * casta.
	 * El entero surge de la multiplicacion del ataque del personaje y 
	 * el daño critico de la casta que pertenece. 
	 * 
	 * @return Retorna el golpe critico que puede realizar el personaje.
	 */
	public final int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	@Override
	public void despuesDeTurno() {

	}
	/** Metodo que retorna un boolean si el personaje puede atacar o no.
	 * Devuelve true si la energia es mayor a la ENERGIAMINIMA,  
	 * puede atacar, y falso si la primera es menor a la ENERGIAMINIMA.
	 * ENERGIAMINIMA atributo static de la clase Personaje.
	 * 
	 * @return Si el personaje puede o no atacar.
	 */
	public final boolean puedeAtacar() {
		return energia > ENERGIAMINIMA;
	}
	
	/** Metodo que retorna un entero que representa los puntos de 
	 * ataque que realizara el personaje. Estos puntos dependen de la 
	 * fuerza del personaje y MULTIPLICADORFZA.
	 * MULTIPLICADORFZA atributo static de la clase Personaje.
	 * @return Los puntos de ataque del personaje.
	 */
	public final int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * MULTIPLICADORFZA);
	}
	/**Metodo que retorna un entero con los puntos de defensa.
	 * Estos puntos son iguales a los puntos de destreza
	 * del personaje.
	 * 
	 * @return Los puntos de destreza del personaje.
	 */
	public final int calcularPuntosDeDefensa() {
		return (this.getDestreza());
	}
	
	/**Metodo que retorna un entero con los puntos de magia
	 * del personaje. Estos puntos dependen de la multiplicacion
	 * de la inteligencia del personaje y MULTIPLICADORMGA.
	 * MULTIPLICADORMGA atributo static de la clase Personaje.
	 * 
	 * @return Puntos de magia del personaje
	 */
	public final int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORMGA);
	}

	/** Metodo void que establece la salud actual del personaje 
	 * como la maxima posible que puede tener.
	 */
	public final void restablecerSalud() {
		this.salud = this.saludTope;
	}
	/** Metodo void que establece la energia del personaje
	 * como la maxima posible que puede tener.
	 */
	public final void restablecerEnergia() {
		this.energia = this.energiaTope;
	}
	/** Metodo void que modifica los atributos de ataque,
	 * defensa y magia del personaje.
	 * Ataque depende de la fuerza del personaje y de MULTIPLICADORFZA(constante).
	 * Defensa depende de la destreza.
	 * Magia depende de la inteligencia y de MULTIPLICADORMGA (constante).
	 * 
	 */
	public final void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.setDefensa(this.calcularPuntosDeDefensa());
		this.magia = this.calcularPuntosDeMagia();
	}
	
	/** Metodo que retorna boolean heredado de la interface Peleable.
	 * Si la salud del personaje es mayor a 0 este está vivo.
	 * 
	 * @return Retorna si esta vivo o no el personaje.
	 */
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

	/**Metodo que retorna un entero de los puntos de salud quitados
	 * al personaje. Al daño total recibido se le resta
	 * la defensa del personaje. Si este daño es menor o igual
	 * a la salud del personaje se le quita daño puntos de salud.
	 * Si el daño es mayor a la salud se establece la salud del
	 * personaje en 0.
	 * 
	 * @param Daño causado al personaje
	 * @return Retorna los puntos de vida quitados al personaje
	 */
	public final int serRobadoSalud(int daño) {
		daño -= this.getDefensa(); 
		if (daño <= 0) {
			return 0;
		}
		if ((salud - daño) >= 0) {
			salud -= daño;
			}
		else {
			daño = salud; 
			salud = 0; 
		}
		return daño;
	} 
	/**Metodo que retorna los puntos de energia quitados
	 * al personaje. Al daño total ejercido al personaje
	 * se le resta la defensa del mismo. Si este daño es
	 * menor o igual a la energia del personaje se le
	 * resta al mismo, sino se establece energia como 0.
	 * 
	 * @param Daño causado al personaje
	 * @return Retorna los puntos de energia quitados al personaje.
	 */
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
	/** Metodo void que aumenta la salud actual del personaje.
	 * Si este aumento es mayor al tope, establece como salud
	 * actual la maxima que puede tener el personaje.
	 * 
	 * @param Puntos de salud a sumar al personaje.
	 */
	public final void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		}
		else {
			this.salud = this.saludTope;
		}
	}
	/**Metodo void que aumenta la energia actual del personaje.
	 * Si este aumento es mayor al tope establece como energia
	 * actual la maxima que puede tener el personaje.
	 * 
	 * @param Puntos de energia a sumar al Personaje.
	 */
	public final void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		}
		else {
			this.energia = this.energiaTope;
		}
	}
	/**Metodo void que crea una nueva alianza. Asigna a ésta
	 * al clan actual del personaje y lo añade a la lista de
	 * Personajes que integran la alianza.
	 * 
	 * @param nombre_alianza
	 */
	public final void crearAlianza(final String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}
	/**Metodo void que desvincula al personaje de la alianza
	 * y establece que el personaje no pertenece a ninguna. 
	 * 
	 */
	public final void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}
	/**Metodo que retorna un boolean si pudo añadir un nuevo
	 * aliado a la alianza en la que se encuentra el personaje.
	 * Si el personaje llamador no pertenece a ninguna alianza
	 * se crea una con el nombre "Alianza 1" por defecto. 
	 * Luego se agrega al nuevo aliado enviado como parametro
	 * a la alianza del personaje llamador.
	 * 
	 * @param Personaje que se añadira al clan del llamador
	 * @return	Boolean si pudo agregar al nuevo aliado
	 */
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
		}
		else {
			return false;
		}
	}
	/**Metodo void utilizado para aumentar los puntos
	 * de fuerza, destreza y de inteligencia del personaje.
	 * Nunca estos atributos superan los maximos.
	 * Una vez modificados los atributos mencionados actualiza
	 * los nuevos puntos de ataque,defensa y magia del personaje.
	 * 
	 * @param Nueva fuerza del personaje
	 * @param Nueva destreza del personaje
	 * @param Nueva inteligencia del personaje
	 */
	public final void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.getFuerza() + fuerza <= FUERZAMAXIMA) {
			this.aumentarFuerza(fuerza);
		}
		if (this.destreza + destreza <= DEFENSAMAXIMA) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= INTELIGENCIAMAXIMA) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}
	
	/** Metodo void que aumenta el nivel del personaje
	 * Si ya se encuentra en el nivel maximo no realiza cambios.
	 * Pero si no se alcanzo al nivel maximo se actualizara la salud tope,
	 * la energia tope y el nivel del personaje hasta que su experiencia 
	 * sea menor a la de un nivel preestablecido. Luego se le descuenta 
	 * al atributo experiencia la experiencia que se utilizo para aumentar
	 * el nivel del personaje.
	 */
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
	/**Metodo que retorna un boolean significando éste si
	 * el personaje tiene la cantidad suficiente de experiencia
	 * para aumentar el nivel o no.
	 * Si retorna true aumento de nivel y false no.
	 * @param La cantidad de experiencia que aumento el personaje
	 * @return Si aumento o no de nivel el personaje
	 */
	public final boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}
	/** Metodo que retorna un entero con la experiencia
	 * equivalente del personaje que depende del nivel
	 * del mismo y de MULTIPLICADOREXP.
	 * MULTIPLICADOREXP atributo estatico de la clase
	 * personaje.
	 */
	@Override
	public final int otorgarExp() {
		return this.getNivel() * MULTIPLICADOREXP;
	}
	
	/**Metodo que retorna un Objetc utilizado para 
	 * clonar a un personaje.
	 * @return Retorna un Objetc con los atributos del
	 * personaje llamador.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**Metodo que retorna un double con la distancia radial
	 * entre el personaje llamador y el personaje parametro.
	 * 
	 * @param Personaje a calcular la distancia
	 * @return La distancia entre los dos Personajes
	 */
	public final double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	/**Metodo que retorna un boolean si pudo realizar exitosamente o no 
	 * la habilidad 1. Esta habilidad dependerá de la casta al que pertenece
	 * el personaje Asesino, Guerrero o Hechicero. La energia del personaje debe
	 * ser mayor a la minima para lograr la habilidad.
	 * @param atacado Es el personaje al cual le realizará la habilidad el 
	 * personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 1 de la casta.
	 */
	public final boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}
	
	/**Metodo que retorna un boolean si pudo realizar exitosamente o no 
	 * la habilidad 2. Esta habilidad dependerá de la casta al que pertenece
	 * el personaje Asesino, Guerrero o Hechicero. La energia del personaje 
	 * debe ser mayor a la minima para lograr la habilidad.
	 * @param atacado Es el personaje al cual le realizará la habilidad el 
	 * personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 2 de la casta.
	 */
	public final boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}
	/**Metodo que retorna un boolean si pudo realizar exitosamente o no 
	 * la habilidad 2. Esta habilidad dependerá de la casta Asesino,Guerrero o
	 * Hechicero al que pertenece el personaje. La energia del personaje 
	 * debe ser mayor a la minima para lograr la habilidad.
	 * @param atacado Es el personaje al cual le realizará la habilidad el 
	 * personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 3 de la casta.
	 */
	public final boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}
	
	/**Metodo abstracto que retorna un boolean si pudo realizar exitosamente o no 
	 * la habilidad. Esta habilidad dependerá de la raza al que pertenece
	 * el personaje Humano, Orco o Elfo. 
	 * La energia del personaje debe ser mayor a la minima para lograr la habilidad,
	 * independientemente de la raza que sea.
	 * @param atacado Es el personaje al cual le realizará la habilidad el 
	 * personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 1 de la Raza.
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);
	public abstract boolean habilidadRaza2(Peleable atacado);
	/** Metodo abstracto implementado en cada raza que retorna un vector
	 * String con los nombres de las habilidades de esa raza.
	 * Depende de la raza que sea el personaje llamador, Humano, Orco o Elfo.
	 * @return Un array de Strings con los nombres de las habilidades.
	 */
	public abstract String[] getHabilidadesRaza();
	/**Metodo abstracto implementado en cada raza que retorna un entero
	 * con el bonus de salud.
	 * Depende de la raza que sea el personaje llamador, Humano, Orco o Elfo.
	 * @return Retorna el entero con el bonus de salud.
	 */
	public abstract int getSaludBonus();
	/**Metodo abstracto implementado en cada raza que retorna un entero
	 * con el bonus de energia.
	 * Depende de la raza que sea el personaje llamador, Humano, Orco o Elfo.
	 * 
	 * @return Retorna el entero con el bonus de energia.
	 */
	public abstract int getEnergiaBonus();
	/**Metodo abstracto implementado en cada raza que retorna un String
	 * con el nombre de la raza que pertenece el personaje llamador
	 * Depende de la raza que sea el personaje llamador, Humano, Orco o Elfo.
	 * 
	 * @return Retorna el String con el nombre de la Raza del personaje.
	 */
	public abstract String getNombreRaza();

}

